package Application;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Logic.Corner;
import Logic.StopBus;
import Logic.University;
import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedNotDirectedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeNotDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import util.AuxClassPath;
import util.Util;

/**
 * MapController
 */
public class Map {

    @FXML
    private Pane panelMapa;
    @FXML
    private AnchorPane scenePane1;

    private static Map ventana;

    public void initialize() {
        ventana = this;
    }

    public static Map getInstance() {
        return ventana;
    }

    public void pintar(MouseEvent event) {
        if (Scene1.getInstance().getValue()) {
            Object nodo = event.getTarget();
            if (nodo instanceof Line) {
                Line l = (Line) nodo;
                ArrayList<String> corners = Util.getVertexsId(l.getId());
                // ILinkedWeightedEdgeNotDirectedGraph grapAux =
                AuxClassPath a = null;
                University.getInstance().insertUbication(event.getX(),
                        event.getY(), corners.get(0), corners.get(1));
                // a = University.getInstance().shortestPath(
                // University.getInstance().findVertex("yourUbication"),
                // University.getInstance().findVertex("C1"));
                mostrarNodos();
                a = University.getInstance().findStopBusShort();
                if (a != null) {
                    drowPath(a.getList(), event);
                    // mostrar el panel con el peso total del camino
                    Scene1.getInstance().getPanelRecorrido().setVisible(true);
                    Scene1.getInstance().setLablePathValue(String.format("%.3f", a.getWeigth()) + " Km");
                    mostrarNodos();
                    // System.out.println();
                    // eliminar ubicacion proporcionada por el usuario
                    University.getInstance().deleteUbication(corners.get(0), corners.get(1));
                } else {
                    System.out.println("No hay paradas");
                    University.getInstance().deleteUbication(corners.get(0), corners.get(1));
                    mostrarNodos();
                }
            }
        } else {
            Object nodo = event.getTarget();
            if (Scene3.getInstance().getChoiceBox().getSelectionModel().getSelectedIndex() != 0)
                if (nodo instanceof Line) {
                    Line l = (Line) nodo;
                    ArrayList<String> corners = Util.getVertexsId(l.getId());
                    Scanner s = new Scanner(System.in);
                    String texto = s.next();
                    double x = event.getX();
                    double y = event.getY();
                    University.getInstance().insertStopBus(texto, x, y, corners.get(0), corners.get(1));
                    mostrarNodos();
                }
        }
    }

    public void drowPath(LinkedList<Object> list, MouseEvent event) {
        clean();
        ListIterator<Object> it = list.listIterator();
        double coIniX, coIniY;
        coIniX = coIniY = 0;
        double coFinX, coFinY;
        coFinX = coFinY = 0;
        Vertex o1 = (Vertex) it.next();
        Vertex o2 = null;
        while (it.hasNext()) {
            o2 = (Vertex) it.next();
            if (o1.getInfo() instanceof Corner) {
                coIniX = ((Corner) ((Vertex) o1).getInfo()).getX();
                coIniY = ((Corner) ((Vertex) o1).getInfo()).getY();
            } else {
                coIniX = ((StopBus) ((Vertex) o1).getInfo()).getX();
                coIniY = ((StopBus) ((Vertex) o1).getInfo()).getY();
            }

            if (o2.getInfo() instanceof Corner) {
                coFinX = ((Corner) ((Vertex) o2).getInfo()).getX();
                coFinY = ((Corner) ((Vertex) o2).getInfo()).getY();
            } else {
                coFinX = ((StopBus) ((Vertex) o2).getInfo()).getX();
                coFinY = ((StopBus) ((Vertex) o2).getInfo()).getY();
            }
            Line line = new Line(coIniX, coIniY, coFinX, coFinY);
            line.setId("remove");
            line.setStroke(Color.RED);
            line.setStrokeWidth(11);
            line.setStrokeLineCap(StrokeLineCap.ROUND);
            Map.getInstance().panelMapa.getChildren().add(line);

            o1 = o2;

        }

        Image imagen = new Image("file:src/images/location-icon.png");
        ImageView imagenView = new ImageView(imagen);
        imagenView.setFitHeight(50);
        imagenView.setFitWidth(50);
        imagenView.setX(event.getX() - 25);
        imagenView.setY(event.getY() - 54);
        imagenView.setId("puente");
        panelMapa.getChildren().add(imagenView);
        Image imagen1 = new Image("file:src/images/azul_bus-preview.png");
        ImageView imagenView1 = new ImageView(imagen1);
        imagenView1.setFitHeight(60);
        imagenView1.setFitWidth(50);
        imagenView1.setX(coFinX - 25);
        imagenView1.setY(coFinY - 54);
        imagenView1.setId("puente");
        panelMapa.getChildren().add(imagenView1);
    }

    public void clean() {
        ListIterator<Node> it = panelMapa.getChildren().listIterator();
        while (it.hasNext()) {
            Node n = it.next();
            if (n instanceof Line) {
                if (((Line) n).getId().equals("remove")) {
                    it.previous();
                    it.remove();
                }
            } else if (n instanceof ImageView)
                if (!((ImageView) n).getId().equals("no")) {
                    it.previous();
                    it.remove();
                }
            // for (Node n : panelMapa.getChildren()) {
            // if (n instanceof Line) {
            // if (((Line) n).getId().equals("remove"))
            // panelMapa.getChildren().remove(n);
            // // // n.toBack();
            // // } else if (((Line) n).getId().equals("remove"))

            // } else if (n instanceof ImageView)
            // if (!((ImageView) n).getId().equals("no"))
            // n.setVisible(false);
            // else if (n instanceof Circle)
            // n.toFront();
            // else if (n instanceof Line)
            // if (!((Line) n).getId().equals("no"))
            // ((Line) n).setStroke(Color.WHITE);
        }
    }

    public void mostrarNodos() {
        for (Vertex v : University.getInstance().getMap().getVerticesList()) {
            if (v.getInfo() instanceof Corner)
                System.out.println(((Corner) v.getInfo()).getId());
            if (v.getInfo() instanceof StopBus)
                System.out.println(((StopBus) v.getInfo()).getId());
        }
    }

    public void showStopBus() {
        for (Vertex v : University.getInstance().getMap().getVerticesList()) {
            if (v.getInfo() instanceof StopBus) {
                double x = ((StopBus) v.getInfo()).getX();
                double y = ((StopBus) v.getInfo()).getY();
                Image imagen1 = new Image("file:src/images/azul_bus-preview.png");
                ImageView imagenView1 = new ImageView(imagen1);
                imagenView1.setFitHeight(60);
                imagenView1.setFitWidth(50);
                imagenView1.setX(x - 25);
                imagenView1.setY(y - 54);
                imagenView1.setId("puente");
                panelMapa.getChildren().add(imagenView1);
            }
        }
    }
}
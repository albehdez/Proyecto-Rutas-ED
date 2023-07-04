package Application;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Logic.Corner;
import Logic.StopBus;
import Logic.University;
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

    // public void pintar(MouseEvent event) {
    // Object nodo = event.getTarget();
    // if (nodo instanceof Line) {
    // // Realizar las acciones que desea
    // Line lineaTocada = (Line) nodo;
    // lineaTocada.setStroke(Color.RED);
    // }
    // }

    // public void markUbication(MouseEvent event) {
    // // double x = event.getX();
    // // double y = event.getY();
    // Object nodo = event.getTarget();
    // if (nodo instanceof Line) {
    // Line linea = (Line) nodo;

    // // System.out.println("tocaste una linea");
    // // linea.setStroke(Color.RED);
    // // Point2D localCoords = linea.sceneToLocal(event.getSceneX(),
    // // event.getSceneY());
    // // double posicion = localCoords.getX() /
    // linea.getBoundsInLocal().getWidth();
    // Image imagen = new Image("file:src/images/location-icon.png");
    // ImageView imagenView = new ImageView(imagen);
    // imagenView.setX(event.getX() - 40);
    // imagenView.setY(event.getY() - 58);
    // // imagenView.setFitWidth(linea.getEndX() - linea.getStartX());
    // // imagenView.setFitHeight(10);
    // // Pane panel = (Pane) linea.getParent();
    // panelMapa.getChildren().add(imagenView);

    // Pane panel = (Pane) linea.getParent();
    // List<Line> lineas = new ArrayList<>();
    // for (Node n : panel.getChildren()) {
    // if (n instanceof Line) {
    // lineas.add((Line) n);
    // }
    // }
    // for (Line l : lineas) {
    // if (l.getUserData() instanceof ImageView) {
    // ImageView imagenAnterior = (ImageView) linea.getUserData();
    // panel.getChildren().remove(imagenAnterior);
    // }

    // linea.setUserData(imagenView);
    // }
    // }
    // }

    // public void markRoute(MouseEvent event) {

    // Object nodo = event.getTarget();
    // if (nodo instanceof Line) {
    // Line linea = (Line) nodo;
    // double posX = event.getX();
    // double posY = event.getY();
    // LinkedList<AuxClassPath> list = new LinkedList<AuxClassPath>();
    // double distStar = Math.sqrt(Math.pow(linea.getStartX() + posX, 2) +
    // Math.pow(linea.getStartY() + posY, 2));
    // double disEnd = Math.sqrt(Math.pow(linea.getEndX() + posX, 2) +
    // Math.pow(linea.getEndY() + posY, 2));
    // if (distStar < disEnd) {
    // Vertex v = University.getInstance().searchVertex(linea.getStartX(),
    // linea.getStartY());
    // list = University.getInstance().findsRoutes(v);
    // drowPath(list);

    // } else if (distStar > disEnd) {
    // Vertex v = University.getInstance().searchVertex(linea.getEndX(),
    // linea.getEndY());
    // list = University.getInstance().findsRoutes(v);
    // drowPath(list);

    // } else {
    // Vertex v = University.getInstance().searchVertex(linea.getStartX(),
    // linea.getStartY());
    // list = University.getInstance().findsRoutes(v);
    // drowPath(list);
    // }

    // }
    // }

    // public void drowPath(LinkedList<AuxClassPath> list) {
    // ListIterator<AuxClassPath> it = list.listIterator();
    // while (it.hasNext()) {
    // List<Node> lis = panelMapa.getChildren();
    // for (Node l : lis) {
    // // if(l instanceof Line)
    // // if(((Line)l).get)
    // }
    // }
    // }

    public void pintar(MouseEvent event) {
        if (Scene1.getInstance().getValue()) {
            Object nodo = event.getTarget();
            if (nodo instanceof Line) {
                Line l = (Line) nodo;
                ArrayList<String> corners = Util.getVertexsId(l.getId());
                // ILinkedWeightedEdgeNotDirectedGraph grapAux =
                // University.getInstance().insertUbication(event.getX(),
                // event.getY(), corners.get(0), corners.get(1));
                AuxClassPath a = University.getInstance().shortestPath(
                        University.getInstance().findVertex("yourUbication"),
                        University.getInstance().searchVertex(511, 269), University.getInstance().getMap());
                mostrarNodos();
                // AuxClassPath a = University.getInstance().findStopBusShort(grapAux);
                if (a != null) {
                    drowPath(a.getList(), event);
                    // mostrar el panel con el peso total del camino
                    Scene1.getInstance().getPanelRecorrido().setVisible(true);
                    Scene1.getInstance().setLablePathValue(String.format("%.3f", a.getWeigth()) + " Km");
                    mostrarNodos();
                    // System.out.println();
                    // eliminar ubicacion proporcionada por el usuario
                    University.getInstance().deleteUbication(corners.get(0), corners.get(1),
                            University.getInstance().getMap());
                } else {
                    System.out.println("No hay paradas");
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

    // public LinkedList<Line> getLineList(LinkedList<Object> lsit) {
    // LinkedList<Line> list = new LinkedList<Line>();
    // LinkedList<LinePosAux> lineList = University.getInstance().findWay(lsit);
    // // ListIterator<Object> it = lineList.listIterator();
    // while (it.hasNext()) {
    // for (Node n : Scene1.getInstance().getAnchorPane().getChildren()) {
    // if (n instanceof Line)
    // if (((Line) n).getId() == ((LinePosAux) it.next()).getAddress())
    // list.add((Line) n);
    // }
    // }

    // return list;
    // }

    // public void drowPath(LinkedList<Object> list, MouseEvent event) {
    // LinkedList<LinePosAux> lineList = University.getInstance().findWay(list);
    // LinkedList<Line> line = getLineList(list);
    // ListIterator<LinePosAux> it = lineList.listIterator();
    // }

    public void drowPath(LinkedList<Object> list, MouseEvent event) {
        clean();

        // LinkedList<LinePosAux> lineList = University.getInstance().findWay(list);
        // ListIterator<LinePosAux> it = lineList.listIterator();
        ListIterator<Object> it = list.listIterator();
        double coIniX, coIniY;
        coIniX = coIniY = 0;
        double coFinX, coFinY;
        coFinX = coFinY = 0;
        // LinePosAux aux = null;
        // aux = it.next();
        // double x, y;
        // x = y = 0;
        // System.out.println(event.getX() + ", " + event.getY());
        // int i = 0;
        // Vertex o = (Vertex) list.get(1);
        // Corner c = ((Corner) (o.getInfo()));
        Vertex o1 = (Vertex) it.next();
        Vertex o2 = (Vertex) it.next();
        while (it.hasNext()) {
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
            // System.out.println(li.getEndX() + ", " + li.getEndY());
            Map.getInstance().panelMapa.getChildren().add(line);

            o1 = o2;
            o2 = (Vertex) it.next();
            // if (i == 0) {
            // // System.out.println(aux.getPosx() + ", " + aux.getPosy());
            // x = aux.getPosx();
            // y = aux.getPosy();
            // i++;
            // }
            // System.out.println(aux.getPosx() + ", " + aux.getPosy());
            // for (Node n : panelMapa.getChildren()) {
            // if (n instanceof Line) {
            // if (((Line) n).getLayoutX() == aux.getPosx() && ((Line) n).getLayoutY() ==
            // aux.getPosy()) {
            // ((Line) n).setStroke(Color.RED);

            // // n.toFront();
            // }
            // }
            // // } else if (n instanceof CubicCurve)
            // // if (((CubicCurve) n).getLayoutX() == aux.getPosx()
            // // && ((CubicCurve) n).getLayoutY() == aux.getPosy()) {
            // // ((CubicCurve) n).setStroke(Color.Red);
            // // }
            // }

            // System.out.println(event.getX() + ", " + event.getY());
            // Line l = (Line) Scene1.getInstance().getAnchorPane().lookup("#" +
            // aux.getAddress());
            // l.setStroke(Color.RED);
            // l.toFront();//

        }
        Image imagen = new Image("file:src/images/location-icon.png");
        ImageView imagenView = new ImageView(imagen);
        imagenView.setFitHeight(50);
        imagenView.setFitWidth(50);
        imagenView.setX(event.getX() - 25);
        imagenView.setY(event.getY() - 54);
        imagenView.setId("puente");
        panelMapa.getChildren().add(imagenView);
        // Line li = new Line(event.getX(), event.getY(), c.getX(), c.getY());
        Image imagen1 = new Image("file:src/images/azul_bus-preview.png");
        ImageView imagenView1 = new ImageView(imagen1);
        imagenView1.setFitHeight(60);
        imagenView1.setFitWidth(50);
        imagenView1.setX(coFinX - 25);
        imagenView1.setY(coFinY - 54);
        // imagenView1.setX(aux.getPosx() - 440);
        // imagenView1.setY(aux.getPosy() - 480);
        imagenView1.setId("puente");
        // Scene1.getInstance().getAnchorPane().getChildren().add(imagenView1);
        panelMapa.getChildren().add(imagenView1);
        // Image imagenFinal = new Image("file:src/images/parada-icon.png");
        // ImageView imagenViewFinal = new ImageView(imagenFinal);
        // imagenViewFinal.setFitHeight(50);
        // imagenViewFinal.setFitWidth(50);
        // imagenViewFinal.setX(aux.getPosx());
        // imagenViewFinal.setY(aux.getPosy());
        // panelMapa.getChildren().add(imagenViewFinal);
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
}
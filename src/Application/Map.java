package Application;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.text.html.HTMLDocument.Iterator;

import Logic.Bus;
import Logic.Corner;
import Logic.StopBus;
import Logic.University;
import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedNotDirectedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeNotDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;
import cu.edu.cujae.ceis.tree.binary.BinaryTree;
import cu.edu.cujae.ceis.tree.iterators.general.InDepthIterator;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
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
        try {
            if (Scene1.getInstance().getValue()) {
                Object nodo = event.getTarget();
                if (nodo instanceof Line) {
                    Line l = (Line) nodo;
                    ArrayList<String> corners = Util.getVertexsId(l.getId());
                    AuxClassPath a = null;
                    University.getInstance().insertUbication(event.getX(),
                            event.getY(), corners.get(0), corners.get(1));
                    // mostrarNodos();
                    a = University.getInstance().findStopBusShort();
                    if (a != null) {
                        drowPath(a.getList(), event);
                        // mostrar el panel con el peso total del camino
                        Scene1.getInstance().getPanelRecorrido().setVisible(true);
                        Scene1.getInstance().setLablePathValue(String.format("%.3f", a.getWeigth()) + " Km");
                        // mostrarNodos();
                        // eliminar ubicacion proporcionada por el usuario
                        University.getInstance().deleteUbication(corners.get(0), corners.get(1));
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        // alert.initOwner(ventana); // Establecer la ventana principal como el
                        // propietario del diálogo
                        alert.setTitle("No se puede mostrar una ruta");
                        alert.setHeaderText(null);
                        alert.setContentText(
                                "No se encuentra ninguna parada registrada en el sistema, por favor registre una parada antes.");
                        alert.showAndWait();
                        University.getInstance().deleteUbication(corners.get(0), corners.get(1));
                        // mostrarNodos();
                    }
                }
            } else {
                Object nodo = event.getTarget();
                if (nodo instanceof Line) {
                    if (Scene3.getInstance().getChoiceBox().getSelectionModel().getSelectedIndex() != 0) {
                        Line l = (Line) nodo;
                        TextInputDialog dialogo = new TextInputDialog();
                        // dialogo.setTitle("Cuadro de texto");
                        dialogo.setHeaderText("Ingrese un identificador para la parada:");
                        dialogo.setContentText("Identificador:");
                        Optional<String> texto = dialogo.showAndWait();
                        ArrayList<String> corners = Util.getVertexsId(l.getId());
                        // Scanner s = new Scanner(System.in);
                        // String texto = s.next();
                        double x = event.getX();
                        double y = event.getY();
                        String matricula = (String) Scene3.getInstance().getChoiceBox().getSelectionModel()
                                .getSelectedItem();
                        University.getInstance().insertStopBus(texto.get(), x, y, corners.get(0),
                                corners.get(1), matricula);
                        showSomeStopBus(matricula);
                    }
                } else {
                    if (nodo instanceof ImageView) {
                        Alert confirmAlert = new Alert(AlertType.CONFIRMATION);
                        confirmAlert.setTitle("Confirmación de acción");
                        confirmAlert.setContentText("¿Estás seguro de que deseas eliminar  esta parada?");
                        ButtonType buttonTypeOk = new ButtonType("Eliminar", ButtonData.OK_DONE);
                        ButtonType buttonTypeCancel = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);
                        confirmAlert.getButtonTypes().setAll(buttonTypeOk, buttonTypeCancel);

                        Optional<ButtonType> result = confirmAlert.showAndWait();
                        if (result.isPresent() && result.get() == buttonTypeOk) {
                            double x = ((ImageView) nodo).getX();
                            double y = ((ImageView) nodo).getY();

                            StopBus sb = (StopBus) University.getInstance().searchVertex(x + 25, y + 54).getInfo();
                            University.getInstance().deleteStopBus(sb.getId());
                            clean();
                            if (Scene3.getInstance().getChoiceBox().getSelectionModel().getSelectedIndex() == 0) {
                                showEveryStopBus();
                            } else {
                                String text = (String) Scene3.getInstance().getChoiceBox().getSelectionModel()
                                        .getSelectedItem();
                                showSomeStopBus(text);
                            }
                        } else {
                            confirmAlert.close();
                        }
                    }
                }
            }
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.INFORMATION);
            // alert.initOwner(ventana); // Establecer la ventana principal como el
            // propietario del diálogo
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(
                    e.getMessage());
            alert.showAndWait();
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
            line.setId("a");
            line.setStroke(Color.RED);
            line.setStrokeWidth(7);
            line.setStrokeLineCap(StrokeLineCap.ROUND);
            panelMapa.getChildren().add(line);

            o1 = o2;

        }

        Image imagen = new Image("file:src/images/location-icon.png");
        ImageView imagenView = new ImageView(imagen);
        imagenView.setFitHeight(50);
        imagenView.setFitWidth(50);
        imagenView.setX(event.getX() - 25);
        imagenView.setY(event.getY() - 54);
        imagenView.setId("aico");
        panelMapa.getChildren().add(imagenView);
        Image imagen1 = new Image("file:src/images/azul_bus-preview.png");
        ImageView imagenView1 = new ImageView(imagen1);
        imagenView1.setFitHeight(60);
        imagenView1.setFitWidth(50);
        imagenView1.setX(coFinX - 25);
        imagenView1.setY(coFinY - 54);
        imagenView1.setId("aico");
        panelMapa.getChildren().add(imagenView1);
    }

    public void clean() {
        LinkedList<Node> li = new LinkedList<Node>();
        ListIterator<Node> it = panelMapa.getChildren().listIterator();
        while (it.hasNext()) {
            Node n = it.next();
            if (n instanceof Line) {
                if (((Line) n).getId().equals("a"))
                    li.add(n);
            } else if (n instanceof ImageView)
                if (((ImageView) n).getId().equals("aico"))
                    li.add(n);
        }
        if (!li.isEmpty())
            panelMapa.getChildren().removeAll(li);
    }

    // public void mostrarNodos() {
    // for (Vertex v : University.getInstance().getMap().getVerticesList()) {
    // if (v.getInfo() instanceof Corner)
    // System.out.println(((Corner) v.getInfo()).getId());
    // if (v.getInfo() instanceof StopBus)
    // System.out.println(((StopBus) v.getInfo()).getId());
    // }
    // }

    public void showEveryStopBus() {
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
                imagenView1.setId("aico");
                panelMapa.getChildren().add(imagenView1);
            }
        }
    }

    /**
     * @param tuition
     */
    public void showSomeStopBus(String tuition) {
        clean();
        LinkedList<StopBus> list = new LinkedList<StopBus>();
        InDepthIterator<Object> iter = University.getInstance().getTree().inDepthIterator();
        boolean stop = false;
        while (iter.hasNext() && !stop) {
            Object current = iter.next();

            if (current instanceof Bus) {
                if (((Bus) current).getTuition().equalsIgnoreCase(tuition)) {
                    stop = true;
                    list = ((Bus) current).getRoute();
                }
            }
        }
        if (!list.isEmpty()) {
            ListIterator<StopBus> it = list.listIterator();
            while (it.hasNext()) {
                StopBus sb = it.next();
                double x = sb.getX();
                double y = sb.getY();
                Image imagen1 = new Image("file:src/images/azul_bus-preview.png");
                ImageView imagenView1 = new ImageView(imagen1);
                imagenView1.setFitHeight(60);
                imagenView1.setFitWidth(50);
                imagenView1.setX(x - 25);
                imagenView1.setY(y - 54);
                imagenView1.setId("aico");
                panelMapa.getChildren().add(imagenView1);
                // Scene3.getInstance().getDeleteButton().setDisable(false);

            }
            // Scene3.getInstance().getInsertButton().setDisable(false);
        } else {
            clean();
        }
    }
}
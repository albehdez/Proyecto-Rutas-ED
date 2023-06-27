package Application;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.text.html.HTMLDocument.Iterator;

import Logic.Corner;
import Logic.University;
import cu.edu.cujae.ceis.graph.vertex.Vertex;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import util.AuxClassPath;
import util.LinePosAux;

/**
 * MapController
 */
public class Map {

    @FXML
    private Pane panelMapa;
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
        Object nodo = event.getTarget();
        if (nodo instanceof Circle) {
            Circle c = (Circle) nodo;
            double x, y;
            x = c.getLayoutX();
            y = c.getLayoutY();
            Vertex aux = University.getInstance().searchVertex(x, y);
            AuxClassPath a = University.getInstance().shortestPath(aux,
                    University.getInstance().searchVertex(909, 821));
            for (Object o : a.getList()) {

                System.out.println(((Corner) ((Vertex) o).getInfo()).getId());
            }
            Image imagen = new Image("file:src/images/location-icon.png");
            ImageView imagenView = new ImageView(imagen);
            imagenView.setFitHeight(50);
            imagenView.setFitWidth(50);
            imagenView.setX(event.getX() - 25);
            imagenView.setY(event.getY() - 54);
            panelMapa.getChildren().add(imagenView);
            drowPath(a.getList());
        }
    }

    public void drowPath(LinkedList<Object> list) {
        clean();
        LinkedList<LinePosAux> lineList = University.getInstance().findWay(list);
        ListIterator<LinePosAux> it = lineList.listIterator();
        while (it.hasNext()) {
            LinePosAux aux = it.next();
            for (Node n : panelMapa.getChildren()) {
                if (n instanceof Line) {
                    if (((Line) n).getLayoutX() == aux.getPosx() && ((Line) n).getLayoutY() == aux.getPosy())
                        ((Line) n).setStroke(Color.BLUE);
                }
            }
        }
    }

    public void clean() {
        for (Node n : panelMapa.getChildren()) {
            if (n instanceof Line) {
                ((Line) n).setStroke(Color.WHITE);
            }
        }
    }
}
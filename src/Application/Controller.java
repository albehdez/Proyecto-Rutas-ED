package Application;

import java.io.IOException;
import java.util.Iterator;

import javax.swing.JOptionPane;

import Logic.Bus;
import Logic.LocationT;
import Logic.Terminal;
import Logic.University;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private Button salirButton;
    @FXML
    private AnchorPane scenePane2;
    Stage stage;
    @FXML
    private VBox VBoxSalir;
    @FXML
    private AnchorPane scenePane1;
    @FXML
    private Pane panelMapa;
    @FXML
    private TextField LocalidadTextField;
    @FXML
    private TextField TermianlTextField;
    @FXML
    private TextField MatriculaTextField;
    @FXML
    private Spinner asientosSpinner;

    public void loadScene2(MouseEvent e) throws IOException {

        Stage secondStage = new Stage();
        secondStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        secondStage.setTitle("Gestionar Omnibus");
        Scene scene = new Scene(root);
        String css = "style.css";
        scene.getStylesheets().add(css);
        secondStage.setAlwaysOnTop(true);
        secondStage.setScene(scene);
        // salirButton = (Button) scene.lookup("SalirButton");

        secondStage.show();

    }

    public void closeWindow2(ActionEvent e) {
        stage = (Stage) scenePane2.getScene().getWindow();
        stage.close();
    }

    public void closeWindow1(MouseEvent e) {
        stage = (Stage) scenePane1.getScene().getWindow();
        stage.close();
    }

    // Establecer la escala inicial
    double initialScale = 1.0;

    // Configurar el gestor de eventos de scroll
    double zoomFactor = 1.5;
    // double minScale = 0.5;
    // double maxScale = 3.0;

    public void zoom(ScrollEvent event) {
        if (event.isControlDown()) {
            event.consume();
            double scale = panelMapa.getScaleX();
            if (event.getDeltaY() < 0) {
                // Disminuir la escala
                scale /= zoomFactor;
                if (scale < initialScale) {
                    scale = initialScale;
                }
            } else {
                // Aumentar la escala
                scale *= zoomFactor;
                if (scale > (initialScale * 3)) {
                    scale = initialScale * 3;
                }
            }
            panelMapa.setScaleX(scale);
            panelMapa.setScaleY(scale);
        }
    }

    public void insertBus() {
        String localidad = LocalidadTextField.getText();
        String terminal = TermianlTextField.getText();
        String bus = MatriculaTextField.getText();
        University.getInstance().insert(localidad, terminal, bus, 123);
        JOptionPane.showMessageDialog(null, "Hola");
        Iterator<Object> it = University.getInstance().getTree().inDepthIterator();

        while (it.hasNext()) {
            Object nod = it.next();
            if (nod instanceof Terminal)
                System.out.println(((Terminal) nod).getId());
            else if (nod instanceof LocationT)
                System.out.println(((LocationT) nod).getName());
            else
                System.out.println(((Bus) nod).getTuition());
        }
    }
}

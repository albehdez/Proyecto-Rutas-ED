package Application;

import java.io.IOException;

import Logic.University;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Scene1 {
    @FXML
    private Pane OpcionesPanel;
    @FXML
    static private Stage stage;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private AnchorPane scenePane1;
    @FXML
    private AnchorPane scenePane2;
    @FXML
    private Label pathValueLabel;
    @FXML
    private Pane panelRecorrido;

    private static Scene1 ventana;
    private boolean value = true;

    public void initialize() {
        ventana = this;
    }

    public static Scene1 getInstance() {
        return ventana;
    }

    public AnchorPane getAnchorPane() {
        return scenePane1;
    }

    public void setLablePathValue(String cant) {
        pathValueLabel.setText(cant);
    }

    public Pane getPanelRecorrido() {
        return panelRecorrido;
    }

    public Label getPathValueLabel() {
        return pathValueLabel;
    }

    public void loadScene2(MouseEvent e) throws IOException {
        // Stage secondStage = new Stage();
        // Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        // secondStage.initModality(Modality.APPLICATION_MODAL);
        // secondStage.initStyle(StageStyle.TRANSPARENT);
        // Scene scene = new Scene(root);
        // String css = "style.css";
        // scene.getStylesheets().add(css);
        // scene.setFill(Color.rgb(243, 243, 243, 0.0));
        // secondStage.setAlwaysOnTop(true);
        // secondStage.setScene(scene);
        // secondStage.show();
        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));

        scenePane1.getChildren().add(root);

    }

    public void loadScene3(MouseEvent e) throws IOException {
        // Stage thirdStage = new Stage();
        // Parent root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
        // // thirdStage.initModality(Modality.APPLICATION_MODAL);
        // thirdStage.initStyle(StageStyle.TRANSPARENT);
        // Scene scene = new Scene(root);
        // String css = "style.css";
        // scene.getStylesheets().add(css);
        // scene.setFill(Color.rgb(243, 243, 243, 0.0));
        // thirdStage.setAlwaysOnTop(true);
        // thirdStage.setScene(scene);
        // thirdStage.setY(100);
        // thirdStage.setX(25);
        // thirdStage.show();
        if (value) {
            Parent root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
            scenePane1.getChildren().add(root);
            value = false;
            Map.getInstance().clean();
        } else {
            value = true;
            scenePane1.getChildren().remove(Scene3.getInstance().getAnchorPane());
            Map.getInstance().clean();
        }
    }

    public void closeWindow1(MouseEvent e) {
        stage = (Stage) scenePane1.getScene().getWindow();
        University.getInstance().writeTree();
        stage.close();
    }

    private static final double MIN_ZOOM_LEVEL = 1.0;
    private static final double MAX_ZOOM_LEVEL = 3.0;
    private double zoomLevel = 1.0;

    public void zoom(ScrollEvent event) {
        if (event.isControlDown() && event.getDeltaY() != 0) {
            double zoomFactor = Math.exp(event.getDeltaY() / 100.0);

            zoomLevel *= zoomFactor;
            if (zoomLevel < MIN_ZOOM_LEVEL) {
                zoomLevel = MIN_ZOOM_LEVEL;
            }
            if (zoomLevel > MAX_ZOOM_LEVEL) {
                zoomLevel = MAX_ZOOM_LEVEL;
            }

            scrollPane.setScaleX(zoomLevel);
            scrollPane.setScaleY(zoomLevel);

            event.consume();
        }
    }

    public boolean getValue() {
        return value;
    }
}

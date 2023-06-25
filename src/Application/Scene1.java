package Application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Scene1 {
    @FXML
    private Stage stage;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private AnchorPane scenePane1;
    @FXML
    private AnchorPane scenePane2;

    public void loadScene2(MouseEvent e) throws IOException {
        Stage secondStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        secondStage.initModality(Modality.APPLICATION_MODAL);
        secondStage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root);
        String css = "style.css";
        scene.getStylesheets().add(css);
        scene.setFill(Color.rgb(243, 243, 243, 0.0));
        secondStage.setAlwaysOnTop(true);
        secondStage.setScene(scene);
        secondStage.show();

    }

    public void loadScene3(MouseEvent e) throws IOException {
        Stage thirdStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
        // thirdStage.initModality(Modality.APPLICATION_MODAL);
        thirdStage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root);
        String css = "style.css";
        scene.getStylesheets().add(css);
        scene.setFill(Color.rgb(243, 243, 243, 0.0));
        thirdStage.setAlwaysOnTop(true);
        thirdStage.setScene(scene);
        thirdStage.setY(100);
        thirdStage.setX(25);
        thirdStage.show();
    }

    public void closeWindow2(ActionEvent e) {
        stage = (Stage) scenePane2.getScene().getWindow();
        stage.close();
    }

    public void closeWindow1(MouseEvent e) {
        stage = (Stage) scenePane1.getScene().getWindow();
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
}

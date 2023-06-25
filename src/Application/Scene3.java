package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Scene3 {
    @FXML
    private AnchorPane scenePane3;

    public void closeWindow(ActionEvent e) {
        Stage stage = (Stage) scenePane3.getScene().getWindow();
        stage.close();
    }
}

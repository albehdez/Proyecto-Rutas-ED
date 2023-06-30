package Application;

import Logic.University;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Scene3 {
    @FXML
    private AnchorPane scenePane3;
    @FXML
    private Stage stage;
    @FXML
    private ComboBox comboBoxBus;

    private static Scene3 ventana;

    public static Scene3 getInstance() {
        return ventana;
    }

    public void initialize() {
        ventana = this;
        loadComboBox();
    }

    public void closeWindow(ActionEvent e) {
        Stage stage = (Stage) scenePane3.getScene().getWindow();
        stage.close();
    }

    String nom[] = { "a", "b", "c" };

    public AnchorPane getAnchorPane() {
        return scenePane3;
    }

    public void loadComboBox() {
        // comboBoxBus.getItems().addAll(nom);
        // comboBoxBus.getItems().addAll(University.getInstance().getTreeBus());
    }
}

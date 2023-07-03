package Application;

import java.util.ArrayList;
import java.util.LinkedList;

import Logic.Bus;
import Logic.University;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Scene3 {
    @FXML
    private AnchorPane scenePane3;
    @FXML
    private Stage stage;
    @FXML
    private ChoiceBox<String> choiceBoxBus;

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

    public AnchorPane getAnchorPane() {
        return scenePane3;
    }

    private LinkedList<Bus> list = new LinkedList<Bus>();

    public void loadComboBox() {
        LinkedList<String> li = new LinkedList<String>();
        list = University.getInstance().getTreeBus();
        for (Bus b : list)
            li.add(b.getTuition());
        ObservableList<String> lis = FXCollections.observableArrayList(li);
        lis.add(0, "todos");
        choiceBoxBus.setItems(lis);
        choiceBoxBus.getSelectionModel().selectFirst();
    }

    public ChoiceBox getChoiceBox() {
        return choiceBoxBus;
    }
}

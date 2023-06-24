package Application;

import java.net.URL;
import java.util.ResourceBundle;

import Logic.University;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.AuxC4Table;

public class Scene2 {
    @FXML
    private AnchorPane scenePane2;
    @FXML
    private TextField LocalidadTextField;
    @FXML
    private TextField TermianlTextField;
    @FXML
    private TextField MatriculaTextField;
    @FXML
    private Spinner<Integer> asientosSpinner;
    @FXML
    private TableView<AuxC4Table> tableBus;
    @FXML
    private TableColumn localidadColumn;
    @FXML
    private TableColumn terminalColumn;
    @FXML
    private TableColumn matriculaColumn;
    @FXML
    private TableColumn cantAsientosColumn;
    private ObservableList<AuxC4Table> bus;
    @FXML
    private Button InsertarButton;

    public void closeWindow2(ActionEvent e) {
        Stage stage = (Stage) scenePane2.getScene().getWindow();
        stage.close();
    }

    public void checkEmpty(KeyEvent event) {
        if (!LocalidadTextField.getText().equalsIgnoreCase("") && !TermianlTextField.getText().equalsIgnoreCase("")
                && !MatriculaTextField.getText().equalsIgnoreCase(""))
            InsertarButton.setDisable(false);
        else
            InsertarButton.setDisable(true);
    }

    public void sugerencia(MouseEvent event) {
        Tooltip tooltip = new Tooltip(
                "Las matriculas de los omnibus comienza con la letra B y seguido contienen una numeración de 6 dígitos");
        tooltip.setShowDelay(new javafx.util.Duration(700));
        Tooltip.install(MatriculaTextField, tooltip);
    }

    public void insertBus() {
        String localidad = LocalidadTextField.getText();
        String terminal = TermianlTextField.getText();
        String bus = MatriculaTextField.getText();
        int seatsNum = (int) asientosSpinner.getValue();

        University.getInstance().insert(localidad, terminal, bus, seatsNum);

        LocalidadTextField.setText("");
        TermianlTextField.setText("");
        MatriculaTextField.setText("");
        InsertarButton.setDisable(true);
        // loadTable();
    }

    // @FXML
    // public void loadTable() {
    // // localidadColumn = new TableColumn<>("Localidad");
    // // terminalColumn = new TableColumn<>("Terminal");
    // // matriculaColumn = new TableColumn<>("Matricula");
    // // cantAsientosColumn = new TableColumn<>("Cantidad de asientos");
    // localidadColumn.setCellValueFactory(new PropertyValueFactory<AuxC4Table,
    // String>("Localiad"));
    // terminalColumn.setCellValueFactory(new PropertyValueFactory<AuxC4Table,
    // String>("Terminal"));
    // matriculaColumn.setCellValueFactory(new PropertyValueFactory<AuxC4Table,
    // String>("Matricula"));
    // cantAsientosColumn.setCellValueFactory(new PropertyValueFactory<AuxC4Table,
    // Integer>("Cantidad de asientos"));

    // bus =
    // FXCollections.observableArrayList(University.getInstance().getNodesInfo());
    // // bus.addAll();
    // tableBus.setItems(bus);
    // }

    // @Override
    // public void initialize(URL location, ResourceBundle resources) {
    // this.loadTable();
    // }
}

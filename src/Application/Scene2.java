package Application;

import Logic.University;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.AuxClassBusTable;

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
    private TableView<AuxClassBusTable> tableBus;
    @FXML
    private TableColumn localidadColumn;
    @FXML
    private TableColumn terminalColumn;
    @FXML
    private TableColumn matriculaColumn;
    @FXML
    private TableColumn cantAsientosColumn;
    private ObservableList<AuxClassBusTable> bus;
    @FXML
    private Button InsertarButton;
    @FXML
    private Label tituloscene2;

    public void closeWindow(ActionEvent e) {
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

    public void cancelButton() {
        LocalidadTextField.setEditable(false);
        TermianlTextField.setEditable(false);
        MatriculaTextField.setEditable(false);
    }

    public void insertBus() {
        String localidad = LocalidadTextField.getText();
        String terminal = TermianlTextField.getText();
        String bus = MatriculaTextField.getText();
        int seatsNum = (int) asientosSpinner.getValue();

        University.getInstance().insertBus(localidad, terminal, bus, seatsNum);

        LocalidadTextField.setText("");
        TermianlTextField.setText("");
        MatriculaTextField.setText("");
        InsertarButton.setDisable(true);
        Stage primaryStage = (Stage) InsertarButton.getScene().getWindow(); //
        // Reemplaza 'btnEnviar' con tu propio nodo

        // // Crear un diálogo de alerta con la ventana principal como propietario
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.initOwner(primaryStage); // Establecer la ventana principal como el
        // propietario del diálogo
        alert.setTitle("Éxito");
        alert.setHeaderText(null);
        alert.setContentText("La información se ha enviado correctamente.");
        alert.showAndWait();
    }

    public void buttonInsertar() {

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

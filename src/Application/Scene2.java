package Application;

import javafx.fxml.FXML;

import javax.swing.Action;

import Logic.University;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
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
    static private Stage stage;
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
    @FXML
    private Button EliminarButton;
    @FXML
    private Button addButton;

    private boolean value = true;

    private static Scene2 ventana;

    public static Scene2 getInstance() {
        return ventana;
    }

    public void initialize() {
        ventana = this;
        loadTable();

        // final ObservableList<AuxClassBusTable> busTable =
        // tableBus.getSelectionModel().getSelectedItems();

    }

    public void closeWindow(ActionEvent e) {
        Scene1.getInstance().getAnchorPane().getChildren().remove(scenePane2);
        // Scene scene = root.getScene();
        // Stage stage = (Stage) scene.getWindow();
        // stage.close();
        // Stage stage = (Stage) scenePane2.getScene().getWindow();
        // stage.close();
        // Scene1.getInstance().getAnchorPane().getChildren()
        // .remove(Scene1.getInstance().getAnchorPane().lookup("scenePane2"));
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

    // public void cancelButton(ActionEvent e) {
    // LocalidadTextField.setEditable(false);
    // TermianlTextField.setEditable(false);
    // MatriculaTextField.setEditable(false);
    // EliminarButton.setDisable(true);
    // }

    public void insertBus() {
        if (value) {
            String localidad = LocalidadTextField.getText();
            String terminal = TermianlTextField.getText();
            String bus = MatriculaTextField.getText();
            int seatsNum = (int) asientosSpinner.getValue();

            University.getInstance().insertBus(localidad, terminal, bus, seatsNum);

            LocalidadTextField.setText("");
            TermianlTextField.setText("");
            MatriculaTextField.setText("");
            InsertarButton.setDisable(true);
            Stage primaryStage = (Stage) InsertarButton.getScene().getWindow();
            update();
            // // Crear un diálogo de alerta con la ventana principal como propietario
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.initOwner(primaryStage); // Establecer la ventana principal como el
            // propietario del diálogo
            alert.setTitle("Éxito");
            alert.setHeaderText(null);
            alert.setContentText("La información se ha enviado correctamente.");
            alert.showAndWait();
        } else {
            update();
        }
    }

    public void buttonInsertar(ActionEvent e) {
        LocalidadTextField.setDisable(false);
        TermianlTextField.setDisable(false);
        MatriculaTextField.setDisable(false);
        asientosSpinner.setDisable(false);
        EliminarButton.setDisable(false);
        // addButton.setDisable(true);

        if (!value)
            value = true;
    }

    public void buttonDelete(ActionEvent e) {
        // tableBus.getSelectionModel()
    }

    public void buttonModificar() {
        String terminal = null;
        String localidad = null;
        String matricula = null;
        asientosSpinner.setDisable(false);
        EliminarButton.setDisable(false);
        if (value)
            value = false;
    }

    public Button getAddButton() {
        return addButton;
    }

    public void buttonCancel(ActionEvent e) {
        LocalidadTextField.setDisable(true);
        TermianlTextField.setDisable(true);
        MatriculaTextField.setDisable(true);
        asientosSpinner.setDisable(true);
        EliminarButton.setDisable(true);
        // Scene2.getInstance().getAddButton().setDisable(false);
        // addButton.setDisable(false);
    }

    @FXML
    public void loadTable() {
        // localidadColumn = new TableColumn<>("Localidad");
        // terminalColumn = new TableColumn<>("Terminal");
        // matriculaColumn = new TableColumn<>("Matricula");
        // cantAsientosColumn = new TableColumn<>("Cantidad de asientos");
        // localidadColumn.setCellValueFactory(new
        // PropertyValueFactory<AuxClassBusTable, String>("Localiad"));
        // terminalColumn.setCellValueFactory(new PropertyValueFactory<AuxClassBusTable,
        // String>("Terminal"));
        // matriculaColumn.setCellValueFactory(new
        // PropertyValueFactory<AuxClassBusTable, String>("Matricula"));
        // cantAsientosColumn
        // .setCellValueFactory(new PropertyValueFactory<AuxClassBusTable,
        // Integer>("Cantidad de asientos"));
        // bus =
        // FXCollections.observableArrayList(University.getInstance().getTreeInfo());
        // tableBus.setItems(bus);
        if (localidadColumn == null && terminalColumn == null && matriculaColumn == null
                && cantAsientosColumn == null) {
            localidadColumn = new TableColumn<>("Localidad");
            terminalColumn = new TableColumn<>("Terminal");
            matriculaColumn = new TableColumn<>("Matricula");
            cantAsientosColumn = new TableColumn<>("Cantidad de asientos");
        }
        localidadColumn.setCellValueFactory(new PropertyValueFactory<AuxClassBusTable, String>("location"));
        terminalColumn.setCellValueFactory(new PropertyValueFactory<AuxClassBusTable, String>("terminal"));
        matriculaColumn.setCellValueFactory(new PropertyValueFactory<AuxClassBusTable, String>("bus"));
        cantAsientosColumn
                .setCellValueFactory(new PropertyValueFactory<AuxClassBusTable, Integer>("cantSeats"));

        // Agregar las columnas a la tabla
        tableBus.getColumns().addAll(localidadColumn, terminalColumn,
                matriculaColumn, cantAsientosColumn);

        update();

        // Asignar los datos a la tabla

    }

    public void update() {
        bus = FXCollections.observableArrayList(University.getInstance().getTreeInfo());
        tableBus.setItems(bus);
    }
}

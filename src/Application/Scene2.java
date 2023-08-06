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
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonModificar;

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
            try {
                String localidad = LocalidadTextField.getText();
                String terminal = TermianlTextField.getText();
                String bus = MatriculaTextField.getText();
                int seatsNum = (int) asientosSpinner.getValue();

                University.getInstance().insert(localidad, terminal, bus, seatsNum);

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
                alert.setTitle("Información");
                alert.setHeaderText(null);
                alert.setContentText("El omnibus se ha registrado correctamente.");
                alert.showAndWait();
            } catch (Exception e) {
                Alert alert = new Alert(AlertType.INFORMATION);
                // alert.initOwner(primaryStage); // Establecer la ventana principal como el
                // propietario del diálogo
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        } else {
            try {
                AuxClassBusTable aux = tableBus.getSelectionModel().getSelectedItem();

                University.getInstance().changeBus(aux.getLocation().getName(), aux.getTerminal().getId(),
                        aux.getBus().getTuition(), aux.getBus().getSeating());

                update();
                Alert alert = new Alert(AlertType.INFORMATION);
                // alert.initOwner(primaryStage); // Establecer la ventana principal como el
                // propietario del diálogo
                alert.setTitle("Información");
                alert.setHeaderText(null);
                alert.setContentText("El omnibus se ha modificado correctamente.");
                alert.showAndWait();
            } catch (Exception e) {
                Alert alert = new Alert(AlertType.INFORMATION);
                // alert.initOwner(primaryStage); // Establecer la ventana principal como el
                // propietario del diálogo
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
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
        try {
            AuxClassBusTable aux = tableBus.getSelectionModel().getSelectedItem();
            University.getInstance().deleteBus(aux.getLocation().getName(), aux.getTerminal().getId(),
                    aux.getBus().getTuition());
            update();
            Alert alert = new Alert(AlertType.INFORMATION);
            // alert.initOwner(primaryStage); // Establecer la ventana principal como el
            // propietario del diálogo
            alert.setTitle("Información");
            // alert.setHeaderText("");
            alert.setContentText("Se ha eliminado el omnibus correctamente");
            alert.showAndWait();
            buttonDelete.setDisable(true);
        } catch (Exception ex) {
            Alert alert = new Alert(AlertType.INFORMATION);
            // alert.initOwner(primaryStage); // Establecer la ventana principal como el
            // propietario del diálogo
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    public void buttonModificar(ActionEvent e) {
        String terminal = null;
        String localidad = null;
        String matricula = null;
        asientosSpinner.setDisable(false);
        EliminarButton.setDisable(false);
        AuxClassBusTable aux = tableBus.getSelectionModel().getSelectedItem();
        LocalidadTextField.setText(aux.getLocation().getName());
        TermianlTextField.setText(aux.getTerminal().getId());
        MatriculaTextField.setText(aux.getBus().getTuition());
        if (value)
            value = false;
    }

    public void ActivateButtonDelete() {
        // if (localidadColumn != null)
        buttonDelete.setDisable(false);
        buttonModificar.setDisable(false);
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
        LocalidadTextField.setText("");
        TermianlTextField.setText("");
        MatriculaTextField.setText("");
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
    // importante

    public void update() {
        bus = FXCollections.observableArrayList(University.getInstance().getTreeInfo());
        tableBus.setItems(bus);
    }
}

package Application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Logic.Bus;
import Logic.University;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Scale;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import util.AuxClassBusTable;

public class Controller {

    @FXML
    private Button salirButton;
    @FXML
    private AnchorPane scenePane2;
    @FXML
    private AnchorPane scenePane3;
    @FXML
    private Stage stage;
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
    private Spinner<Integer> asientosSpinner;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private TableView RegistroTabla;
    @FXML
    private Button InsertarButton;
    @FXML
    private ImageView icoInfoMat;
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

    public void drawMap() throws IOException {
        FXMLLoader root1 = FXMLLoader.load(getClass().getResource("map.fxml"));
        Pane map = root1.load();
        scrollPane.setContent(map);
    }

    public void loadScene2(MouseEvent e) throws IOException {
        Stage secondStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        secondStage.initModality(Modality.APPLICATION_MODAL);
        secondStage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root);
        String css = "style.css";
        scene.getStylesheets().add(css);
        scene.setFill(Color.rgb(243, 243, 243, 0.7));
        secondStage.setAlwaysOnTop(true);
        secondStage.setScene(scene);
        // loadTable();
        secondStage.show();

    }

    public void loadScene3(MouseEvent e) throws IOException {
        Stage thirdStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
        thirdStage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root);
        String css = "style.css";
        scene.getStylesheets().add(css);
        scene.setFill(Color.rgb(243, 243, 243, 0.6));
        thirdStage.setAlwaysOnTop(true);
        thirdStage.setScene(scene);
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

    public void closeWindow3(MouseEvent e) {
        // stage = (Stage) scenePane3.getScene().getWindow();
        stage.close();
    }

    // Establecer la escala inicial
    double initialScale = 1.0;

    // Configurar el gestor de eventos de scroll
    double zoomFactor = 1.5;
    // double minScale = 0.5;
    // double maxScale = 3.0;

    private final double ZOOM_FACTOR = 1.1; // Factor de zoom
    private double lastXX, lastYY;
    private double currentZoom = 1.0; // Nivel de zoom actual

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
        // loadTable();
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

    public void desplazar(ScrollEvent event) {
        if (event.isControlDown()) {
            event.consume();
            double deltaY = event.getDeltaY();
            double deltaScale = Math.pow(1.01, deltaY);
            double newScaleX = scrollPane.getScaleX() * deltaScale;
            double newScaleY = scrollPane.getScaleY() * deltaScale;
            scrollPane.setScaleX(newScaleX);
            scrollPane.setScaleY(newScaleY);
        }
    }

    private double lastX;
    private double lastY;

    @FXML
    private void handleMouseDragged(MouseEvent event) {
        double deltaX = event.getX() - lastX;
        double deltaY = event.getY() - lastY;

        panelMapa.setLayoutX(panelMapa.getLayoutX() + deltaX);
        panelMapa.setLayoutY(panelMapa.getLayoutY() + deltaY);

        lastX = event.getX();
        lastY = event.getY();
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
package Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.Init;

public class App extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Init.data();
        Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        Scene scene = new Scene(root);
        String css = "style.css";
        scene.getStylesheets().add(css);
        stage.setResizable(false);
        stage.setTitle("CUJAE-Rutas");
        stage.setScene(scene);
        stage.show();
    }
}
package Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }
//a
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        Scene scene = new Scene(root, 1100, 650);
        String css = "style.css";
        scene.getStylesheets().add(css);
        // stage.setFullScreen(true);
        stage.setResizable(false);
        stage.setTitle("CUJAE-Trans");
        stage.setScene(scene);
        stage.show();
    }
}
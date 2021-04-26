package by.teachmeskills.figuresfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.IOException;

public class FiguresFxApp extends Application {
    private static final Logger logger = Logger.getLogger(FiguresFxApp.class);

    @Override
    public void start(Stage window){
        window.setTitle("FXFigures");
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/mainScreenView.fxml"));
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        assert root != null;
        window.setScene(new Scene(root, 1024, 600));
        window.setResizable(false);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }

}

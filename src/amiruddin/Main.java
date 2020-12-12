package amiruddin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
//need to add-modules javafx.controls,javafx.fxml,javafx.media,javafx.graphics
//in order to run the program
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent vtypewriterparent = FXMLLoader.load(getClass().getResource(
                "resources/vtypewriter.fxml"));

        primaryStage.setTitle("Vtypewriter");
        primaryStage.setResizable(false);

        Scene vtypewriter = new Scene(vtypewriterparent);
        String vtypewriterIcon = getClass().getResource(
                "resources/vtypewriterIcon.png").toString();
        primaryStage.getIcons().add(new Image(vtypewriterIcon));
        primaryStage.setScene(vtypewriter);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

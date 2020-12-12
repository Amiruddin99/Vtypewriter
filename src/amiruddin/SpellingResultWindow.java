package amiruddin;

import amiruddin.controller.ResultWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class SpellingResultWindow {

    private static Stage checkResultWindow = null;

    public static Stage getSpellingResultWindow() {
        return checkResultWindow;
    }

    public static void createSpellingResultWindow(){
        checkResultWindow = new Stage();
        checkResultWindow.setAlwaysOnTop(true);
        checkResultWindow.setTitle("Spelling Mistake");
        checkResultWindow.setResizable(false);
        checkResultWindow.initModality(Modality.NONE);
    }

    public static void openSpellingResult(List<String> spellingMistake) {
        try {
            FXMLLoader fxmlLoader =
                    new FXMLLoader(SpellingResultWindow.
                            class.getResource("/amiruddin/resources/spellingResult.fxml"));

            Parent popUpWindow = fxmlLoader.load();

            ResultWindowController resultWindowController = fxmlLoader.getController();
            resultWindowController.setSpellingText(spellingMistake);

            SpellingResultWindow.getSpellingResultWindow().
                    setScene(new Scene(popUpWindow,400,200));
            SpellingResultWindow.getSpellingResultWindow().show();

        }catch (IOException exception) {
            System.err.println("openSpellingResult:"+exception.getMessage());
        }

    }
}

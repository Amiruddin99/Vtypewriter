package amiruddin.controller;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.List;

public class ResultWindowController {

    @FXML private TextFlow incorrectSpellingWindow;

    public void setSpellingText(List<String> spellingMistake)
    {
        if(spellingMistake.isEmpty()) {
            Text text = new Text(" There is no mistake detected.");
            this.incorrectSpellingWindow.getChildren().addAll(text);
        }
        else
            for(String word:spellingMistake) {
                Text text = new Text(word + "\n");
                text.setFill(Color.RED);
                Text initialText = new Text(" The mistake is ");
                this.incorrectSpellingWindow.getChildren().addAll(initialText,text);
            }
        spellingMistake.clear();//clear all the string in the spellingMistake list
    }

}

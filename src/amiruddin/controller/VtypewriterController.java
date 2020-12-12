package amiruddin.controller;

import amiruddin.SpellingResultWindow;
import amiruddin.utils.Save;
import amiruddin.utils.SpellingCheck;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;



public class VtypewriterController {

    private final SpellingCheck check = new SpellingCheck();
    private AudioClip typewriterClip = null;
    private final Save save = new Save();

    @FXML private TextArea typewriterText;
    @FXML private ToggleButton uppercase;

    @FXML
    private void initialize(){
        final String soundFileName = "/amiruddin/resources/typewriterSound.mp3";
        String buttonAudioFile = getClass().getResource(soundFileName).toString();
        typewriterClip = new AudioClip(buttonAudioFile);
        typewriterText.setEditable(true);//make it so that you cant use keyboard to type
        typewriterText.setWrapText(true);//go to newline when the when text reach max width
    }


    public void onMouseClick(MouseEvent mouseEvent) {
        Button specialButton = (Button) mouseEvent.getSource();
        String character = specialButton.getText();
        if(character.equalsIgnoreCase("Save As")) {
            save.saveText(typewriterText.getText());
            System.out.println("done");
        }
    }

    public void onMouseToggle() {
       if(uppercase.isPressed())
            typewriterClip.play();
    }

    public void onMousePressed(MouseEvent mouseEvent) {
        Button typewriterKey = (Button) mouseEvent.getSource();
        String character;
        character = typewriterKey.getText();

        switch (character) {
            case "SPACEBAR" ->  insertCharacter(" ");
            case "\u232b" -> removeCharacter();
            case "\u23ce" -> insertCharacter("\n");
            case "Clear" -> clearText();
            case "Check" -> SpellingResultWindow.openSpellingResult(
                    check.checkSpelling(typewriterText.getText() ));
            default ->{
                if (uppercase.isSelected())
                    insertCharacter(character);
                else
                    insertCharacter(character.toLowerCase());}
        }
    }

    public void clearText()
    {
        typewriterClip.play();
        if(!typewriterText.getText().isEmpty())
            typewriterText.clear();
    }
    public void insertCharacter(String character) {
        typewriterClip.play();
        typewriterText.setText(typewriterText.getText()+character);
    }

    public void removeCharacter() {
        typewriterClip.play();
        if(!typewriterText.getText().isEmpty()){
            typewriterText.setText(typewriterText.getText(0, typewriterText.getLength()-1));
        }
    }

}

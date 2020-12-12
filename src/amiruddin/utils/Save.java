package amiruddin.utils;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Save {

    public void saveText(String text)
    {

        FileChooser fileChooser = new FileChooser();

        //Create an extension filter
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        //set default directory for saving file
        String userDirectoryString = System.getProperty("user.dir");
        File userDirectory = new File(userDirectoryString);
        fileChooser.setInitialDirectory(userDirectory);

        //Create a save dialog window
        Stage saveStage = new Stage();
        File file = fileChooser.showSaveDialog(saveStage);

        //Save if file exist
        if(file != null){
            SaveFile(text, file);
        }

    }

    public void SaveFile(String content, File file){
        try {
            FileWriter fileWriter;

            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }
}

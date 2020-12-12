package amiruddin.utils;

import amiruddin.SpellingResultWindow;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SpellingCheck {

    private final List<String> wordDictionary = new ArrayList<>();
    private final List<String> incorrectWord = new ArrayList<>();

    public SpellingCheck() {
        loadDictionary();
        SpellingResultWindow.createSpellingResultWindow();
    }

    public void loadDictionary() {
        final String filePathName= "src/amiruddin/resources/words.txt";
        String word;

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePathName));
            try{
                while((word = bufferedReader.readLine()) != null )
                {
                    this.wordDictionary.add(word);
                }
            }catch (IOException i) {
                System.out.println("Error reading file");
            }
        }catch (FileNotFoundException e){
            System.out.println("Error loading text");
        }

        System.out.println("Dictionary loaded");
    }

    public List<String> checkSpelling(String typewriterString) {
        typewriterString = typewriterString.replaceAll("[^a-zA-Z0-9]", " ");
        Scanner checking = new Scanner(typewriterString);

        String currentWord;

        while(checking.hasNext()) {
            currentWord = checking.next();
            if(!check(currentWord)){
                this.incorrectWord.add(currentWord);
            }
        }

        return incorrectWord;
    }

    public boolean check(String currentWord) {
        boolean isSpelledCorrectly = false;
        int counter = 0;
        while(!isSpelledCorrectly && (counter < this.wordDictionary.size()) ){
            if(currentWord.trim().equalsIgnoreCase(this.wordDictionary.get(counter))) {
                isSpelledCorrectly = true;
            }
            counter++;
        }

        return isSpelledCorrectly;
    }

}

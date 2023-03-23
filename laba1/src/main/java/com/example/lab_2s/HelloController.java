package com.example.lab_2s;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.Scanner;

public class HelloController {
    @FXML
    private Label label;


    @FXML
    private TextArea textArea;
    @FXML
    private TextArea textArea2;
    @FXML
    private Label label2;

    @FXML
    private Label labelshliah;
    @FXML
    protected void Button() {
        String perevirka = "Будь ласка оберіть файл";
        if (labelshliah.getText().isEmpty()) {
            labelshliah.setText("Будь ласка оберіть файл");
        }
        else if(labelshliah.getText().equals(perevirka)){
            labelshliah.setText("Будь ласка оберіть файл");
        }
        else {
            String text = labelshliah.getText();
            String output = "";
            int key = 10;

            try (FileReader fr = new FileReader(labelshliah.getText())) {
                Scanner scanner = new Scanner(fr);

                while (scanner.hasNextLine())
                {
                    text = scanner.nextLine();
                    System.out.println(text);}
            } catch (IOException e) {
                label.setText("файлу немає");
            }

            char[] shufrovan = new char[text.length()];
            for (int i = 0; i < text.length(); i++) {
                if (Character.isLetter(text.charAt(i)) && Character.isUpperCase(text.charAt(i))) {
                    shufrovan[i] = (char) ((((((int)(text.charAt(i))) - 'A' + key) % 26) + 'A'));

                }
                else if (Character.isLetter(text.charAt(i)) && Character.isLowerCase(text.charAt(i))) {
                    shufrovan[i] = (char) (((((int)(text.charAt(i))) - 'a' + key) % 26) + 'a');
                }
                else {
                    output += text.charAt(i);
                }
                output += shufrovan[i];
            }
            textArea.setText(output);



        try (FileWriter writer = new FileWriter("C:\\Users\\XE\\Desktop\\Text.txt", false)) {//Змінити файл
            writer.write(output);
            writer.flush();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


}

    @FXML
    private void ButtonChoise1(){
        //для зашифровання коду вибрати файл
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            File file = fileChooser.showOpenDialog(null);
            String text = file.getAbsolutePath();
            labelshliah.setText(text);
        }catch (Exception e) {
            labelshliah.setText("Будь ласка оберіть файл");
        }
    }

    @FXML
    private void Button1() {

//для розшифровання коду
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            File file = fileChooser.showOpenDialog(null);
            String text = file.getAbsolutePath();
            label2.setText(text);
        }catch (Exception e) {
            label2.setText("Please select file");
        }
    }
    @FXML
    private void Button2() {


        String perevirka = "Будь ласка оберіть файл";
        if (label2.getText().isEmpty()) {
            label2.setText("Будь ласка оберіть файл");
        }
        else if(label2.getText().equals(perevirka)){
            label2.setText("Будь ласка оберіть файл");
        }
        else {
            String text = label2.getText();
            String output = "";
            int key = 16;

            try (FileReader fr = new FileReader(label2.getText())) {
                Scanner scanner = new Scanner(fr);

                while (scanner.hasNextLine())
                {
                    text = scanner.nextLine();
                    System.out.println(text);}
            } catch (IOException e) {
                label.setText("File not found");
            }

            char[] shufrovan = new char[text.length()];
            for (int i = 0; i < text.length(); i++) {
                if (Character.isLetter(text.charAt(i)) && Character.isUpperCase(text.charAt(i))) {
                    shufrovan[i] = (char) ((((((int)(text.charAt(i))) - 'A' + key) % 26) + 'A'));

                }
                else if (Character.isLetter(text.charAt(i)) && Character.isLowerCase(text.charAt(i))) {
                    shufrovan[i] = (char) (((((int)(text.charAt(i))) - 'a' + key) % 26) + 'a');
                }
                else {
                    output += text.charAt(i);
                }
                output += shufrovan[i];
            }
            textArea2.setText(output);


            try (FileWriter writer = new FileWriter("C:\\Users\\XE\\Desktop\\Text1.txt", false)) {//Змінити файл
                writer.write(output);
                writer.flush();

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
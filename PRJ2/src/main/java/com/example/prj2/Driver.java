package com.example.prj2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Driver extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("Huffman");
        AnchorPane g = new AnchorPane();
        Scene scene = new Scene(g, 500, 500);
        stage.setScene(scene);

        TextField t = new TextField();
        Button b = new Button("Browse");
        Button r = new Button("Read");
        Label la = new Label("Encode");

        la.setLayoutX(60);
        la.setLayoutY(100);
        la.setPrefSize(150,70);
        t.setPrefWidth(350);
        t.setLayoutY(20);
        t.setLayoutX(70);
        t.setDisable(true);
        b.setPrefSize(100,50);
        b.setLayoutY(70);
        b.setLayoutX(200);
        r.setPrefSize(100,50);
        r.setLayoutY(120);
        r.setLayoutX(200);
        Line l = new Line();
        l.setStartX(0);
        l.setStartY(170);
        l.setEndX(500);
        l.setEndY(170);

        TextField t1 = new TextField();
        Button b1 = new Button("Browse");
        Button r1 = new Button("Read");
        Label la1 = new Label("Decode");

        t1.setPrefWidth(350);
        t1.setLayoutY(180);
        t1.setLayoutX(70);
        t1.setDisable(true);
        b1.setPrefSize(100,50);
        b1.setLayoutY(230);
        b1.setLayoutX(200);
        r1.setPrefSize(100,50);
        r1.setLayoutY(280);
        r1.setLayoutX(200);
        la1.setLayoutX(60);
        la1.setLayoutY(250);
        la1.setPrefSize(150,70);

        g.getChildren().add(la1);
        g.getChildren().add(r1);
        g.getChildren().add(t1);
        g.getChildren().add(b1);

        g.getChildren().add(b);
        g.getChildren().add(r);
        g.getChildren().add(t);
        g.getChildren().add(l);
        g.getChildren().add(la);
        stage.show();
        Calc c = new Calc();

        b1.setOnAction(e->{

            FileChooser fileChooserShares = new FileChooser();
            fileChooserShares.setTitle("Select shares file .txt");


            File selectedFile = fileChooserShares.showOpenDialog(null);
            System.out.println(selectedFile);
            if (String.valueOf(selectedFile).equals("null")) {
                return;
            }
            else{

                t1.setText(selectedFile.toString());
            }
        });

        r1.setOnAction(e->{

            try {
                c.DeCode(t1.getText().toString());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            Node ro = c.de();
            c.GetDecode(ro,"");
            try {
                c.PrintDecode("C:\\Users\\ibrahim\\Dawnloads\\out."+c.strbath);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        r.setOnAction(e->{


            try {
                c.Scan(t.getText().toString());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            c.fun();
            try {
                c.PrintCode("C:\\Users\\ibrahim\\Downloads\\ourt.huff");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        b.setOnAction(e->{

            FileChooser fileChooserShares = new FileChooser();
            fileChooserShares.setTitle("Select shares file .txt");


            File selectedFile = fileChooserShares.showOpenDialog(null);
            System.out.println(selectedFile);
            if (String.valueOf(selectedFile).equals("null")) {
                return;
            }
            else{

                t.setText(selectedFile.toString());
            }

                });

    }

    public static void main(String[] args) throws IOException {










        launch();
    }
}
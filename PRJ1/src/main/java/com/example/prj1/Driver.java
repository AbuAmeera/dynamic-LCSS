package com.example.prj1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Driver extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Electric");
        AnchorPane g = new AnchorPane();
        AnchorPane g1 = new AnchorPane();
        ScrollPane scroll = new ScrollPane();
        Scene scene = new Scene(scroll, 500, 600);
        stage.setScene(scene);
        Calc c = new Calc();
        VBox vbox = new VBox();
        TextArea ta = new TextArea();
        Calc ce = new Calc();




        scroll.setContent(g);

        TextField t = new TextField();
        Button b = new Button("Browse");
        Button rb = new Button("Read");
        t.setDisable(true);
        t.setLayoutX(100);
        rb.setLayoutY(30);
        g1.getChildren().add(b);
        g1.getChildren().add(rb);
        g1.getChildren().add(t);
        Scene scene2= new Scene(g1,300,250);
        stage.setScene(scene2);
        stage.show();


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
        rb.setOnAction(e->{

            Calc co = new Calc();
            try {
                co.scan(t.getText().toString());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

            String str = c.ar1;
            String str1 = c.ar1;
            String rim = str1;
            String ans = null;
            try {
                ans = c.fun().trim();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

            int sp = ans.lastIndexOf(" ");
            if (ans == "y"){
                Label l = new Label("Wrong Input");
                g.getChildren().add(l);
            }
            else {
                int size = Integer.parseInt(ans.substring(sp + 1));
                ans = ans.substring(0, sp);
                int arr1[] = new int[c.size];
                int arr2[] = new int[c.size];

                int place = 0;

                if (c.flag == 1) {
                    Label l = new Label("Wrong Input");
                    g.getChildren().add(l);
                } else {
                    for (int i = 1; i <= c.size; i++) {

                        Label l = new Label();
                        l.setText(i + "");
                        Label l2 = new Label("");
                        Label l1 = new Label();

                        str = str.trim();

                        if (str.contains(" ")) {
                            int space = str.indexOf(" ");
                            //str = str.trim();
                            l1.setText(str.substring(0, space));

                            str = str.substring(space);
                        } else {

                            str = str.trim();
                            l1.setText(str);

                        }

                        Circle circle = new Circle(place, place, 20);

                        StackPane layout = new StackPane();

                        Circle circle1 = new Circle(place, place, 20);
                        StackPane layout1 = new StackPane();

                        layout.getChildren().addAll(circle, l1);
                        circle.setFill(Color.AQUA);

                        layout1.getChildren().addAll(circle1, l);
                        circle1.setFill(Color.AQUA);

                        layout.setLayoutX(10);
                        layout.setLayoutY(place);

                        layout1.setLayoutX(200);
                        layout1.setLayoutY(place);

                        int r = Integer.parseInt(l.getText().trim());
                        arr1[r - 1] = place;
                        r = Integer.parseInt(l1.getText().trim());
                        arr2[r - 1] = place;

                        g.getChildren().add(layout);
                        g.getChildren().add(layout1);
                        place += 45;


                    }


                    int s;
                    int sx = 40, ex = 200;
                    System.out.println(ans);
                    for (int i = 0; i < size; i++) {

                        Line line = new Line();
                        String strl;
                        ans = ans.trim();
                        int stringLengthWithoutSpaces = ans.length() - ans.replace(" ", "").length();
                        int fans;
                        if (stringLengthWithoutSpaces > 0) {
                            int space = ans.indexOf(" ");
                            strl = ans.substring(0, space);
                            ans = ans.substring(space + 1);
                            fans = Integer.parseInt(strl.trim());
                        } else {

                            fans = Integer.parseInt(ans.trim());
                        }

                        line.setStartX(40);
                        line.setStartY(arr2[fans - 1] + 20);
                        line.setEndX(200);
                        line.setEndY(arr1[fans - 1] + 20);
                        g.getChildren().add(line);
                    }
                    ta.setText(ce.stre);
                    ta.setLayoutY(place + 10);
                    g.getChildren().add(ta);
                }
            }
            Stage s = new Stage();
            s.setScene(scene);
            s.show();
            stage.close();
        });




    }

    public static void main(String[] args) throws FileNotFoundException {

        launch();
    }
}
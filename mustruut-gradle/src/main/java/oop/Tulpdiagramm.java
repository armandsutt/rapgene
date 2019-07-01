/*

package oop;
import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.effect.InnerShadow;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.util.Scanner;

public class Tulpdiagramm extends Application {
    public List<Integer> Väljastamine(String failinimi)
        throws Exception {
        List<Integer> täisarvud = new ArrayList<>();
        File fail = new File("andmed.txt");
        try (Scanner scan = new Scanner(fail, "UTF-8")) {
            while (scan.hasNextLine()) {
                String rida = scan.nextLine();
                täisarvud.add(Integer.parseInt(rida));
            }

            System.out.println(Arrays.toString(täisarvud.toArray()));
        }
        return täisarvud;
    }

    @Override
    public void start(Stage peaLava) {

        Group juur = new Group();
        Canvas lõuend = new Canvas(600,600);
        juur.getChildren().add(lõuend);




        Scene stseen1 = new Scene(juur);

        peaLava.setTitle("Tulpdiagramm");
        peaLava.setScene(stseen1);
        peaLava.show();
    }

    public static void main(String[] args) throws Exception {
            launch(args);
        }
    }
 }

 */
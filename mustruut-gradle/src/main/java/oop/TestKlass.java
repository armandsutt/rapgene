package oop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
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

import static javafx.application.Application.launch;

public class TestKlass extends Application {

    public static List<String> loeSisse (String faill) throws Exception {
        File fail = new File(faill);
        List<String> list = new ArrayList<>();

        try (Scanner sc = new Scanner(fail, "UTF-8")) {
            while (sc.hasNextLine()) {
                String rida = sc.nextLine();
                rida = rida + " ";
                list.add(rida);
            }
        }
        return list;
    }

    public void start(Stage peaLava) throws Exception {

        Group juur = new Group();
        Canvas lõuend = new Canvas(535, 535);
        GraphicsContext gc = lõuend.getGraphicsContext2D();
        gc.fillRect(50, 50, 435, 435);
        juur.getChildren().add(lõuend);
        Scene stseen1 = new Scene(juur);
        Button nupp1 = new Button("yEEt");
        nupp1.setLayoutX(100);
        nupp1.setLayoutY(60);

        peaLava.setTitle("Must ruut");
        peaLava.setScene(stseen1);
        peaLava.show();
    }

    public static void main(String[] args) throws Exception{
        List<String> eesliide = loeSisse("C://Users//kaibu//OneDrive//Töölaud//YLI//OOP//mustruut-gradle//eesliide");
        List<String> suurSõna = loeSisse("C://Users//kaibu//OneDrive//Töölaud//YLI//OOP//mustruut-gradle//suurSõna");

        Küsimused küsimused = new Küsimused(loeSisse("C://Users//kaibu//OneDrive//Töölaud//YLI//OOP//mustruut-gradle//kysimused"));
        List<String> vastused = new ArrayList<>();

        SuvalineKüsimus nimekiri = new SuvalineKüsimus(küsimused);
        Scanner scan = new Scanner(System.in);

        for (String küsimus : nimekiri.Tsükkel()) {
            System.out.println(küsimus);
            String vastus = scan.nextLine();
            vastused.add(vastus);
        }

        System.out.println("Lavale astuvad:");
        Esinejad esinejateNimed = new Esinejad(eesliide, vastused, suurSõna);
        esinejateNimed.väljastaEsinejad();

        /*Hääl hääl = new Hääl(esinejateNimed);
        hääl.teeHäält();*/

        launch(args);
    }
}

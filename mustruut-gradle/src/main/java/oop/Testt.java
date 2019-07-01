package oop;
import javafx.animation.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.util.Duration;

import javax.accessibility.AccessibleValue;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Testt extends Application {

    public static List<String> loeSisse(String faill) throws Exception{
        File fail = new File(faill);
        List<String> list = new ArrayList<>();

        try (Scanner sc = new Scanner(fail, "UTF-8")){
            while (sc.hasNextLine()){
                String rida = sc.nextLine();
                rida = rida + " ";
                list.add(rida);
            }
        }

        return list;
    }

    @Override
    public void start(Stage peaLava) throws Exception, TühjaVäljaErind {

        List<String> eesliide = loeSisse("C://Users//kaibu//OneDrive//Töölaud//YLI//OOP//mustruut-gradle//eesliide");
        List<String> suurSõna = loeSisse("C://Users//kaibu//OneDrive//Töölaud//YLI//OOP//mustruut-gradle//suurSõna");

        Küsimused küsimused = new Küsimused(loeSisse("C://Users//kaibu//OneDrive//Töölaud//YLI//OOP//mustruut-gradle//kysimused"));
        List<String> vastused = new ArrayList<>();

        SuvalineKüsimus nimekiri = new SuvalineKüsimus(küsimused);
        Scanner scan = new Scanner(System.in);

        List<String> vägaÕigedKüsimused = nimekiri.Tsükkel();

        // avaleht, stseen1
        Group juur1 = new Group();
        Scene stseen = new Scene(juur1, 800, 600, Color.BEIGE);

        Text avakirje = new Text();
        avakirje.setX(60);
        avakirje.setY(400);
        avakirje.setText("RAPGENE");
        avakirje.setFill(Color.CHOCOLATE);
        avakirje.setFont(Font.font(null, FontWeight.BOLD, 150));
        avakirje.setEffect(new GaussianBlur());
        Text allaNurka = new Text();
        allaNurka.setX(600);
        allaNurka.setY(560);
        allaNurka.setText("Press any button to le continue");
        allaNurka.setFill(Color.VIOLET);

        juur1.getChildren().addAll(avakirje, allaNurka);

        peaLava.setTitle("RAPGENE!!!!!!!!!");
        peaLava.setScene(stseen);
        peaLava.show();

        //stseen2
        //Küsimuste ja kastide väljastamine
        VBox juur2 = new VBox();
        juur2.setAlignment(Pos.CENTER);
        Label kys1 = new Label(vägaÕigedKüsimused.get(0));
        TextField väli1 = new TextField();
        väli1.setPrefWidth(300);
        juur2.setSpacing(10);

        Label kys2 = new Label(vägaÕigedKüsimused.get(1));
        TextField väli2 = new TextField();
        väli2.setPrefWidth(300);

        Label kys3 = new Label(vägaÕigedKüsimused.get(2));
        TextField väli3 = new TextField();
        väli3.setPrefWidth(300);

        Label kys4 = new Label(vägaÕigedKüsimused.get(3));
        TextField väli4 = new TextField();
        väli4.setPrefWidth(300);

        Label kys5 = new Label(vägaÕigedKüsimused.get(4));
        TextField väli5 = new TextField();
        väli5.setPrefWidth(300);

        Label kys6 = new Label(vägaÕigedKüsimused.get(5));
        TextField väli6 = new TextField();
        väli6.setPrefWidth(300);

        Button submit = new Button("Läksime!");

        List<Label> küssad = new ArrayList<>();
        küssad.add(kys1);
        küssad.add(kys2);
        küssad.add(kys3);
        küssad.add(kys4);
        küssad.add(kys5);
        küssad.add(kys6);

        juur2.getChildren().addAll(kys1, väli1, kys2, väli2, kys3, väli3, kys4, väli4, kys5, väli5, kys6, väli6, submit);

        //kuva 3
        VBox juur3 = new VBox();

        submit.setOnMouseClicked(event -> {
            vastused.add(väli1.getText());
            vastused.add(väli2.getText());
            vastused.add(väli3.getText());
            vastused.add(väli4.getText());
            vastused.add(väli5.getText());
            vastused.add(väli6.getText());

            if (vastused.contains("")) {
                for (String väli : vastused) {
                    if (väli.equals("")) {
                         try {
                             throw new TühjaVäljaErind(küssad.get(vastused.indexOf(väli)));

                         } catch (TühjaVäljaErind tühjaVäljaErind) {
                             vastused.clear();
                             break;
                         }
                    }
                }
            }

            else {
                stseen.rootProperty().setValue(juur3);
                juur3.setAlignment(Pos.CENTER);
                Esinejad esinejateNimed = new Esinejad(eesliide, vastused, suurSõna);

                /*Hääl hääl = new Hääl(esinejateNimed);
                hääl.teeHäält();*/

                Label pealkiri = new Label("LAVALE ASTUVAAAD: ");
                pealkiri.setScaleX(5);
                pealkiri.setScaleY(5);
                pealkiri.setTextFill(Color.INDIANRED);
                pealkiri.setPadding(new Insets(0, 10, 10, 10));
                juur3.getChildren().add(pealkiri);
                for (String nimi : esinejateNimed.getEsinejad()) {
                    Label silt = new Label(nimi);
                    silt.setScaleX(3);
                    silt.setScaleY(2);
                    silt.setTextFill(Color.LIGHTCORAL);
                    silt.setPadding(new Insets(10, 10, 15, 10));
                    juur3.getChildren().add(silt);
                }

                try (BufferedWriter bw = new BufferedWriter( //faili kirjutamine
                        new FileWriter(new File("nimed.txt")))) {

                    bw.write("Lavale astuvad:");
                    bw.newLine();
                    for (String nimi : esinejateNimed.getEsinejad()) {
                        bw.write(nimi);
                        bw.newLine();
                    }
                } catch (IOException ioe) {
                    System.out.println("Probleem!");
                }
            }
        });

        stseen.setOnKeyPressed(event -> {
            stseen.rootProperty().setValue(juur2);
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
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

public class MustRuut extends Application {

    @Override
    public void start(Stage peaLava) {

        Group juur = new Group();
        Canvas lõuend = new Canvas(535, 535);
        GraphicsContext gc = lõuend.getGraphicsContext2D();
        gc.fillRect(50, 50, 435, 435);
        juur.getChildren().add(lõuend);
        Scene stseen1 = new Scene(juur);
        Button nupp1 = new Button("yEEt");
        nupp1.setLayoutX(100);
        nupp1.setLayoutY(60);

        //Ülesanne 4.
        InnerShadow vari = new InnerShadow(1, Color.BLUEVIOLET);
        vari.setOffsetX(3);
        vari.setOffsetY(7);
        nupp1.setEffect(vari);
        juur.getChildren().add(nupp1);

        //Ülesanne 5.
        Polygon kolmnurk = new Polygon();
        kolmnurk.getPoints().addAll(new Double[]{
                300.0, 70.0,
                90.0, 200.0,
                400.0, 80.0});
        kolmnurk.setFill(Color.YELLOW);
        juur.getChildren().add(kolmnurk);

        Path path = new Path();
        path.getElements().add(new MoveTo(90,60));
        path.getElements().add(new CubicCurveTo(400,
                40, 175, 250, 500,
                150));

        PathTransition pathTransition1 = new PathTransition();
        pathTransition1.setDuration(Duration.millis(1000));
        pathTransition1.setNode(kolmnurk);
        pathTransition1.setPath(path);

        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(5);
        rotateTransition.setAutoReverse(true);

        ParallelTransition pt = new ParallelTransition(kolmnurk,
                pathTransition1,
                rotateTransition);

        SequentialTransition st = new SequentialTransition(
                kolmnurk, pathTransition1, rotateTransition
        );

        SequentialTransition stt = new SequentialTransition(
                kolmnurk, pt, st
        );
        stt.play(); //et teeks paralleelse ja sequentiali järjest:D




        peaLava.setTitle("Must ruut");
        peaLava.setScene(stseen1);
        peaLava.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
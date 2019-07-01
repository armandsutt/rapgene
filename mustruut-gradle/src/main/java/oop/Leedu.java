package oop;
import javafx.application.Application;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Leedu extends Application {

    @Override
    public void start(Stage peaLava) {

        Group juur = new Group();
        Canvas lõuend = new Canvas(1000, 600);
        GraphicsContext gc = lõuend.getGraphicsContext2D();
        gc.setFill(Color.YELLOW);
        gc.fillRect(0, 0, 1000, 200);
        gc.setFill(Color.GREEN);
        gc.fillRect(0, 200, 1000, 200);
        gc.setFill(Color.RED);
        gc.fillRect(0, 400, 1000, 200);
        juur.getChildren().add(lõuend);

        //3. ülesanne algab siit
        Circle ring1 = new Circle(100, 100, 100, Color.RED);
        ring1.setOnMouseEntered(event -> ring1.setFill(
                Color.BLACK
        ));
        ring1.setOnMouseExited(event -> ring1.setFill(Color.RED));

        ring1.setOnMouseClicked(event -> ring1.setRadius(20));

        //lõppeb siin

        juur.getChildren().add(ring1);

        Scene stseen1 = new Scene(juur);

        peaLava.setTitle("Lietuva");
        peaLava.setScene(stseen1);
        peaLava.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

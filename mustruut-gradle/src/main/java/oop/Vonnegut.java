//Ülesanne 7.

package oop;
import javafx.animation.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;

public class Vonnegut extends Application {

    @Override
    public void start(Stage peaLava) {
        double i=0.75;
        FlowPane flow = new FlowPane();

        Canvas lõuend = new Canvas(600, 600);
        GraphicsContext gc = lõuend.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(375*i, 50*i, 50*i, 700*i);
        gc.fillRect(50*i,375*i,700*i,50*i);
        gc.fillPolygon(new double[]{700*i,125*i,100*i,675*i},
        new double[]{675*i,100*i,125*i,700*i}, 4);
        gc.fillPolygon(new double[]{100*i,675*i,700*i,125*i},
                new double[]{675*i,100*i,125*i,700*i}, 4);
        flow.getChildren().add(lõuend);

        Circle ring = new Circle();
        ring.setCenterX(400);
        ring.setCenterY(400);
        ring.setRadius(20);
        ring.setFill(Color.BLACK);
        flow.getChildren().add(ring);

        BorderPane border = new BorderPane();
        border.setMinWidth(800);

        HBox hbox = new HBox();
        Label silt = new Label("juhhei");
        hbox.getChildren().add(silt);
        border.setCenter(hbox);


        Circle ring1 = new Circle(100, 100, 100, Color.RED);
        flow.getChildren().add(ring1);
// setOnMouseEntered määrab sündmuse käsitleja
// käsitleja defineeritakse anonüümse klassiga
        ring1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                ring1.setFill(Color.GREEN);
                // siin saab kasutada ka ümbritsevas skoobis olevaid muutujaid, nt ring1
                System.out.println("Hiir läks ringi peale");
            }
        });

        flow.getChildren().add(border);

        ScaleTransition st = new ScaleTransition(Duration.millis(1000), ring);
        st.setByX(40);
        st.setByY(40);
        st.setCycleCount(4);
        st.setAutoReverse(true);
        st.play();

        Scene stseen1 = new Scene(flow, 800, 800);
        peaLava.setTitle("Vonnegut");
        peaLava.setScene(stseen1);
        peaLava.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
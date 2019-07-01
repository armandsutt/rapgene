package oop;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Ül6 extends Application {

    @Override
    public void start(Stage peaLava) {
        int laius = 250;
        int kõrgus = 150;

        Group juur = new Group();

        Label tekst = new Label();
        tekst.setText("Mitu jalga on jaanalinnul?");
        juur.getChildren().add(tekst);

        Button nupp1 = new Button("Kaheksa");
        nupp1.setLayoutX(0);
        nupp1.setLayoutY(50);

        Button nupp2 = new Button("Kaksteist");
        nupp2.setLayoutX(0);
        nupp2.setLayoutY(75);

        Button nupp3 = new Button("Kaks");
        nupp3.setLayoutX(0);
        nupp3.setLayoutY(100);
        juur.getChildren().addAll(nupp1, nupp2, nupp3);

        nupp1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tekst.setText("Proovi veel!!");
                juur.getChildren().remove(nupp1);
            }
        });

        nupp2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                juur.getChildren().remove(nupp2);
                tekst.setText("Proovi uuesti!!!!!");
            }
        });

        nupp3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                nupp3.setTextFill(Color.GREEN);
                tekst.setText("JUHHEI!");
                nupp1.setTextFill(Color.BLACK);
                nupp2.setTextFill(Color.BLACK);
            }
        });

        Scene stseen1 = new Scene(juur, laius, kõrgus, Color.SNOW);
        peaLava.setScene(stseen1);
        peaLava.setTitle("Jaanalind");
        peaLava.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
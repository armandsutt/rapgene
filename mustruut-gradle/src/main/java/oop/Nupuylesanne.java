//Ülesanne 4

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

public class Nupuylesanne extends Application {

    @Override
    public void start(Stage peaLava) {
        int laius = 250;
        int kõrgus = 150;

        Group juur = new Group();

        Button nupp1 = new Button("can't touch this");

        nupp1.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        nupp1.setLayoutX(
                                (int)(Math.random()*laius));
                        nupp1.setLayoutY(
                                (int)(Math.random()*kõrgus));
                    }
                });

        juur.getChildren().add(nupp1);

        Scene stseen1 = new Scene(juur, laius, kõrgus, Color.SNOW);
        peaLava.setScene(stseen1);
        peaLava.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

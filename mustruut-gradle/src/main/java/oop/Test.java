package oop;
import javafx.animation.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;

import java.sql.Time;

public class Test extends Application {

    @Override
    public void start(Stage peaLava) {
        FlowPane flow = new FlowPane();

        TextField tekst = new TextField("mingi tekst");
        flow.getChildren().add(tekst);

        ListView<String> list = new ListView<String>();
        ObservableList<String> items = FXCollections.observableArrayList (
                "Esimene", "Teine", "Kolmas", "Neljas");
        list.setMaxHeight(100);
        list.setItems(items);
        flow.getChildren().add(list);

        BorderPane border = new BorderPane();
        border.setMinWidth(250);

        Button nupp1 = new Button("1");
        border.setLeft(nupp1);
        Button nupp2 = new Button("2");
        border.setRight(nupp2);

        HBox hbox = new HBox();
        Label silt1 = new Label("silt1");
        Label silt2 = new Label("silt2");
        hbox.getChildren().addAll(silt1, silt2);
        border.setCenter(hbox);

        flow.getChildren().add(border);

        Scene stseen1 = new Scene(flow, 250, 150, Color.SNOW);
        peaLava.setScene(stseen1);
        peaLava.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
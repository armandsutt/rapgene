package oop;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class TühjaVäljaErind extends Exception {

    public TühjaVäljaErind(Label silt) {
        silt.setTextFill(Color.RED);
    }
}

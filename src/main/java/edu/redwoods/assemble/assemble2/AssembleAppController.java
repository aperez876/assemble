package edu.redwoods.assemble.assemble2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AssembleAppController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
package Trajectory.View;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

class LeftPanel {

    GridPane gridPane;
    TextField inputX;
    TextField inputY;
    TextField inputVx;
    TextField inputVy;
    TextField inputDt;


    LeftPanel() {
        gridPane = WindowUtils.createGridPane();
        gridPane.setAlignment(Pos.BASELINE_RIGHT);
        Label x = WindowUtils.createLabel("X");
        Label y = WindowUtils.createLabel("Y");
        Label xVelocity = WindowUtils.createLabel("X Velocity");
        Label yVelocity = WindowUtils.createLabel("Y Velocity");
        Label timeStep = WindowUtils.createLabel("Time step:");
        inputX = createTextField();
        inputY = createTextField();
        inputVx = createTextField();
        inputVy = createTextField();
        inputDt = createTextField();
        gridPane.add(x, 0, 0);
        gridPane.add(inputX, 1, 0);
        gridPane.add(y, 0, 1);
        gridPane.add(inputY, 1, 1);
        gridPane.add(xVelocity, 0, 2);
        gridPane.add(inputVx, 1, 2);
        gridPane.add(yVelocity, 0, 3);
        gridPane.add(inputVy, 1, 3);
        gridPane.add(timeStep, 0, 4);
        gridPane.add(inputDt, 1, 4);
    }

    private static TextField createTextField() {
        TextField textField = new TextField();
        textField.setMaxWidth(50);
        return textField;
    }
}

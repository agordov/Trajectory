package Trajectory.View;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

class LeftPanel {

    GridPane gridPane;
    TextField inputX;
    TextField inputY;
    TextField inputVx;
    TextField inputVy;
    TextField inputDt;


    LeftPanel() {
        gridPane = WindowUtils.createGridPane();
        Label x = WindowUtils.createLabel("X");
        Label y = WindowUtils.createLabel("Y");
        Label coordinates = WindowUtils.createLabel("Coordinates");
        Label velocity = WindowUtils.createLabel("Velocity");
        Label timeStep = WindowUtils.createLabel("Time step:");
        inputX = createTextField();
        inputY = createTextField();
        inputVx = createTextField();
        inputVy = createTextField();
        inputDt = new TextField();
        gridPane.add(new StackPane(x), 1, 0);
        gridPane.add(new StackPane(y), 2, 0);
        gridPane.add(coordinates, 0, 1);
        gridPane.add(inputX, 1, 1);
        gridPane.add(inputY, 2, 1);
        gridPane.add(velocity, 0, 2);
        gridPane.add(inputVx, 1, 2);
        gridPane.add(inputVy, 2, 2);
        gridPane.add(timeStep, 0, 3);
        gridPane.add(inputDt, 1, 3, 2, 1);
    }

    private static TextField createTextField() {
        TextField textField = new TextField();
        textField.setMaxWidth(50);
        return textField;
    }
}

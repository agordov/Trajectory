package Trajectory.View;

import Trajectory.Controller.ClearController;
import Trajectory.Controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static Trajectory.View.WindowUtils.*;

public class Window extends Application{
    private static Button startButton;
    private static Button clearButton;
    private static GridPane gridPane;
    private static LineChart<Number, Number> trajectoryGraph;
    private static Text errorField;
    private static TextField inputX;
    private static TextField inputY;
    private static TextField inputVx;
    private static TextField inputVy;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Trajectory");

        gridPane = createGridPane();
        startButton = new Button("Start");
        HBox hBox = createHBox();
        hBox.getChildren().add(startButton);
        clearButton = new Button("Clear");
        hBox.getChildren().add(clearButton);
        gridPane.add(new StackPane(hBox), 1, 1);

        RightPanel rightPanel = new RightPanel();
        HBox bottomPanel = createBottomPanel();
        Scene scene = new Scene(gridPane, 640, 480);
        stage.setScene(scene);

        gridPane.setGridLinesVisible(true);
        gridPane.add(bottomPanel, 0, 1);
        gridPane.add(rightPanel.gridPane, 1, 0);


        errorField = createText("");
        gridPane.add(new StackPane(errorField), 0, 2);
        trajectoryGraph = createLineChart();
        trajectoryGraph.setCreateSymbols(false);
        trajectoryGraph.setTitle("Trajectories");
        gridPane.add(trajectoryGraph, 0, 0);

        clearButton.setOnAction(new ClearController(trajectoryGraph, errorField));

        startButton.setOnAction(new Controller(trajectoryGraph, errorField, inputX, inputY, inputVx, inputVy,
                rightPanel.distanceValue, rightPanel.maxHeightValue, rightPanel.flightTimeValue));

        stage.show();
    }

    private static HBox createBottomPanel() {
        HBox hBox = createHBox();
        Label x = createLabel("X");
        Label y = createLabel("Y");
        Label vX = createLabel("Vx");
        Label vY = createLabel("Vy");
        inputX = createTextField();
        inputY = createTextField();
        inputVx = createTextField();
        inputVy = createTextField();
        hBox.getChildren().addAll(
                new VBox(x, inputX),
                new VBox(y, inputY),
                new VBox(vX, inputVx),
                new VBox(vY, inputVy)
        );
        return hBox;
    }

    private static TextField createTextField() {
        TextField textField = new TextField();
        textField.setMaxWidth(50);
        return textField;
    }

    private static LineChart<Number, Number> createLineChart() {
        NumberAxis x = new NumberAxis();
        NumberAxis y = new NumberAxis();
        return new LineChart<>(x, y);
    }

}

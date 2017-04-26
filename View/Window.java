package Trajectory.View;

import Trajectory.Controller.ClearController;
import Trajectory.Controller.Controller;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static Trajectory.View.WindowUtils.*;

public class Window extends Application{
    private Button startButton;
    private Button clearButton;
    private BorderPane borderPane;
    private LineChart<Number, Number> trajectoryGraph;
    private Text errorField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Trajectory");

        borderPane = new BorderPane();
        borderPane.setPrefSize(640, 480);

        RightPanel rightPanel = new RightPanel();
        LeftPanel leftPanel = new LeftPanel();
        Scene scene = new Scene(borderPane, 640, 480);
        stage.setScene(scene);

        HBox hBox = createHBox();
        hBox.setAlignment(Pos.BASELINE_RIGHT);
        startButton = new Button("Start");
        clearButton = new Button("Clear");
        hBox.getChildren().add(clearButton);
        hBox.getChildren().add(startButton);
        leftPanel.gridPane.add(new StackPane(hBox), 0, 4, 3, 1);

        trajectoryGraph = createLineChart();
        trajectoryGraph.setCreateSymbols(false);
        trajectoryGraph.setTitle("Trajectories");

        borderPane.setVisible(true);
        borderPane.setLeft(leftPanel.gridPane);
        borderPane.setRight(rightPanel.gridPane);
        borderPane.setCenter(trajectoryGraph);
        errorField = createText("");
        borderPane.setBottom(new StackPane(errorField));

        clearButton.setOnAction(new ClearController(trajectoryGraph, errorField,
                leftPanel.inputX, leftPanel.inputY, leftPanel.inputVx, leftPanel.inputVy, leftPanel.inputDt));

        startButton.setOnAction(new Controller(trajectoryGraph, errorField,
                leftPanel.inputX, leftPanel.inputY, leftPanel.inputVx, leftPanel.inputVy, leftPanel.inputDt,
                rightPanel.distanceValue, rightPanel.maxHeightValue, rightPanel.flightTimeValue));

        stage.show();
    }


    private static LineChart<Number, Number> createLineChart() {
        NumberAxis x = new NumberAxis();
        NumberAxis y = new NumberAxis();
        return new LineChart<>(x, y);
    }
}

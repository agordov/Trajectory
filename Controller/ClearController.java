package Trajectory.Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.chart.LineChart;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ClearController implements EventHandler<ActionEvent> {
    private LineChart<Number, Number> lineChart;
    private Text errorField;
    private TextField inputX;
    private TextField inputY;
    private TextField inputVx;
    private TextField inputVy;
    private TextField inputDt;
    private Text maxHeightValue;
    private Text flightTimeValue;
    private Text distanceValue;

    public ClearController(LineChart<Number, Number> lineChart, Text errorField,
                           TextField inputX, TextField inputY, TextField inputVx, TextField inputVy, TextField inputDt,
                           Text maxHeightValue, Text flightTimeValue, Text distanceValue) {
        this.lineChart = lineChart;
        this.errorField = errorField;
        this.inputX = inputX;
        this.inputY = inputY;
        this.inputVx = inputVx;
        this.inputVy = inputVy;
        this.inputDt = inputDt;
        this.maxHeightValue = maxHeightValue;
        this.flightTimeValue = flightTimeValue;
        this.distanceValue = distanceValue;
    }

    private void clearChart() {
        lineChart.getData().removeAll(lineChart.getData());
        errorField.setText("");
        inputX.setText("");
        inputY.setText("");
        inputVx.setText("");
        inputVy.setText("");
        inputDt.setText("");
        maxHeightValue.setText("");
        flightTimeValue.setText("");
        distanceValue.setText("");
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        clearChart();
    }
}

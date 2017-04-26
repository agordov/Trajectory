package Trajectory.Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.chart.LineChart;
import javafx.scene.text.Text;

public class ClearController implements EventHandler<ActionEvent> {
    private LineChart<Number, Number> lineChart;
    private Text errorField;

    public ClearController(LineChart<Number, Number> lineChart, Text errorField) {
        this.lineChart = lineChart;
        this.errorField = errorField;
    }

    private void clearChart() {
        lineChart.getData().removeAll(lineChart.getData());
        errorField.setText("");
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        clearChart();
    }
}

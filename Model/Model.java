package Trajectory.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public class Model {

    private final double FFA = 9.81;

    public ObservableList<XYChart.Data> createTrajectory(double x0, double y0, double vx, double vy, double dt) {
        // XYChart.Series<Number, Number> series = new XYChart.Series<>();
        ObservableList<XYChart.Data> data = FXCollections.observableArrayList();
        double x = x0;
        double y = y0;
        while(y != 0) {
            data.add(new XYChart.Data<Number, Number>(x, y));
            x += vx * dt;
            y += vy * dt + FFA * dt * dt / 2;
        }
        return data;
    }
}

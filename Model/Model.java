package Trajectory.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public class Model {


    private final double FFA = 9.81;
    private double x;
    private double y;
    private double vx;
    private double vy;
    private double dt;

    public Model(double x, double y, double vx, double vy, double dt) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.dt = dt;
    }

    public XYChart.Series<Number, Number> createTrajectory() {
        ObservableList<XYChart.Data<Number, Number>> data = FXCollections.observableArrayList();
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        double xcur;
        double ycur = y;
        double t = 0;
        while(ycur >= 0) {
            xcur = vx * t + x;
            ycur = y + vy * t - FFA * t * t / 2;
            t += dt;
            data.add(new XYChart.Data<>(xcur, ycur));
        }
        series.setData(data);
        return series;
    }

    public double maxHeight() {
        return y + vy * vy / 2 / FFA;
    }

    public double flightTime() {
        return (vy + Math.sqrt(vy * vy + 2 * FFA * y)) / 2;
    }

    public double maxDistance() {
        return flightTime() * vx + x;
    }

}

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

    public ObservableList<XYChart.Data> createTrajectory() {
        ObservableList<XYChart.Data> data = FXCollections.observableArrayList();
        double xcur = x;
        double ycur = y;
        while(ycur != 0) {
            data.add(new XYChart.Data<Number, Number>(xcur, ycur));
            xcur += vx * dt;
            ycur += vy * dt + FFA * dt * dt / 2;
        }
        return data;
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

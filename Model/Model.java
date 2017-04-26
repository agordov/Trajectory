package Trajectory.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public class Model {

    private final double FFA = 9.81;
    private final double AIR_DRAG = 1;
    private final double m = 1;
    private double x;
    private double y;
    private double vx;
    private double vy;
    private double dt;
    private double t;
    private double airDrag;



    public Model(double x, double y, double vx, double vy, double dt, boolean airDragEx) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.dt = dt;
        this.t = 0;
       if(airDragEx )
           this.airDrag = AIR_DRAG;
    }

    public XYChart.Series<Number, Number> createTrajectory() {
        ObservableList<XYChart.Data<Number, Number>> data = FXCollections.observableArrayList();
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        double xCur;
        double yCur = y;
        double vxCur;
        double vyCur;
        while(yCur >= 0) {
            vxCur = vx - airDrag*vx*t/m;
            vyCur = vy - (FFA+airDrag*vy/m)*t;
            xCur = x + vxCur * t ;
            yCur = y + vyCur * t;
            t += dt;
            data.add(new XYChart.Data<>(xCur, yCur));
        }
        series.setData(data);
        return series;
    }

    public double maxHeight() {
        double t = m/(airDrag+m*FFA);
        return y + vy *t*(1+airDrag/m) - FFA*t*t;
    }

    public double flightTime() {
        return t;
//        return (vy + Math.sqrt(vy * vy + 2 * FFA * y)) / 2;
    }

    public double maxDistance() {
        return flightTime() * vx* (1 - airDrag / m) + x;
    }

}

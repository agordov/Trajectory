package Trajectory.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public class Model {

    private final double FFA = 9.81;
    private final double AIR_DRAG = 0.8;
    private final double m = 1;
    private double x;
    private double y;
    private double vx;
    private double vy;
    private double dt;
    private double t;
    private double airDrag;
    private double maxH;
    private double distance;



    public Model(double x, double y, double vx, double vy, double dt, boolean hasAirDrag) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.dt = dt;
        this.t = 0;
        this.distance = 0;
        this.maxH = 0;
        if(hasAirDrag) {
           this.airDrag = AIR_DRAG;
        }
    }

    public XYChart.Series<Number, Number> createTrajectory() {
        ObservableList<XYChart.Data<Number, Number>> data = FXCollections.observableArrayList();
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        double xCur = x;
        double yCur = y;
        double vxCur = vx;
        double vyCur = vy;
        data.add(new XYChart.Data<>(xCur, yCur));
        while(yCur > 0 || (vyCur > 0 && yCur == 0)) {
            vxCur -= airDrag*vxCur*dt/m;
            vyCur -= (FFA+airDrag*vyCur/m)*dt;
            xCur += vxCur * dt ;
            yCur += vyCur * dt;
            t += dt;
            if (yCur > maxH) {
                maxH = yCur;
            }
            data.add(new XYChart.Data<>(xCur, yCur));
        }
        if (data.size() > 1) {
            series.setData(approximateLastPoint(data, data.size() - 1));
        }
        distance = (double)data.get(data.size() - 1).getXValue();
        return series;
    }

    private ObservableList<XYChart.Data<Number, Number>> approximateLastPoint(ObservableList<XYChart.Data<Number, Number>> data, int len) {
        double yLast = (double) data.get(len).getYValue();
        double xLast = (double) data.get(len).getXValue();
        data.remove(len);
        len--;
        double yCur = (double) data.get(len).getYValue();
        double xCur = (double) data.get(len).getXValue();
        xLast = (0 - yLast) * (xCur - xLast) / (yCur - yLast) + xLast;
        data.add(new XYChart.Data<>(xLast, 0));
        return data;
    }

    public double maxHeight() {
       return maxH;
    }

    public double flightTime() {
        return t;
    }

    public double maxDistance() {
        return distance;
    }

}

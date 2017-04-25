package Trajectory.Controller;

import Trajectory.Model.Model;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public class Controller {
    private Model model;
    private double x;
    private double y;
    private double vX;
    private double vY;
    public Controller(String x, String y, String vX, String vY) throws NumberFormatException {
        try {
            this.x = getX(x);
            this.y = getY(y);
            this.vX = getVx(vX);
            this.vY = getVy(vY);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("This is not a number");
        }
        Model model = new Model(this.x, this.y, this.vX, this.vY, 0.001);
    }

    private double getX(String x){
        return Double.parseDouble(x);
    }

    private double getY(String y){
        return Double.parseDouble(y);
    }

    private double getVx(String vX){
        return Double.parseDouble(vX);
    }

    private double getVy(String vY) {
        return Double.parseDouble(vY);
    }

    public ObservableList<XYChart.Data> getData(){
       return model.createTrajectory();
    }
}


package Trajectory.Controller;

import Trajectory.Model.Model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller implements EventHandler<ActionEvent> {

    private LineChart<Number, Number> lineChart;
    private Text maxDistance;
    private Text maxHeight;
    private Text flightTime;
    private Text errorField;
    private Model model;
    private TextField inputX;
    private TextField inputY;
    private TextField inputVx;
    private TextField inputVy;
    private double x;
    private double y;
    private double vX;
    private double vY;

    public Controller(LineChart<Number, Number> lineChart, Text errorField, TextField inputX, TextField inputY, TextField inputVx, TextField inputVy,
                      Text maxDistance, Text maxHeight, Text flightTime) {
        this.lineChart = lineChart;
        this.flightTime = flightTime;
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
        this.errorField = errorField;
        this.inputX = inputX;
        this.inputY = inputY;
        this.inputVx = inputVx;
        this.inputVy = inputVy;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            initParams(inputX.getText(), inputY.getText(), inputVx.getText(), inputVy.getText());
            lineChart.getData().add(getTrajectory());
            maxHeight.setText(String.format("%.3f", maxHeight()));
            maxDistance.setText(String.format("%.3f", maxDistance()));
            flightTime.setText(String.format("%.3f", flightTime()));
        } catch (NumberFormatException e) {
            errorField.setText("One of the input field is empty or not a number");
        }
    }

    public void initParams(String x, String y, String vX, String vY) throws NumberFormatException{
        this.x = getX(x);
        this.y = getY(y);
        this.vX = getVx(vX);
        this.vY = getVy(vY);
    }

    public XYChart.Series<Number, Number> getTrajectory() {
        model = new Model(x, y, vX, vY, 0.05);
        return model.createTrajectory();
    }

    private double getX(String x) {
        return Double.parseDouble(x);
    }

    private double getY(String y) {
        return Double.parseDouble(y);
    }

    private double getVx(String vX) {
        return Double.parseDouble(vX);
    }

    private double getVy(String vY) {
        return Double.parseDouble(vY);
    }

    public double maxHeight() {
        return model.maxHeight();
    }

    public double getFlightTime() {
        return model.flightTime();
    }

    public double maxDistance() {
        return model.maxDistance();
    }
}

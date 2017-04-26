package Trajectory.Controller;

import Trajectory.Model.Model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.CheckBox;
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
    private TextField inputDt;
    private double x;
    private double y;
    private double vX;
    private double vY;
    private double dT;
    private CheckBox checkBox;

    public Controller(LineChart<Number, Number> lineChart, Text errorField,
                      TextField inputX, TextField inputY, TextField inputVx, TextField inputVy, TextField inputDt,
                      Text maxDistance, Text maxHeight, Text flightTime, CheckBox checkBox) {
        this.lineChart = lineChart;
        this.flightTime = flightTime;
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
        this.errorField = errorField;
        this.inputX = inputX;
        this.inputY = inputY;
        this.inputVx = inputVx;
        this.inputVy = inputVy;
        this.inputDt = inputDt;
        this.checkBox = checkBox;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            errorField.setText("");
            initParams(inputX.getText(), inputY.getText(), inputVx.getText(), inputVy.getText(), inputDt.getText());
            lineChart.getData().add(getTrajectory());
            maxHeight.setText(String.format("%.3g", maxHeight()));
            maxDistance.setText(String.format("%.3g", maxDistance()));
            flightTime.setText(String.format("%.3g", getFlightTime()));
        } catch (NumberFormatException e) {
            errorField.setText("One of the input field is empty or not a number");
        }
    }

    public void initParams(String x, String y, String vX, String vY, String dT) throws NumberFormatException{
        this.x = getX(x);
        this.y = getY(y);
        this.vX = getVx(vX);
        this.vY = getVy(vY);
        this.dT = getDt(dT);
    }

    public XYChart.Series<Number, Number> getTrajectory() {
        model = new Model(x, y, vX, vY, dT, checkBox.isSelected());
        return model.createTrajectory();
    }

    private double getDt(String dT) {
        return Double.parseDouble(dT);
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

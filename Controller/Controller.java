package TopProject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.awt.*;
import java.util.ArrayList;

import static javafx.scene.input.KeyCode.Y;


public class Controller {
    private Model model;


    public Controller() {
    }


    public void setModel(Model model) {
        this.model = model;

    }

    public TextField getX(){

        return X.Graph;
    }
    public void getY(){

        return Y.Graph;
    }
    public void getVx(){
        return Vx.Graph;
    }
    public void getVy()
    {
        return Vy.Graph;
    }


     btn.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent e) {
            Controller controller = new Controller();
        ArrayList <Double> Data = new <> ArrayList;
        Double X = Double.parseDouble (getX());
        Double Y = Double.parseDouble (getY());
        Double Vx = Double.parseDouble (getVx());
        Double Vy = Double.parseDouble (getVy());
        Model.CreateTrajectory (X, Y, Vx, Vy);


        });
    }
}
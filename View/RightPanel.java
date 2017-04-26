package Trajectory.View;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import static Trajectory.View.WindowUtils.createGridPane;
import static Trajectory.View.WindowUtils.createLabel;
import static Trajectory.View.WindowUtils.createText;

public class RightPanel {
    GridPane gridPane;
    Label maxHeight;
    Label flightTime;
    Label distance;
    Text maxHeightValue;
    Text flightTimeValue;
    Text distanceValue;

    public RightPanel() {
        maxHeight = createLabel("MaxHeight:");
        flightTime = createLabel("Flight time:");
        distance = createLabel("Distance:");
        maxHeightValue = createText("");
        flightTimeValue = createText("");
        distanceValue = createText("");
        gridPane = createGridPane();
        gridPane.add(maxHeight, 0, 0);
        gridPane.add(maxHeightValue, 1, 0);
        gridPane.add(flightTime, 0, 1);
        gridPane.add(flightTimeValue, 1, 1);
        gridPane.add(distance, 0, 2);
        gridPane.add(distanceValue, 1, 2);
    }
}

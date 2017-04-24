package javaFx.Trajectory.View;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class Panel {
    private GridPane gridPane;

    Panel(int verticalCells, int horizontalCells, Pos pos) {
        gridPane = new GridPane();
        gridPane.setAlignment(pos);
        for (int i = 0 ; i < horizontalCells ; i++) {
            gridPane.add();
        }
    }
}

package javaFx.Trajectory.View;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static javaFx.Trajectory.View.Constants.*;
import static javaFx.Trajectory.View.WindowUtils.*;

public class Window extends Application{
    private static Button button;
    private static GridPane gridPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Trajectory");


        gridPane = createGridPane();
        button = new Button("Start");
        HBox hBox = createHBox();
        hBox.getChildren().add(button);

        VBox rightPanel = createRightPanel();
        HBox bottomPanel = createBottomPanel();
        Scene scene = new Scene(gridPane, 640, 480);
        stage.setScene(scene);

        gridPane.setGridLinesVisible(true);
        gridPane.add(bottomPanel, 0, 1);
        gridPane.add(rightPanel, 1, 0);
        gridPane.add(new StackPane(button), 1, 1);
        stage.show();
    }

    private static VBox createRightPanel() {
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        Label maxHeight = createLabel("MaxHeight:");
        Label time = createLabel("Falling time:");
        Label distance = createLabel("Distance:");
        Text maxHeightValue = createText("");
        Text timeValue = createText("");
        Text distanceValue = createText("");
        vBox.getChildren().addAll(
                new HBox(maxHeight, maxHeightValue),
                new HBox(time, timeValue),
                new HBox(distance, distanceValue)
        );
        return vBox;
    }

    private static HBox createBottomPanel() {
        HBox hBox = createHBox();
        Label x = createLabel("X");
        Label y = createLabel("Y");
        Label vX = createLabel("Vx");
        Label vY = createLabel("Vy");
        TextField inputX = createTextField();
        TextField inputY = createTextField();
        TextField inputVx = createTextField();
        TextField inputVy = createTextField();
        hBox.getChildren().addAll(
                new VBox(x, inputX),
                new VBox(y, inputY),
                new VBox(vX, inputVx),
                new VBox(vY, inputVy)
        );
        return hBox;
    }

    private static TextField createTextField() {
        TextField textField = new TextField();
        textField.setMaxWidth(50);
        return textField;
    }

    private static GridPane createGridPane(Pos pos, int hGap, int vGap, int topPad, int rightPad, int bottomPad, int leftPad) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(pos);
        gridPane.setHgap(hGap);
        gridPane.setVgap(vGap);
        gridPane.setPadding(new Insets(topPad, rightPad, bottomPad, leftPad));
        return gridPane;
    }

    private static GridPane createGridPane() {
        return createGridPane(DEFAULT_POS, DEFAULT_HGAP, DEFAULT_VGAP,
                DEFAULT_TOPPAD, DEFAULT_RIGHTPAD, DEFAULT_BOTPAD, DEFAULT_LEFTPAD);
    }

}

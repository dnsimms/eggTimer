package destiny.creates;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Stack;

public class EggApp extends Application {
    private double xOffset = 0;
    private double yOffset = 0;
    private Button exitButton = new Button();
    private Label appTitle;

    @Override
    public void start(Stage stage) throws Exception {
        //TODO: Apply an intro with logo
        //TODO: place pseudo things in the place of items that will be replaced with assets
        //TODO: Create a method to build out the eggTimer stage and scene
        //TODO: add in the egg buttons
        appTitle = new Label("EGG TIMER");
        stage.setTitle("Egg Timer"); //sets the name of the top most label of the window
        appTitle.setId("greeting");

        StackPane stackPane = new StackPane(appTitle);
        exitButton.setId("exit-button");//ugly blue button until I make the asset
        StackPane.setAlignment(exitButton, Pos.TOP_LEFT);
        StackPane.setMargin(exitButton, new Insets(20,0,0,25));
        stackPane.getChildren().add(exitButton);
        exitButton.setOnAction(event ->{
            System.exit(0);
        });
        Scene scene = new Scene(stackPane, 412, 917);//creates the look of the 'window'
        scene.getStylesheets().add("pixelStyler.css");
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);//sets the look to the window
        stage.initStyle(StageStyle.TRANSPARENT);

        stackPane.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        }); //grab the coordinates of the pane when pressed

        stackPane.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        }); //set the coordinates as the user drags


        stage.show();
    }
}

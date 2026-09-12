package destiny.creates;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import destiny.creates.ImageLoader;

import java.io.FileInputStream;
import java.util.Stack;

public class EggApp extends Application {
    private double xOffset = 0;
    private double yOffset = 0;
    private Button exitButton = new Button();
    private Label appTitle;
    private ImageLoader[] eggOptions;
    private BorderPane borderPane;
    private Scene scene, scene2;

    @Override
    public void start(Stage stage) throws Exception {
        //TODO: place pseudo things in the place of items that will be replaced with assets
        //TODO: Create a method to build out the eggTimer stage and scene
        //TODO: add in the egg buttons
        appTitle = new Label("EGG TIMER");
        Font customFont = Font.loadFont(new FileInputStream("src/main/resources/PressStart2P-Regular.ttf"), 40);
        appTitle.setFont(customFont);
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
        scene = new Scene(stackPane, 412, 917);//creates the look of the 'window'
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

        intro(stage);


        stage.show();
    }

    /**
     * Animated intro to raise the app title to the top of the window.
     * @param stage
     */
    private void intro(Stage stage){
        TranslateTransition intro = new TranslateTransition();
        intro.setDuration(Duration.seconds(2));
        intro.setNode(appTitle);
        intro.setByY(-300.0);

//        intro.setOnFinished(event -> {
//            showTimerDial(stage);
//        });
        intro.play();
    }

//    private void showTimerDial(Stage stage){
//        eggOptions = new ImageLoader[5]; //Length of five since I have four options
//        eggOptions[0]= new ImageLoader("hard_boiled.png");
//        eggOptions[1] = new ImageLoader("boiled_egg.png");
//        eggOptions[2] = new ImageLoader("runny_boiled.png");
//        eggOptions[3] = new ImageLoader("fried_egg.png");
//
//        borderPane = new BorderPane();
//        borderPane.setLeft(eggOptions[0]);
//        borderPane.setTop(eggOptions[1]);
//        borderPane.setRight(eggOptions[2]);
//        borderPane.setBottom(eggOptions[3]);
//
//        scene.setRoot(borderPane);
//    }

//    private ImageView titleRun(){
//        appTitleImg = new Image("eggTimerTitle.svg", 100,100, false, false);
//        ImageView titleHolder = new ImageView(appTitleImg);
//        titleHolder.setPreserveRatio(true);
//        titleHolder.setCache(true);
//        return titleHolder;
//    }
}

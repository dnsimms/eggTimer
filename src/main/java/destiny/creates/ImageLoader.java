package destiny.creates;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class ImageLoader extends VBox {

    private static final int DEFAULT_HT = 80;
    private static final int DEFAULT_WT = 80;


    ImageView imgView;
    String name;

    /**
     * Sets a placeholder image
     */
    public ImageLoader(){
        super();

        Image img = new Image ("placeholder.png", DEFAULT_HT, DEFAULT_WT, false, false);
        imgView = new ImageView(img);
        imgView.setPreserveRatio(true);

        this.getChildren().add(imgView);

    }

    /**
     * Loads the ImageLoader with a user supplied image, height, and width.
     * @param imageName Name, path, or URL for the image.
     * @param height Height for the image
     * @param width Width for the image
     */
    public ImageLoader(String imageName, int height, int width){
        super();

        try {
            Image img = new Image(imageName, height, width, false, false);
            imgView = new ImageView(img);
            imgView.setPreserveRatio(true);
            this.getChildren().add(imgView);
        } catch (IllegalArgumentException msg) {
            System.out.println("The image name or URL is invalid!");
        }
    }

    /**
     * Sets the supplied image at the default height and width
     * @param imageName Name, path, or URL for the image
     */
    public ImageLoader(String imageName){
        super();

        try {
            Image img = new Image(imageName, DEFAULT_HT, DEFAULT_WT, false, false);
            imgView = new ImageView(img);
            imgView.setPreserveRatio(true);
            this.getChildren().add(imgView);
        } catch (IllegalArgumentException msg) {
            System.out.println("The image name or URL is invalid!");
        }
    }

    /**
     * Sets a new image in the ImageLoader at the default height and width
     * @param imageName Name, path, or URL for the image.
     */
    public void setImage(String imageName){
        //TODO: Implement this method
    }
}

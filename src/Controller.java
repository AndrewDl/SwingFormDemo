import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.IOException;

/**
 * Created by Andrew on 23.04.2016.
 */
public class Controller implements IController {
    IView view;
    IModel model;
    public Controller(IView view, IModel model){
        this.view = view;
        this.model = model;

        String path = "img/R2D2.jpg";
        File imageFile = new File(path);

        view.addCopyListener(
                new ButtonCopyListener(){
                    @Override public void actionPerformed(ActionEvent e){
                        BufferedImage img = ImageProcessor.imageToGrey(view.getOriginalImage());
                        img = ImageProcessor.binarizationTreshold(img,0x656565);
                        view.setResultingImage(img);
                    }
                }
        );

        if (imageFile.exists()) {
            try {
                this.view.setOriginalImage(ImageIO.read(imageFile));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private class ButtonCopyListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}

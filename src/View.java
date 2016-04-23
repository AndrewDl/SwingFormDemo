import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Andrew on 23.04.2016.
 */
public class View extends DesignerComponents implements IView{
    public View()
    {
        InitializeComponents();
        this.setVisible(true);


        BufferedImage myPicture = null;

        File image = new File("img/NoImage.jpg");

        if (image.exists()){
            try {
                myPicture = ImageIO.read(image);
            } catch (IOException e) {
                e.printStackTrace();
            }

            SetOriginalImage(myPicture);
            SetResultingImage(myPicture);
        }

        this.pack();

    }

    @Override
    public void SetOriginalImage(BufferedImage image){
        labelPictureOriginal.setIcon(new ImageIcon(image));
        labelPictureOriginal.setText("");
    }

    @Override
    public void SetOriginalImage(Icon image) {
        labelPictureOriginal.setIcon(image);
    }

    @Override
    public void SetResultingImage(BufferedImage image){
        labelPictureResulting.setIcon(new ImageIcon(image));
        labelPictureResulting.setText("");
    }

    @Override
    public void SetResultingImage(Icon image) {
        labelPictureResulting.setIcon(image);
    }

    @Override
    public void AddCopyListener(ActionListener listener) {
        buttonCopy.addActionListener(listener);
    }

    @Override
    public Icon getOriginalImage() {
        return labelPictureOriginal.getIcon();
    }

    @Override
    public Icon getResultingImage() {
        return labelPictureResulting.getIcon();
    }
}

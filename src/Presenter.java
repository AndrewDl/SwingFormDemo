import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by Andrew on 23.04.2016.
 */
public class Presenter implements IPresenter {
    IView view;
    IModel model;
    public Presenter(IView view, IModel model){
        this.view = view;
        this.model = model;

        String path = "img/R2D2.jpg";
        File imageFile = new File(path);

        view.AddCopyListener(new ButtonCopyListener());

        if (imageFile.exists()) {
            try {
                this.view.SetOriginalImage(ImageIO.read(imageFile));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private class ButtonCopyListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Icon image = view.getOriginalImage();
            view.SetResultingImage(image);
        }
    }
}

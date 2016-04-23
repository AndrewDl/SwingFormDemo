import javax.imageio.ImageIO;
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

        view.addCopyListener(new ButtonCopyListener());

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
            BufferedImage testImage = view.getOriginalImage();

            int treshold = 0x888888;

            int rgbArray[][] = new int[640][480];

            for (int i=0; i < testImage.getWidth(); i++)
                for (int j=0; j < testImage.getHeight(); j++)
                    //testImage.setRGB(i,j,testImage.getRGB(i,j)&0xFFFFFF);
                {
                    if (testImage.getRGB(i,j) > treshold )
                        rgbArray[i][j] = 0x000000;
                    else
                        rgbArray[i][j] = 0xFFFFFF;
 /*                   if ((testImage.getRGB(i,j)>> 16 & 0xFF) > treshold )
                        rgbArray[i][j] = rgbArray[i][j] | (0x00<<24);
                    else
                        rgbArray[i][j] = rgbArray[i][j] | (0xFF<<24);

                    if ((testImage.getRGB(i,j)>> 8 & 0xFF) > treshold )
                        rgbArray[i][j] = rgbArray[i][j] | (0x00<<8);
                    else
                        rgbArray[i][j] = rgbArray[i][j] | (0xFF<<8);

                    if ((testImage.getRGB(i,j)>> 0 & 0xFF) > treshold )
                        rgbArray[i][j] = rgbArray[i][j] | (0x00<<0);
                    else
                        rgbArray[i][j] = rgbArray[i][j] | (0xFF<<0);
*/
                    testImage.setRGB(i,j,rgbArray[i][j]);
                }



            view.setResultingImage(testImage);

        }
    }
}

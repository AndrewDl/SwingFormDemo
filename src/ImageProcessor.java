import java.awt.image.BufferedImage;

/**
 * Created by Andrew on 24.04.2016.
 */
public class ImageProcessor {
    public static BufferedImage imageToGrey(BufferedImage image)    {

        int rgbArray[][] = ToRGBArray(image);

        int width = rgbArray.length;
        int height = rgbArray[0].length;

        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++){

                int pixel = rgbArray[i][j];
                int pixelRED = (int)( 0.2125 * ((pixel>>16) & 0xFF) );
                int pixelGREEN = (int)( 0.7152 * ((pixel>>8) & 0xFF) );
                int pixelBLUE = (int)( 0.0722 * ((pixel>>0) & 0xFF) );

                rgbArray[i][j] = (pixelRED + pixelGREEN + pixelBLUE) << 16;
                rgbArray[i][j] |= (pixelRED + pixelGREEN + pixelBLUE) << 8;
                rgbArray[i][j] |= (pixelRED + pixelGREEN + pixelBLUE) << 0;
            }

        return ToBufferedImage(rgbArray);
    }

    public static BufferedImage binarizationTreshold(BufferedImage image, int treshold){
        int rgbArray[][] = ToRGBArray(image);

        int width = rgbArray.length;
        int height = rgbArray[0].length;

        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++){

                if ( (rgbArray[i][j]&0xFFFFFF)>treshold){
                    rgbArray[i][j] = 0xFFFFFF;

                }
                else{
                    rgbArray[i][j] = 0x000000;
                }
            }

        return ToBufferedImage(rgbArray);
    }

    private static int[][] ToRGBArray (BufferedImage image){

        int rgbArray[][] = new int[image.getWidth()][image.getHeight()];

        for (int i=0; i < image.getWidth(); i++)
            for (int j=0; j < image.getHeight(); j++)
            {
                rgbArray[i][j] = image.getRGB(i,j);
            }

        return rgbArray;
    }

    private static BufferedImage ToBufferedImage(int[][] rgbArray){

        int width = rgbArray.length;
        int height = rgbArray[0].length;

        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                image.setRGB(i,j,rgbArray[i][j]);
        return image;
    }
}

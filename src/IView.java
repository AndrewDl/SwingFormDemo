import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * Created by Andrew on 23.04.2016.
 */
public interface IView {
    void SetOriginalImage(BufferedImage image);

    void SetOriginalImage(Icon image);

    void SetResultingImage(BufferedImage image);

    void SetResultingImage(Icon image);

    void AddCopyListener(ActionListener listener);

    Icon getOriginalImage();

    Icon getResultingImage();
}

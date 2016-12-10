package CenterStageComponents;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alex on 10/30/2016.
 */
public class JImage extends JComponent
{
    private Image image;

    public JImage(Image image)
    {
        this.image = image;
        setPreferredSize(new Dimension(image.getWidth(this), image.getHeight(this)));
    }


    public void setImage (Image image)
    {
        this.image = image;
    }

    public Image getImage()
    {
        return image;
    }

    @Override
    public void paintComponents(Graphics g)
    {
        super.paintComponents(g);
        g.drawImage(image, 0, 0, image.getWidth(this), image.getHeight(this), this);
    }
}

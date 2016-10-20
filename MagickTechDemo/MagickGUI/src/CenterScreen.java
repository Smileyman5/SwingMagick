import javax.swing.*;
import java.awt.*;

/**
 * Created by alex on 10/16/2016.
 */
public class CenterScreen extends JPanel
{
    private Image image;

    public CenterScreen(Image image)
    {
        this.image = image;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}

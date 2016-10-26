import CenterStageComponents.CenterStageProperties;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alex on 10/26/2016.
 */
public class CenterStage extends JPanel
{
    private JPanel imageHolder;
    private JLabel image;
    private JScrollPane scrollPane;

    public CenterStage()
    {
        setBackground(Color.CYAN);

        image = new JLabel();
        image.setBackground(Color.WHITE);
        image.setIcon(new ImageIcon("./out/images/crop.png"));

        imageHolder = new JPanel();
        imageHolder.setBackground(Color.LIGHT_GRAY);
        imageHolder.add(image);

        scrollPane = new JScrollPane();
        scrollPane.add(imageHolder);

        setLayout(new MigLayout("", "[grow]", "[grow][]"));
        add (new JScrollPane(imageHolder), "grow, wrap");
        add (new CenterStageProperties(), "growx");
    }
}

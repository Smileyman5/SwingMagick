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
//    private JLabel image2;
    private JScrollPane scrollPane;

    public CenterStage()
    {
        setBackground(Color.DARK_GRAY);

        image = new JLabel();
        image.setBackground(Color.DARK_GRAY);
        image.setIcon(new ImageIcon("./out/images/nature.png"));

//        image2 = new JLabel();
//        image2.setBackground(Color.WHITE);
//        image2.setIcon(new ImageIcon("./out/images/crop.png"));


        imageHolder = new JPanel(new MigLayout());
        imageHolder.setBackground(Color.DARK_GRAY);
        imageHolder.add(image, "wrap");
//        imageHolder.add(image2);

        scrollPane = new JScrollPane();
        scrollPane.add(imageHolder);

        setLayout(new MigLayout("", "[grow]", "[grow][]"));
        add (new JScrollPane(imageHolder), "grow, wrap");
        add (new CenterStageProperties(), "growx");
    }
}

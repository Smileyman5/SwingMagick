import CenterStageComponents.CenterStageProperties;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by alex on 10/26/2016.
 */
public class CenterStage extends JPanel
{
    private ImageIcon image;
    private JPanel imageHolder;
    private JLabel imageLabel;
//    private JLabel image2;
    private JScrollPane scrollPane;

    public CenterStage()
    {
        setBackground(Color.DARK_GRAY);

        image = new ImageIcon("./out/images/nature2.jpg");

        imageLabel = new JLabel(image, JLabel.CENTER);
        imageLabel.setBackground(Color.DARK_GRAY);
        imageLabel.setPreferredSize(new Dimension(image.getIconWidth() + 20, image.getIconHeight() + 20));
//        image2 = new JLabel();
//        image2.setBackground(Color.WHITE);
//        image2.setIcon(new ImageIcon("./out/images/crop.png"));


        imageHolder = new JPanel(new GridBagLayout());
        imageHolder.setBackground(Color.DARK_GRAY);
        imageHolder.add(imageLabel);
//        imageHolder.add(image2);

        scrollPane = new JScrollPane(imageHolder);

        setLayout(new MigLayout("", "[grow]", "[grow][]"));
        add (scrollPane, "grow, wrap");
        add (new CenterStageProperties(scrollPane, imageLabel), "growx");
    }

    /**
     * Takes a requested image file and displays it on the stage
     * @param file The file being viewed
     */
    public void setDisplayedImage(File file) {
        image = new ImageIcon(file.getAbsolutePath());
        imageLabel.setIcon(image);
        imageLabel.setPreferredSize(new Dimension(image.getIconWidth() + 20, image.getIconHeight() + 20));
    }
}

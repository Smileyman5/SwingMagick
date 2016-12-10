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
    private String imageFilename;
    private JPanel imageHolder;
    private JLabel imageLabel;
//    private JLabel image2;
    private JScrollPane scrollPane;

    public CenterStage()
    {
        setBackground(Color.DARK_GRAY);

        imageFilename = "./out/images/nature2.jpg";
        image = new ImageIcon("./out/images/nature2.jpg");

        imageLabel = new JLabel(image, JLabel.CENTER);
        imageLabel.setBackground(Color.DARK_GRAY);
        imageLabel.setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
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
        imageFilename = file.getAbsolutePath();
        imageLabel.setIcon(image);
        imageLabel.setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
    }

    public String getCurrentImage(){
        System.out.println(imageFilename);
        return imageFilename;
    }

    // TODO command execution should probably happen here? because image loading? or at least tie this class and the tools
    // to a model
}

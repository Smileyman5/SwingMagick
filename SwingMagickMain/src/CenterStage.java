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
    private final File temp;
    private volatile File currentImage;
    private ImageIcon image;
    private String imageFilename;
    private JPanel imageHolder;
    private JLabel imageLabel;
//    private JLabel image2;
    private JScrollPane scrollPane;

    public CenterStage()
    {
        setBackground(Color.DARK_GRAY);

        temp = new File("out/images/temp.jpg");
        imageFilename = "out/images/nature2";
        currentImage = new File(imageFilename + ".jpg");
        image = new ImageIcon(currentImage.getAbsolutePath());

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
        image.getImage().flush();
        image = new ImageIcon(file.getAbsolutePath());
        imageFilename = file.getAbsolutePath();
        imageLabel.setIcon(image);
        imageLabel.setPreferredSize(new Dimension(image.getIconWidth() + 20, image.getIconHeight() + 20));
    }

    public File getCurrentImage(){
//        System.out.println(imageFilename);
        return currentImage;
    }

    public void refresh()
    {
//        setDisplayedImage(temp);
        setDisplayedImage(new File(currentImage.getAbsolutePath()));
    }

    // TODO command execution should probably happen here? because image loading? or at least tie this class and the tools
    // to a model
}

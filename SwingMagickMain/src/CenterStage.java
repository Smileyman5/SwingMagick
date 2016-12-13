import CenterStageComponents.CenterStageProperties;
import ToolComponents.CropPanel;
import net.miginfocom.swing.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by alex on 10/26/2016.
 */
public class CenterStage extends JPanel
{
    private volatile File currentImage;
    private ImageIcon image;
    private String imageFilename;
    private JPanel imageHolder;
    private JLabel imageLabel;
//    private JLabel image2;
    private JScrollPane scrollPane;

    public CenterStage(CropPanel cropPanel)
    {
        setBackground(Color.DARK_GRAY);
        imageFilename = "out/images/nature2";
        FileManager.MAIN_FILE.setFile(new File(imageFilename + ".jpg"));
        currentImage = FileManager.MAIN_FILE.getFile();
        try
        {
            FileManager.TEMP_FILE.setFile(File.createTempFile("nature2", ".jpg"));
            FileManager.UNDO_FILE.setFile(File.createTempFile("nature2", ".jpg"));

            BufferedImage bi1 = ImageIO.read(currentImage);
            BufferedImage bi2 = ImageIO.read(currentImage);

            ImageIO.write(bi1, "jpg", FileManager.TEMP_FILE.getFile());
            ImageIO.write(bi2, "jpg", FileManager.UNDO_FILE.getFile());

            FileManager.TEMP_FILE.getFile().deleteOnExit();
            FileManager.UNDO_FILE.getFile().deleteOnExit();

        } catch (IOException e)
        {
            e.printStackTrace();
        }
        currentImage = FileManager.TEMP_FILE.getFile();

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
        add (new CenterStageProperties(scrollPane, imageLabel, cropPanel), "growx");
    }

    /**
     * Takes a requested image file and displays it on the stage
     * @param file The file being viewed
     */
    public void setDisplayedImage(File file) {
        if (!file.getAbsolutePath().equals(FileManager.TEMP_FILE.getFile().getAbsolutePath()))
        {
            FileManager.MAIN_FILE.setFile(file);
            String[] fileName = file.getName().split(".");
            try
            {

                if (fileName.length >= 2)
                {
                    FileManager.TEMP_FILE.setFile(File.createTempFile(fileName[0], "."+fileName[1]));
                    FileManager.UNDO_FILE.setFile(File.createTempFile(fileName[0], "."+fileName[1]));
                }
                else
                {
                    FileManager.TEMP_FILE.setFile(File.createTempFile(file.getName(), ".jpg"));
                    FileManager.UNDO_FILE.setFile(File.createTempFile(file.getName(), ".jpg"));
                }
                BufferedImage bi1 = ImageIO.read(file);
                BufferedImage bi2 = ImageIO.read(file);

                ImageIO.write(bi1, "jpg", FileManager.TEMP_FILE.getFile());
                ImageIO.write(bi2, "jpg", FileManager.UNDO_FILE.getFile());

                FileManager.TEMP_FILE.getFile().deleteOnExit();
                FileManager.UNDO_FILE.getFile().deleteOnExit();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        else
        {
            FileManager.TEMP_FILE.setFile(file);
        }
        image.getImage().flush();
        image = new ImageIcon(FileManager.TEMP_FILE.getFile().getAbsolutePath());
        imageFilename = FileManager.TEMP_FILE.getFile().getAbsolutePath();
        currentImage = FileManager.TEMP_FILE.getFile();
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
        setDisplayedImage(FileManager.TEMP_FILE.getFile());
    }

    // TODO command execution should probably happen here? because image loading? or at least tie this class and the tools
    // to a model
}

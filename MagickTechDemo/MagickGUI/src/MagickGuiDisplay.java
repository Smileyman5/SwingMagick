import net.miginfocom.swing.MigLayout;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
import org.im4java.process.ProcessStarter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by alex on 10/11/2016.
 */
public class MagickGuiDisplay extends JPanel
{
    private final JFileChooser fileChooser = new JFileChooser();

    private File imageFile;
    private Image image;
    private JButton rotateButton;
    private CenterScreen centerScreen;


    public MagickGuiDisplay()
    {
        try {
            // Set cross-platform look: "Nimbus"
            UIManager.setLookAndFeel(UIManager.getInstalledLookAndFeels()[1].getClassName());
        }
        catch (UnsupportedLookAndFeelException | InstantiationException
                | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        String myPath="C:\\Program Files (x86)\\ImageMagick-6.3.9-Q8";
        ProcessStarter.setGlobalSearchPath(myPath);

        // Setting Miglayout for the manager
        setLayout(new MigLayout("","[grow]","[][grow]"));

        try
        {
            imageFile = new File("test.jpg");
            image = ImageIO.read(new File("output.jpg"));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        rotateButton = new JButton("Rotate!");
        rotateButton.addActionListener(event -> runCommand("convert -rotate 90", imageFile));
        centerScreen = new CenterScreen(image);

        add(rotateButton, "growx, wrap");
        add(centerScreen, "growx, growy");

    }

    private void runCommand(String s, File currentImage)
    {
        try
        {
            // create command
            ConvertCmd cmd = new ConvertCmd();

            // create the operation, add images and operators/options
            IMOperation op = new IMOperation();
            op.addImage(currentImage.getName());
            op.rotate(0d);
            op.addImage("output.jpg");

            // execute the operation
            System.out.println("convert " + op);
            cmd.run(op);
        } catch (IOException | InterruptedException | IM4JavaException e)
        {
            e.printStackTrace();
        }
    }
}

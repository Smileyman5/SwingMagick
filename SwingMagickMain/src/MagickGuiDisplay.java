import net.miginfocom.swing.MigLayout;
import org.im4java.process.ProcessStarter;

import javax.swing.*;

/**
 * Created by alex on 10/23/2016.
 */
public class MagickGuiDisplay extends JPanel
{
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

        setLayout(new MigLayout("", "[][grow]", "[][][grow]"));

        add(new JButton("File Menu"), "span, growx");
        add(new ToolPallet(), "spany, growy");
        add(new JButton("Properties menu"), "growx, cell 1 1");
        add(new JButton("Center Stage"), "grow, cell 1 2");
    }
}

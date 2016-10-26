import net.miginfocom.swing.MigLayout;
import org.im4java.process.ProcessStarter;

import javax.swing.*;
import java.awt.*;

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

        setBackground(Color.LIGHT_GRAY);
        setLayout(new MigLayout("", "[][grow]", "[][][grow]"));

        add(buildJMenuBar(), "span, growx");
        add(new ToolPallet(), "spany, growy");
        add(new JButton("Properties menu"), "growx, cell 1 1");
        add(new CenterStage(), "grow, cell 1 2");
    }

    private JMenuBar buildJMenuBar() {
        /*
        Move this to its own class eventually
         */
        //Setting up menu bar
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
        //Assigning menu components
        menuBar = new JMenuBar();
        menu = new JMenu("File");
        menuBar.add(menu);
        menuItem = new JMenuItem("Open");
        menu.add(menuItem); //note: before defining the next menu item, define its action listener.
        menuItem = new JMenuItem("Save");
        menu.add(menuItem);
        menu.addSeparator();
        menuItem = new JMenuItem("Exit");
        menu.add(menuItem);
        menu = new JMenu("Edit");
        menuBar.add(menu);
        menuItem = new JMenuItem("Undo");
        menu.add(menuItem);
        menuItem = new JMenuItem("Redo");
        menu.add(menuItem);
        menu = new JMenu("View");
        menuBar.add(menu);
        menuItem = new JMenuItem("Display Preferences");
        menu.add(menuItem);
        menu = new JMenu("Help");
        menuBar.add(menu);
        menuItem = new JMenuItem("About");
        menu.add(menuItem);
        return menuBar;
    }
}

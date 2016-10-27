import net.miginfocom.swing.MigLayout;
import org.im4java.process.ProcessStarter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * Created by alex on 10/23/2016.
 */
public class MagickGuiDisplay extends JPanel
{
    private CenterStage stage;

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

        setBackground(Color.DARK_GRAY);
        setLayout(new MigLayout("", "[][grow]", "[][][grow]"));

        add(buildJMenuBar(), "span, growx");
        add(new ToolPallet(), "spany, growy");
        add(new PropertiesPanel(), "growx, cell 1 1");
        stage = new CenterStage();
        add(stage, "grow, cell 1 2");
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
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fc = new JFileChooser();
                int returnVal = fc.showOpenDialog(MagickGuiDisplay.this);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    stage.setDisplayedImage(file);
                }
            }
        });
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        menu.add(menuItem); //note: before defining the next menu item, define its action listener.
        menuItem = new JMenuItem("Save");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        menu.add(menuItem);
        menu.addSeparator();
        menuItem = new JMenuItem("Exit");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        menu.add(menuItem);
        menu = new JMenu("Edit");
        menuBar.add(menu);
        menuItem = new JMenuItem("Undo");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        menu.add(menuItem);
        menuItem = new JMenuItem("Redo");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK+ InputEvent.SHIFT_MASK));
        menu.add(menuItem);
        menu = new JMenu("View");
        menuBar.add(menu);
        menuItem = new JMenuItem("Display Preferences");
        menu.add(menuItem);
        menu = new JMenu("Help");
        menuBar.add(menu);
        menuItem = new JMenuItem("About");
        menu.add(menuItem);
        menuBar.setMinimumSize(new Dimension(20, 20));
        return menuBar;
    }
}

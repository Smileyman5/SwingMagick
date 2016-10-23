import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by alex on 9/22/2016.
 * Entry point for the program
 */
public class Main
{
    /**
     * Main method
     * @param args
     *      Unused but required parameter
     */
    public static void main(String[] args) throws IOException, InterruptedException
    {
        SwingUtilities.invokeLater(() -> new Main());
    }

    public Main()
    {
        // Setting up main frame
        JFrame frame = new JFrame("Magick Display!");
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
        //Placing menu bar in frame
        frame.setJMenuBar(menuBar);
        // Exit on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // mainPanel is where all visuals will take place
        frame.setContentPane(new MagickGuiDisplay());
        // Set preferred size of screen
        frame.setPreferredSize(new Dimension(500, 500));
        // Packing...
        frame.pack();
        // Display!
        frame.setVisible(true);
    }
}


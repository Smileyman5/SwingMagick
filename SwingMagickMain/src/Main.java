import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
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
        // Exit on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // mainPanel is where all visuals will take place
        frame.setContentPane(new MagickGuiDisplay());
        // Set minimum size of screen
        frame.setMinimumSize(new Dimension(600, 500));
        // Set preferred size of screen
        frame.setPreferredSize(new Dimension(1300, 900));
        // Packing...
        frame.pack();
        // Display!
        frame.setVisible(true);
    }
}


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

    /**
     * Constructor.
     * Starts up main view
     */
    public Main()
    {
        MagickGuiDisplay magickGuiDisplay = new MagickGuiDisplay();
        // Setting up main frame
        JFrame frame = new JFrame("Magick Display!");
        // Exit on close
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // mainPanel is where all visuals will take place
        frame.setContentPane(magickGuiDisplay);
        // Adding window listener
        addWindowListener(frame, magickGuiDisplay);
        // Set minimum size of screen
        frame.setMinimumSize(new Dimension(600, 500));
        // Set preferred size of screen
        frame.setPreferredSize(new Dimension(1300, 900));
        // Packing...
        frame.pack();
        // Display!
        frame.setVisible(true);
    }

    private void addWindowListener(Frame frame, MagickGuiDisplay magickGuiDisplay)
    {
        frame.addWindowListener(new WindowAdapter()
        {

            @Override
            public void windowClosing(WindowEvent e)
            {
                super.windowClosing(e);
                if (!magickGuiDisplay.lastCommand.equals("save"))
            {
                if(JOptionPane.showConfirmDialog(magickGuiDisplay,
                        "Are you sure you want to quit without saving?",
                        "Exiting Without Saving",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
                {
                    System.exit(0);
                }
            }
            else
            {
                System.exit(0);
            }

            }
        });
    }
}


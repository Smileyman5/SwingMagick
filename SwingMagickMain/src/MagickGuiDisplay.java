import ToolComponents.CropPanel;
import ToolComponents.FilterPanel;
import ToolComponents.FlipPanel;
import ToolComponents.ResizePanel;
import ToolComponents.RotatePanel;
import net.miginfocom.swing.MigLayout;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
import org.im4java.process.ProcessStarter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by alex on 10/23/2016.
 */
public class MagickGuiDisplay extends JPanel
{
    private CenterStage stage;

    private JPanel cards;
    private JPanel cropPanel = new CropPanel();
    private JPanel filterPanel = new FilterPanel();
    private JPanel flipPanel = new FlipPanel();
    private JPanel resizePanel = new ResizePanel();
    private JPanel rotatePanel = new RotatePanel();

    private ToolPallet pallet = new ToolPallet();

    public MagickGuiDisplay()
    {
        cards = new JPanel(new CardLayout());

        cards.add(cropPanel, "crop");
        cards.add(filterPanel, "filter");
        cards.add(flipPanel, "flip");
        cards.add(resizePanel, "resize");
        cards.add(rotatePanel, "rotate");

        filterPanel.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                String xmd = evt.getPropertyName();
                if (xmd.equals("filterImg")) {
                    try {
                        String filter = (String) evt.getNewValue();
                        // create command
                        ConvertCmd cmd = new ConvertCmd();
                        cmd.setSearchPath("C:\\Program Files (x86)\\ImageMagick-6.3.9-Q8");

                        IMOperation op = new IMOperation();

                        File currentFilename = stage.getCurrentImage();

                        op.addImage(currentFilename.getAbsolutePath());

                        if (filter.equals("Sepia")) {
                            op.sepiaTone(65d);
                        } else if (filter.equals("Invert")) {
                            op.negate();
                        } else if (filter.equals("Monochrome")) {
                            op.monochrome();
                        }
//                        op.addImage("./out/images/output" + currentFilename.substring(currentFilename.length()-4, currentFilename.length()));
                        op.addImage(currentFilename.getAbsolutePath());

                        // execute the operation
//                        System.out.println("convert " + op);
                        cmd.run(op);

//                        stage.setDisplayedImage(new File("./out/images/output" + currentFilename.substring(currentFilename.length()-4, currentFilename.length())));
                        stage.refresh();
                    } catch (IOException | InterruptedException | IM4JavaException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        flipPanel.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                String xmd = evt.getPropertyName();

                if (xmd.equals("flipImg")) {
                    try {
                        boolean[] instructions = (boolean[]) evt.getNewValue();
                        // create command
                        ConvertCmd cmd = new ConvertCmd();
                        cmd.setSearchPath("C:\\Program Files (x86)\\ImageMagick-6.3.9-Q8");

                        IMOperation op = new IMOperation();

                        File currentFilename = stage.getCurrentImage();

                        op.addImage(currentFilename.getAbsolutePath());
                        if (instructions[1]) {
                            op.flip();//over x-axis
                        }
                        if (instructions[0]) {
                            op.flop();//over y-axis
                        }
//                        op.addImage("./out/images/output" + currentFilename.substring(currentFilename.length()-4, currentFilename.length()));
                        op.addImage(currentFilename.getAbsolutePath());

                        // execute the operation
//                        System.out.println("convert " + op);
                        cmd.run(op);

//                        stage.setDisplayedImage(new File("./out/images/output" + currentFilename.substring(currentFilename.length()-4, currentFilename.length())));
                        stage.refresh();
                    } catch (IOException | InterruptedException | IM4JavaException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        resizePanel.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                String xmd = evt.getPropertyName();
                if (xmd.equals("resizeImg")) {
                    try {
                        int[] params = (int[]) evt.getNewValue();
                        // create command
                        ConvertCmd cmd = new ConvertCmd();
                        cmd.setSearchPath("C:\\Program Files (x86)\\ImageMagick-6.3.9-Q8");

                        IMOperation op = new IMOperation();

                        File currentFilename = stage.getCurrentImage();

                        op.addImage(currentFilename.getAbsolutePath());

                        int dimX = params[0];
                        int dimY = params[1];
                        if (params[2] == 1) {
                            op.resize(dimX, dimY, '!');
                        } else {
                            op.resize(dimX, dimY);
                        }
//                        op.addImage("./out/images/output" + currentFilename.substring(currentFilename.length()-4, currentFilename.length()));
                        op.addImage(currentFilename.getAbsolutePath());

                        // execute the operation
//                        System.out.println("convert " + op);
                        cmd.run(op);

//                        stage.setDisplayedImage(new File("./out/images/output" + currentFilename.substring(currentFilename.length()-4, currentFilename.length())));
                        stage.refresh();
                    } catch (IOException | InterruptedException | IM4JavaException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        rotatePanel.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                String xmd = evt.getPropertyName();
                if (xmd.equals("rotateImg")) {
                    try {
                        // create command
                        ConvertCmd cmd = new ConvertCmd();
                        cmd.setSearchPath("C:\\Program Files (x86)\\ImageMagick-6.3.9-Q8");

                        IMOperation op = new IMOperation();

                        File currentFilename = stage.getCurrentImage();

                        op.addImage(currentFilename.getAbsolutePath());
                        op.rotate((Double) evt.getNewValue());
//                        op.addImage("./out/images/output" + currentFilename.substring(currentFilename.length()-4, currentFilename.length()));
                        op.addImage(currentFilename.getAbsolutePath());

                        // execute the operation
//                        System.out.println("convert " + op);
                        cmd.run(op);

//                        stage.setDisplayedImage(new File("./out/images/output" + currentFilename.substring(currentFilename.length()-4, currentFilename.length())));
                        stage.refresh();
                    } catch (IOException | InterruptedException | IM4JavaException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

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
        add(pallet, "spany, growy");

        //add the card panel, defaults to crop
        add(cards, "growx, cell 1 1");
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, "crop");

        pallet.addListeners(evt -> {
            String toolName = evt.getPropertyName();
            if (!toolName.equals("save") || !toolName.equals("undo")) {
                CardLayout cl1 = (CardLayout)(cards.getLayout());
                cl1.show(cards, toolName);
            } else if (toolName.equals("save")) {
                //save function goes here
            } else if (toolName.equals("undo")) {
                //undo function here
            }
        });

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

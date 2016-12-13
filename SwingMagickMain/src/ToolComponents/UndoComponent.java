package ToolComponents;

import ToolComponents.CustomComponents.CustomButton;
import net.miginfocom.swing.MigLayout;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mike on 10/26/2016.
 */
public class UndoComponent extends ToolComponent {
    private CustomButton undoButton;
    private String[] imageDir;
    private boolean isUndo;

    public UndoComponent()
    {
        setLayout(new MigLayout());
        isUndo = true;
        imageDir = new String[]{"./out/images/undo.png", "./out/images/undo-hover.png", "./out/images/undo-clicked.png"};
        undoButton = new CustomButton(imageDir[0], "undo");
        undoButton.setRolloverIcon(new ImageIcon(imageDir[1]));
        undoButton.setPressedIcon(new ImageIcon(imageDir[2]));
        add(undoButton);
        undoButton.setToolTipText("Undo the previous action.");
        undoButton.addActionListener(e -> flipImage());
    }

    public void reset()
    {
        if (isUndo)
            return;
        ConvertCmd cmd = new ConvertCmd();
        cmd.setSearchPath("C:\\Program Files (x86)\\ImageMagick-6.3.9-Q8");
        undoButton.setToolTipText("Undo the previous action.");

        for (String dir: imageDir)
        {
            IMOperation op = new IMOperation();
            op.addImage(dir);
            op.flop();
            op.addImage(dir);

            try
            {
                cmd.run(op);
            } catch (IOException | InterruptedException | IM4JavaException e)
            {
                e.printStackTrace();
            }
        }
        isUndo = true;
        refresh();
    }

    private void flipImage()
    {
        ConvertCmd cmd = new ConvertCmd();
        cmd.setSearchPath("C:\\Program Files (x86)\\ImageMagick-6.3.9-Q8");
        if (isUndo)
            undoButton.setToolTipText("Redo the previous action.");
        else
            undoButton.setToolTipText("Undo the previous action.");
        isUndo = !isUndo;

        for (String dir: imageDir)
        {
            IMOperation op = new IMOperation();
            op.addImage(dir);
            op.flop();
            op.addImage(dir);

            try
            {
                cmd.run(op);
            } catch (IOException | InterruptedException | IM4JavaException e)
            {
                e.printStackTrace();
            }
        }
        refresh();
    }

    public void refresh()
    {
        try
        {
            BufferedImage main = ImageIO.read(new File(imageDir[0]));
            BufferedImage roll = ImageIO.read(new File(imageDir[1]));
            BufferedImage press = ImageIO.read(new File(imageDir[2]));

            undoButton.setIcon(new ImageIcon(main));
            undoButton.setRolloverIcon(new ImageIcon(roll));
            undoButton.setPressedIcon(new ImageIcon(press));

            repaint();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void addListener(PropertyChangeListener listener) {
        undoButton.addPropertyChangeListener(listener);
    }
}

package ToolComponents;

import ToolComponents.CustomComponents.CustomButton;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * Created by Mike on 10/26/2016.
 */
public class UndoComponent extends ToolComponent {
    private CustomButton undoButton;

    public UndoComponent()
    {
        setLayout(new MigLayout());
        undoButton = new CustomButton("./out/images/undo.png");
        undoButton.setRolloverIcon(new ImageIcon("./out/images/undo-hover.png"));
        undoButton.setPressedIcon(new ImageIcon("./out/images/undo-clicked.png"));
        add(undoButton);
        undoButton.setToolTipText("Undo the previous action.");
    }
}

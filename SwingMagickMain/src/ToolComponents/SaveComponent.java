package ToolComponents;

import ToolComponents.CustomComponents.CustomButton;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * Created by Mike on 10/26/2016.
 */
public class SaveComponent extends ToolComponent{
    private CustomButton saveButton;

    public SaveComponent()
    {
        setLayout(new MigLayout());
        saveButton = new CustomButton("./out/images/save.png");
        saveButton.setRolloverIcon(new ImageIcon("./out/images/save-hover.png"));
        saveButton.setPressedIcon(new ImageIcon("./out/images/save-clicked.png"));
        add(saveButton);
        saveButton.setToolTipText("Save the current image to a specified directory.");
    }
}

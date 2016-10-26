package ToolComponents;

import ToolComponents.CustomComponents.CustomButton;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * Created by Mike on 10/26/2016.
 */
public class RotateComponent extends ToolComponent
{
    private CustomButton rotateButton;

    public RotateComponent()
    {
        setLayout(new MigLayout());
        rotateButton = new CustomButton("./out/images/rotate.png");
        rotateButton.setRolloverIcon(new ImageIcon("./out/images/rotate-hover.png"));
        rotateButton.setPressedIcon(new ImageIcon("./out/images/rotate-clicked.png"));
        add(rotateButton);
        rotateButton.setToolTipText("Rotate the image.");
    }
}
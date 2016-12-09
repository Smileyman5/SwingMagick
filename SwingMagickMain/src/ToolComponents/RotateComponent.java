package ToolComponents;

import ToolComponents.CustomComponents.CustomButton;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.beans.PropertyChangeListener;

/**
 * Created by Mike on 10/26/2016.
 */
public class RotateComponent extends ToolComponent
{
    private CustomButton rotateButton;

    public RotateComponent()
    {
        setLayout(new MigLayout());
        rotateButton = new CustomButton("./out/images/rotate.png", "rotate");
        rotateButton.setRolloverIcon(new ImageIcon("./out/images/rotate-hover.png"));
        rotateButton.setPressedIcon(new ImageIcon("./out/images/rotate-clicked.png"));

        rotateButton.addPopupItem(new JMenuItem("45 degrees"));
        rotateButton.addPopupItem(new JMenuItem("90 degrees"));
        rotateButton.addPopupItem(new JMenuItem("180 degrees"));
        rotateButton.addPopupItem(new JMenuItem("270 degrees"));

        add(rotateButton);
        rotateButton.setToolTipText("Rotate the image.");
    }

    public void addListener(PropertyChangeListener listener) {
        rotateButton.addPropertyChangeListener(listener);
    }
}
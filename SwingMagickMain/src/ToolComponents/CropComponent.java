package ToolComponents;

import ToolComponents.CustomComponents.CustomButton;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.beans.PropertyChangeListener;

/**
 * Created by alex on 10/23/2016.
 */
public class CropComponent extends ToolComponent
{
    private CustomButton cropButton;

    public CropComponent()
    {
        setLayout(new MigLayout());
        cropButton = new CustomButton("./out/images/crop.png","crop");
        cropButton.setRolloverIcon(new ImageIcon("./out/images/crop-hover.png"));
        cropButton.setPressedIcon(new ImageIcon("./out/images/crop-clicked.png"));
        add(cropButton);
        cropButton.setToolTipText("Crop the image into a rectangular region.");
    }

    public void addListener(PropertyChangeListener listener) {
        cropButton.addPropertyChangeListener(listener);
    }
}

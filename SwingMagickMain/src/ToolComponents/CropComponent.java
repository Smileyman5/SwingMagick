package ToolComponents;

import ToolComponents.CustomComponents.CustomButton;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * Created by alex on 10/23/2016.
 */
public class CropComponent extends ToolComponent
{
    private CustomButton cropButton;

    public CropComponent()
    {
        setLayout(new MigLayout());
        cropButton = new CustomButton("./out/images/crop.png");
        cropButton.setRolloverIcon(new ImageIcon("./out/images/crop-hover.png"));
        cropButton.setPressedIcon(new ImageIcon("./out/images/crop-clicked.png"));
        add(cropButton);
    }
}

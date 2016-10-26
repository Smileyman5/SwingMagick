package ToolComponents;

import ToolComponents.CustomComponents.CustomButton;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * Created by alex on 10/25/2016.
 */
public class ResizeComponent extends ToolComponent
{
    private CustomButton resizeButton;

    public ResizeComponent()
    {
        setLayout(new MigLayout());
        resizeButton = new CustomButton("./out/images/resize.png");
        resizeButton.setRolloverIcon(new ImageIcon("./out/images/resize-hover.png"));
        resizeButton.setPressedIcon(new ImageIcon("./out/images/resize-clicked.png"));
        add(resizeButton);
        resizeButton.setToolTipText("Resize the image.");
    }
}

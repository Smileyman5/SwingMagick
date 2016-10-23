package ToolComponents;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * Created by alex on 10/23/2016.
 */
public class CropComponent extends ToolComponent
{
    private static final String WRAP_GROW_STRING = "wrap, growx";

    private JButton cropButton;
    private JButton resizeButton;

    public CropComponent()
    {
        setLayout(new MigLayout());
        cropButton = new JButton("Crop");
        resizeButton = new JButton("Resize");

        add(cropButton, WRAP_GROW_STRING);
        add(resizeButton, WRAP_GROW_STRING);
    }
}

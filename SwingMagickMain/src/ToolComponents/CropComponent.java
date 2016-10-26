package ToolComponents;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * Created by alex on 10/23/2016.
 */
public class CropComponent extends ToolComponent
{
    private JButton cropButton;

    public CropComponent()
    {
        setLayout(new MigLayout("", "[grow]", "[]"));
        cropButton = new JButton("Crop");
        add(cropButton, "growx");
    }
}

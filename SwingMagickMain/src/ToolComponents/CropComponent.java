package ToolComponents;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * Created by alex on 10/23/2016.
 */
public class CropComponent extends ToolComponent
{
    private JButton button;

    public CropComponent()
    {
        setLayout(new MigLayout());
        button = new JButton("Click me!");

        add(button);
    }
}

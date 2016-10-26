package ToolComponents;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * Created by alex on 10/25/2016.
 */
public class ResizeComponent extends ToolComponent
{
    private JButton resizeButton;

    public ResizeComponent()
    {
        setLayout(new MigLayout("", "[grow]", "[]"));
        resizeButton = new JButton("Resize");
        add(resizeButton, "growx");
    }
}

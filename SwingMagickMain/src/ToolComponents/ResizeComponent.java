package ToolComponents;

import ToolComponents.CustomComponents.CustomButton;
import net.miginfocom.swing.MigLayout;

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
        add(resizeButton);
    }
}

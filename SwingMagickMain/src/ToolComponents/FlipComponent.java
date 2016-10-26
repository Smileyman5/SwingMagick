package ToolComponents;

import ToolComponents.CustomComponents.CustomButton;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * Created by Mike on 10/26/2016.
 */
public class FlipComponent extends ToolComponent {

    private CustomButton flipButton;

    public FlipComponent()
    {
        setLayout(new MigLayout());
        flipButton = new CustomButton("./out/images/flip.png");
        flipButton.setRolloverIcon(new ImageIcon("./out/images/flip-hover.png"));
        flipButton.setPressedIcon(new ImageIcon("./out/images/flip-clicked.png"));
        add(flipButton);
        flipButton.setToolTipText("Flip the image on an axis.");
    }
}

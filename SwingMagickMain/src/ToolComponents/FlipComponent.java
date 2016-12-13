package ToolComponents;

import ToolComponents.CustomComponents.CustomButton;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.beans.PropertyChangeListener;

/**
 * Created by Mike on 10/26/2016.
 */
public class FlipComponent extends ToolComponent {

    private CustomButton flipButton;
    private String[] imageDir;

    public FlipComponent()
    {
        setLayout(new MigLayout());
        imageDir = new String[]{"./out/images/flip.png", "./out/images/flip-hover.png", "./out/images/flip-clicked.png"};
        flipButton = new CustomButton(imageDir[0], "flip");
        flipButton.setRolloverIcon(new ImageIcon(imageDir[1]));
        flipButton.setPressedIcon(new ImageIcon(imageDir[2]));
        add(flipButton);
        flipButton.setToolTipText("Flip the image on an axis.");
    }

    public void addListener(PropertyChangeListener listener) {
        flipButton.addPropertyChangeListener(listener);
    }
}

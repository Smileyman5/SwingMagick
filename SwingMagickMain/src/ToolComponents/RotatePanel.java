package ToolComponents;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

/**
 * Created by Mike on 12/7/2016.
 */
public class RotatePanel extends JPanel {

    private JTextField rotateDegreesField;

    private JLabel label;
    private JLabel unit;

    private JButton confirmButton;

    public RotatePanel() {

        setLayout(new MigLayout());
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        label = (new JLabel("Rotate Properties:      "));
        label.setForeground(Color.WHITE);

        rotateDegreesField = new JTextField();
        rotateDegreesField.setColumns(4);
        rotateDegreesField.setBackground(Color.GRAY);
        rotateDegreesField.setForeground(Color.WHITE);

        unit = (new JLabel("Degrees"));
        unit.setForeground(Color.WHITE);

        confirmButton = new JButton("Rotate");
        confirmButton.setBackground(Color.GRAY);

        add(label);
        add(rotateDegreesField);
        add(unit);
        add(confirmButton, "push, al right");
    }
}

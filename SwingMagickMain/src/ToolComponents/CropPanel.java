package ToolComponents;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

/**
 * The JPanel containing the options for the crop tool
 */
public class CropPanel extends JPanel{
    private JTextField startXField;
    private JTextField startYField;
    private JTextField endXField;
    private JTextField endYField;

    private JLabel propertyTypeLabel;
    private JLabel coordStartLabel;
    private JLabel coordEndLabel;
    private JLabel commaLabel = new JLabel(",");
    private JLabel commaLabel2 = new JLabel(",");

    private JButton confirmButton;

    public CropPanel () {
        setLayout(new MigLayout());
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        propertyTypeLabel = new JLabel("Crop Properties:    (X1, Y1) = (");
        propertyTypeLabel.setForeground(Color.WHITE);
        coordStartLabel = new JLabel(")     (X2, Y2) = (");
        coordStartLabel.setForeground(Color.WHITE);
        coordEndLabel = new JLabel(")");
        coordEndLabel.setForeground(Color.WHITE);
        commaLabel.setForeground(Color.WHITE);
        commaLabel2.setForeground(Color.WHITE);

        startXField = new JTextField("Start_Coordinate");
        startXField.setBackground(Color.GRAY);
        endXField = new JTextField("End_Coordinate");
        endXField.setBackground(Color.GRAY);
        startYField = new JTextField("Start_Coordinate");
        startYField.setBackground(Color.GRAY);
        endYField = new JTextField("End_Coordinate");
        endYField.setBackground(Color.GRAY);

        confirmButton = new JButton("Crop");
        confirmButton.setBackground(Color.GRAY);

        add(propertyTypeLabel);
        add(startXField);
        add(commaLabel);
        add(startYField);
        add(coordStartLabel);
        add(endXField);
        add(commaLabel2);
        add(endYField);
        add(coordEndLabel);
        add(confirmButton, "push, al right");
    }
}

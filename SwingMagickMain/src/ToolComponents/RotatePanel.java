package ToolComponents;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mike on 12/7/2016.
 */
public class RotatePanel extends JPanel {

    private JTextField rotateDegreesField;

    private ButtonGroup rotationSettings;

    private JRadioButton rotateRight;
    private JRadioButton rotateLeft;
    private JRadioButton rotate180;

    private JLabel label;
    private JLabel unit;

    private JButton confirmButton;

    public RotatePanel() {

        setLayout(new MigLayout());
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        label = (new JLabel("Rotate Properties:      "));
        label.setForeground(Color.WHITE);

        rotateRight = new JRadioButton("Rotate Clockwise      ");
        rotateRight.setBackground(Color.DARK_GRAY);
        rotateRight.setForeground(Color.WHITE);
        rotateLeft = new JRadioButton("Rotate Counterclockwise      ");
        rotateLeft.setBackground(Color.DARK_GRAY);
        rotateLeft.setForeground(Color.WHITE);
        rotate180 = new JRadioButton("Rotate 180 Degrees");
        rotate180.setBackground(Color.DARK_GRAY);
        rotate180.setForeground(Color.WHITE);

        rotationSettings = new ButtonGroup();
        rotationSettings.add(rotateLeft);
        rotationSettings.add(rotate180);
        rotationSettings.add(rotateRight);

//        rotateDegreesField = new JTextField();
//        rotateDegreesField.setColumns(4);
//        rotateDegreesField.setBackground(Color.GRAY);
//        rotateDegreesField.setForeground(Color.WHITE);

//        unit = (new JLabel("Degrees"));
//        unit.setForeground(Color.WHITE);

        confirmButton = new JButton("Rotate");
        confirmButton.setBackground(Color.GRAY);

        add(label);
        add(rotateRight);
        add(rotateLeft);
        add(rotate180);
        add(confirmButton, "push, al right");

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Double degreeSet = 0d;
                    if (rotateRight.isSelected()) {
                        degreeSet = 90d;
                    } else if (rotateLeft.isSelected()) {
                        degreeSet = 270d;
                    } else if (rotate180.isSelected()) {
                        degreeSet = 180d;
                    }
                    firePropertyChange("rotateImg", false, degreeSet);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

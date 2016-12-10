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
public class FlipPanel extends JPanel{

    private JCheckBox flipXAxisBox;
    private JCheckBox flipYAxisBox;

    private JLabel label;
    private JLabel xAxisLabel;
    private JLabel yAxisLabel;

    private JButton confirmButton;

    public FlipPanel() {
        setLayout(new MigLayout());
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        label = (new JLabel("Flip Properties:      "));
        label.setForeground(Color.WHITE);

        xAxisLabel = new JLabel("      Flip on X-Axis");
        xAxisLabel.setForeground(Color.WHITE);
        flipXAxisBox = new JCheckBox();
        flipXAxisBox.setBackground(Color.DARK_GRAY);
        flipXAxisBox.setForeground(Color.WHITE);
        yAxisLabel = new JLabel("      Flip on Y-Axis");
        yAxisLabel.setForeground(Color.WHITE);
        flipYAxisBox = new JCheckBox();
        flipYAxisBox.setBackground(Color.DARK_GRAY);
        flipYAxisBox.setForeground(Color.WHITE);

        confirmButton = new JButton("Flip");
        confirmButton.setBackground(Color.GRAY);

        add(label);
        add(xAxisLabel);
        add(flipXAxisBox);
        add(yAxisLabel);
        add(flipYAxisBox);
        add(confirmButton, "push, al right");

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                boolean[] flipInstructions = {flipXAxisBox.isSelected(), flipYAxisBox.isSelected()};
                firePropertyChange("flipImg",false,flipInstructions);
            }
        });
    }
}

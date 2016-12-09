package ToolComponents;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

/**
 * The JPanel containing the options for the filter tool
 */
public class FilterPanel extends JPanel {

    private final String[] filters = {"Monochrome","Sepia","Invert"};
    private JComboBox<String> filterOptions;

    private JLabel propertyLabel;
    private JLabel comboBoxLabel;

    private JButton confirmButton;

    public FilterPanel() {
        setLayout(new MigLayout());
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        filterOptions = new JComboBox<>(filters);
        //these colors don't work? must need look and feel adjustments
        filterOptions.setBackground(Color.GRAY);
        filterOptions.setForeground(Color.WHITE);

        propertyLabel = new JLabel("Filter Options:      ");
        propertyLabel.setForeground(Color.WHITE);
        comboBoxLabel = new JLabel("      Filter:");
        comboBoxLabel.setForeground(Color.WHITE);

        confirmButton = new JButton("Apply Filter");
        confirmButton.setBackground(Color.GRAY);

        add(propertyLabel);
        add(comboBoxLabel);
        add(filterOptions);
        add(confirmButton, "push, al right");
    }
}

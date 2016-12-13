package ToolComponents;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * The JPanel containing the options for the crop tool
 */
public class CropPanel extends JPanel{
    public boolean displaying;

    public JTextField startXField;
    public JTextField startYField;
    public JTextField endXField;
    public JTextField endYField;

    private JLabel propertyTypeLabel;
    private JLabel coordStartLabel;
    private JLabel coordEndLabel;
    private JLabel commaLabel = new JLabel("      Y =");
    private JLabel commaLabel2 = new JLabel("      Y =");

    private JButton confirmButton;

    public CropPanel () {

        displaying = true;
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
        decimalFormat.setGroupingUsed(false);

        setLayout(new MigLayout());
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        propertyTypeLabel = new JLabel("Crop Properties:    Image Size: X =");
        propertyTypeLabel.setForeground(Color.WHITE);
        coordStartLabel = new JLabel("      Crop Offset: X =");
        coordStartLabel.setForeground(Color.WHITE);
        coordEndLabel = new JLabel(")");
        coordEndLabel.setForeground(Color.WHITE);
        commaLabel.setForeground(Color.WHITE);
        commaLabel2.setForeground(Color.WHITE);

        startXField = new JFormattedTextField(decimalFormat);
        startXField.setColumns(6);
        startXField.setBackground(Color.GRAY);
        startXField.setForeground(Color.WHITE);
        endXField = new JFormattedTextField(decimalFormat);
        endXField.setColumns(6);
        endXField.setBackground(Color.GRAY);
        endXField.setForeground(Color.WHITE);
        startYField = new JFormattedTextField(decimalFormat);
        startYField.setColumns(6);
        startYField.setBackground(Color.GRAY);
        startYField.setForeground(Color.WHITE);
        endYField = new JFormattedTextField(decimalFormat);
        endYField.setColumns(6);
        endYField.setBackground(Color.GRAY);
        endYField.setForeground(Color.WHITE);

        confirmButton = new JButton("Crop");
        confirmButton.setBackground(Color.GRAY);
        confirmButton.setForeground(Color.WHITE);

        add(propertyTypeLabel);
        add(startXField);
        add(commaLabel);
        add(startYField);
        add(coordStartLabel);
        add(endXField);
        add(commaLabel2);
        add(endYField);
//        add(coordEndLabel);
        add(confirmButton, "push, al right");

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!startXField.getText().equals("") && !startYField.getText().equals("") &&
                        !endXField.getText().equals("") && !endYField.getText().equals("")) {
                    int[] params = {Integer.parseInt(startXField.getText()), Integer.parseInt(startYField.getText()),
                            Integer.parseInt(endXField.getText()), Integer.parseInt(endYField.getText())};
                    firePropertyChange("cropImg", false, params);
                }
            }
        });
    }
}

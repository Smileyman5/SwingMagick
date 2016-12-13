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
 * Created by Mike on 12/7/2016.
 */
public class ResizePanel extends JPanel {
    private JTextField sizeXField;
    private JTextField sizeYField;

    private JCheckBox aspectRatioBox;

    private JLabel propertyTypeLabel;
    private JLabel xLabel;
    private JLabel yLabel;
    private JLabel aspectRatioLabel;

    private JButton confirmButton;

    public ResizePanel() {

        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
        decimalFormat.setGroupingUsed(false);

        setLayout(new MigLayout());
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        propertyTypeLabel = new JLabel("Resize Properties:      ");
        propertyTypeLabel.setForeground(Color.WHITE);

        xLabel = new JLabel("      X = ");
        xLabel.setForeground(Color.WHITE);

        sizeXField = new JFormattedTextField(decimalFormat);
        sizeXField.setBackground(Color.GRAY);
        sizeXField.setForeground(Color.WHITE);
        sizeXField.setColumns(6);

        yLabel = new JLabel("px      Y = ");
        yLabel.setForeground(Color.WHITE);

        sizeYField = new JFormattedTextField(decimalFormat);
        sizeYField.setBackground(Color.GRAY);
        sizeYField.setForeground(Color.WHITE);
        sizeYField.setColumns(6);

        aspectRatioLabel = new JLabel("px      Ignore Aspect Ratio");
        aspectRatioLabel.setForeground(Color.WHITE);

        aspectRatioBox = new JCheckBox();
        aspectRatioBox.setBackground(Color.DARK_GRAY);
        aspectRatioBox.setForeground(Color.WHITE);

        aspectRatioBox.setIcon(new ImageIcon("./out/images/deselectedbox.png"));
        aspectRatioBox.setSelectedIcon(new ImageIcon("./out/images/selectedbox.png"));

        confirmButton = new JButton("Resize");
        confirmButton.setBackground(Color.GRAY);

        add(propertyTypeLabel);
        add(xLabel);
        add(sizeXField);
        add(yLabel);
        add(sizeYField);
        add(aspectRatioLabel);
        add(aspectRatioBox);
        add(confirmButton, "push, al right");

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int ignoreAspectRatio = 0;
                if (aspectRatioBox.isSelected()) {
                    ignoreAspectRatio = 1;
                }
                int[] resizeParams = {Integer.parseInt(sizeXField.getText()),Integer.parseInt(sizeYField.getText()),ignoreAspectRatio};
                firePropertyChange("resizeImg",false,resizeParams);
            }
        });
    }
}

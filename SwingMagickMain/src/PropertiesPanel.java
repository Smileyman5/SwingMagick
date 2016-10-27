import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alex on 10/26/2016.
 */
public class PropertiesPanel extends JPanel
{
    private JTextField startCoordTestField;
    private JTextField endCoordTestField;
    private JLabel propertyTypeLabel;
    private JLabel coordStartLabel;
    private JLabel coordEndLabel;

    public PropertiesPanel()
    {
        setLayout(new MigLayout());
        setBackground(Color.DARK_GRAY);

        propertyTypeLabel = new JLabel("Crop Properties:     (X1, Y1): (");
        propertyTypeLabel.setForeground(Color.WHITE);
        coordStartLabel = new JLabel(")     (X2, Y2): (");
        coordStartLabel.setForeground(Color.WHITE);
        coordEndLabel = new JLabel(")");
        coordEndLabel.setForeground(Color.WHITE);

        startCoordTestField = new JTextField("Start_Coordinate");
        startCoordTestField.setBackground(Color.GRAY);
        endCoordTestField = new JTextField("End_Coordinate");
        endCoordTestField.setBackground(Color.GRAY);

        add(propertyTypeLabel);
        add(startCoordTestField);
        add(coordStartLabel);
        add(endCoordTestField);
        add(coordEndLabel);
    }
}

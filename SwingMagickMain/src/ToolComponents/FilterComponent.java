package ToolComponents;

import ToolComponents.CustomComponents.CustomButton;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.beans.PropertyChangeListener;

/**
 * Created by alex on 10/27/2016.
 */
public class FilterComponent extends ToolComponent
{
    private CustomButton filterButton;

    public FilterComponent()
    {
        setLayout(new MigLayout());
        filterButton = new CustomButton("./out/images/filter.png", "filter");
        filterButton.setRolloverIcon(new ImageIcon("./out/images/filter-hover.png"));
        filterButton.setPressedIcon(new ImageIcon("./out/images/filter-clicked.png"));

        filterButton.addPopupItem(new JMenuItem("Interpolated filter"));
        filterButton.addPopupItem(new JMenuItem("Gaussian filter"));
        filterButton.addPopupItem(new JMenuItem("Cubic filter"));
        filterButton.addPopupItem(new JMenuItem("Cylindrical filter"));
        filterButton.addPopupItem(new JMenuItem("Lagrange filter"));

        add(filterButton);
        filterButton.setToolTipText("Brings the image through a filter.");
    }

    public void addListener(PropertyChangeListener listener) {
        filterButton.addPropertyChangeListener(listener);
    }
}

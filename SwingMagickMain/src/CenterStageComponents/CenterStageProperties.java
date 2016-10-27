package CenterStageComponents;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alex on 10/26/2016.
 */
public class CenterStageProperties extends JPanel
{
    JLabel toolTipLabel;
    JLabel sizeLabel;
    JLabel locationLabel;
    JLabel zoomLabel;


    public CenterStageProperties()
    {
        setLayout(new MigLayout("", "[grow]", "[]"));
        setBackground(Color.DARK_GRAY);

        toolTipLabel = new JLabel("Left-click and drag to select area to crop");
        toolTipLabel.setForeground(Color.WHITE);
        sizeLabel = new JLabel("size: 32x32");
        sizeLabel.setForeground(Color.WHITE);
        locationLabel = new JLabel("loc: 16x22");
        locationLabel.setForeground(Color.WHITE);
        zoomLabel = new JLabel("zoom: 100%");
        zoomLabel.setForeground(Color.WHITE);

        add(toolTipLabel, "align left");
        add(sizeLabel, "align right");
        add(locationLabel, "align right");
        add(zoomLabel, "align right");

    }
}

package CenterStageComponents;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * Created by alex on 10/26/2016.
 */
public class CenterStageProperties extends JPanel
{
    public CenterStageProperties()
    {
        setLayout(new MigLayout("", "[grow]", "[]"));
        add(new JLabel("Left-click and drag to select area to crop"), "align left");
        add(new JLabel("size: 32x32"), "align right");
        add(new JLabel("loc: 16x22"), "align right");
        add(new JLabel("zoom: 100%"), "align right");

    }
}

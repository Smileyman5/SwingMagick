package CenterStageComponents;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by alex on 10/26/2016.
 */
public class CenterStageProperties extends JPanel
{
    private JLabel toolTipLabel;
    private JLabel sizeLabel;
    private JLabel locationLabel;
    private JLabel zoomLabel;
    private ImageIcon image;

    public CenterStageProperties(JScrollPane scrollPane, JLabel imageLabel)
    {
        setLayout(new MigLayout("", "[grow]", "[]"));
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        toolTipLabel = new JLabel("Left-click and drag to select area to crop");
        toolTipLabel.setForeground(Color.WHITE);
        sizeLabel = new JLabel("size: " + 32 + "x" + 32);
        sizeLabel.setForeground(Color.WHITE);
        locationLabel = new JLabel("loc: " + 0 + "x" + 0);
        locationLabel.setForeground(Color.WHITE);
        zoomLabel = new JLabel("zoom: 100%");
        zoomLabel.setForeground(Color.WHITE);

        scrollPane.addMouseMotionListener(new MouseMotionListener()
        {
            @Override
            public void mouseDragged(MouseEvent e) { }

            @Override
            public void mouseMoved(MouseEvent e)
            {
//                System.out.println(scrollPane.getComponent(0).getX());
                locationLabel.setText("loc: " + (e.getX() - imageLabel.getX() - 10) + "x" + (e.getY() - imageLabel.getY() - 10));
            }
        });

        add(toolTipLabel, "align left");
        add(sizeLabel, "align right");
        add(locationLabel, "align right");
        add(zoomLabel, "align right");

    }
}

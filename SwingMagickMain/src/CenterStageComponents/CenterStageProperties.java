package CenterStageComponents;

import ToolComponents.CropPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
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
    private JLabel imageLabel;
    private Point startDrag;
    private Point endDrag;

    public CenterStageProperties(JScrollPane scrollPane, JLabel imageLabel, CropPanel cropPanel)
    {
        this.imageLabel = imageLabel;
        setLayout(new MigLayout("", "[grow]", "[]"));
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        toolTipLabel = new JLabel("Left-click and drag to select area to crop");
        toolTipLabel.setForeground(Color.WHITE);
        sizeLabel = new JLabel("size: " + imageLabel.getWidth() + "x" + imageLabel.getHeight());
        sizeLabel.setForeground(Color.WHITE);
        locationLabel = new JLabel("loc: " + 0 + "x" + 0);
        locationLabel.setForeground(Color.WHITE);
        zoomLabel = new JLabel("zoom: 100%");
        zoomLabel.setForeground(Color.WHITE);

        scrollPane.addMouseMotionListener(new MouseMotionListener()
        {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                sizeLabel.setText("size: " + imageLabel.getWidth() + "x" + imageLabel.getHeight());
                locationLabel.setText("loc: " + (e.getX() - imageLabel.getX() - 13) + "x" + (e.getY() - imageLabel.getY() - 13));
            }

            @Override
            public void mouseMoved(MouseEvent e)
            {
                sizeLabel.setText("size: " + imageLabel.getWidth() + "x" + imageLabel.getHeight());
                locationLabel.setText("loc: " + (e.getX() - imageLabel.getX() - 13) + "x" + (e.getY() - imageLabel.getY() - 13));
            }
        });

        scrollPane.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mousePressed(MouseEvent e)
            {
                startDrag = new Point((e.getX() - imageLabel.getX() - 13), (e.getY() - imageLabel.getY() - 13));
            }

            @Override
            public void mouseDragged(MouseEvent e)
            {

            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                double x = imageLabel.getWidth();
                double y = imageLabel.getHeight();
                endDrag = new Point((e.getX() - imageLabel.getX() - 13), (e.getY() - imageLabel.getY() - 13));
                if (cropPanel.displaying)
                {
                    double sx = (startDrag.getX() < 0) ? 0 : startDrag.getX();
                    double sy = (startDrag.getY() < 0) ? 0 : startDrag.getY();
                    double ex = (endDrag.getX() < 0) ? 0 : endDrag.getX();
                    double ey = (endDrag.getY() < 0) ? 0 : endDrag.getY();

                    sx = (sx > x) ? x : sx;
                    sy = (sy > y) ? y : sy;
                    ex = (ex > x) ? x : ex;
                    ey = (ey > y) ? y : ey;

                    cropPanel.startXField.setText(String.valueOf(ex - sx));
                    cropPanel.startYField.setText(String.valueOf(ey - sy));
                    cropPanel.endXField.setText(String.valueOf(sx));
                    cropPanel.endYField.setText(String.valueOf(sy));
                }
            }

        });

        add(toolTipLabel, "align left");
        add(sizeLabel, "align right");
        add(locationLabel, "align right");
        add(zoomLabel, "align right");

    }
}

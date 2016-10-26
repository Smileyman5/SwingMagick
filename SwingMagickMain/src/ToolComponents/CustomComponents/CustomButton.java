package ToolComponents.CustomComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by alex on 10/26/2016.
 */
public class CustomButton extends JButton implements MouseListener
{

    private Icon currentIcon;

    public CustomButton(String imageDir)
    {
        currentIcon = new ImageIcon(imageDir);
        setIcon(currentIcon);
        addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        currentIcon.paintIcon(this, g, 0, 0);
    }

    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (getPressedIcon() != null)
            currentIcon = getPressedIcon();
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        if (getRolloverIcon() != null)
            currentIcon =  getRolloverIcon();
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        if (getRolloverIcon() != null)
            currentIcon = getRolloverIcon();
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        currentIcon = getIcon();
    }
}

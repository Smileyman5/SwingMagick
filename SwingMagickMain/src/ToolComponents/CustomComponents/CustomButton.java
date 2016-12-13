package ToolComponents.CustomComponents;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alex on 10/26/2016.
 */
public class CustomButton extends JButton
{
    private Icon currentIcon;
    private JPopupMenu popupMenu;

    public CustomButton(String imageDir, String toolType)
    {
        popupMenu = new JPopupMenu();
        currentIcon = new ImageIcon(imageDir);
        setIcon(currentIcon);
        setBorderPainted(false);
        setBorder(null);
        setMargin(new Insets(0, 0, 0, 0));
        setContentAreaFilled(false);

//        addActionListener(e -> new Thread(() -> popupMenu.show(this, getWidth()/2, getHeight()/2)).start());
        addActionListener(e -> firePropertyChange(toolType, 0, 1));
    }

    public void addPopupItem(JMenuItem menuItem)
    {
        popupMenu.add(menuItem);
    }
}

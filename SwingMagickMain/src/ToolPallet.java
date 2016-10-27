import ToolComponents.*;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by alex on 10/23/2016.
 */
public class ToolPallet extends JPanel
{
    private static final String WRAP_GROW_STRING = "wrap, growx";

    private ArrayList<ToolComponent> toolComponents = new ArrayList<>();

    public ToolPallet()
    {
        setLayout(new MigLayout("", "[grow]", "[][][][][]push[][]"));
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        toolComponents.add(new CropComponent());
        toolComponents.add(new ResizeComponent());
        toolComponents.add(new RotateComponent());
        toolComponents.add(new FlipComponent());
        toolComponents.add(new FilterComponent());
//        toolComponents.add(new SaveComponent());
//        toolComponents.add(new UndoComponent());
        for (ToolComponent component: toolComponents)
            add(component, WRAP_GROW_STRING);
        add(new SaveComponent(), "growx, wrap, aligny bottom");
        add(new UndoComponent(), "growx, aligny bottom");
    }

    public void addComponent(ToolComponent component)
    {
        System.out.println("Adding " +  component);
        toolComponents.add(component);
        add(component, WRAP_GROW_STRING);
        repaint();
    }

    public boolean removeComponent(ToolComponent component)
    {
        if (!toolComponents.remove(component))
            return false;
        System.out.println("Removing " + component);
        remove(component);
        repaint();
        return true;
    }
}

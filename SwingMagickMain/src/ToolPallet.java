import ToolComponents.CropComponent;
import ToolComponents.ResizeComponent;
import ToolComponents.ToolComponent;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
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
        setLayout(new MigLayout("", "[grow]", ""));
        toolComponents.add(new CropComponent());
        toolComponents.add(new ResizeComponent());
        for (ToolComponent component: toolComponents)
            add(component, WRAP_GROW_STRING);
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

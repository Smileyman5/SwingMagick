import ToolComponents.*;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

/**
 * Created by alex on 10/23/2016.
 */
public class ToolPallet extends JPanel
{
    private static final String WRAP_GROW_STRING = "wrap, growx";

    private ArrayList<ToolComponent> toolComponents = new ArrayList<>();

    private CropComponent crop = new CropComponent();
    private ResizeComponent resize = new ResizeComponent();
    private RotateComponent rotate = new RotateComponent();
    private FlipComponent flip = new FlipComponent();
    private FilterComponent filter = new FilterComponent();
    private SaveComponent save = new SaveComponent();
    private UndoComponent undo = new UndoComponent();

    public ToolPallet()
    {
        setLayout(new MigLayout("", "[grow]", "[][]push[][][][][]"));
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        toolComponents.add(crop);
        toolComponents.add(resize);
        toolComponents.add(rotate);
        toolComponents.add(flip);
        toolComponents.add(filter);
//        toolComponents.add(new SaveComponent());
//        toolComponents.add(new UndoComponent());
        add(save, "growx, wrap");
        add(undo, "growx, wrap");
        for (ToolComponent component: toolComponents)
            add(component, WRAP_GROW_STRING);
    }

    public void addListeners(PropertyChangeListener listener) {
        crop.addListener(listener);
        resize.addListener(listener);
        flip.addListener(listener);
        rotate.addListener(listener);
        filter.addListener(listener);
        save.addListener(listener);
        undo.addListener(listener);
    }

    public void reset()
    {
        undo.reset();
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

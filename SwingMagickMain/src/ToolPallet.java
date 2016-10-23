import ToolComponents.CropComponent;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * Created by alex on 10/23/2016.
 */
public class ToolPallet extends JPanel
{
    public ToolPallet()
    {
        setLayout(new MigLayout());
        add(new CropComponent());
    }
}

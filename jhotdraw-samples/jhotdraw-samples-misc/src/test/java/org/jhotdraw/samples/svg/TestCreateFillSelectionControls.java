package org.jhotdraw.samples.svg;

import static org.junit.Assert.*;
import java.awt.*;
import javax.swing.*;
import org.jhotdraw.samples.svg.gui.FillToolBar;
import org.jhotdraw.util.ResourceBundleUtil;
import org.junit.Test;

public class TestCreateFillSelectionControls {
    @Test
    public void testCreateFillSelectionControls(){
        FillToolBar fillToolBar = new FillToolBar();
        JPanel p = new JPanel();
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");

        fillToolBar.createFillSelectionControls(p, labels);
        
        assertTrue(p.getLayout() instanceof GridBagLayout);
        //log result and expected
        System.out.println("Is p's layout a GridBagLayout? " + (p.getLayout() instanceof GridBagLayout) + " Expected: true");

        //does p have components?
        assertTrue(p.getComponentCount() > 0);
        //log result and expected
        System.out.println("Does p have components? " + (p.getComponentCount() > 0)+ " Expected: true");

        //does p have correct number of components?
        assertEquals(2, p.getComponentCount());
        //log result and expected
        System.out.println("Does p have correct number of components? " + (p.getComponentCount() == 2)+ " Expected: true");

        //does p have buttons?
        assertTrue(p.getComponent(0) instanceof AbstractButton);
        assertTrue(p.getComponent(1) instanceof AbstractButton);
        //log result and expected
        System.out.println("Does p have buttons? " + (p.getComponent(0) instanceof AbstractButton && p.getComponent(1) instanceof AbstractButton) + " Expected: true");
    }
}

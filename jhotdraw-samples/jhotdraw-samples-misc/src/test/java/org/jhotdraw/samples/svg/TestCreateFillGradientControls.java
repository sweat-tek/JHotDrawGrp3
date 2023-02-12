package org.jhotdraw.samples.svg;

import static org.junit.Assert.*;
import java.awt.*;
import javax.swing.*;
import org.jhotdraw.samples.svg.gui.FillToolBar;
import org.jhotdraw.util.ResourceBundleUtil;
import org.junit.Test;

public class TestCreateFillGradientControls {
    @Test
    public void testCreateFillGradientControls(){
        FillToolBar fillToolBar = new FillToolBar();
        JPanel p = new JPanel();
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");

        fillToolBar.createFillGradientControls(p, labels);
        assertTrue(p.getLayout() instanceof GridBagLayout);
        //log result and expected
        System.out.println("Is p's layout a GridBagLayout? " + (p.getLayout() instanceof GridBagLayout) + " Expected: true");

        //check subpanels
        JPanel p1 = (JPanel) p.getComponent(0);
        JPanel p2 = (JPanel) p.getComponent(1);
        JPanel p3 = (JPanel) p.getComponent(2);
        assertNotNull(p1);
        assertNotNull(p2);
        assertNotNull(p3);
        //log result and expected
        System.out.println("Does p1 have components? " + (p1.getComponentCount() > 0)+ " Expected: true");
        System.out.println("Does p2 have components? " + (p2.getComponentCount() > 0)+ " Expected: true");
        System.out.println("Does p3 have components? " + (p3.getComponentCount() > 0)+ " Expected: true");


        

        //check subpanels' layout
        assertTrue(p1.getLayout() instanceof GridBagLayout);
        assertTrue(p2.getLayout() instanceof GridBagLayout);
        assertTrue(p3.getLayout() instanceof GridBagLayout);
        //log result and expected
        System.out.println("Is p1's layout a GridBagLayout? " + (p1.getLayout() instanceof GridBagLayout) + " Expected: true");
        System.out.println("Is p2's layout a GridBagLayout? " + (p2.getLayout() instanceof GridBagLayout) + " Expected: true");
        System.out.println("Is p3's layout a GridBagLayout? " + (p3.getLayout() instanceof GridBagLayout) + " Expected: true");
        

        //check subpanels' are transparent
        assertFalse(p1.isOpaque());
        assertFalse(p2.isOpaque());
        assertFalse(p3.isOpaque());
        //log if subpanels are transparent
        System.out.println("Is p1 opaque? " + p1.isOpaque() + " Expected: false");
        System.out.println("Is p2 opaque? " + p2.isOpaque() + " Expected: false");
        System.out.println("Is p3 opaque? " + p3.isOpaque() + " Expected: false");



        //check if subpanels have correct number of components
        assertEquals(2, p1.getComponentCount());
        assertEquals(2, p2.getComponentCount());
        assertEquals(0, p3.getComponentCount());
        //log result and expected
        System.out.println("Does p1 have 2 components? " + (p1.getComponentCount() == 2));
        System.out.println("Does p2 have 2 components? " + (p2.getComponentCount() == 2));
        System.out.println("Does p3 have 0 components? " + (p3.getComponentCount() == 0));

    }
}

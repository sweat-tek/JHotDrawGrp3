package org.jhotdraw.samples.svg;

import static org.junit.Assert.*;

import org.jhotdraw.samples.svg.gui.FillToolBar;
import org.junit.Test;

public class TestFillToolBarInvariants {
    @Test
    public void testInvariants() {
        FillToolBar fillToolBar = new FillToolBar();
        
        // Test that the fillToolBar is not null
        assertNotNull(fillToolBar);
        
        // Test that the fillToolBar's name is not null and has a non-empty string value
        assertNotNull(fillToolBar.getName());
        assertFalse(fillToolBar.getName().isEmpty());
        
        // Test that the fillToolBar's orientation is set to HORIZONTAL by default
        assertEquals(fillToolBar.getOrientation(), FillToolBar.HORIZONTAL);
        
        
        // Test that the fillToolBar's components array is not null
        assertNotNull(fillToolBar.getComponents());
        
        // Test that the fillToolBar's components array is not empty
        assertFalse(fillToolBar.getComponents().length == 0);
    }
}

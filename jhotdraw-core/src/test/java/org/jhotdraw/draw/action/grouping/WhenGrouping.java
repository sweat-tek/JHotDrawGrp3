package org.jhotdraw.draw.action.grouping;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DrawingEditor;

public class WhenGrouping extends Stage<WhenGrouping> {
    @ExpectedScenarioState
    @ProvidedScenarioState
    private DrawingEditor editor;

}

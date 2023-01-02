package org.jhotdraw.samples.svg.behaviour;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;
import static org.junit.Assert.assertEquals;

public class ThenUserSeesTextField extends Stage<ThenUserSeesTextField> {

    @ExpectedScenarioState
    private SVGTextFigure svgTextFigure;

    ThenUserSeesTextField TheUserSeesTheText() {
        assertEquals("Hello World", svgTextFigure.getText());
        return this;
    }

}
package org.jhotdraw.draw.figure.behaviour;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;

public class WhenUserCreatesText extends Stage<WhenUserCreatesText> {

    @ExpectedScenarioState
    @ProvidedScenarioState
    private SVGTextFigure svgTextFigure;

    WhenUserCreatesText TheUserChangesTheText() {
        String text = "Hello World";
        svgTextFigure.setText(text);
        return this;
    }

}

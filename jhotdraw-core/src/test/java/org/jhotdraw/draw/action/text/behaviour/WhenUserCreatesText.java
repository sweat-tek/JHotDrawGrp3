package org.jhotdraw.draw.action.text.behaviour;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.figure.TextFigure;

public class WhenUserCreatesText extends Stage<WhenUserCreatesText> {

    @ExpectedScenarioState
    @ProvidedScenarioState
    TextFigure svgTextFigure;

    WhenUserCreatesText TheUserChangesTheText() {
        String text = "Hello World";
        svgTextFigure.setText(text);
        return this;
    }

}

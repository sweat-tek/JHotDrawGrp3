package org.jhotdraw.draw.action.text.behaviour;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.figure.TextFigure;
import org.junit.jupiter.api.Assertions;


public class ThenUserSeesTextField extends Stage<ThenUserSeesTextField> {

    @ExpectedScenarioState
    TextFigure svgTextFigure;

    ThenUserSeesTextField TheUserSeesTheText() {
        Assertions.assertEquals("Hello World", svgTextFigure.getText());
        return this;
    }

}
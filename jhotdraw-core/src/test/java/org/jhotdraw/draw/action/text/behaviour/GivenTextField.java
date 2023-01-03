package org.jhotdraw.draw.action.text.behaviour;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.figure.TextFigure;


class GivenTextField extends Stage<GivenTextField> {

    @ProvidedScenarioState
    TextFigure svgTextFigure;

    @BeforeStage
    void createFigure() {
        svgTextFigure = new TextFigure();
    }

    GivenTextField AUserCreatesATextFigure() {
        svgTextFigure.getText();
        return this;
    }
}
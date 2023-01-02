package org.jhotdraw.samples.svg.behaviour;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;


class GivenTextField extends Stage<GivenTextField> {

    @ProvidedScenarioState
    SVGTextFigure svgTextFigure;

    @BeforeStage
    void createFigure() {
        svgTextFigure = new SVGTextFigure();
    }

    GivenTextField AUserCreatesATextFigure() {
        svgTextFigure.getText();
        return this;
    }
}
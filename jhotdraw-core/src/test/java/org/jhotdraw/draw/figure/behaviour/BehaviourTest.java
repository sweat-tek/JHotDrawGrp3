package org.jhotdraw.draw.figure.behaviour;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class BehaviourTest extends ScenarioTest<GivenTextField, WhenUserCreatesText, ThenUserSeesTextField> {

    /*
     Grouped behavior test

       Given a user creates a text figure
        When the user changes the text
        Then the user sees the text
    */

    @Test
    public void GroupedBehaviorTest() {
        given().AUserCreatesATextFigure();
        when().TheUserChangesTheText();
        then().TheUserSeesTheText();
    }
}
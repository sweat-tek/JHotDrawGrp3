package org.jhotdraw.draw;

import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.draw.figure.RectangleFigure;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class QuadTreeDrawingTest {
    private Drawing drawing;

    @Before
    public void setUp() {
        drawing = new QuadTreeDrawing();
    }

    @Test
    public void testSendToBack() {
        Figure figure1 = new RectangleFigure();
        Figure figure2 = figure1.clone();
        Figure figure3 = figure1.clone();

        drawing.add(figure1);
        drawing.add(figure2);
        drawing.add(figure3);

        Assertions.assertArrayEquals(
                new Figure[]{figure3, figure2, figure1},
                drawing.getFiguresFrontToBack().toArray(),
                "Figures should be added in order, back to front"
        );

        drawing.sendToBack(figure3);

        Assertions.assertArrayEquals(
                new Figure[]{figure2, figure1, figure3},
                drawing.getFiguresFrontToBack().toArray(),
                "Figure should correctly be sent to the back"
        );
    }

    @Test
    public void testBringToFront() {
        Figure figure1 = new RectangleFigure();
        Figure figure2 = figure1.clone();
        Figure figure3 = figure1.clone();

        drawing.add(figure1);
        drawing.add(figure2);
        drawing.add(figure3);

        Assertions.assertArrayEquals(
                new Figure[]{figure3, figure2, figure1},
                drawing.getFiguresFrontToBack().toArray(),
                "Figures are not added in the correct order"
        );

        drawing.bringToFront(figure1);

        Assertions.assertArrayEquals(
                new Figure[]{figure1, figure3, figure2},
                drawing.getFiguresFrontToBack().toArray(),
                "Figures are not sent to back in the correct order"
        );
    }



}

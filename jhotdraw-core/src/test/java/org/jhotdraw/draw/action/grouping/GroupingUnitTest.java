package org.jhotdraw.draw.action.grouping;

import org.jhotdraw.draw.*;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.draw.figure.GroupFigure;
import org.jhotdraw.draw.figure.RectangleFigure;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Collection;
import java.util.List;

public class GroupingUnitTest {

    private DrawingView view;
    private DrawingEditor editor;

    private final Grouping grouping = new Grouping();

    @Before
    public void setUp() {
        this.editor = new DefaultDrawingEditor();
        this.view = new DefaultDrawingView();

        this.view.setDrawing(new DefaultDrawing());
        this.editor.setActiveView(view);
    }

    @Test
    public void testGrouping() {
        final Drawing drawing = view.getDrawing();
        Collection<Figure> figures = List.of(
            new RectangleFigure(),
            new RectangleFigure()
        );

        drawing.addAll(figures);
        Assertions.assertEquals(2, drawing.getChildren().size(), "Drawing should have 2 children");
        Assertions.assertInstanceOf(
            RectangleFigure.class,
            drawing.getChildren().get(0),
            "Drawing should have a RectangleFigure as first child"
        );


        grouping.groupFigures(view, new GroupFigure(), figures);

        Assertions.assertEquals(1, drawing.getChildren().size(), "Drawing should have 1 child - the group");
        Assertions.assertInstanceOf(
            GroupFigure.class,
            drawing.getChildren().get(0),
            "Drawing should have a GroupFigure as first child"
        );

    }

    @Test
    public void testUngrouping() {
        final Drawing drawing = view.getDrawing();
        GroupFigure group = new GroupFigure();
        group.addAll(List.of(
            new RectangleFigure(),
            new RectangleFigure()
        ));
        Collection<Figure> figures = List.of(group);
        drawing.addAll(figures);

        Assertions.assertEquals(1, drawing.getChildren().size(), "Drawing should have 1 child - the group");
        Assertions.assertInstanceOf(
            GroupFigure.class,
            drawing.getChildren().get(0),
            "Drawing should have a GroupFigure as first child"
        );

        grouping.ungroupFigures(view, group);

        Assertions.assertEquals(2, drawing.getChildren().size(), "Drawing should have 2 children");
        Assertions.assertInstanceOf(
            RectangleFigure.class,
            drawing.getChildren().get(0),
            "Drawing should have a RectangleFigure as first child"
        );

    }
}

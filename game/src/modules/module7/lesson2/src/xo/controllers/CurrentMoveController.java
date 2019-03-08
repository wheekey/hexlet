package xo.controllers;

import xo.model.Field;
import xo.model.Figure;
import xo.model.Point;

public class CurrentMoveController {

    public Figure currentMove(final Field field) {
        int countFigure = 0;
        for (int x = 0; x < field.getSize(); x++) {
            countFigure += countFiguresInTheRow(field, x);
        }

        if (countFigure == field.getSize() * field.getSize())
            return null;

        if (countFigure % 2 == 0)
            return Figure.X;

        return Figure.O;
    }

    private int countFiguresInTheRow(final Field field, final Integer row) {
        int countFigure = 0;
        for (int x = 0; x < field.getSize(); x++) {
            final Point p = new Point(x, row);
            if (field.getFigure(p) != null)
                countFigure++;
        }
        return countFigure;
    }
}

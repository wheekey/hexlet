package xo.view;


import xo.model.Field;
import xo.model.Figure;
import xo.model.Point;

public class AICoordinateGetter implements ICoordinateGetter {

    private Figure aICoordinateFigure = Figure.X;
    /*
    Итак, стоит обобщить вышеизложенное и кратко изложить шаги ИИ:


    Проверить, нельзя ли завершить игру победой.
    Проверить, не может ли враг на следующем ходе завершить игру победой.
    Проверить, можно ли создать противнику безвыходную ситуацию
    Если нельзя, то походить просто на одну из выгодных позиций.
    Если и это невозможно, походить на первую попавшуюся клетку.
    */

    public Point getMoveCoordinate(final Field field) {
        // BEGIN (write your solution here) (write your solution here)

        // END

        // BEGIN (write your solution here)

        // END
    }


    /**
     * Проверить, нельзя ли завершить игру победой.
     *
     */
    private Point getPointToWinNow(final Field field)
    {

    }

    private Point getPointToWinByRow(final Field field)
    {

    }

    private  Point getPointToWinByColumn(final Field field)
    {

    }

    private Point getPointToWinByDiag(final Field field)
    {

    }
}

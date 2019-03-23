package xo.view;

import xo.model.Field;
import xo.model.Figure;
import xo.model.Interval;
import xo.model.Point;

public class AICoordinateGetter implements ICoordinateGetter {

    private Figure aICoordinateFigure = Figure.X;
    private Figure randomCoordinateFigure = Figure.O;

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

        // Проверить, нельзя ли завершить игру победой.
        Point pointToWin = getPointToWinNow(field, aICoordinateFigure);

        if (pointToWin != null) {
            return pointToWin;
        }
        // END

        // Проверить, не может ли враг на следующем ходе завершить игру победой.
        Point pointToWinForCompetitor = getPointToWinNow(field, randomCoordinateFigure);

        // Помешаем противниику и не дадим ему победить.
        if (pointToWinForCompetitor != null) {
            return pointToWinForCompetitor;
        }

        // BEGIN (write your solution here)
        // Проверить, можно ли создать противнику безвыходную ситуацию
        pointToWin = getPointForHopelessSituationForCompetitor(field, aICoordinateFigure);

        if(pointToWin != null)
        {
            return pointToWin;
        }

        // Если не удается создать безвыходную ситуацию, то достаем выигрышную позицию
        pointToWin = getWinPosition(field);

        if(pointToWin != null)
        {
            return pointToWin;
        }

        return getAnyEmptyPoint(field);
        // END
    }


    private Point getAnyEmptyPoint(final Field field)
    {
        int fieldSize = field.getSize();

        for (int row = 0; row < fieldSize; row++) {
            for (int col = 0; col < fieldSize; col++) {
                Point point = new Point(row, col);

                if(isEmptyPoint(field, point))
                {
                    return point;
                }
            }
        }

        return null;
    }

    private boolean isEmptyPoint(final Field field, final Point point)
    {
        return field.getFigure(point) == null;
    }

    // Метод достает любую выигрышную позицию
    private Point getWinPosition(final Field field)
    {
        int fieldSize = field.getSize();

        for (int row = 0; row < fieldSize; row++) {
            for (int col = 0; col < fieldSize; col++) {
                Point point = new Point(row, col);

                if(isEdgePoint(point, field) || isCentralPoint(field, point))
                {
                    return point;
                }
            }
        }

        return null;
    }

    private boolean isCentralPoint(final Field field, final Point point)
    {
        int fieldSize = field.getSize();

        return point.getX() == (int)Math.floor(fieldSize/2) && point.getY() == (int)Math.floor(fieldSize/2);
    }

    /**
     * Единственный шанс выиграть (если противник не абсолютно туп) - создать безвыходную ситуацию.
     * Это достигается созданием определенной комбинации ваших меток,
     * при которой, как бы враг ни походил, вы всегда можете выиграть партию.
     * Эти комбинации - заполнены 3 угловые точки, причем между 2-мя парами из них должны быть пустые клетки;
     * заполнены 2 угловые и центральная, и соблюдается то же правило.
     * Из второго пункта можно понять, что существуют "выигрышные" позиции - это (1,1), (1,3), (3,1), (3,3), (2,2).
     * 11 | 12 | 13
     * 21 | 22 | 23
     * 31 | 32 | 33
     */
    private Point getPointForHopelessSituationForCompetitor(final Field field, final Figure winFigure) {
        //Проверим, заполнены ли три угловые точки нашей фигурой:
        if (isExistOpportunityToMakeHopelessSituationForCompetitorByThreeEdgePoints(field, winFigure)) {
            return getPointForHopelessSituationForCompetitorByThreeEdgePoints(field, winFigure);
        }



        return null;
    }

    private Point getPointForHopelessSituationForCompetitorByThreeEdgePoints(final Field field, final Figure winFigure) {
        Point[] perimeterPoints = formPerimeterPointsArray(field);

        // it should be three edge points
        for (Point point : perimeterPoints) {
            Figure figure = field.getFigure(point);

            if (isEdgePoint(point, field) && figure == null) {
                return point;
            }
        }

        return null;

    }

    private boolean isEdgePoint(final Point point, final Field field) {
        int maxPointPosition = field.getSize() - 1;
        int minPointPosition = 0;

        return (point.getX() == maxPointPosition || point.getX() == minPointPosition) && (point.getY() == maxPointPosition || point.getY() == minPointPosition);
    }

    private boolean isExistOpportunityToMakeHopelessSituationForCompetitorByThreeEdgePoints(final Field field, final Figure winFigure) {
        Interval currentInterval = getWinIntervalByThreeEdgePoints(field, winFigure);

        return currentInterval.getSize() >= getWinIntervalSize(field);
    }

    private int getWinIntervalSize(final Field field) {
        int fieldSize = field.getSize();
        // define win interval
        return fieldSize + fieldSize - 1;
    }

    private Interval getWinIntervalByThreeEdgePoints(final Field field, final Figure winFigure) {
        Interval interval = new Interval();

        int winIntervalSize = getWinIntervalSize(field);
        int currentIntervalSize = 0;

        Point[] perimeterPoints = formPerimeterPointsArray(field);

        for (int i = 0; i < perimeterPoints.length; i++) {
            Figure figure = field.getFigure(perimeterPoints[i]);
            if (figure == null || figure == winFigure) {
                currentIntervalSize++;

                if (currentIntervalSize == 1) {
                    interval.setStartIntervalPosition(i);
                }

                if (currentIntervalSize >= winIntervalSize) {
                    interval.setEndIntervalPosition(i);
                    return interval;
                }


            } else {
                currentIntervalSize = 0;
                interval.reset();
            }
        }

        // Сбрасываем, т.к. интервал нужной длины не найден
        interval.reset();
        return interval;
    }

    private Point[] formPerimeterPointsArray(final Field field) {
        Point[] perimeterPoints = new Point[field.getSize() * field.getSize() - 1];

        // perimeter points counter
        int perimeterPointsCounter = 0;

        // если или координаты точки по оси абсцисс или точка по оси ординат - максимальная, то эта точка находится на периметре.
        for (int row = 0; row < field.getSize(); row++) {
            for (int col = 0; col < field.getSize(); col++) {
                Point point = new Point(row, col);
                if (isPointOnPerimeter(field, point)) {
                    perimeterPoints[perimeterPointsCounter] = point;
                    perimeterPointsCounter++;
                }
            }
        }

        return perimeterPoints;
    }

    private boolean isPointOnPerimeter(final Field field, final Point point) {
        int fieldSize = field.getSize();

        return point.getX() == 0 || point.getY() == 0 || point.getX() == fieldSize - 1 || point.getY() == fieldSize - 1;

    }

    /**
     * Проверить, нельзя ли завершить игру победой.
     */
    private Point getPointToWinNow(final Field field, final Figure winFigure) {

        Point pointToWin = getPointToWinByRow(field, winFigure);
        if (pointToWin != null) {
            return pointToWin;
        }
        pointToWin = getPointToWinByColumn(field, winFigure);
        if (pointToWin != null) {
            return pointToWin;
        }
        pointToWin = getPointToWinByForwardDiag(field, winFigure);
        if (pointToWin != null) {
            return pointToWin;
        }
        pointToWin = getPointToWinByBackwardDiag(field, winFigure);
        if (pointToWin != null) {
            return pointToWin;
        }

        return null;
    }

    /**
     * В данном методе ищем точку в строке, куда сможем поставить свою фигуру для победы.
     *
     * @param field
     * @return Point
     */
    private Point getPointToWinByRow(final Field field, final Figure winFigure) {
        int pointsToWin = 0;
        Point pointToWin = null;
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                Point fieldPoint = new Point(i, j);

                if (field.getFigure(fieldPoint) == winFigure) {
                    pointsToWin++;
                }

                //Сохраняем как возможную выигрышную точку
                if (field.getFigure(fieldPoint) == null) {
                    pointToWin = fieldPoint;
                }
            }

            // Если наших точек в строке уже две, то можем победить по строке.
            if (pointsToWin == 2) {
                return pointToWin;
            }
        }

        return null;
    }

    /**
     * В данном методе ищем точку в столбце, куда сможем поставить свою фигуру для победы.
     *
     * @param field
     * @return Point
     */
    private Point getPointToWinByColumn(final Field field, final Figure winFigure) {
        int pointsToWin = 0;
        Point pointToWin = null;
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                Point fieldPoint = new Point(j, i);

                if (field.getFigure(fieldPoint) == winFigure) {
                    pointsToWin++;
                }

                //Сохраняем как возможную выигрышную точку
                if (field.getFigure(fieldPoint) == null) {
                    pointToWin = fieldPoint;
                }
            }

            // Если наших точек в строке уже две, то можем победить по строке.
            if (pointsToWin == 2) {
                return pointToWin;
            }
        }

        return null;
    }

    /**
     * В данном методе вернем выигрышную точку, если в следующем ходу сможем победить.
     *
     * @param field
     * @return
     */
    private Point getPointToWinByForwardDiag(final Field field, final Figure winFigure) {
        // Сначала по прямой диагонали проверяем, сможем ли победить
        int fieldSize = field.getSize();
        int pointsToWin = 0;
        Point pointToWin = null;
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                Point fieldPoint = new Point(i, j);
                if (i == j) {
                    if (field.getFigure(fieldPoint) == winFigure) {
                        pointsToWin++;
                    } else if (field.getFigure(fieldPoint) == null) {
                        pointToWin = fieldPoint;
                    }
                }
            }
        }

        if (pointsToWin == 2) {
            return pointToWin;
        }

        /*
        00 01 02
        10 11 12
        20 21 22
        */

        return null;
    }

    private Point getPointToWinByBackwardDiag(final Field field, final Figure winFigure) {
        int fieldSize = field.getSize();
        int pointsToWin = 0;
        Point pointToWin = null;
        // По обратной диагонали
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                Point fieldPoint = new Point(i, j);
                if (i + j == fieldSize - 1) {
                    if (field.getFigure(fieldPoint) == winFigure) {
                        pointsToWin++;
                    } else if (field.getFigure(fieldPoint) == null) {
                        pointToWin = fieldPoint;
                    }
                }
            }
        }

        if (pointsToWin == 2) {
            return pointToWin;
        }

        return null;
    }

}


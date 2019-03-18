package xo.view;


import xo.model.Field;
import xo.model.Figure;
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


        // END
    }

    /**
        Единственный шанс выиграть (если противник не абсолютно туп) - создать безвыходную ситуацию.

        Это достигается созданием определенной комбинации ваших меток,
        при которой, как бы враг ни походил, вы всегда можете выиграть партию.

        Эти комбинации - заполнены 3 угловые точки, причем между 2-мя парами из них должны быть пустые клетки;
        заполнены 2 угловые и центральная, и соблюдается то же правило.

        Из второго пункта можно понять, что существуют "выигрышные" позиции - это (1,1), (1,3), (3,1), (3,3), (2,2).

       11 | 12 | 13
       21 | 22 | 23
       31 | 32 | 33

     */
    private Point getPointForHopelessSituationForCompetitor(final Field field, final Figure winFigure)
    {
        //Проверим, заполнены ли три угловые точки нашей фигурой:
        if(isExistOpportunityToMakeHopelessSituationForCompetitor(field, winFigure))
        {

        }

        return null;
    }




    private boolean isExistOpportunityToMakeHopelessSituationForCompetitor(final Field field, final Figure winFigure)
    {



        return isExistOpportunityToMakeHopelessSituationForCompetitorByThreeEdgePoints(final Field field, final Figure winFigure);
    }

    private boolean isExistOpportunityToMakeHopelessSituationForCompetitorByThreeEdgePoints(final Field field, final Figure winFigure) {

    // Идем циклом по периметру и сохраняем значения.
        // В итоге формируем массив из единиц и ноликов. Если ячейка не заполнена или заполнена фигурой winFigure и она находится на периметре
        //То это единичка, иначе - нолик.

       //Массив значений равен размерности поля NxN
       int[]

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

    private Point getPointToWinByBackwardDiag(final Field field, final Figure winFigure)
    {
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

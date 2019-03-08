package xo;


import xo.controllers.MoveController;
import xo.controllers.WinnerController;
import xo.model.Field;
import xo.model.Figure;
import xo.model.Point;
import xo.view.AICoordinateGetter;
import xo.view.ConsoleView;
import xo.view.ICoordinateGetter;
import xo.view.RandomCoordinateGetter;

public class Main {

    public static void main(String... args) throws Exception {

        final Field field = new Field();

        final ICoordinateGetter random = new RandomCoordinateGetter();

        final ICoordinateGetter ai = new AICoordinateGetter();

        final MoveController mc = new MoveController();

        final WinnerController wc = new WinnerController();

        final ConsoleView cv = new ConsoleView();


        cv.show(field);

        for (int i = 0; i < 9; i++) {

            Thread.sleep(500);

            final Point p;

            if (i % 2 == 0)
                p = ai.getMoveCoordinate(field);
            else
                p = random.getMoveCoordinate(field);

            final Figure f = i % 2 == 0 ? Figure.X : Figure.O;

            if (!mc.applyFigure(field, p, f)) {
                throw new RuntimeException("looks like AI make illegal moves;)");
            }

            final Figure winner = wc.getWinner(field);

            cv.show(field);

            if (winner == Figure.O)
                throw new RuntimeException("O win's 0_o");

            if (winner == Figure.X) {
                System.out.println("X - win's!");
                return;
            }

        }
        throw new RuntimeException("no one won =(");
    }
}
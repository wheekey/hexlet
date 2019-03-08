package xo.view;


import xo.model.Field;
import xo.model.Point;

import java.util.Random;

public class RandomCoordinateGetter implements ICoordinateGetter {

    private static final Random RANDOM = new Random();

    public Point getMoveCoordinate(final Field field) {
        Point randomPoint = new Point(RANDOM.nextInt(field.getSize()), RANDOM.nextInt(field.getSize()));
        while (field.getFigure(randomPoint) != null) {
            randomPoint = new Point(RANDOM.nextInt(field.getSize()), RANDOM.nextInt(field.getSize()));
        }
        return randomPoint;
    }
}
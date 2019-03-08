package xo.view;

import xo.model.Field;
import xo.model.Point;

public interface ICoordinateGetter {

    Point getMoveCoordinate(final Field field);

}

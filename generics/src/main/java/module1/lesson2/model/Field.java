package module1.lesson2.model;

// public class Field {
// BEGIN (write your solution here)

// END

private static final int MIN_COORDINATE = 0;

// private final Figure[][] field;
// BEGIN (write your solution here)

// END

private final int fieldSize;

public Field(final int fieldSize) {
        this.fieldSize = fieldSize;
        // field = (Figure[][])new Object[filedSize][filedSize];
        // BEGIN (write your solution here)

        // END
        }

public int getSize() {
        return fieldSize;
        }

// public Figure getFigure(final Point point) throws InvalidPointException {
//     if (!checkPoint(point)) {
//         throw new InvalidPointException();
//     }
//     return field[point.getX()][point.getY()];
// }

// BEGIN (write your solution here)

// END

// public void setFigure(final Point point, final Figure figure) throws InvalidPointException {
//     if (!checkPoint(point)) {
//         throw new InvalidPointException();
//     }
//     field[point.getX()][point.getY()] = figure;
// }

// BEGIN (write your solution here)

// END

private boolean checkPoint(final Point point) {
        return checkCoordinate(
        point.getX(),
        field.length)
        && checkCoordinate(
        point.getY(),
        field[point.getX()].length);
        }

private boolean checkCoordinate(final int coordinate, final int maxCoordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;
    }

public static void main(String[] args) throws InvalidPointException {
        Field<Figure> xoField = new Field<>(3);
        xoField.setFigure(new Point(1, 1), Figure.O);
        Field<String> chField = new Field<>(8);
        chField.setFigure(new Point(2, 2), "figure1");
        }
        }
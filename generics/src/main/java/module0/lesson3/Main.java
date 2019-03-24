package module0.lesson3;

public class Main {

    public static void main(String... args) {
        final Integer left = 1;
        final Double middle = .4;
        final String right;
        right = "right";
        final Triple triple = new Triple(left, right, middle);
        final Tuple<Integer, String> t = triple;

        try {
            final Integer leftId = t.getLeft();
            if (!left.equals(leftId)) {
                throw new RuntimeException("Triple#getLeft() do not returns the value that have been set in the constructor");
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            final String rightValue = t.getRight();
            if (!right.equals(rightValue)) {
                throw new RuntimeException("Triple#getRight() do not returns the value that have been set in the constructor");
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            final Double middleValue = (Double)triple.getMiddle();
            if (!middle.equals(middleValue)) {
                throw new RuntimeException("Triple#getMiddle() do not returns the value that have been set in the constructor");
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}


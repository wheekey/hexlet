package module0.lesson2;

public class Main {

    public static void main(String... args) {
        final Tuple<Integer, String> t = new Tuple<>(12, "Max");
        final Integer leftId = t.getLeft();
        if (leftId != 12) {
            throw new RuntimeException("Tuple#getLeft() do not returns the value that have been set in the constructor");
        }
        final String rightValue = t.getRight();
        if (rightValue != "Max") {
            throw new RuntimeException("Tuple#getRight() do not returns the value that have been set in the constructor");
        }
    }
}


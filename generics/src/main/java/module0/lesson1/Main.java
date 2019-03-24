package module0.lesson1;

public class Main {

    public static void main(String... args) {
        final Box<Integer> b = new Box<>(12);
        final Integer bFromTheBox = b.getValue();
        if (bFromTheBox != 12) {
            throw new RuntimeException("Box#getValue() do not returns the value that have been set in the constructor");
        }
    }

}


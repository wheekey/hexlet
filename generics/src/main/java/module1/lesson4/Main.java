package module1.lesson4;

public class Main {

    public static void main(String... args) {
        final Man slava = new Man("Slava");
        final Man gleb = new Man("Gleb");
        final List<Man> mans = new ArrayList<>();
        mans.add(slava);
        mans.add(gleb);
        mans.add(gleb);
        mans.add(slava);
        final int expectedResult = 0;
        final int actualResult = new CollectionHelper().findFirstIndex(mans, "Sl");
        if (actualResult != expectedResult) {
            throw new RuntimeException(String.format("CollectionsHelper.findFirstIndex returns incorrect result for: " +
                            "target: %s. " +
                            "Incorrect result is: %d, expected: %d", "slava", actualResult,
                    expectedResult));
        }
    }
}
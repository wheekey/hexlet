package module1.lesson3;

public class Main {

    public static void main(String... args) {
        final Man slava = new Man("Slava", Sex.M);
        final Man gleb = new Man("Gleb", Sex.M);
        final Man liza = new Man("Liza", Sex.F);
        final Man konchita = new Man("Konchita", Sex.M);
        final List<Man> mans = new ArrayList<>();
        final List<Man> emptyMans = new ArrayList<>();
        mans.add(slava);
        mans.add(gleb);
        mans.add(konchita);
        mans.add(gleb);
        mans.add(slava);
        final int expectedResult = 0;
        final int actualResult = CollectionHelper.<Man>findFirstIndex(mans, slava);
        if (actualResult != expectedResult) {
            throw new RuntimeException(String.format("CollectionsHelper.findFirstIndex returns incorrect result for: " +
                            "target: %s. " +
                            "Incorrect result is: %d, expected: %d", "slava", actualResult,
                    expectedResult));
        }
        final int expectedResult2 = 4;
        final int actualResult2 = CollectionHelper.<Man>findLastIndex(mans, slava);
        if (actualResult2 != expectedResult2) {
            throw new RuntimeException(String.format("CollectionsHelper.findLastIndex returns incorrect result for: " +
                            "target: %s. " +
                            "Incorrect result is: %d, expected: %d", "slava", actualResult2,
                    expectedResult2));
        }

        final int expectedResult3 = -1;
        final int actualResult3 = CollectionHelper.<Man>findLastIndex(mans, liza);
        if (actualResult3 != expectedResult3) {
            throw new RuntimeException(String.format("CollectionsHelper.findLastIndex returns incorrect result for: " +
                            "target: %s. " +
                            "Incorrect result is: %d, expected: %d", "liza", actualResult3,
                    expectedResult3));
        }

        final int expectedResult4 = -1;
        final int actualResult4 = CollectionHelper.<Man>findFirstIndex(mans, liza);
        if (actualResult4 != expectedResult4) {
            throw new RuntimeException(String.format("CollectionsHelper.findFirstIndex returns incorrect result for: " +
                            "target: %s. " +
                            "Incorrect result is: %d, expected: %d", "liza", actualResult4,
                    expectedResult4));
        }

        final int expectedResult5 = 2;
        final int actualLResult5 = CollectionHelper.<Man>findLastIndex(mans, konchita);
        final int actualFResult5 = CollectionHelper.<Man>findFirstIndex(mans, konchita);
        if (actualLResult5 != expectedResult5 && actualFResult5 != expectedResult5) {
            throw new RuntimeException(String.format("CollectionsHelper.findLastIndex & findFirstIndex returns incorrect result for: " +
                            "target: %s. " +
                            "Incorrect result is:\n    First %d\n    Last %d, expected: %d", "konchita", actualFResult5,
                    actualLResult5));
        }
    }
}
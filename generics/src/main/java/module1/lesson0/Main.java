package module1.lesson0;

public class Main {

    public static void main(String... args) {
        final List<Integer> numbersList = new ArrayList<>();
        numbersList.add(1);
        numbersList.add(2);
        numbersList.add(1);
        final int expectedResult = 1;
        final int actualResult = CollectionsHelper.findIndex(numbersList, 2);
        if (actualResult != expectedResult) {
            throw new RuntimeException(String.format("CollectionsHelper.findIndex returns incorrect result for list: " +
                    "%s and target: %d. " +
                    "Incorrect result is: %d, expected: %d", numbersList.toString(), 2, actualResult, expectedResult));
        }

        final List<String> wordsList = new ArrayList<>();
        wordsList.add("1");
        wordsList.add("1");
        wordsList.add("2");
        final int expectedResult2 = 2;
        final int actualResult2 = CollectionsHelper.findIndex(wordsList, "2");
        if (actualResult2 != expectedResult2) {
            throw new RuntimeException(String.format("CollectionsHelper.findIndex returns incorrect result for list: " +
                            "%s and target: %s. " +
                            "Incorrect result is: %d, expected: %d", wordsList.toString(), "2",
                    actualResult2, expectedResult2));
        }

        final int expectedResult3 = -1;
        final int actualResult3 = CollectionsHelper.findIndex(numbersList, "2");
        if (actualResult3 != expectedResult3) {
            throw new RuntimeException(String.format("CollectionsHelper.findIndex returns incorrect result for list: " +
                            "%s and target: %s. " +
                            "Incorrect result is: %d, expected: %d", numbersList.toString(), "2",
                    actualResult3, expectedResult3));
        }
    }
}


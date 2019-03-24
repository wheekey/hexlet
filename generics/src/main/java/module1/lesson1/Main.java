package module1.lesson1;

public class Main {

    public static void main(String... args) {
        final CollectionsHelper<Human> collectionsHelper = new CollectionsHelper<>();

        final List<Human> mans = new ArrayList<Human>(){
            {
                add(new Man("Slava"));
                add(new Man("Klod"));
                add(new Woman("Klara"));
                add(new Woman("Tamara"));
                add(new Intersex("Borodachka"));
            }
        };

        final Human expectedResult = mans.get(0);
        final Human actualResult = collectionsHelper.findFirst(mans, "Sl", Sex.M);
        if (actualResult != expectedResult) {
            throw new RuntimeException(String.format("CollectionsHelper.findFirs returns incorrect result for: \n" +
                            "target: %s. \n" +
                            "Incorrect result is: %s, expected: %s", "\"Sl & Sex.M\"", actualResult.getName(),
                    expectedResult.getName()));
        }
        final Human expectedResult2 = null;
        final Human actualResult2 = collectionsHelper.findFirst(mans, "Sl", Sex.F);
        if (actualResult2 != expectedResult2) {
            throw new RuntimeException(String.format("CollectionsHelper.findFirs returns incorrect result for: \n" +
                            "target: %s. \n" +
                            "Incorrect result is: %s, expected: %s", "\"Sl & Sex.F\"", actualResult2.getName(),
                    null));
        }
        final Human expectedResult3 = mans.get(4);
        Human actualResult3 = collectionsHelper.findFirst(mans, "Bor", Sex.I);
        if (actualResult3 != expectedResult3) {
            throw new RuntimeException(String.format("CollectionsHelper.findFirs returns incorrect result for: \n" +
                            "target: %s. \n" +
                            "Incorrect result is: %s, expected: %s", "\"Bor & Sex.I\"", actualResult3.getName(),
                    expectedResult3.getName()));
        }
        actualResult3 = collectionsHelper.findFirst(mans, "Bor", Sex.F);
        if (actualResult3 != null) {
            throw new RuntimeException(String.format("CollectionsHelper.findFirs returns incorrect result for: \n" +
                            "target: %s. \n" +
                            "Incorrect result is: %s, expected: %s", "\"Bor & Sex.F\"", actualResult3.getName(),
                    null));
        }
        final Human expectedResult4 = mans.get(2);
        final Human actualResult4 = collectionsHelper.findFirst(mans, "Kl", Sex.F);
        if (actualResult4 != expectedResult4) {
            throw new RuntimeException(String.format("CollectionsHelper.findFirs returns incorrect result for: \n" +
                            "target: %s. \n" +
                            "Incorrect result is: %s, expected: %s", "\"Kl & Sex.F\"", actualResult4.getName(),
                    expectedResult4.getName()));
        }
        final Human expectedResult5 = mans.get(1);
        final Human actualResult5 = collectionsHelper.findFirst(mans, "Kl", Sex.M);
        if (actualResult5 != expectedResult5) {
            throw new RuntimeException(String.format("CollectionsHelper.findFirs returns incorrect result for: \n" +
                            "target: %s. \n" +
                            "Incorrect result is: %s, expected: %s", "\"Kl & Sex.M\"", actualResult5.getName(),
                    expectedResult5.getName()));
        }
    }
}


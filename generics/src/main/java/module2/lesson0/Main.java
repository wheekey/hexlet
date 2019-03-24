package module2.lesson0;

public class Main {

    public static void main(String... args) {
        XeroxTester xeroxTester = new XeroxTester();
        CopyController.copy(xeroxTester);
        if (!xeroxTester.scanExecuted) {
            throw new RuntimeException("scan was never called during the copy process");
        }
        if (!xeroxTester.printExecuted) {
            throw new RuntimeException("print was never called during the copy process");
        }
    }

    private static class XeroxTester implements IPrinter, IScanner {

        private boolean scanExecuted;

        private boolean printExecuted;

        public String scan() {
            scanExecuted = true;
            return "scan";
        }

        public void print(String txt) {
            printExecuted = true;
            if (!txt.equals("scan")) {
                throw new RuntimeException("Printed text != to \"scan\"");
            }
        }
    }
}
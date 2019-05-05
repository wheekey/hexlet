package kymbrik;


public class Main {

    public static void main(String[] args) {
        System.out.println(132123);
    }

    public static int min(int a, int b) {
        if (a < b)
            return a;
        else
            return b;
    }

    public static int min(int a, int b, int c) {
        if (a < b && a < c) return a;
        if (b < c) return b;
        return c;
    }

}

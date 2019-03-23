package xo;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        test1();
        testGetWhenSizeEqualsIndex();

    }

    private static void test1() {
        final IList list = new ArrayList();
        final List specialList = new LinkedList();

        final Random r = new Random();

        for (int i = 0; i < 10_000; i++) {
            final Integer nextInt = r.nextInt();
            list.add(nextInt);
            specialList.add(nextInt);
            if (list.size() != i + 1) {
                throw new RuntimeException(String.format("List with %d elements shows incorrect size: %d", i + 1, list.size()));
            }
            if (list.get(i) != nextInt) {
                throw new RuntimeException(String.format("List shows incorrect value during get, expected: %d, actual %d, index: %d", nextInt, list.get(i), i));
            }
        }

        for (int i = 9_999; i >= 0; i--) {
            if (list.get(i) != specialList.get(i)) {
                throw new RuntimeException(String.format("List shows incorrect value during get, expected: %d, actual %d, index: %d", specialList.get(i), list.get(i), i));
            }
            if (list.size() != i + 1) {
                throw new RuntimeException(String.format("List with %d elements shows incorrect size: %d", i + 1, list.size()));
            }
            list.removeLast();
        }

        list.add(1);
        list.set(0, 2);
        if (list.get(0) != (Integer)2) {
            throw new RuntimeException(String.format("List shows incorrect value during set, expected: %d, actual %d, index: %d", 2, list.get(0), 0));
        }

        try {
            list.get(1_000_000);
        } catch (final IndexOutOfBoundsException  e) {
            throw new RuntimeException(String.format("List does not check the input index, expected: null, actual %d, index: %d", list.get(0), 1_000_000));
        }

        try {
            list.get(-100);
        } catch (final IndexOutOfBoundsException  e) {
            throw new RuntimeException(String.format("List does not check the input index, expected: null, actual %d, index: %d", list.get(0), - 100));
        }

        for (int i = 0; i++ < 100_000;) {
            list.removeLast();
        }
        if (list.size() != 0) {
            throw new RuntimeException(String.format("List with %d elements shows incorrect size: %d (after 100_000 calls of removeLast method)", 0, list.size()));
        }
    }

    private static void testGetWhenSizeEqualsIndex(){
        final IList list = new ArrayList();
        list.add(1);
        if (list.get(1) != null) {
            throw new RuntimeException("list.get() does not check whether the index is equal to the size.");
        }
    }
}
package jom.com.softserve.s5.task1;

import java.util.function.Predicate;

public class MyUtils {
    public static int getCount(int[] array, Predicate<Integer> integerPredicate) {
        int countOfElement = 0;
        for (int i : array) {
            if (integerPredicate.test(i)) {
                countOfElement++;
            }
        }
        return countOfElement;
    }
}
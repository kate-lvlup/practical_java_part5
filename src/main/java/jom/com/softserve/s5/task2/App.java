package jom.com.softserve.s5.task2;

import java.util.Arrays;
import java.util.function.Consumer;

public class App {
    public static Consumer<double[]> cons = (double[] array) -> {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 2) {
                array[i] = array[i] * 0.8;
            } else {
                array[i] = array[i] * 0.9;
            }
        }
    };

    public static double[] getChanged(double[] initialArray, Consumer<double[]> consumer) {
        double[] newArray = Arrays.copyOf(initialArray, initialArray.length);
        consumer.accept(newArray);
        return newArray;
    }
}
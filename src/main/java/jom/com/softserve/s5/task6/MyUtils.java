package jom.com.softserve.s5.task6;

import java.util.function.Predicate;
import java.util.function.BiFunction;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;

class MyUtils {
    public static int findMaxByCondition(List<Integer> numbers, Predicate<Integer> pr) {
        return numbers.stream()
                .filter(pr)
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("No value present"));
    }
}

class User {
    public final List<Integer> values = new ArrayList<Integer>();   
    
   public int getFilterdValue(BiFunction<List<Integer>, Predicate<Integer>, Integer> function, Predicate<Integer> condition) {
        return function.apply(values, condition);
    }

    public int getMaxValueByCondition(Predicate<Integer> condition) {
        return getFilterdValue(
                MyUtils::findMaxByCondition,
                condition
        );
    }
}

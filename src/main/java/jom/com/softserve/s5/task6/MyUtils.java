package jom.com.softserve.s5.task6;

import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.List;

class MyUtils {
    public static Integer findMaxByCondition(List<Integer> numbers, Predicate<Integer> pr) {
        return numbers.stream()
                .filter(pr)
                .max((integer, anotherInteger) -> integer.compareTo(anotherInteger))
                .orElse(null);
    }
}

class User {

    public final List<Integer> values = new ArrayList<>();

    public int getFilterdValue(BiFunction<List<Integer>, Predicate<Integer>, Integer> function, Predicate<Integer> condition) {
        return function.apply(values, condition);
    }

    public int getMaxValueByCondition(Predicate<Integer> condition) {
        Integer maxByCondition = MyUtils.findMaxByCondition(values, condition);
        return getFilterdValue(
                (collection, predicate) -> collection.stream().filter(predicate).max(Integer::compareTo).orElse(null),
                condition
        );
    }
}
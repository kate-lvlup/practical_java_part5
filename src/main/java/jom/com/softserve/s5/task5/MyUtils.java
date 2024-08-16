package jom.com.softserve.s5.task5;

import java.util.Set;
import java.util.function.Predicate;

class MyUtils {
    public static Predicate<Integer> getPredicateFromSet(Set<Predicate<Integer>> predicateSet) {
        return predicateSet.stream()
                .reduce((integerPredicate, other) -> integerPredicate.and(other))
                .orElse(x -> true);
    }
}

package jom.com.softserve.s5.task3;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;


public class App {
    public static BinaryOperator<String> greetingOperator = (parameter1, parameter2) ->
            "Hello " + parameter1 + " " + parameter2 + "!!!";


    public static List<String> createGreetings(List<Person> people, BinaryOperator<String> binaryOperator) {
        return people.stream()
                .map(person -> binaryOperator.apply(person.name, person.surname))
                .collect(Collectors.toList());
    }
}

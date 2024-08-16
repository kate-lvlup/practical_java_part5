package jom.com.softserve.s5.task4;

import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    DecisionMethod goShopping;

    public Person(String name) {
        this.name = name;
        this.goShopping = (productName, discount) -> "product1".equals(productName) && discount > 10;
    }

    public String getName() {
        return name;
    }

    public void setGoShopping(DecisionMethod goShopping) {
        this.goShopping = goShopping;
    }

    public boolean willGoShopping(String productName, int discount) {
        return goShopping.decide(productName, discount);
    }
}

@FunctionalInterface
interface DecisionMethod {
    boolean decide(String productName, int discount);
}


class Shop {
    List<DecisionMethod> clients = new ArrayList<>();

    public int sale(String productName, int discount) {
        return (int) clients.stream()
                .filter(decisionMethod -> decisionMethod.decide(productName, discount))
                .count();
    }
}
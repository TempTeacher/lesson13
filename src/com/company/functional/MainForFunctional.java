package com.company.functional;

import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MainForFunctional {

    public static void main(String...args) {
        // without lambda
        FunctionalInterfaceTest functionalInterfaceTest = new FunctionalInterfaceTest() {
            @Override
            public void print(String text) {
                System.out.println(text);
            }
        };

        //custom
        FunctionalInterfaceTest functionalInterfaceImpl = System.out::println;
        // or (the same)
        functionalInterfaceImpl = c -> System.out.println(c);

        //inner
        Predicate<String> isSize10 = str -> str.length() == 10;
        BinaryOperator<Integer> summarize = (x, y) -> x + y; // or Integer::sum;
        UnaryOperator<Integer> square = x -> x * x;
        Function<String, Integer> convertStringToInteger = x -> Integer.parseInt(x); //or Integer::parseInt
        Consumer<String> print = x -> System.out.print(x);
        Supplier<Integer> generateRandom = () -> new Random().nextInt();

        //complex
        functionalInterfaceImpl = c -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("input string is ");
            stringBuilder.append(c);
            stringBuilder.append("the size is ");
            stringBuilder.append(c.length());
            stringBuilder.append("last symbol is '");
            stringBuilder.append(c.charAt(c.length() - 1));
            System.out.println(stringBuilder);
        };
        generateRandom = () -> {
            Random random = new Random();
            int rand = random.nextInt(101);
            return rand - 400;
        };

        // using
        int summa = summarize.apply(2, 6);
        System.out.println(summa);
    }

}

@FunctionalInterface // <- not mandatory, can't add more than 1 methode
interface FunctionalInterfaceTest {
    void print(String text); // <- can be any number of parameters
//    void methode2(); <- error
}

class RegularClass implements FunctionalInterfaceTest {

    @Override
    public void print(String text) {

    }
}

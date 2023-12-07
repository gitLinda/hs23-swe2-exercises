package ch.juventus.lambda;

import ch.juventus.object.Person;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class LambdaExamples {

    public static void main(String[] args) {
        // Übung 1
        Function<Date, String> dateConverter = (date) -> "Jetzt ist " + date;
        System.out.println(dateConverter.apply(new Date()));

        // Übung 2
        MathOperation addition = Integer::sum;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (a, b) -> a * b;
        MathOperation division = (a, b) -> a / b;

        System.out.println(operate(10, 5, addition));
        System.out.println(operate(10, 5, subtraction));
        System.out.println(operate(10, 5, multiplication));
        System.out.println(operate(10, 5, division));

        // Stream API Übung 1
        List<List<Integer>> input = List.of(
                List.of(1, 2, 3, 4, 5),
                List.of(3, 4, 5, 6, 7)
        );

        List<Integer> output = input.stream()
                .flatMap(Collection::stream)
                .map(n -> n * 2)
                .distinct()
                .sorted()
                .toList();

        System.out.println(output);

        // Stream API Übung 2
        List<Person> personInput = List.of(
                new Person("Hans", 50),
                new Person("Peter", 60),
                new Person("Lisa", 7),
                new Person("Anna", 25)
        );

        boolean allOlderThan18 = personInput.stream()
                .filter(person -> !person.getFirstName().toLowerCase().startsWith("a"))
                .map(Person::getAge)
                .allMatch(age -> age > 18);

        System.out.println(allOlderThan18);

        // Optionals Übung
        List<String> optionalsInput = List.of("a", "b", "c", "d");

        Optional<String> result = optionalsInput.stream()
                .filter(character -> character.equals("b"))
                .findAny();
        System.out.println(result.orElse("Not found"));

        Optional<String> result2 = optionalsInput.stream()
                .filter(character -> character.equals("z"))
                .findAny();
        System.out.println(result2.orElse("Not found"));
    }

    private static int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operate(a, b);
    }

}

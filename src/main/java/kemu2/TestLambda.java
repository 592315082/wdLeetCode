package kemu2;

import java.util.*;
import java.util.stream.Collectors;

public class TestLambda {

    private final String name;

    TestLambda(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

        InterTestLambda interTestLambda = TestLambda::new;
        TestLambda testLambda = interTestLambda.create("Hello World");
        System.out.println(testLambda.name);

        String[] array = new String[]{"Apple", "Orange", "Banana", "Lemon"};
        Arrays.sort(array, (s1, s2) -> {
            System.out.println("s1:" + s1 + " s2:" + s2);
            System.out.println(s1.compareTo(s2));
            return s1.compareTo(s2);
        });
        System.out.println(String.join(",", array));

        Arrays.sort(array, TestLambda::cmp);
        Arrays.sort(array, String::compareTo);
        List<String> list = Arrays.asList(array);
        list.forEach(System.out::println);

        String[] arrays = new String[]{"Bob", "Alice", "Tim"};
        List<String> names = Arrays.asList(arrays);
        List<Person3> persons = names.stream().map(Person3::new).collect(Collectors.toList());
        System.out.println(persons);
    }

    static int cmp(String s1, String s2) {
        return s2.compareTo(s1);
    }
}

interface InterTestLambda {
    TestLambda create(String name);
}

class Person3 {
    String name;

    public Person3(String name) {
        this.name = name;
    }

    public String toString() {
        return "Person: " + this.name;
    }
}
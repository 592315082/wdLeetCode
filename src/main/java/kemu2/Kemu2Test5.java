package kemu2;

import java.util.LinkedList;
import java.util.List;

public class Kemu2Test5 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Dog madDog = new MadDog();
        dog.bark();
        madDog.bark();

        String str = "123";
        String xx = str + 456;
        System.out.println(xx);

        List<String> list = new LinkedList<>();
        list.add(null);
    }
}

class Dog {
    public static void bark() {
        System.out.println("Dog");
    }
}

class MadDog extends Dog {
    public static void bark() {
        System.out.println("madDog");
    }
}

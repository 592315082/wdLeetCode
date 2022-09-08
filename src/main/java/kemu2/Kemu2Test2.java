package kemu2;

public class Kemu2Test2 {
    public static void main(String[] args) {
        Person1 p = new Student1("Xiao Ming");
        p.run();
    }
}

interface Person1 {
    String getName();
    default void run() {
        System.out.println(getName() + " run");
        System.out.println(111111);
    }
}

class Student1 implements Person1 {
    private String name;

    public Student1(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
package kemu2;

public class Kemu2Test1 {
    public static void main(String[] args) {
        Student s = new Student();

        Person person = new Student(); // 向上转型
        person.setName("aaaa");
        ((Student) person).setScore(11);  //向下转型
        System.out.println("11111111111111");

        Person p1 = new Student();
        Person p2 = new Person();
        Student s1 = (Student) p1;
        if (p2 instanceof Student) {
            Student s2 = (Student) p2;
        }
        System.out.println("11111111111111");
    }

}

class Student extends Person {
    protected int score;

    public Student(){
        super();
    }

    public Student(String name, int age, int score) {
        super(name, age);
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

class Person {
    protected String name;

    protected int age;

    public Person(){

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
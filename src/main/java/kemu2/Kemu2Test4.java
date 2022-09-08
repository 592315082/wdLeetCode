package kemu2;

import java.lang.reflect.*;

public class Kemu2Test4 {
    public static void main(String[] args) throws NoSuchFieldException,
            IllegalAccessException, NoSuchMethodException,
            InvocationTargetException, InstantiationException {
        printClassInfo("".getClass());
        printClassInfo(Runnable.class);
        printClassInfo(java.time.Month.class);
        printClassInfo(String[].class);
        printClassInfo(int.class);

        System.out.println("=======================================");
        Field f = String.class.getDeclaredField("value");
        System.out.println(f.getName()); // "value"
        System.out.println(f.getType()); // class [B 表示byte[]类型
        int m = f.getModifiers();
        System.out.println(m);
        Modifier.isFinal(m); // true
        Modifier.isPublic(m); // false
        Modifier.isProtected(m); // false
        Modifier.isPrivate(m); // true
        Modifier.isStatic(m); // false

        System.out.println("=======================================");
        Object p = new Person2("Xiao Ming");
        Class c = p.getClass();
        Field f2 = c.getDeclaredField("name");
        f2.setAccessible(true);
        Object value = f2.get(p);
        System.out.println(value); // "Xiao Ming"
        f2.set(p, "Xiao sb");
        System.out.println(((Person2) p).getName());

        System.out.println("=======================================");

        Class stdClass = Student2.class;
        Method method = stdClass.getMethod("getScore", String.class);
        System.out.println(method);
        System.out.println(stdClass.getMethod("getName"));
        System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));

        System.out.println("=======================================");
        System.out.println("反射调用substring");
        String s = "Hello world";
        Method method2 = String.class.getMethod("substring", int.class, int.class);
        String r = (String) method2.invoke(s, 0, 6);
        System.out.println(r);

        System.out.println("=======================================");
        System.out.println("反射调用静态方法，Integer.parseInt(String)");
        Method method3 = Integer.class.getMethod("parseInt", String.class);
        Integer integer = (Integer) method3.invoke(null, "12345");
        System.out.println(integer);
        System.out.println(integer.getClass().getTypeName());

        System.out.println("=======================================");
        System.out.println("调用非public方法 Method.setAccessible(true)");
        Student2 student2 = new Student2();
        System.out.println(Student2.class);
        System.out.println(student2.getClass());
        System.out.println(Student2.class.equals(student2.getClass()));
        System.out.println(Student2.class == student2.getClass());
        Method method4 = Student2.class.getDeclaredMethod("setGrade", int.class);
        method4.setAccessible(true);
        method4.invoke(student2, 5);
        System.out.println(student2.getGrade());

        System.out.println("=======================================");
        System.out.println("多态");
        Method method5 = Person2.class.getMethod("hello");
        method5.invoke(new Student2());
        //Person p = new Student();
        //p.hello();

        System.out.println("=======================================");
        // 只能public无参数构造方法
        Person2 person2 = Person2.class.newInstance();
        person2.hello();

        // 获取构造方法Integer(int):
        Constructor cons1 = Integer.class.getConstructor(int.class);
        // 调用构造方法:
        Integer n1 = (Integer) cons1.newInstance(123);
        System.out.println(n1);

        // 获取构造方法Integer(String)
        Constructor cons2 = Integer.class.getConstructor(String.class);
        Integer n2 = (Integer) cons2.newInstance("456");
        System.out.println(n2);

        // 反射 获取父类
        Class i = Integer.class;
        Class n = i.getSuperclass();
        System.out.println(n);
        Class o = n.getSuperclass();
        System.out.println(o);
        System.out.println(o.getSuperclass());
    }

    static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }
}

class Person2 {

    public Person2 () {

    }

    public Person2(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.println("Person:hello");
    }
}

class Student2 extends Person2 {

    public Student2() {
        super();

    }

    public Student2(String name) {
        super(name);
    }

    public int score;

    public int grade;

    private int getScore() {
        return score;
    }

    public int getScore(String type) {
        return 99;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getGrade() {
        return grade;
    }

    private int getGrade(int year) {
        return 1;
    }

    private void setGrade(int grade) {
        this.grade = grade;
    }

    public void hello() {
        System.out.println("Student:hello");
    }
}
package kemu2;

public class Kemu2Test3 {
    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(123, 456);
        int n = add(p);
        System.out.println(n);

        Pair<Number> p1 = new Pair<>(12.3, 4.56);
        Pair<Integer> p2 = new Pair<>(123, 456);
        setSame(p1, 100, 100);
        setSame(p2, 100, 100);
        System.out.println(p1.getFirst() + "," + p1.getLast());
        System.out.println(p2.getFirst() + "," + p2.getLast());

        System.out.println("============================");
        //@SuppressWarnings("uncheck")
        Pair[] arr = new Pair[2];
        Pair<String>[] ps = (Pair<String>[]) arr;
        ps[0] = new Pair<>("a", "b");
        arr[1] = new Pair<Integer>(1,2);
        Pair<String> p3 = ps[1];
        //String s = p3.getFirst();
        //System.out.println(s);
        System.out.println("============================");
    }

    // 上界通配符
    static int add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        //p.setFirst(new Integer(first.intValue() + 100));
        //p.setLast(new Integer(last.intValue() + 100));
        return p.getFirst().intValue() + p.getLast().intValue();
    }

    // 下界
    static void setSame(Pair<? super Integer> p, Integer first, Integer last) {
        p.setFirst(first);
        //p.setLast(last);
    }
}

class Pair<T> {
    private T first;
    private T last;
    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getLast() {
        return last;
    }

    public void setLast(T last) {
        this.last = last;
    }
}

package kemu2;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestStream {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("a", "b", "c");
        stream.forEach(System.out::println);

        Stream<String> stream1 = Arrays.stream(new String[] {"a", "b", "c"});
        stream1.forEach(System.out::println);
        System.out.println("=====================================");

        String[] arrays = new String[]{"X", "  Y", "Z"};
        List<String> list = Arrays.asList(arrays);
        list.forEach(s -> System.out.println(s));
        System.out.println("=====================================");
        Stream<String> stream2 = list.stream();
        stream2.map(String::toLowerCase).map(String::trim).forEach(System.out::println);
        System.out.println("=====================================");

        IntStream.of(1,2,3,4,5,6).filter(n -> n % 2 != 0).forEach(System.out::print);
        System.out.println("");
        System.out.println("=====================================");

        Stream<Integer> natual = Stream.generate(new NatualSupplier());
        natual.limit(5).forEach(System.out::println);
        System.out.println("=====================================");

        int product = IntStream.of(1,2,3,4).reduce(1, (acc, n) -> acc * n);
        System.out.println(product);
        System.out.println("=====================================");

        String[] array = new String[]{"profile=native", "debug=true", "logging=warn", "interval=500"};
        List<String> props = Arrays.asList(array);
        Map<String, String> hashmap = new HashMap<>();
        Map<String, String> map = props.stream().map(kv -> {
            String[] ss = kv.split("\\=", 2);
            hashmap.put(ss[0], ss[1]);
            return hashmap;
        }).reduce(new HashMap<>(), (m, kv) -> {
            m.putAll(kv);
            return m;
        });
        map.forEach((k, v) -> {
            System.out.println(k + "=" + v);
        });

    }
}

class NatualSupplier implements Supplier<Integer> {
    int n = 0;
    @Override
    public Integer get() {
        n++;
        return n;
    }
}


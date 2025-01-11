package Stream.questions;

import java.util.*;
import java.util.stream.IntStream;

public class stream {
    public static void main(String[] args) {
//1
        IntStream is1 = IntStream.range(0,5);
        is1.forEach(System.out::println);

        IntStream is2 = IntStream.rangeClosed(0,5);
        is2.forEach(System.out::println);

        OptionalDouble avg = IntStream.range(0,5).average();
        System.out.println(avg.getAsDouble());

        IntStream is3 = IntStream.range(0,0);
        double avg2 = is3.average().orElse(0);
        System.out.println(avg2);
//2
        List<Item> l = Arrays.asList(new Item("Screw", 1), new Item("Nail", 2), new Item("Bolt", 3));

        l.stream()
                .sorted((a,b)->a.name().compareTo(b.name()))
                .forEach(System.out::println);
        l.stream()
                .sorted(Comparator.comparing(a->a.name()))
                .map((item)->item.name())
                .forEach(System.out::println);

        l.stream()
                .map(i->i.name())
                .sorted()
                .forEach(System.out::println);




    }
}

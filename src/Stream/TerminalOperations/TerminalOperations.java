package Stream.TerminalOperations;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TerminalOperations {


    public static void main(String[] args) {
        //MIN MAX
        Optional<String> min = Stream.of("dog", "cat", "bird", "fish", "horse")
                .min((s1, s2) -> s1.length() - s2.length());
        min.ifPresent(System.out::println);

        Optional<Integer> max = Stream.of(4,2,6,12,9)
                .max((i1, i2) -> i1 - i2);
        max.ifPresent(System.out::println);

        //findAny findFirst
        Optional<String> any = Stream.of("dog", "cat", "bird", "fish", "horse")
                .findAny();
        any.ifPresent(System.out::println);// dog

        Optional<String> first = Stream.of("dog", "cat", "bird", "fish", "horse")
                .findFirst();
        first.ifPresent(System.out::println);// dog

      //anyMatch allMatch noneMatch
        List<String> list = List.of("dog", "cat", "bird", "fish", "horse");
        Predicate<String> pred = name -> name.startsWith("c");
        System.out.println(list.stream().anyMatch(pred)); //true
        System.out.println(list.stream().allMatch(pred)); //false
        System.out.println(list.stream().noneMatch(pred)); //false

        //foreach
        Stream<String> names = Stream.of("dog", "cat", "bird", "fish", "horse");
        names.forEach(System.out::println);


    }

}

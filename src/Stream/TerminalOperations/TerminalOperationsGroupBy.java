package Stream.TerminalOperations;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperationsGroupBy {

    public static void main(String[] args) {

        Stream<String> animals = Stream.of("dog", "cat", "bird", "fish", "horse");
        Map<Integer, List<String>> map = animals.collect(
                Collectors.groupingBy(String::length));
        System.out.println(map);


        Stream<String> name = Stream.of("dog", "cat", "cat","bird", "fish", "horse");
        Map<Integer, Set<String>> map2 = name.collect(
                Collectors.groupingBy(
                        String::length,
                        Collectors.toSet()));
        System.out.println(map2);

        Stream<String> name2 = Stream.of("dog", "cat", "cat","bird", "fish", "horse");
        Map<Integer,List<String>> map3 = name2.collect(
                Collectors.groupingBy(
                        String::length,
                        TreeMap::new,
                        Collectors.toList()));
        System.out.println(map3);

    }
}

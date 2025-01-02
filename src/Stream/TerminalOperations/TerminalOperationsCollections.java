package Stream.TerminalOperations;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperationsCollections {

    public static void main(String[] args) {

        StringBuilder word = Stream.of("I", "love", "Java")
                .collect(() -> new StringBuilder(),
                        (sb, s) -> sb.append(s),
                        (sb1, sb2) -> sb1.append(sb2));
        System.out.println(word);

//Colect (Collector)
        String s = Stream.of("cake", "donut", "pie")
                .collect(Collectors.joining(", "));
        System.out.println(s);

        Double avg = Stream.of("cake", "donut", "pie")
                .collect(Collectors.averagingInt(x->x.length()));
        System.out.println(avg);

        //collectors.ToMap()
        Map<String, Integer> map =
                Stream.of("cake", "donut", "pie")
                        .collect(
                                Collectors.toMap(
                                        x -> x,
                                        x -> x.length()
                                )
                        );
        System.out.println(map);

        Map<Integer, String> map2 =
                Stream.of("cake", "donut", "pie")
                        .collect(
                                Collectors.toMap(
                                        x -> x.length(),
                                        x -> x,
                                        (s1, s2) -> s1 + ", " + s2
                                )
                        );
        System.out.println(map2);

        Map<String, Integer> map3 = Stream.of("cake", "donut", "cake", "pie")
                .collect(
                        Collectors.toMap(
                                        x -> x,
                                        x -> x.length(),
                                        (s1, s2) -> s1 + s2,// caso tenha string duplicadas ele ira somar o valor
                                        () -> new TreeMap<>()));

        System.out.println(map3);
        System.out.println(map3.getClass());



    }
}

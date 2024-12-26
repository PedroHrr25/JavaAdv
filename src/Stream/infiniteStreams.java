package Stream;

import java.util.stream.Stream;

public class infiniteStreams {
    public static void main(String[] args) {

        //1 infinite
        Stream<Integer> infStream = Stream.iterate(2, n -> n + 2);
        infStream.forEach(System.out::println);

        //2 limite
        infStream.limit(10).forEach(System.out::println);
    }
}

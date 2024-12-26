package Stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class stream {

    public static void main(String[] args) {

//1
        Double[] numbers = {1.0, 2.0, 3.0, 4.0, 5.0};

        Stream<Double> stream1 = Arrays.stream(numbers);

        long n = stream1.count();
        System.out.println("Number of elements: " + n);
//2
        List<String> animalList = Arrays.asList("dog", "cat", "bird", "fish", "horse");

        Stream<String> streamAnimals = animalList.stream();

        System.out.println("Number of animals: " + streamAnimals.count());
//3
        Map<String, Integer> namesToAges = new HashMap<>();
        namesToAges.put("Sean", 35);
        namesToAges.put("Liam", 20);
        namesToAges.put("Emma", 28);
        System.out.println("Numbers of Entries: " +
                namesToAges.entrySet()
                        .stream()
                        .count());





    }





}

package Stream.questions;

import Stream.IntermidiateOperations.Person;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
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

        List<Integer> li2 = Arrays.asList(1,2,3,4,5);
        Integer sum = li2
                .stream()
                .mapToInt(i->i)
                .sum();
        System.out.println(sum);

        List<Person> people = Arrays.asList(new Person("Sean", 35), new Person("Liam", 20), new Person("Emma", 28));
        Person oldestPerson = people
                .stream()
                .max(Comparator.comparing(p->p.age()))
                .get();
        System.out.println(oldestPerson);

        List<Integer> li = Arrays.asList(22,13,32);
        Optional<Integer> oi = li
                .stream()
                .max(Comparator.comparing(i->i));

        List<Integer> ls = Arrays.asList(10,47,33,23,12);
        int max2 = ls.stream()
                .reduce((a,b)->Integer.max(a,b))
                .get();
        System.out.println(max2);

        //Optional

        List<Book> books = Arrays.asList(new Book("Thinking in Java", 30), new Book("Java in 24 hours", 20), new Book("Java for Dummies", 10));

        double avaragePrice = books.stream()
                .filter(book -> book.getPrice()>10)
                .mapToDouble(book -> book.getPrice())
                .average()
                //.getAsDouble();
                        .orElseGet(()->0);
        System.out.println(avaragePrice);

        Map<String,Double> bookMap =
                books.stream()
                        .collect(Collectors.toMap(b->b.getTitle(), b->b.getPrice()));
        BiConsumer<String, Double> funcBC = (a,b) ->{
            if(a.startsWith("T")){
                System.out.println(b);
            }
        };

        bookMap.forEach(funcBC);

        List<Book> bookList = Arrays.asList(new Book("Gone with the wind", 20), new Book("Gone with the wind", 15), new Book("The Catcher in the Rye", 10));
        bookList.stream()
                .collect(Collectors.toMap(b->b.getTitle(), b->b.getPrice(), (b1,b2)->b1*b2))
                .forEach((a,b)-> System.out.println(a+" "+b));






    }
}

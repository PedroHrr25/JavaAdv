package LambdaLab;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdasLab {

    //1
  public void consumer() {
      Consumer<String> lambda = s -> System.out.println(s);
        lambda.accept("Consumer Consumer");

      Printable<String> printable = s -> System.out.println(s);
        printable.print("Printable Consumer");

      Consumer<String> consumerMR = System.out::println;
        consumerMR.accept("Consumer MR");
  }

  //2
  public void supplier() {
        Retrievable<Integer> lambda2 = () -> 77;
          System.out.println("Retrievable: " + lambda2.retrieve());

          Supplier<Integer> supplier2 = () -> 77;
          System.out.println("Supplier: " + supplier2.get());
      }

  //3
  public void predicate(){
      Evaluate<Integer> lambda2 = i -> i < 0;
        System.out.println("Evaluate: " + lambda2.evaluate(-1));
        System.out.println("Evaluate: " + lambda2.evaluate(+1));

      Predicate<Integer> predicate = i -> i < 0;
        System.out.println("Predicate: " + predicate.test(-1));
        System.out.println("Predicate: " + predicate.test(+1));

      int x = 4;
      System.out.println("Is " + x + " even? " + check(4, i -> i % 2 == 0));
      x = 7;
      System.out.println("Is " + x + " even? " + check(7, i -> i % 2 == 0));

      String name = "Mr. Joe Blogss";
        System.out.println("Does " + name + " Start with Mr. ? " +
                check("Mr. Joe Blogss ", s ->s.startsWith("Mr."))); //true
      name = "Ms. Ann Blogss";
        System.out.println("Does " + name + " Start with Mr. ? " +
                check("Ms. Joe Blogss ", s ->s.startsWith("Mr."))); //false

      Person person = new Person("John", 25, 1.8);
         System.out.println("Is "+ person.getName() + " a adult? " +
              check(person, p -> p.getAge() >= 18)); //true
      person = new Person("Mary", 15, 1.6);
        System.out.println("Is "+ person.getName() + " a adult? " +
                check(person, p -> p.getAge() >= 18)); //false

      Functionable<Integer, String> lambda = i -> "Number is: " + 1;
        System.out.println("Functionable: " + lambda.applyThis(5));

      Function<Integer, String>  function = i-> "Number is: " + i;
        System.out.println("Function: " + function.apply(5));

  //4
  List<Person> personList = new ArrayList<>();
    personList.add(new Person("John", 25, 1.8));
    personList.add(new Person("Mary", 15, 1.6));
    personList.add(new Person("Mike", 35, 1.7));
    personList.add(new Person("Tom", 45, 1.9));
sortAge(personList);
sortName(personList);

  }

  public static <T> boolean check(T t, Predicate<T> lambda) {
      return lambda.test(t);
  }

  public static void sortAge (List<Person> listPeople) {
      listPeople.sort(Comparator.comparing(p -> p.getAge())); // lambda syntax
      //Comparator.comparing(Person::getAge) // method reference syntax

      System.out.println("After Sort by Age");
      listPeople.forEach(s-> System.out.println(s)); // lambda syntax
      //listPeople.forEach(System.out::println); // method reference syntax
  }

public static void sortName (List<Person> listPeople) {
      listPeople.sort(Comparator.comparing(p -> p.getName())); // lambda syntax
      //Comparator.comparing(Person::getName) // method reference syntax

      System.out.println("After Sort by Name");
      listPeople.forEach(s-> System.out.println(s)); // lambda syntax
      //listPeople.forEach(System.out::println); // method reference syntax
  }
}



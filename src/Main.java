import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {

//Predicate
        Predicate<Integer> predicate = i -> i < 0;
        System.out.println("Predicate: " + predicate.test(-1));
        System.out.println("Predicate: " + predicate.test(+1));

        String namePredicateTrue = "Mr. Joe Blogss";
        System.out.println("Does " +namePredicateTrue + " Start with Mr. ? " + check("Mr. Joe Blogss ", s ->s.startsWith("Mr."))); //true
        String namePredicateFalse = "Ms. Ann Blogss";
        System.out.println("Does " +namePredicateFalse + " Start with Mr. ? " + check("Ms. Joe Blogss ", s ->s.startsWith("Mr."))); //false

        Predicate<String> pStr = s -> s.contains("City");
        System.out.println(pStr.test("Vatican City")); //True

//BiPredicate
        BiPredicate<String, Integer> checkLength = (str, len) -> str.length() == len;
        System.out.println(checkLength.test("Vatican City",8));//false

//supplier
        Supplier<StringBuilder> supSB = () -> new StringBuilder();
        System.out.println("Sbpplier SB: " + supSB.get().append("SK"));// Supplier SB: SK
        Supplier<LocalTime> supTime = () -> LocalTime.now();
        System.out.println("Suppler Time: " + supTime.get()); // Supplier Time :
        Supplier<Double> sRandom = () -> Math.random();
        System.out.println("Supplier Number: " + sRandom.get()); //Supplier Number ...

//Consumer
        Consumer<String> printC = s -> System.out.println(s);
        System.out.println("To be or not to be, that is the question");

        List<String> names = new ArrayList<>();
        names.add("John"); names.add("Mary");
        names.forEach(printC);

//BiConsumer
        var mapCapitalCities = new HashMap<String, String>();
        BiConsumer<String, String> biCon = (key, value ) -> mapCapitalCities.put(key,value);
        biCon.accept("Dublin","Ireland");
        biCon.accept("Washington D.C","USA");

        BiConsumer<String , String> mapPrint = (key, value) -> System.out.println(key + " is the capital of: "+ value);
        mapCapitalCities.forEach(mapPrint);

        Evaluate<Integer> lambda = i -> {return i < 0;};
        System.out.println("Evaluate: " + lambda.isNegative(-1));
        System.out.println("Evaluate: " + lambda.isNegative(1));

//Function
        Function<String, Integer> fn2 = s -> s.length();
        System.out.println("Function: " + fn2.apply("Moscow"));//6

//BiFunction
        BiFunction<String , String, Integer> biFn = (s1, s2) -> s1.length() + s2.length();
        System.out.println("BiFunction: " + biFn.apply("Willian", "Shakespeare")); // 18

        BiFunction<String , String, String> biFn2 = (s1,s2) -> s1.concat(s2);
        System.out.println("BiFunction: " + biFn2.apply("Willian ", "Shakespeare"));






    }

    public static <T> boolean check(T t , Predicate<T> lambda){
        return lambda.test(t);
    }

}
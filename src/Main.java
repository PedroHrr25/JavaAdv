import java.time.LocalTime;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

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




        Evaluate<Integer> lambda = i -> {return i < 0;};
        System.out.println("Evaluate: " + lambda.isNegative(-1));
        System.out.println("Evaluate: " + lambda.isNegative(1));



    }

    public static <T> boolean check(T t , Predicate<T> lambda){
        return lambda.test(t);
    }

}
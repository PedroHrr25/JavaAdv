import java.util.function.BiPredicate;
import java.util.function.Predicate;

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


        Evaluate<Integer> lambda = i -> {return i < 0;};
        System.out.println("Evaluate: " + lambda.isNegative(-1));
        System.out.println("Evaluate: " + lambda.isNegative(1));



    }

    public static <T> boolean check(T t , Predicate<T> lambda){
        return lambda.test(t);
    }

}
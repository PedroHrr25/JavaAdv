import java.time.LocalTime;
import java.util.*;
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
//UnaryOperator
    // a diferença basica do UnaryOperator é que ele transforma a entrada na saida, enquanto o Function precisa de 2 parametros 1 que vai ser a entrada e outro que vai ser a saida.
        UnaryOperator<String> unaryOp = name -> "My name is "+ name;
        System.out.println("UnaryOperator: " + unaryOp.apply("Sean"));

// method references
    //bound
        String name = "Mr. Joe Bloggs";
        Supplier<String> lowerLambda = () -> name.toLowerCase();
        Supplier<String> lowerMethodReference = name::toLowerCase;
        System.out.println(lowerLambda.get());
        System.out.println(lowerMethodReference.get());

        Predicate<String> tittleLambda =  (title) -> name.startsWith(title);
        Predicate<String> tittleMethodRerefence = name::startsWith;
        System.out.println(tittleLambda.test("Mr.")); //true
        System.out.println(tittleMethodRerefence.test("Ms.")); //false

    //unbound
        Function<String, String> upperL = s -> s.toUpperCase();
        Function<String, String> upperMR = String::toUpperCase;
        System.out.println(upperL.apply("sean"));
        System.out.println(upperMR.apply("sean"));

        BiFunction<String, String, String> concatL = (s1,s2) -> s1.concat(s2);
        BiFunction<String, String, String>  contatMR = String::concat;
        System.out.println(concatL.apply("Sean ", "Kennedy"));
        System.out.println(contatMR.apply("Sean ","Kennedy"));
    //staticMethod Reference
        Consumer<List<Integer>> sortL = list -> Collections.sort(list);
        Consumer<List<Integer>> sortMR = Collections::sort;
        List<Integer> listOfNumbers = Arrays.asList(2,1,5,6,8);
        sortL.accept(listOfNumbers);
        System.out.println(listOfNumbers);

        listOfNumbers = Arrays.asList(4,5,2,1,2);
        sortMR.accept(listOfNumbers);
        System.out.println(listOfNumbers);







    }

    public static <T> boolean check(T t , Predicate<T> lambda){
        return lambda.test(t);
    }

}
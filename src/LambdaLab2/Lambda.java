package LambdaLab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class Lambda {

    //1
    public static void main(String[] args) {
        List list = Arrays.asList(1, 2, 6, 5,3);
        Consumer<List<Integer>> lambda = l -> Collections.sort(l);
        System.out.println(list);
        lambda.accept(list);
        System.out.println(list);

        list = Arrays.asList(1, 2, 6, 5,3);

        Consumer<List<Integer>> methodRef = Collections::sort;
        System.out.println(list);
        methodRef.accept(list);
        System.out.println(list);

    //2 boundMR
        String name = "MR. Joe Bloggs";

        Predicate<String> lambda2 = s -> name.startsWith(s);
        System.out.println(lambda2.test("Mr.")); //true
        System.out.println(lambda2.test("Ms.")); //false

        Predicate<String> methodRef2 = name::startsWith;
        System.out.println(methodRef2.test("Mr.")); //true
        System.out.println(methodRef2.test("Ms.")); //false

    //3 unbound
        Predicate<String> lambda3 = s -> s.isEmpty();
        System.out.println(lambda3.test("")); //true
        System.out.println(lambda3.test("Hello")); //false

        Predicate<String> methodRef3 = String::isEmpty;
        System.out.println(methodRef3.test("")); //true
        System.out.println(methodRef3.test("Hello")); //false

        BiPredicate<String , String> lambda4 = (s1,s2) -> s1.startsWith(s2);
        System.out.println(lambda4.test("Sean", "S")); //true
        System.out.println(lambda4.test("Sean", "K")); //false

        BiPredicate<String , String> methodRef4 = String::startsWith;
        System.out.println(methodRef4.test("Sean", "S")); //true
        System.out.println(methodRef4.test("Sean", "K")); //false

    //4 contructor
        Supplier<List<String>> lambda5 = () -> new ArrayList();
        List<String> listConstructor  = lambda5.get();
        listConstructor.add("Lambda");
        System.out.println(listConstructor);

        Supplier<List<String>> methodRef5 = ArrayList::new;
        List<String> listConstructor2  = methodRef5.get();
        listConstructor2.add("Method Reference");

        Function<Integer, List<String>> lambda6 = x -> new ArrayList(x);
        List<String> listConstructor3  = lambda6.apply(10);
        listConstructor3.add("Lambda");
        System.out.println(listConstructor3);

        Function<Integer, List<String>> methodRef6 = ArrayList::new;
        List<String> listConstructor4  = methodRef6.apply(5);
        listConstructor4.add("Method Reference");
        System.out.println(listConstructor4);




    }

}

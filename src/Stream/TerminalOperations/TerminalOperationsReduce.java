package Stream;

import java.util.stream.Stream;

public class TerminalOperationsReduce {
    public static void main(String[] args) {


        //vai todos os elementos e soma começando com o elemento vazio, precisa necessariamente começar com um elemento inicio
        // no caso foi escolhido o elemento vazio mas poderia ser qualquer coisa string.

        String name = Stream.of("a", "b", "c", "d", "e")
                .reduce("", (s1, s2) -> s1 + s2);
        System.out.println(name);

        Integer product = Stream.of(1, 2, 3, 4, 5)
                .reduce(1, (i1, i2) -> i1 * i2);
        System.out.println(product);

        //bifunction com reduce

        Stream<String> stream = Stream.of("dog", "cat", "bird", "fish", "horse");
        int length = stream.reduce(0, // identify
                (n,str) -> n + str.length(), // somando ao valor inicial transformar string em integer
                (n1,n2) -> n1 + n2); // somando as 2 string transformadas em integer
        System.out.println(length);







    }
}

package pt.ual.pp.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        List<String> strings = Arrays.asList(
                "As the asteroid hurtled toward earth, Becky was upset her dentist appointment had been canceled.",
                "Malls are great places to shop; I can find everything I need under one roof.",
                "The blue parrot drove by the hitchhiking mongoose.",
                "It was a really good Monday for being a Saturday.",
                "The sudden rainstorm washed crocodiles into the ocean."
        );


        filterStrings(strings, string -> string.startsWith("A")).forEach(System.out::println);

        filterStrings(strings, string -> string.length() > 10).forEach(System.out::println);

        filterStrings(strings, string -> string.split(" ").length > 8).forEach(System.out::println);

        filterStrings(strings, string -> filterStrings(Arrays.asList(string.split(" ")), s -> s.length() < 3).size() == 0).forEach(System.out::println);

        filterStrings(strings, string ->
                (string.length() - string.replace("w", "").length()) % 2 == 0 &&
                        (string.length() - string.replace("w", "").length()) != 0)
                .forEach(System.out::println);
    }

    public static List<String> filterStrings(List<String> strings, Predicate<String> predicate) {
        return strings.stream().filter(predicate).collect(Collectors.toList());
    }
}

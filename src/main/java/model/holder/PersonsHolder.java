package model.holder;

import lombok.Getter;
import model.Person;

import java.util.Locale;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Getter
public class PersonsHolder {

    private static TreeSet<Person> personSet = new TreeSet<>();

    public static void addPerson(Person person) {
        personSet.add(person);

    }

    public static TreeSet<Person> filterPersons(Locale locale) {
        Predicate<Person> isStudentOfGivenLocale = person -> person.getNationality().getLocale().equals(locale);
        return personSet.stream()
                .filter(isStudentOfGivenLocale)
                .sorted()
                .collect(Collectors.toCollection(TreeSet::new));
    }

}

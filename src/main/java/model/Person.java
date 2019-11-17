package model;

import com.github.javafaker.Faker;
import enums.NationalityEnum;
import generator.DateGenerator;
import generator.PeselGenerator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import model.holder.PersonsHolder;

import java.text.Collator;
import java.time.LocalDate;
import java.util.Locale;

@Getter
@EqualsAndHashCode
public abstract class Person implements Comparable<Person> {

    private static final Locale PL_LOCALE = new Locale("pl");
    public static final Collator PL_COLLATOR = Collator.getInstance(PL_LOCALE);

    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    private final String pesel;
    private final NationalityEnum nationality;
    private final Faker faker = new Faker();

    public Person() {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        nationality = NationalityEnum.getRandom();
        birthDate = DateGenerator.getRandomBirthDate();
        pesel = PeselGenerator.generatePesel(this);
        PersonsHolder.addPerson(this);
    }

    @Override
    public int compareTo(Person person) {
        final int compareResult = PL_COLLATOR.compare(lastName, person.getLastName());
        if (compareResult != 0) {
            return  compareResult;
        }
        return PL_COLLATOR.compare(firstName, person.firstName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", pesel='" + pesel + '\'' +
                ", nationality=" + nationality +
                '}';
    }
}

package test;

import generator.PeselGenerator;
import model.Person;
import model.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PeselGeneratorTest {

    private static final Random random = new Random();

    @Test
    public void generatePeselTest() {
        List<Person> personList = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            Person person = new Student();
            final String pesel = PeselGenerator.generatePesel(person);
            System.out.println(i + " " + pesel);
        }

    }
}

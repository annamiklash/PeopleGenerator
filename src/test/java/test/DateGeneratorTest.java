package test;

import generator.DateGenerator;
import org.junit.Test;

import java.time.LocalDate;

public class DateGeneratorTest {

    @Test
    public void birthDateGeneratorTest(){
        for (int i = 0; i < 10; i++) {
            final LocalDate randomBirthDate = DateGenerator.getRandomBirthDate();
            final String string = randomBirthDate.toString();
            System.out.println(string);

        }
    }

    @Test
    public void hireDateGeneratorTest(){
        for (int i = 0; i < 10; i++) {
            final LocalDate randomHireDate = DateGenerator.getRandomHireDate();
            final String string = randomHireDate.toString();
            System.out.println(string);
        }
    }
}
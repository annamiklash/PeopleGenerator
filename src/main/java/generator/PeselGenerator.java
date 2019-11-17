package generator;

import enums.SexEnum;
import model.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PeselGenerator {

    private static final Random RANDOM = new Random();
    private static final int ZERO = Integer.parseInt("0");
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("YYMMdd");

    private static final List<Integer> FEMALE_DIGITS = Arrays.asList(0, 2, 4, 6, 8);
    private static final List<Integer> MALE_DIGITS = Arrays.asList(1, 3, 5, 7, 9);

    private static final int[] NUMBERS = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};


    public static String generatePesel(Person person) {
        final String peselWithoutControlDigit = generateStringDate(person) + generateRandomFourDigits() + generateSexDigit(person);
        final int controlDigit = generateControlDigit(peselWithoutControlDigit);
        return peselWithoutControlDigit + controlDigit;
    }

    private static String generateStringDate(Person person) {
        final LocalDate birthDate = person.getBirthDate();
        return birthDate.format(dateFormatter);
    }

    private static String generateRandomFourDigits() {
        return String.format("%04d", RANDOM.nextInt(10000));
    }

    private static String generateSexDigit(Person person) {
        if (person.getSex().equals(SexEnum.WOMAN)) {
            final int randomIndex = RANDOM.nextInt(FEMALE_DIGITS.size());
            return String.valueOf(FEMALE_DIGITS.get(randomIndex));
        } else {
            final int randomIndex = RANDOM.nextInt(MALE_DIGITS.size());
            return String.valueOf(MALE_DIGITS.get(randomIndex));
        }
    }

    //TODO: test
    private static int generateControlDigit(String peselWithoutControlDigit) {
        final List<Integer> peselNumbersList = peselWithoutControlDigit.chars()
                .mapToObj(character -> Integer.parseInt("" + character))
                .collect(Collectors.toList());

        int sum = 0;
        for (int i = 0; i < NUMBERS.length; i++) {
            int digit = peselNumbersList.get(i);
            sum += NUMBERS[i] * digit;
        }

        return (sum % 10);
    }


}


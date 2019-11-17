package generator;

import model.Person;

import java.util.Random;

public class PeselGenerator {

    private static final Random RANDOM = new Random();
    private static final int ZERO = Integer.parseInt("0");

    private static final int[] NUMBERS = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};

    public static String generatePesel(Person person) {
        final String peselWithoutControlDigit = generateStringDate(person) + generateRandomFourDigits() + generateSexDigit();
        final int controlDigit = generateControlDigit(peselWithoutControlDigit);
        return peselWithoutControlDigit + controlDigit;
    }

    private static String generateStringDate(Person person) {
        final int year = person.getBirthDate().getYear();
        final int month = person.getBirthDate().getMonthValue();
        final int day = person.getBirthDate().getDayOfMonth();

        String yearString = String.valueOf(year).substring(2);
        String monthString = String.valueOf(month);
        if (monthString.length() == 1) {
            monthString = "0" + monthString;
        }

        String dayString = String.valueOf(day);
        if (dayString.length() == 1) {
            dayString = "0" + dayString;
        }
        return yearString + monthString + dayString;
    }

    private static String generateRandomFourDigits() {
        return String.format("%04d", RANDOM.nextInt(10000));
    }

    private static String generateSexDigit() {
        final int randomDigit = RANDOM.nextInt(2);
        return String.valueOf(randomDigit);
    }

    private static int generateControlDigit(String peselWithoutControlDigit) {
        int sum = 0;
        for (int i = 0; i < NUMBERS.length; i++) {
            int digit = peselWithoutControlDigit.charAt(i) - ZERO;
            sum += NUMBERS[i] * digit;
        }
        return 10 - (sum % 10);
    }


}


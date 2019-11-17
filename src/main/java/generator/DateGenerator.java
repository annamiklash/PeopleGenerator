package generator;

import lombok.ToString;

import java.time.LocalDate;
import java.util.Random;

@ToString
public class DateGenerator {

    private static final LocalDate minBirthDate = LocalDate.of(1960, 1, 1) ;
    private static final LocalDate maxBirthDate = LocalDate.of(2000, 1, 1) ;

    private static final LocalDate minHireDate = LocalDate.of(2000, 1, 1) ;
    private static final LocalDate maxHireDate = LocalDate.now();
    private static final Random random = new Random();

    public static LocalDate getRandomBirthDate() {
        final int minDay = (int) minBirthDate.toEpochDay();
        final int maxDay = (int) maxBirthDate.toEpochDay();
        final long randomDay = minDay + random.nextInt(maxDay - minDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    public static LocalDate getRandomHireDate() {
        final int minDay = (int) minHireDate.toEpochDay();
        final int maxDay = (int) maxHireDate.toEpochDay();
        final long randomDay = minDay + random.nextInt(maxDay - minDay);
        return LocalDate.ofEpochDay(randomDay);
    }
}

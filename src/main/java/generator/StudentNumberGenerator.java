package generator;

import java.util.Random;

public class StudentNumberGenerator {

    private static final Random random = new Random();

    public static String generateStudentNo() {
        return String.format("%03d", random.nextInt(1000));
    }
}

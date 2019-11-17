package generator;

import enums.AcademicDegreeEnum;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DegreeGenerator {

    private static final Random RANDOM = new Random();
    private static final List<AcademicDegreeEnum> DEGREE_ENUM_LIST = Arrays.asList(AcademicDegreeEnum.values());

    public static AcademicDegreeEnum getRandom(){
        final int i = RANDOM.nextInt(DEGREE_ENUM_LIST.size());
        return DEGREE_ENUM_LIST.get(i);
    }

}

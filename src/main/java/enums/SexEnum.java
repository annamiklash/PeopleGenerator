package enums;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum SexEnum {
    MAN,
    WOMAN;

    private static final Random RANDOM = new Random();
    private static final List<SexEnum> SEX_ENUM_LIST = Arrays.asList(SexEnum.values());

    public static SexEnum getRandom() {
        final int i = RANDOM.nextInt(SEX_ENUM_LIST.size());
        return SEX_ENUM_LIST.get(i);
    }

}

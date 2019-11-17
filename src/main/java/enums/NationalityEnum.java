package enums;

import java.text.Collator;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public enum NationalityEnum {
    Polish(new Locale("pl")),
    Ukrainian(new Locale("ua")),
    Belarussian(new Locale("by")),
    Slovakian(new Locale("sk")),
    Lithuanian(new Locale("lt")),
    Latvian(new Locale("lv")),
    British(new Locale("en_UK")),
    Indian(new Locale("en_IN")),
    Chinese(new Locale("cn")),
    Vietnamese(new Locale("vm"));

    private  final Collator collator;
    private final Locale locale;
    private static final Random RANDOM = new Random();

    private static final List<NationalityEnum> NATIONALITY_ENUM_LIST = Arrays.asList(NationalityEnum.values());

    NationalityEnum(Locale locale) {
        this.locale = locale;
        collator = Collator.getInstance(locale);
    }

    public static NationalityEnum getRandom(){
        final int i = RANDOM.nextInt(NATIONALITY_ENUM_LIST.size());
        return NATIONALITY_ENUM_LIST.get(i);
    }

    public Locale getLocale() {
        return locale;
    }

    public Collator getCollator() {
        return  collator;
    }
}

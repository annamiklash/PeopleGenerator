package model.holder;

import lombok.Getter;
import model.Teacher;

import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Getter
public class TeachersHolder {

    private static final Random random = new Random();
    private static TreeSet<Teacher> teachersSet = new TreeSet<>();

    public static void addTeacher(Teacher teacher) {
        teachersSet.add(teacher);
    }

    public static Teacher getTeacherWithRandomIndex() {
        final int randomIndex = random.nextInt(teachersSet.size());
        Iterator<Teacher> teacherIterator = teachersSet.iterator();
        Teacher current = null;
        int counter = 0;
        while (teacherIterator.hasNext() ){
            current = teacherIterator.next();
            if (counter == randomIndex){
                return current;
            }
            counter++;
        }
        return null;
    }

    public static TreeSet<Teacher> filterTeachers(Locale locale) {
        Predicate<Teacher> isStudentOfGivenLocale = teacher -> teacher.getNationality().getLocale().equals(locale);
        return teachersSet.stream()
                .filter(isStudentOfGivenLocale)
                .sorted()
                .collect(Collectors.toCollection(TreeSet::new));
    }


}

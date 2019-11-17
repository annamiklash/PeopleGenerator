package model.holder;

import lombok.Getter;
import model.Teacher;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Getter
public class TeachersHolder {

    private static final Random random = new Random();
    private static TreeSet<Teacher> teachersSet = new TreeSet<>();

    public static void addTeacher(Teacher teacher) {
        teachersSet.add(teacher);
    }

    public static List<Teacher> getRandomTeachersList(int expectedListSize) {
        final Set<Teacher> studentSet = new HashSet<>();

        final List<Teacher> allStudentList = new ArrayList<>(teachersSet);
        int studentCount = 0;
        while (studentCount != expectedListSize) {
            final int randomIndex = random.nextInt(teachersSet.size());
            final Teacher randomStudent = allStudentList.get(randomIndex);
            if (!studentSet.contains(randomStudent)) {
                studentSet.add(randomStudent);
                studentCount++;
            }
        }
        return new ArrayList<>(studentSet);
    }

    public static TreeSet<Teacher> filterTeachers(Locale locale) {
        Predicate<Teacher> isStudentOfGivenLocale = teacher -> teacher.getNationality().getLocale().equals(locale);
        return teachersSet.stream()
                .filter(isStudentOfGivenLocale)
                .sorted()
                .collect(Collectors.toCollection(TreeSet::new));
    }


}

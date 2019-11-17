package model.holder;

import lombok.Getter;
import model.Student;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Getter
public class StudentsHolder {

    private static final Random random = new Random();
    private static TreeSet<Student> studentsSet = new TreeSet<>();

    public static void addStudent(Student student) {
        studentsSet.add(student);
    }

    public static List<Student> getRandomStudentsList(int expectedListSize) {
        final Set<Student> studentSet = new HashSet<>();

        final List<Student> allStudentList = new ArrayList<>(studentsSet);
        int studentCount = 0;
        while (studentCount != expectedListSize) {
            final int randomIndex = random.nextInt(studentsSet.size());
            final Student randomStudent = allStudentList.get(randomIndex);
            if (!studentSet.contains(randomStudent)) {
                studentSet.add(randomStudent);
                studentCount++;
            }
        }
        return new ArrayList<>(studentSet);
    }

    public static TreeSet<Student> getStudentsSet() {
        return studentsSet;
    }

    public static TreeSet<Student> filterStudents(Locale locale) {
        Predicate<Student> isStudentOfGivenLocale = student -> student.getNationality().getLocale().equals(locale);
        return studentsSet.stream()
                .filter(isStudentOfGivenLocale)
                .sorted()
                .collect(Collectors.toCollection(TreeSet::new));
    }


}

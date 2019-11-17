package model.holder;

import lombok.Getter;
import model.Student;

import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Getter
public class StudentsHolder {

    private static final Random random = new Random();
    private static TreeSet<Student> studentsSet = new TreeSet<>();

    public static void addStudent(Student student) {
        studentsSet.add(student);
    }

    public static Student getStudentWithRandomIndex() {
        final int randomIndex = random.nextInt(studentsSet.size());
        Iterator<Student> studentIterator = studentsSet.iterator();
        Student current = null;
        int counter = 0;
        while (studentIterator.hasNext()) {
            current = studentIterator.next();
            if (counter == randomIndex) {
                return current;
            }
            counter++;
        }
        return null;
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

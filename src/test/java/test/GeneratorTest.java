package test;

import common.Constants;
import model.*;
import model.holder.DepartmentsHolder;
import model.holder.StudentsHolder;
import model.holder.TeachersHolder;
import org.junit.Test;

import java.util.*;

public class GeneratorTest {
    private static final Random random = new Random();

    @Test
    public void test() {
//        generateStudents();
//        filterStudents();
        generateTeachers();
        filterTeachers();
//        generateDepartments();
//        generateStudentGroups();
//        generateSubjects();
    }


    @Test
    public void generateStudents() {
        for (int i = 1; i <= Constants.STUDENTS; i++) {
            Student student = new Student();
            System.out.println(i + " " + student);
        }
       /* final TreeSet<Student> studentsSet = StudentsHolder.getStudentsSet();
        studentsSet.forEach(System.out::println);*/
    }

    @Test
    public void filterStudents() {
        final TreeSet<Student> cn = StudentsHolder.filterStudents(new Locale("cn"));
        System.out.println("Filtered by 'cn' locale: ");
        cn.forEach(System.out::println);
    }

    @Test
    public void generateTeachers() {
        for (int i = 1; i <= Constants.TEACHERS; i++) {
            Teacher teacher = new Teacher();
            System.out.println(i + " " + teacher);
        }
    }

    @Test
    public void filterTeachers() {
        final TreeSet<Teacher> by = TeachersHolder.filterTeachers(new Locale("lt"));
        System.out.println("Filtered by 'lt' locale: ");
        by.forEach(System.out::println);
    }

    @Test
    public void generateDepartments() {
        for (int i = 1; i <= Constants.DEPARTMENTS; i++) {
            String departmentName = "Department " + i;
            int count = 0;
            List<Teacher> employees = new ArrayList<>();
            while (count < Constants.TEACHERS_IN_DEPARTMENT) {
                final Teacher teacherWithRandomIndex = TeachersHolder.getTeacherWithRandomIndex();
                employees.add(teacherWithRandomIndex);
                count++;
            }
            Department department = new Department(departmentName, employees);
            System.out.println(departmentName + " " + department);
        }
    }

    @Test
    public void generateStudentGroups() {
        for (int i = 1; i <= Constants.STUDENT_GROUPS; i++) {
            String groupName = "Group " + i;

            final List<Student> students = generateRandomStudents(Constants.STUDENT_MIN, Constants.STUDENT_MAX);
            StudentGroup group = new StudentGroup(groupName, students);
            System.out.println(groupName + " " + group);

        }
    }

    @Test
    public void generateSubjects() {
        for (int i = 1; i <= Constants.SUBJECTS; i++) {
            String subjectName = "Subject " + i;
            Department supervisingDepartment = DepartmentsHolder.getDepartmentWithRandomIndex();
            Teacher lecturer = TeachersHolder.getTeacherWithRandomIndex();
            final List<Student> attendingStudents = generateRandomStudents(Constants.STUDENTS_ATTENDING_SUBJECT_MIN,
                    Constants.STUDENTS_ATTENDING_SUBJECT_MAX);
            final Subject subject = new Subject(subjectName, supervisingDepartment, lecturer, attendingStudents);
            System.out.println(subjectName + " " + subject);

        }
    }

    private List<Student> generateRandomStudents(int min, int max) {
        final int studentsNumber = randomStudentsNumberInGroup(min, max);
        List<Student> groupStudents = new ArrayList<>();
        for (int i = 0; i < studentsNumber; i++) {
            final Student studentByRandomIndex = StudentsHolder.getStudentWithRandomIndex();
            groupStudents.add(studentByRandomIndex);
        }
        return groupStudents;
    }

    private static int randomStudentsNumberInGroup(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}

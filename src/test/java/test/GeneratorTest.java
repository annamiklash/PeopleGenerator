package test;

import common.Constants;
import model.*;
import model.holder.DepartmentsHolder;
import model.holder.StudentsHolder;
import model.holder.TeachersHolder;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TreeSet;

public class GeneratorTest {
    private static final Random random = new Random();

    @Test
    public void test() {
        generateStudents();
        filterStudents();
        generateTeachers();
        filterTeachers();
        generateDepartments();
        generateStudentGroups();
        generateSubjects();
    }

    private void generateStudents() {
        System.out.println("Generating 100 students \n");
        for (int i = 1; i <= Constants.STUDENTS; i++) {
            Student student = new Student();
            System.out.println(i + " " + student);
        }
       /* final TreeSet<Student> studentsSet = StudentsHolder.getStudentsSet();
        studentsSet.forEach(System.out::println);*/
    }


    private void filterStudents() {
        final TreeSet<Student> cn = StudentsHolder.filterStudents(new Locale("cn"));
        System.out.println("\n Filtered by 'cn' locale: \n ");
        cn.forEach(System.out::println);
    }


    private void generateTeachers() {
        System.out.println("\n Generating 10 teachers \n");
        for (int i = 1; i <= Constants.TEACHERS; i++) {
            Teacher teacher = new Teacher();
            System.out.println(i + " " + teacher);
        }
    }

    private void filterTeachers() {
        final TreeSet<Teacher> by = TeachersHolder.filterTeachers(new Locale("lt"));
        System.out.println("\n Filtered by 'lt' locale: ");
        by.forEach(System.out::println);
    }


    private void generateDepartments() {
        System.out.println(" \n Generating departments \n");
        for (int i = 1; i <= Constants.DEPARTMENTS; i++) {
            String departmentName = "Department " + i;

            List<Teacher> employees = TeachersHolder.getRandomTeachersList(Constants.TEACHERS_IN_DEPARTMENT);
            Department department = new Department(departmentName, employees);
            System.out.println(departmentName + " " + department);
        }
    }


    private void generateStudentGroups() {
        System.out.println("\n Generating student groups \n");
        for (int i = 1; i <= Constants.STUDENT_GROUPS; i++) {
            String groupName = "Group " + i;

            final List<Student> students = generateRandomStudents(Constants.STUDENT_MIN, Constants.STUDENT_MAX);

            Assert.assertTrue(Constants.STUDENT_MIN <= students.size() && students.size() <= Constants.STUDENT_MAX);

            StudentGroup group = new StudentGroup(groupName, students);
            System.out.println(groupName + " " + group);

        }
    }


    private void generateSubjects() {
        System.out.println("\n Generating subjects \n");
        for (int i = 1; i <= Constants.SUBJECTS; i++) {
            String subjectName = "Subject " + i;
            final Department supervisingDepartment = DepartmentsHolder.getDepartmentWithRandomIndex();
            final List<Teacher> randomTeachersList = TeachersHolder.getRandomTeachersList(1);
            final Teacher lecturer = randomTeachersList.get(0);
            final List<Student> attendingStudents = generateRandomStudents(Constants.STUDENTS_ATTENDING_SUBJECT_MIN,
                    Constants.STUDENTS_ATTENDING_SUBJECT_MAX);

            Assert.assertTrue(Constants.STUDENTS_ATTENDING_SUBJECT_MIN <= attendingStudents.size() && attendingStudents.size() <= Constants.STUDENTS_ATTENDING_SUBJECT_MAX);
            final Subject subject = new Subject(subjectName, supervisingDepartment, lecturer, attendingStudents);
            System.out.println(subjectName + " " + subject);

        }
    }


    private List<Student> generateRandomStudents(int min, int max) {
        final int studentsNumber = randomStudentsNumberFromRange(min, max);
        return StudentsHolder.getRandomStudentsList(studentsNumber);
    }

    private static int randomStudentsNumberFromRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}

package model.holder;

import lombok.Getter;
import model.StudentGroup;

import java.util.HashSet;
import java.util.Set;


@Getter
public class StudentGroupHolder {
    private static Set<StudentGroup> studentGroupSet = new HashSet<>();

    public static void addStudentGroup(StudentGroup studentGroup) {
        studentGroupSet.add(studentGroup);

    }
}










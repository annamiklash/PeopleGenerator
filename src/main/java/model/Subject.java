package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import model.holder.SubjectsHolder;

import java.util.List;
@Getter
@EqualsAndHashCode
@ToString
public class Subject {

    private final String subjectName;
    private final Department supervisingDepartment;
    private final Teacher lecturer;
    private final List<Student> attendingStudentsList;

    public Subject(String subjectName, Department supervisingDepartment, Teacher lecturer, List<Student> students) {
        this.subjectName = subjectName;
        this.supervisingDepartment = supervisingDepartment;
        this.lecturer = lecturer;
        this.attendingStudentsList = students;
        SubjectsHolder.addSubject(this);
    }


}


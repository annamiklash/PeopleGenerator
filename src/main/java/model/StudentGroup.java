package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import model.holder.StudentGroupHolder;

import java.util.List;

@Getter
@EqualsAndHashCode
@ToString(callSuper = true)
public class StudentGroup {

    private final String groupName;
    private final List<Student> studentGroup;

    public StudentGroup(String groupName, List<Student> studentGroup) {
        this.groupName = groupName;
        this.studentGroup = studentGroup;
        StudentGroupHolder.addStudentGroup(this);
    }



}

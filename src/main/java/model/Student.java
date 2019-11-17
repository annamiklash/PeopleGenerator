package model;

import generator.StudentNumberGenerator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import model.holder.StudentsHolder;

@Getter
@EqualsAndHashCode(callSuper = true)

public class Student extends Person {

    private final String studentBookNo;

    public Student() {
        super();
        studentBookNo = StudentNumberGenerator.generateStudentNo();
        StudentsHolder.addStudent(this);
    }

    @Override
    public String toString() {
         return super.toString() + "Student{" +
                "studentBookNo=" + studentBookNo +
                "} ";
    }
}

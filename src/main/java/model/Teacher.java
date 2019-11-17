package model;

import enums.AcademicDegreeEnum;
import generator.DateGenerator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import model.holder.TeachersHolder;

import java.time.LocalDate;

@Getter
@EqualsAndHashCode(callSuper = true)
public class Teacher extends Person {

    private final LocalDate hireDate;
    private final AcademicDegreeEnum academicDegree;

    public Teacher() {
        super();
        academicDegree = AcademicDegreeEnum.getRandom();
        hireDate = DateGenerator.getRandomHireDate();
        TeachersHolder.addTeacher(this);
    }

    @Override
    public String toString() {
        return super.toString() + "Teacher{" +
                "hireDate=" + hireDate +
                ", academicDegree=" + academicDegree +
                "}";
    }
}

package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.holder.DepartmentsHolder;

import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Department  {

    private final String departmentName;
    private final List<Teacher> departmentEmployees;

    public Department(String departmentName, List<Teacher> departmentEmployees) {
        this.departmentName = departmentName;
        this.departmentEmployees = departmentEmployees;
        DepartmentsHolder.addDepartment(this);
    }


}

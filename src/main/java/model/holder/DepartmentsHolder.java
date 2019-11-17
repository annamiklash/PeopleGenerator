package model.holder;

import lombok.Getter;
import model.Department;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

@Getter
public class DepartmentsHolder {

    private static final Random random = new Random();
    private static Set<Department> departmentsSet = new HashSet<>();

    public static void addDepartment(Department department) {
        departmentsSet.add(department);
    }

    public static Department getDepartmentWithRandomIndex() {
        final int randomIndex = random.nextInt(departmentsSet.size());
        Iterator<Department> departmentIterator = departmentsSet.iterator();
        Department current = null;
        int counter = 0;
        while (departmentIterator.hasNext() ){
            current = departmentIterator.next();
            if (counter == randomIndex){
                return current;
            }
            counter++;
        }
        return null;
    }


}

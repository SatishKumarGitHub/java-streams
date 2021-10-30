package util;

import model.Employee;

import java.util.Arrays;
import java.util.List;

public class EmployeeUtil {

    public static List<Employee> getEmployees(){
        Employee e1 = new Employee(1,"john", "Tester", 10234.67);
        Employee e2 = new Employee(2,"Smith", "Developer", 11034.67);
        Employee e3 = new Employee(3,"ABD", "Data analyst", 9934.67);
        Employee e4 = new Employee(4,"Thala", "SAP", 10115.67);
        Employee e5 = new Employee(5,"virat", "Facility", 67234.67);
        return Arrays.asList(e1,e2,e3,e4,e5);
    }
}

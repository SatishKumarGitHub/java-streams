package sort;

import model.Employee;
import util.EmployeeUtil;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingExample {

    public static void main(String[] args) {

        List<Employee> employees = EmployeeUtil.getEmployees();

        sortEmployee(employees);
        sortEmployeeTraditionalWay(employees);


    }

    private static void sortEmployee(List<Employee> employees) {

        System.out.println("----------------- sorting by employee name and salary ---------------");
        List<Employee> sortedList = employees.stream().sorted(Comparator.comparing(Employee::getName).thenComparingDouble(Employee::getSalary)).collect(Collectors.toList());
        // List<Employee> sortedList = employees.stream().sorted(Comparator.comparing(e -> e.getName().toLowerCase())).collect(Collectors.toList());
        sortedList.parallelStream().forEachOrdered(System.out::println);
    }

    private static void sortEmployeeTraditionalWay(List<Employee> employees) {
        System.out.println("---------------Traditional way ------------------------");
     //   Collections.sort(employees, (e1, e2) -> e1.getDepartment().compareTo(e2.getDepartment()));
        Collections.sort(employees, Comparator.comparing(Employee::getDepartment));


        employees.forEach(System.out::println);

    }


}

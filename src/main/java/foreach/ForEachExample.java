package foreach;

import model.Employee;
import util.EmployeeUtil;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ForEachExample {


    public static void main(String[] args) {
        List<Employee> employees = EmployeeUtil.getEmployees();
        convertLitToMap(employees);
        System.out.println("------------- Maintain Insertion order -----------------------");
        convertLitToMapMaintainOrder(employees);
        System.out.println("------------- CTC  -----------------------");
        double totalCTC = findTotalCTC(employees);
        double ctc = Double.parseDouble(new DecimalFormat(".##").format(totalCTC));
        System.out.println("Total CTC  = " + ctc);

        System.out.println("-----------------------------------------------------------");
        sortEmployeeByName(employees);
        findMinSalEmployee(employees);
        findMaxSalEmployee(employees);
        findAvgSalEmployee(employees);

    }


    private static void convertLitToMap(List<Employee> employees) {
        Map<Integer, String> map = employees.stream().collect(Collectors.toMap(Employee::getId, Employee::getName));
        map.forEach((k, v) -> System.out.println("k = " + k + " v = " + v));

    }

    private static void convertLitToMapMaintainOrder(List<Employee> employees) {
        Map<Integer, String> map = employees.stream().collect(Collectors.toMap(Employee::getId, Employee::getName,
                (old, newValue) -> newValue, LinkedHashMap::new));
        map.forEach((k, v) -> System.out.println("k = " + k + " v = " + v));

    }


    private static double findTotalCTC(List<Employee> employees) {
        return employees.stream().mapToDouble(Employee::getSalary).sum();
    }


    private static void sortEmployeeByName(List<Employee> employees) {
        employees.stream().sorted(Comparator.comparing(Employee::getName)).forEach(e -> System.out.println(e));
    }

    private static void findMinSalEmployee(List<Employee> employees) {
        double min = employees.stream().mapToDouble(Employee::getSalary).min().getAsDouble();
        System.out.println("min = " + min);
    }

    private static void findMaxSalEmployee(List<Employee> employees) {
        double min = employees.stream().mapToDouble(Employee::getSalary).min().getAsDouble();
        System.out.println("min = " + min);
    }

    private static void findAvgSalEmployee(List<Employee> employees) {

        double avg = employees.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
        System.out.println("avg = " + avg);

    }

}

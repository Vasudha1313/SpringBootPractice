package com.practice.employee.controller;

import java.util.*;
import java.util.stream.Collectors;

public class PracticeSolutions {

    public static void main(String[] args){

        List<EmployeePractice> employees = Arrays.asList(
                new EmployeePractice("Alice", 30, 70000, "HR"),
                new EmployeePractice("Bob", 40, 90000, "IT"),
                new EmployeePractice("Charlie", 35, 120000, "Finance"),
                new EmployeePractice("David", 45, 80000, "IT"),
                new EmployeePractice("Eve", 28, 75000, "HR"),
                new EmployeePractice("Frank", 50, 110000, "Finance")
        );

      //----------------  1. Find all employees in the IT department
        System.out.println("The employees in the IT department are : ");
        employees.stream().filter(emp->emp.getDepartment().equals("IT"))
                .forEach(System.out::println);

        //----------------2. Find employees earning more than $80,000

        System.out.println("The employees earning more than $80,000 are : ");
        List<EmployeePractice> empSalaryFilterList = employees.stream().filter(emp-> emp.getSalary()>80000)
                .collect(Collectors.toList());
        empSalaryFilterList.forEach(System.out::println);

       //----------------- 3. Get a list of employee names

        List<String> employeeNames = employees.stream().map(EmployeePractice::getName)
                .collect(Collectors.toList());
        System.out.println("The employee names are : "+ employeeNames);

       //----------------- 4. Find the highest-paid employee

        Optional<EmployeePractice> highestPaidEmp = employees.stream().max(
                Comparator.comparing(EmployeePractice::getSalary));
        System.out.println("Highest paid Employee is "+ highestPaidEmp.orElse(null));

        //----------------5. Find the youngest employee
        Optional<EmployeePractice> youngestEmp = employees.stream().min(
                Comparator.comparing(EmployeePractice::getAge));
        System.out.println("Youngest employee is :" + youngestEmp.orElse(null));

        //----------------6. Calculate the average salary of all employees

        double averageSalary =
        employees.stream().mapToDouble(EmployeePractice::getSalary).average().getAsDouble();
        System.out.println("Average salary of all employees is = " + averageSalary);

       //-----------------7. Group employees by department

        Map<String, List<EmployeePractice>> empInDepartmentMap = employees.stream()
                .collect(Collectors.groupingBy(EmployeePractice::getDepartment));
        System.out.println("Employees by department "+ empInDepartmentMap);
        //-----------------8. Count employees in each department
        //empInDepartmentMap =
        Map<String, Long>  empCountInDepartment = employees.stream()
                .collect(Collectors.groupingBy(EmployeePractice::getDepartment,Collectors.counting()));
        System.out.println("Employees in each departments are "+ empCountInDepartment);


        //----------------9. Find the highest salary in each department

        //................10. Partition employees into two groups: Above and below $80,000 salary

        //----------------11. Get the names of employees sorted by salary (ascending)

        //----------------12. Find the total salary expense for each department

        //----------------13. Find the second highest-paid employee

        //----------------14. Get a comma-separated list of all employee names

        //----------------15. Find employees whose names start with "A"

        //----------------16. Increase salary of all employees by 10%

        //----------------17. Find employees whose age is between 30 and 40

        //----------------18. Find employees in each department sorted by salary (descending)

        //----------------19. Find the employee with the longest name

        //----------------20. Paginate employees (e.g., return page 1, size 2)

    }
}

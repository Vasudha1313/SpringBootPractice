package com.practice.employee.controller;

public class EmployeePractice {

        String name;
        int age;
        double salary;
        String department;

        EmployeePractice(String name, int age, double salary, String department) {
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.department = department;
        }

        public String getName() { return name; }
        public int getAge() { return age; }
        public double getSalary() { return salary; }
        public String getDepartment() { return department; }

        @Override
        public String toString() {
            return name + " (" + department + ", " + salary + ")";
        }
    }


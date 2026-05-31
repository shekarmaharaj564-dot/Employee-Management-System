package com.EmployeeManagment.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeManagement {

    private List<Employee> employees = new ArrayList<>();

    // Add Employee
    public void addEmployee(Employee employee) 
            throws EmployeeException {
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    // Display Employees
    public void displayEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        employees.forEach(System.out::println);
    }

    // Find Employee using Optional
    public Employee findEmployee(int id)
            throws EmployeeException {

        Optional<Employee> employee =
                employees.stream()
                        .filter(emp ->
                                emp.getEmployeeId() == id)
                        .findFirst();

        return employee.orElseThrow(() ->
                new EmployeeException(
                        "Employee not found."));
    }

    // Search Employee
    public void searchEmployee(int id) {

        try {

            Employee employee =
                    findEmployee(id);

            System.out.println(employee);

        } catch (EmployeeException e) {

            System.out.println(e.getMessage());
        }
    }

    // Update Salary
    public void updateSalary(int id,
                             double salary)
            throws EmployeeException {

        Employee employee =
                findEmployee(id);

        employee.setSalary(salary);

        System.out.println(
                "Salary updated successfully.");
    }

    // Remove Employee
    public void removeEmployee(int id)
            throws EmployeeException {

        Employee employee =
                findEmployee(id);

        employees.remove(employee);

        System.out.println(
                "Employee removed successfully.");
    }

    // Filter by Department using Streams
    public void employeesByDepartment(
            String department) {

        List<Employee> result =
                employees.stream()
                        .filter(emp ->
                                emp.getDepartment()
                                        .equalsIgnoreCase(
                                                department))
                        .collect(Collectors.toList());

        if (result.isEmpty()) {

            System.out.println(
                    "No employees found.");

        } else {

            result.forEach(
                    System.out::println);
        }
    }
}
package com.EmployeeManagment.src;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static int getValidEmployeeId(Scanner sc) {

        while (true) {

            try {

                System.out.print("Employee ID : ");

                int id = sc.nextInt();

                if (id > 0) {
                    return id;
                }

                System.out.println(
                        "Please enter a valid positive Employee ID.");

            } catch (InputMismatchException e) {

                System.out.println(
                        "Please enter a valid integer Employee ID.");

                sc.nextLine();
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeManagement manager =
                new EmployeeManagement();

        int choice = 0;

        do {

            try {

                System.out.println(
                        "\n===== EMPLOYEE MANAGEMENT =====");

                System.out.println("1. Add Employee");
                System.out.println("2. Display Employees");
                System.out.println("3. Search Employee");
                System.out.println("4. Update Salary");
                System.out.println("5. Remove Employee");
                System.out.println("6. Employees By Department");
                System.out.println("7. Exit");

                System.out.print("Enter Choice : ");

                choice = sc.nextInt();

                switch (choice) {

                    case 1:

                        int id = getValidEmployeeId(sc);

                        sc.nextLine();

                        System.out.print("Name : ");
                        String name = sc.nextLine();

                        System.out.print("Department : ");
                        String dept = sc.nextLine();

                        System.out.print("Salary : ");
                        double salary = sc.nextDouble();

                        try {

                            manager.addEmployee(
                                    new Employee(
                                            id,
                                            name,
                                            dept,
                                            salary));

                        } catch (EmployeeException e) {

                            System.out.println(
                                    "Error : "
                                            + e.getMessage());
                        }

                        break;

                    case 2:

                        manager.displayEmployees();

                        break;

                    case 3:

                        int searchId =
                                getValidEmployeeId(sc);

                        manager.searchEmployee(
                                searchId);

                        break;

                    case 4:

                        try {

                            int updateId =
                                    getValidEmployeeId(sc);

                            System.out.print(
                                    "New Salary : ");

                            double newSalary =
                                    sc.nextDouble();

                            manager.updateSalary(
                                    updateId,
                                    newSalary);

                        } catch (EmployeeException e) {

                            System.out.println(
                                    "Error : "
                                            + e.getMessage());
                        }

                        break;

                    case 5:

                        try {

                            int removeId =
                                    getValidEmployeeId(sc);

                            manager.removeEmployee(
                                    removeId);

                        } catch (EmployeeException e) {

                            System.out.println(
                                    "Error : "
                                            + e.getMessage());
                        }

                        break;

                    case 6:

                        sc.nextLine();

                        System.out.print(
                                "Department : ");

                        String department =
                                sc.nextLine();

                        manager.employeesByDepartment(
                                department);

                        break;

                    case 7:

                        System.out.println(
                                "Thank You!");

                        break;

                    default:

                        System.out.println(
                                "Invalid Choice.");
                }

            } catch (InputMismatchException e) {

                System.out.println(
                        "Please enter a valid menu choice.");

                sc.nextLine();
            }

        } while (choice != 7);

        sc.close();
    }
}
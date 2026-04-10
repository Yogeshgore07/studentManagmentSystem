package com.mycompany.fileminiproject;

import java.util.*;

public class FileMiniProject {

    public static void main(String[] args) {

        Scanner obj = new Scanner(System.in);
        int choice;
        int temp;

        System.out.println("-----Welcome to Student Management System Using Java-----");

        while (true) {

            try {
                System.out.println("\n 1. See All Students");
                System.out.println("2. Add Student");
                System.out.println("3. Search Student");
                System.out.println("5. Update Student Name");
                System.out.println("6. Update Student Marks");
                System.out.println("7. Delete Student");
                System.out.println("8. See Sorted list as per Marks");
                System.out.println("9. See Topper Details");
                System.out.println("10. Total Student");
                System.out.println("11. Export data");
                System.out.println("12. Exit");

                System.out.print("Select Appropriate Option: ");

                if (!obj.hasNextInt()) {
                    System.out.println("Invalid input! Enter numbers only.");
                    obj.next();
                    continue;
                }

                choice = obj.nextInt();

                switch (choice) {

                    case 1:
                        StudentDAO.DisplayAllStudent();
                        break;

                    case 2:
                        StudentDAO.AddStudent();
                        break;

                    case 3:
                        StudentDAO.SearchStudent();
                        break;

                    case 5:
                        System.out.print("Enter current Roll: ");

                        if (!obj.hasNextInt()) {
                            System.out.println("Invalid roll!");
                            obj.next();
                            break;
                        }

                        temp = obj.nextInt();

                        if (temp <= 0) {
                            System.out.println("Roll must be positive!");
                            break;
                        }

                        StudentDAO.UpdateStudentName(temp);
                        break;

                    case 6:
                        System.out.print("Enter current Roll: ");

                        if (!obj.hasNextInt()) {
                            System.out.println("Invalid roll!");
                            obj.next();
                            break;
                        }

                        temp = obj.nextInt();

                        if (temp <= 0) {
                            System.out.println("Roll must be positive!");
                            break;
                        }

                        StudentDAO.UpdateStudentMarks(temp);
                        break;

                    case 7:
                        System.out.print("Enter Roll: ");

                        if (!obj.hasNextInt()) {
                            System.out.println("Invalid roll!");
                            obj.next();
                            break;
                        }

                        temp = obj.nextInt();

                        if (temp <= 0) {
                            System.out.println("Roll must be positive!");
                            break;
                        }

                        StudentDAO.DeleteStudent(temp);
                        break;

                    case 8:
                        StudentDAO.SortStudentByMarks();
                        break;

                    case 9:
                        StudentDAO.SeeTopper();
                        break;

                    case 10:
                        StudentDAO.StudentCount();
                        break;

                    case 11:
                        StudentDAO.ExportData();
                        break;

                    case 12:
                        System.out.print("Confirm Exit? (yes/no): ");
                        String exit = obj.next();

                        if (exit.equalsIgnoreCase("yes")) {
                            System.out.println("Thank You For Visiting...");
                            System.out.println("System Exited...");
                            System.exit(0);
                        }
                        break;

                    default:
                        System.out.println("Wrong Choice! Try again.");
                }

            } catch (Exception e) {
                System.out.println("Error occurred: " + e.getMessage());
                obj.nextLine(); 
            }
        }
    }
}

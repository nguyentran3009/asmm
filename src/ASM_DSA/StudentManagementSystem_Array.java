/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASM_DSA;

/**
 *
 * @author Admin
 */
import java.util.Scanner;

public class StudentManagementSystem_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentArray studentArray = new StudentArray(10);

        while (true) {
            System.out.println("      STUDENT MANAGEMENT        ");
            System.out.println("==============================");
            System.out.println("          MAIN MENU           ");
            System.out.println("==============================");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Sort Students with MergeSort");
            System.out.println("5. Sort Students with QuickSort");
            System.out.println("6. Search Student with Binary Search");
            System.out.println("7. Search Student with Linear Search");
            System.out.println("8. Display All Students");
            System.out.println("9. Display Student Ranking Table");
            System.out.println("10. Exit");
            System.out.print("Choose an option (1-10): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Add Student ---");
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    studentArray.addStudent(new Student(id, name, marks, age));
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    System.out.println("\n--- Edit Student ---");
                    System.out.print("Enter ID of student to edit: ");
                    int editId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new Name: ");
                    String editName = scanner.nextLine();
                    System.out.print("Enter new Marks: ");
                    double editMarks = scanner.nextDouble();
                    System.out.print("Enter new Age: ");
                    int editAge = scanner.nextInt();
                    studentArray.editStudent(editId, editName, editMarks, editAge);
                    System.out.println("Student edited successfully!");
                    break;
                case 3:
                    System.out.println("\n--- Delete Student ---");
                    System.out.print("Enter ID of student to delete: ");
                    int deleteId = scanner.nextInt();
                    studentArray.deleteStudent(deleteId);
                    System.out.println("Student deleted successfully!");
                    break;
                case 4:
                    System.out.println("\n--- Sort Students with MergeSort ---");
                    studentArray.sortStudentsWithMergeSort();
                    System.out.println("Students sorted successfully!");
                    break;
                case 5:
                    System.out.println("\n--- Sort Students with QuickSort ---");
                    studentArray.sortStudentsWithQuickSort();
                    System.out.println("Students sorted successfully!");
                    break;
                case 6:
                    System.out.println("\n--- Search Student with Binary Search ---");
                    System.out.print("Enter ID of student to search: ");
                    int searchId = scanner.nextInt();
                    Student studentBinary = studentArray.searchStudentWithBinarySearch(searchId);
                    if (studentBinary != null) {
                        System.out.println("Student Found: " + studentBinary);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 7:
                    System.out.println("\n--- Search Student with Linear Search ---");
                    System.out.print("Enter ID of student to search: ");
                    int linearSearchId = scanner.nextInt();
                    Student studentLinear = studentArray.searchStudentWithLinearSearch(linearSearchId);
                    if (studentLinear != null) {
                        System.out.println("Student Found: " + studentLinear);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 8:
                    System.out.println("\n--- Display All Students ---");
                    studentArray.displayStudents();
                    break;
                case 9:
                    displayRankingTable();
                    break;
                case 10:
                    System.out.println("\nExiting program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    private static void displayRankingTable() {
        System.out.println("\nStudent Ranking Table:");
        System.out.printf("%-12s%-15s%n", "Marks", "Rank");
        System.out.println("-------------------------------");
        System.out.printf("%-12s%-15s%n", "[0 – 5.0)", "Fail");
        System.out.printf("%-12s%-15s%n", "[5.0 – 6.5)", "Medium");
        System.out.printf("%-12s%-15s%n", "[6.5 – 7.5)", "Good");
        System.out.printf("%-12s%-15s%n", "[7.5 – 9.0)", "Very Good");
        System.out.printf("%-12s%-15s%n", "[9.0 – 10.0]", "Excellent");
    }
   public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        int n = arr.length;
        for (int i = 0; i < n; i++) { // Loop through array
            if (arr[i] == target) {
                return i; // Element found
            }
        }
        return -1; // Element not found
    }
    }
}

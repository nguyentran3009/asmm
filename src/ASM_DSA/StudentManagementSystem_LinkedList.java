/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASM_DSA;

/**
 *
 * @author Admin
 */
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

class DuplicateIDException extends Exception {
    public DuplicateIDException(String message) {
        super(message);
    }
}

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class InvalidIDException extends Exception {
    public InvalidIDException(String message) {
        super(message);
    }
}

class InvalidMenuOptionException extends Exception {
    public InvalidMenuOptionException(String message) {
        super(message);
    }
}

class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

class InvalidNameException extends Exception {
    public InvalidNameException(String message) {
        super(message);
    }
}

public class StudentManagementSystem_LinkedList {
    // ANSI escape code for colors
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentLinkedList studentList = new StudentLinkedList();
        boolean running = true;

        while (true) {
            try {
                System.out.println("      STUDENT MANAGEMENT        ");
                System.out.println("==============================");
                System.out.println("          MAIN MENU           ");
                System.out.println("==============================");
                System.out.println("1. Add Student");
                System.out.println("2. Edit Student");
                System.out.println("3. Delete Student");
                System.out.println("4. Sort Students (Bubble Sort)");
                System.out.println("5. Sort Students (Merge Sort)");
                System.out.println("6. Search Student (Linear Search)");
                System.out.println("7. Search Student (Binary Search)");
                System.out.println("8. Display All Students");
//                System.out.println("9. Compare Sorting and Searching");
                System.out.println("9. Exit");
                System.out.print("Choose an option (1-9): ");
                int choice = scanner.nextInt();
                
                if (choice < 1 || choice > 9) {
                    throw new InvalidMenuOptionException("Invalid menu option. Please choose between 1 and 9.");
                }

                switch (choice) {
                    case 1:
                        System.out.println("\n--- Add Student ---");
                        int id = 0;
                        while (true) {
                            try {
                                System.out.print("Enter ID: ");
                                id = scanner.nextInt();
                                if (id <= 0) throw new InvalidIDException("ID must be a positive number.");
                                // Check for existing student using both search methods
                                if (studentList.searchStudent1(id) != null || studentList.searchStudent2(id) != null) {
                                    throw new DuplicateIDException("ID already exists.");
                                }
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println(ANSI_RED + "Invalid input. Please enter a valid number." + ANSI_RESET);
                                scanner.nextLine(); // Clear the invalid input
                            } catch (InvalidIDException | DuplicateIDException e) {
                                System.out.println(ANSI_RED + "Error: " + e.getMessage() + ANSI_RESET);
                                scanner.nextLine(); // Clear the invalid input
                            }
                        }
                        
                        scanner.nextLine();  // Consume newline
                        String name;
                        while (true) {
                            try {
                                System.out.print("Enter Name: ");
                                name = scanner.nextLine().trim();
                                if (name.isEmpty()) throw new InvalidNameException("Name cannot be empty.");
                                if (!Pattern.matches("[a-zA-Z ]+", name)) throw new InvalidNameException("Name must contain only letters and spaces.");
                                break;
                            } catch (InvalidNameException e) {
                                System.out.println(ANSI_RED + "Error: " + e.getMessage() + ANSI_RESET);
                            }
                        }
                        
                        double marks = 0;
                        while (true) {
                            try {
                                System.out.print("Enter Marks (0-10): ");
                                marks = scanner.nextDouble();
                                if (marks < 0 || marks > 10) throw new InvalidMarksException("Marks must be between 0 and 10.");
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println(ANSI_RED + "Invalid input. Please enter a valid number." + ANSI_RESET);
                                scanner.nextLine(); // Clear the invalid input
                            } catch (InvalidMarksException e) {
                                System.out.println(ANSI_RED + "Error: " + e.getMessage() + ANSI_RESET);
                            }
                        }
                        
                        int age = 0;
                        while (true) {
                            try {
                                System.out.print("Enter Age: ");
                                age = scanner.nextInt();
                                if (age < 18) throw new InvalidAgeException("Age must be 18 or older.");
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println(ANSI_RED + "Invalid input. Please enter a valid number." + ANSI_RESET);
                                scanner.nextLine(); // Clear the invalid input
                            } catch (InvalidAgeException e) {
                                System.out.println(ANSI_RED + "Error: " + e.getMessage() + ANSI_RESET);
                            }
                        }

                        studentList.addStudent(new Student(id, name, marks, age));
                        System.out.println(ANSI_GREEN + "Student added successfully!" + ANSI_RESET);
                        break;
                    case 2:
                        System.out.println("\n--- Edit Student ---");
                        int editId = 0;
                        while (true) {
                            try {
                                System.out.print("Enter ID of student to edit: ");
                                editId = scanner.nextInt();
                                if (editId <= 0) throw new InvalidIDException("ID must be a positive number.");
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println(ANSI_RED + "Invalid input. Please enter a valid number." + ANSI_RESET);
                                scanner.nextLine(); // Clear the invalid input
                            } catch (InvalidIDException e) {
                                System.out.println(ANSI_RED + "Error: " + e.getMessage() + ANSI_RESET);
                            }
                        }
                        
                        scanner.nextLine();  // Consume newline
                        String editName;
                        while (true) {
                            try {
                                System.out.print("Enter new Name: ");
                                editName = scanner.nextLine().trim();
                                if (editName.isEmpty()) throw new InvalidNameException("Name cannot be empty.");
                                if (!Pattern.matches("[a-zA-Z ]+", editName)) throw new InvalidNameException("Name must contain only letters and spaces.");
                                break;
                            } catch (InvalidNameException e) {
                                System.out.println(ANSI_RED + "Error: " + e.getMessage() + ANSI_RESET);
                            }
                        }
                        
                        double editMarks = 0;
                        while (true) {
                            try {
                                System.out.print("Enter new Marks (0-10): ");
                                editMarks = scanner.nextDouble();
                                if (editMarks < 0 || editMarks > 10) throw new InvalidMarksException("Marks must be between 0 and 10.");
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println(ANSI_RED + "Invalid input. Please enter a valid number." + ANSI_RESET);
                                scanner.nextLine(); // Clear the invalid input
                            } catch (InvalidMarksException e) {
                                System.out.println(ANSI_RED + "Error: " + e.getMessage() + ANSI_RESET);
                            }
                        }
                        
                        int editAge = 0;
                        while (true) {
                            try {
                                System.out.print("Enter new Age: ");
                                editAge = scanner.nextInt();
                                if (editAge < 18) throw new InvalidAgeException("Age must be 18 or older.");
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println(ANSI_RED + "Invalid input. Please enter a valid number." + ANSI_RESET);
                                scanner.nextLine(); // Clear the invalid input
                            } catch (InvalidAgeException e) {
                                System.out.println(ANSI_RED + "Error: " + e.getMessage() + ANSI_RESET);
                            }
                        }

                        studentList.editStudent(editId, editName, editMarks, editAge);
                        System.out.println(ANSI_GREEN + "Student edited successfully!" + ANSI_RESET);
                        break;
                    case 3:
                        System.out.println("\n--- Delete Student ---");
                        int deleteId = 0;
                        while (true) {
                            try {
                                System.out.print("Enter ID of student to delete: ");
                                deleteId = scanner.nextInt();
                                if (deleteId <= 0) throw new InvalidIDException("ID must be a positive number.");
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println(ANSI_RED + "Invalid input. Please enter a valid number." + ANSI_RESET);
                                scanner.nextLine(); // Clear the invalid input
                            } catch (InvalidIDException e) {
                                System.out.println(ANSI_RED + "Error: " + e.getMessage() + ANSI_RESET);
                            }
                        }
                        
                        studentList.deleteStudent(deleteId);
                        System.out.println(ANSI_GREEN + "Student deleted successfully!" + ANSI_RESET);
                        break;
                   case 4:
                        System.out.println("\n--- Sort Students (Bubble Sort) ---");
                        long startTimeBubble = System.nanoTime();
                        studentList.sortStudents1();
                        long endTimeBubble = System.nanoTime();
                        long bubbleSortTimeMillis = (endTimeBubble - startTimeBubble) / 1_000_000;
                        studentList.displayStudents();
                        System.out.println("Bubble Sort Time: " + bubbleSortTimeMillis + " milliseconds");
                        break;
                    case 5:
                        System.out.println("\n--- Sort Students (Merge Sort) ---");
                        long startTimeMerge = System.nanoTime();
                        studentList.sortStudents2();
                        long endTimeMerge = System.nanoTime();
                        long mergeSortTimeMillis = (endTimeMerge - startTimeMerge) / 1_000_000;
                        studentList.displayStudents();
                        System.out.println("Merge Sort Time: " + mergeSortTimeMillis + " milliseconds");
                        break;
                    case 6:
                        System.out.println("\n--- Search Student (Linear Search) ---");
                        int searchIdLinear = 0;
                        while (true) {
                            try {
                                System.out.print("Enter ID of student to search: ");
                                searchIdLinear = scanner.nextInt();
                                if (searchIdLinear <= 0) throw new InvalidIDException("ID must be a positive number.");
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid number.");
                                scanner.nextLine(); // Clear the invalid input
                            } catch (InvalidIDException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        }
                        
                        long startTimeLinear = System.nanoTime();
                        Student studentLinear = studentList.searchStudent1(searchIdLinear);
                        long endTimeLinear = System.nanoTime();
                        long linearSearchTimeMillis = (endTimeLinear - startTimeLinear) / 1_000_000;
                        
                        if (studentLinear != null) {
                            System.out.println("Student Found: " + studentLinear);
                        } else {
                            System.out.println("Student not found.");
                        }
                        System.out.println("Linear Search Time: " + linearSearchTimeMillis + " milliseconds");
                        break;
                    case 7:
                        System.out.println("\n--- Search Student (Binary Search) ---");
                        int searchIdBinary = 0;
                        while (true) {
                            try {
                                System.out.print("Enter ID of student to search: ");
                                searchIdBinary = scanner.nextInt();
                                if (searchIdBinary <= 0) throw new InvalidIDException("ID must be a positive number.");
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid number.");
                                scanner.nextLine(); // Clear the invalid input
                            } catch (InvalidIDException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        }
                        
                        studentList.sortStudents2(); // Ensure list is sorted for Binary Search
                        long startTimeBinary = System.nanoTime();
                        Student studentBinary = studentList.searchStudent2(searchIdBinary);
                        long endTimeBinary = System.nanoTime();
                        long binarySearchTimeMillis = (endTimeBinary - startTimeBinary) / 1_000_000;
                        
                        if (studentBinary != null) {
                            System.out.println("Student Found: " + studentBinary);
                        } else {
                            System.out.println("Student not found.");
                        }
                        System.out.println("Binary Search Time: " + binarySearchTimeMillis + " milliseconds");
                        break;
                    case 8:
                        System.out.println("\n--- Display All Students ---");
                        studentList.displayStudents();
                        break;
                    case 9:
                        System.out.println("\n--- Compare Sorting and Searching ---");
                        
                        // Add more students
                        for (int i = 0; i < 10000; i++) {
                            studentList.addStudent(new Student(i, "Student" + i, i % 11, 18 + i % 10));
                        }
                        
                        // Bubble Sort Time
                        long startTimeBubbleCompare = System.nanoTime();
                        studentList.sortStudents1();
                        long endTimeBubbleCompare = System.nanoTime();
                        long bubbleSortTimeCompareMillis = (endTimeBubbleCompare - startTimeBubbleCompare) / 1_000_000;
                        
                        // Merge Sort Time
                        long startTimeMergeCompare = System.nanoTime();
                        studentList.sortStudents2();
                        long endTimeMergeCompare = System.nanoTime();
                        long mergeSortTimeCompareMillis = (endTimeMergeCompare - startTimeMergeCompare) / 1_000_000;
                        
                        // Linear Search Time
                        int searchIdForLinear = 500;
                        long startTimeLinearCompare = System.nanoTime();
                        studentList.searchStudent1(searchIdForLinear);
                        long endTimeLinearCompare = System.nanoTime();
                        long linearSearchTimeCompareMillis = (endTimeLinearCompare - startTimeLinearCompare) / 1_000_000;
                        
                        // Binary Search Time
                        int searchIdForBinary = 500;
                        studentList.sortStudents2(); // Ensure list is sorted for Binary Search
                        long startTimeBinaryCompare = System.nanoTime();
                        studentList.searchStudent2(searchIdForBinary);
                        long endTimeBinaryCompare = System.nanoTime();
                        long binarySearchTimeCompareMillis = (endTimeBinaryCompare - startTimeBinaryCompare) / 1_000_000;
                        
                        System.out.println("Bubble Sort Time for 10000 elements: " + bubbleSortTimeCompareMillis + " milliseconds");
                        System.out.println("Merge Sort Time for 10000 elements: " + mergeSortTimeCompareMillis + " milliseconds");
                        System.out.println("Linear Search Time for 10000 elements: " + linearSearchTimeCompareMillis + " milliseconds");
                        System.out.println("Binary Search Time for 10000 elements: " + binarySearchTimeCompareMillis + " milliseconds");
                        break;
                    case 10:
                        System.out.println("\nExiting program. Goodbye!");
                        running = false;
                        scanner.close();
                        break;
                    default:
                        System.out.println(ANSI_RED + "\nInvalid choice. Please try again." + ANSI_RESET);
                }
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "\nInvalid input. Please enter a valid number." + ANSI_RESET);
                scanner.nextLine(); // Clear the invalid input
            } catch (InvalidMenuOptionException e) {
                System.out.println(ANSI_RED + "\nError: " + e.getMessage() + ANSI_RESET);
                scanner.nextLine(); // Clear the invalid input
            } catch (Exception e) {
                System.out.println(ANSI_RED + "\nAn unexpected error occurred: " + e.getMessage() + ANSI_RESET);
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }
}


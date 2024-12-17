/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASM_DSA;

/**
 *
 * @author Admin
 */
import java.util.Arrays;
import java.util.Comparator;

import java.util.Arrays;

public class StudentArray {
    private Student[] students;
    private int size;

    public StudentArray(int capacity) {
        students = new Student[capacity];
        size = 0;
    }

    public void addStudent(Student student) {
        if (size == students.length) {
            students = Arrays.copyOf(students, size * 2);
        }
        students[size++] = student;
    }

    public void editStudent(int id, String name, double marks, int age) {
        for (int i = 0; i < size; i++) {
            if (students[i].getId() == id) {
                students[i].setName(name);
                students[i].setMarks(marks);
                students[i].setAge(age);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void deleteStudent(int id) {
        for (int i = 0; i < size; i++) {
            if (students[i].getId() == id) {
                students[i] = students[size - 1];
                students[size - 1] = null;
                size--;
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void sortStudentsWithMergeSort() {
        mergeSort(students, 0, size - 1);
    }
    private void mergeSort(Student[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }
    private void merge(Student[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        Student[] leftArray = new Student[n1];
        Student[] rightArray = new Student[n2];
        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, middle + 1, rightArray, 0, n2);
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].getMarks() <= rightArray[j].getMarks()) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < n1) {
            array[k++] = leftArray[i++];
        }
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }

    // QuickSort algorithm
    public void sortStudentsWithQuickSort() {
        quickSort(students, 0, size - 1);
    }
    private void quickSort(Student[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }
    private int partition(Student[] array, int low, int high) {
        Student pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j].getMarks() <= pivot.getMarks()) {
                i++;

                Student temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        Student temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    // Binary Search algorithm
    public Student searchStudentWithBinarySearch(int id) {
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (students[mid].getId() == id) {
                return students[mid];
            }

            if (students[mid].getId() < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    // Linear Search algorithm
    public Student searchStudentWithLinearSearch(int id) {
        for (int i = 0; i < size; i++) {
            if (students[i].getId() == id) {
                return students[i];
            }
        }
        return null;
    }

    public void displayStudents() {
        if (size == 0) {
            System.out.println("No students to display.");
            return;
        }
        System.out.printf("%-12s%-25s%-10s%-8s%-15s%n", "ID", "Full Name", "Marks", "Age", "Rank");
        System.out.println("--------------------------------------------------------------------");

        for (int i = 0; i < size; i++) {
            System.out.printf("%-12d%-25s%-10.2f%-8d%-15s%n",
                    students[i].getId(), students[i].getName(), students[i].getMarks(), students[i].getAge(), students[i].getRank());
        }

        System.out.println("--------------------------------------------------------------------");
    }
    
}


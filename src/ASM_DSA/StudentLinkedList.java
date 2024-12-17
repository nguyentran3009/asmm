/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASM_DSA;

/**
 *
 * @author Admin
 */
public class StudentLinkedList {
    private Node head;

    public StudentLinkedList() {
        this.head = null;
    }

    public void addStudent(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void editStudent(int id, String name, double marks, int age) {
    Node current = head;
    while (current != null) {
        if (current.student.getId() == id) {
            current.student.setName(name);
            current.student.setMarks(marks);
            current.student.setAge(age);
            return;
        }
        current = current.next;
    }
}


    public void deleteStudent(int id) {
        if (head == null) return;

        if (head.student.getId() == id) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.student.getId() == id) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
    
    // thuật toán sắp xếp nổi bọt (Bubble Sort)
    public void sortStudents1() {
        if (head == null || head.next == null) return;

        Node current;
        Node index;
        Student temp;

        for (current = head; current.next != null; current = current.next) {
            for (index = current.next; index != null; index = index.next) {
                if (current.student.getMarks() > index.student.getMarks()) {
                    temp = current.student;
                    current.student = index.student;
                    index.student = temp;
                }
            }
        }
    }
    
    // thuật toán sắp xếp Merge Sort 
    public void sortStudents2() {
        if (head == null || head.next == null) return;
        head = mergeSort(head);
    }

    private Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        return sortedMerge(left, right);
    }

    private Node getMiddle(Node head) {
        if (head == null) return head;

        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node sortedMerge(Node left, Node right) {
        Node result = null;

        if (left == null) return right;
        if (right == null) return left;

        if (left.student.getMarks() <= right.student.getMarks()) {
            result = left;
            result.next = sortedMerge(left.next, right);
        } else {
            result = right;
            result.next = sortedMerge(left, right.next);
        }
        return result;
    }

    
    // thuật toán tìm kiếm tuyến tính (Linear Search)
    public Student searchStudent1(int id) {
        Node current = head;
        while (current != null) {
            if (current.student.getId() == id) {
                return current.student;
            }
            current = current.next;
        }
        return null;
    }
    
    // thuật toán Tìm kiếm nhị phân (Binary Search)
    public Student searchStudent2(int id) {
        // Ensure the list is sorted before performing binary search
        head = mergeSort(head);

        int length = getLength();
        return binarySearch(head, 0, length - 1, id);
    }

    private int getLength() {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    private Student binarySearch(Node head, int left, int right, int id) {
        if (right >= left) {
            int mid = left + (right - left) / 2;
            Node midNode = getNodeAt(head, mid);

            if (midNode.student.getId() == id) {
                return midNode.student;
            }

            if (midNode.student.getId() > id) {
                return binarySearch(head, left, mid - 1, id);
            } else {
                return binarySearch(head, mid + 1, right, id);
            }
        }
        return null;
    }

    private Node getNodeAt(Node head, int index) {
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current;
            }
            count++;
            current = current.next;
        }
        return null;
    }
    


    public void displayStudents() {
    if (head == null) {
        System.out.println("No students to display.");
        return;
    }
    Node current = head;
    System.out.println("Student List:");
     System.out.printf("%-8s%-25s%-10s%-8s%-15s%n", "ID", "Full Name", "Marks", "Age", "Rank");
    System.out.println("---------------------------------------------------------");
    while (current != null) {
        System.out.println(current.student);
        current = current.next;
    }
    System.out.println("---------------------------------------------------------");
    }
    
    

}

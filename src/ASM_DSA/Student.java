/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASM_DSA;

/**
 *
 * @author Admin
 */
public class Student {
    private int id;
    private String name;
    private double marks; 
    private int age;
    
    public Student(int id, String name, double marks, int age) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.age = age;
    }
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getMarks() { return marks; }
    public void setMarks(double marks) { this.marks = marks; }
    public int getAge(){return age;}
    public void setAge(int age) {this.age = age;}

    public String getRank() {
        if (marks < 5.0) return "Fail";
        if (marks < 6.5) return "Medium";
        if (marks < 7.5) return "Good";
        if (marks < 9.0) return "Very Good";
        return "Excellent";
    }

    @Override
    public String toString() {
        return String.format("%-8d%-25s%-10.2f%-8d%-15s", id, name, marks,age, getRank());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit4;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author 1dingrai
 */
public class Student 
{

    /**
     * @param args the command line arguments
     */
    
    // CLASS CONSTANTS - must be final static   
    final static String SCHOOL = "Garth Webb";
    
    // CLASS VARIABLES
    private int nextId;
    
    // OBJECT VARIABLES - should be private  
    private int id; //Primary key
    private String firstName;
    private String lastName;
    private Date dob;
    private int grade;
    private int studentNumber;
    
    // Constructors are called only once when you call a new object
    // They are empty containers that can be filled
    public Student( int studentNumber )
    {
        this.studentNumber = studentNumber;
        
    }

    public Student(String firstName, String lastName, Date dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    //Encapsulate - Force program to use setters and getters
    @Override
    public boolean equals(Object obj) {
        //Checks that object is equal to itself
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        //Cast the object into student so they can be compared
        final Student other = (Student) obj;
        if (this.id != other.id) {
            return false;
        }
        if (studentNumber < 0 && !Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.dob, other.dob)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", studentNumber=" + studentNumber + '}';
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    private int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }
    
    public static void main(String[] args) {
        Student a = new Student(1);
        Student b = new Student(1);
        Student c = new Student(2);
        Student d = a;
        Student e;
        
        //False, different objects
        System.out.println( a == b );
        //True, same object
        System.out.println( a == d);
        //True because they have the same id, therefore same person
        System.out.println( a.equals(b) );
        //False, different id
        System.out.println( a.equals(c) );
        
//        Date d = new Date();
//        Student a = new Student("First", "Last", d);
//        Student b = new Student("First", "Last", d);
        
        System.out.println( a == b);
        System.out.println( a.equals(b) );
    }
    
}

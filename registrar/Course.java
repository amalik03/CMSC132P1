/* Name: Areeb Malik
 * Directory ID: Areeb03
 * UID: 117859317
 * Section: 0105
 * I pledge on my honor that I have not given or received any unauthorized assistance on this assignment.
 */
package registrar;

import java.util.ArrayList;

public class Course {
    String department;
    int number;
    int numSeats;
    ArrayList<Student> enrolledStudents;

    public Course(String department, int number, int numSeats) {
        this.department = department;
        this.number = number;
        this.numSeats = numSeats;

        enrolledStudents = new ArrayList<Student>();
    }

    public boolean addStudent(Student s) {
        boolean foundStudent = false;
        Student x = new Student(s.firstName, s.lastName);
        
        if (!enrolledStudents.isEmpty()) {
            for (Student student : enrolledStudents) {
                if (student.firstName.equals(s.firstName) && student.lastName.equals(s.lastName)) {
                    foundStudent = true;
                    x = student;
                }
            }

            if (!foundStudent) {
                s.courses.add(this);
                this.enrolledStudents.add(s);
                return true;
            } else {
                if (!x.isEnrolled(department, number) && x.courses.size() < 5) {
                    x.courses.add(this);
                    this.enrolledStudents.add(x);
                    return true;
                }
            }
        } 
        else {
            s.courses.add(this);
           this.enrolledStudents.add(s);
            return true;
        }

        return false;
    }
}

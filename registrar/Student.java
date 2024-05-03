/* Name: Areeb Malik
 * Directory ID: Areeb03
 * UID: 117859317
 * Section: 0105
 * I pledge on my honor that I have not given or received any unauthorized assistance on this assignment.
 */
package registrar;

import java.util.ArrayList;

public class Student {
    String firstName;
    String lastName;
    ArrayList<Course> courses = new ArrayList<Course>();

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean isEnrolled(String department, int number) {
        if (!courses.isEmpty()) {
            for (Course c : courses) {
                if (c.department.equals(department) && c.number == number) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean addCourse(String department, int number, int numSeats) {
    	Student s = new Student(firstName, lastName);
        // if (!this.isEnrolled(department, number)) { <-- still works but created a student object to make it more readable
    	//												   and to understand it better 
    	if(s.isEnrolled(department, number)){
            if (courses.size() < 5) {
                courses.add(new Course(department, number, numSeats));
                return true;
            }
        }

        return false;
    }
}
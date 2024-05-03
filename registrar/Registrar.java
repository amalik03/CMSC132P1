/* Name: Areeb Malik
 * Directory ID: Areeb03
 * UID: 117859317
 * Section: 0105
 *I pledge on my honor that I have not given or received any unauthorized assistance on this assignment.
 */
package registrar;

import java.util.ArrayList;

public class Registrar {
    String department;
    int number;
    int numSeats;
    ArrayList<Course> courses = new ArrayList<Course>();
    ArrayList<Student> students = new ArrayList<Student>();

    // this method will allow a student to add a course to the list of courses
    // they're taking this semester. they will only be allowed to add it
    // if the course is not full or the course number exists
    public Registrar addNewCourse(String department, int number, int numSeats) {
        if (this.department != null && this.department.equals(department)
                && this.number == number) {
            return null;
        }
        
        if (number <= 0 || numSeats <= 0) {
            return null;
        }

        // we are setting the global variables to the method variables
        // then adding them into the list of courses a student is taking
        this.department = department;
        this.number = number;
        this.numSeats = numSeats;
        Course courseToAdd = new Course(department, number, numSeats);
        courses.add(courseToAdd);

        return this;
    }

    // this method will allow a student to cancel their registration to a course
    // in this method we will check to see if the have courses in their list
    // if not that means they are not taking any courses thus cannot cancel
    // registration to a course
    public boolean cancelCourse(String department, int number) {
        int i = 0;
        boolean result = false;

        if (!courses.isEmpty()) {
        	for (i = 0; i < courses.size(); i++) {
                Course c = courses.get(i);
                if (c.department.equals(department) && c.number == number) {
                    courses.remove(i);
                    return true;
                }
        	}
        }
        return result;
    }
    // Returns the number of courses a student is taking
    public int numCourses() {
        return courses.size();
    }

    // this method will allow a student to be added to a course under certain
    // conditions. We first check to see if the department and course number
    // is not null or 0 respectively. or if the students first and last name
    // is not null or empty
    public boolean addToCourse(String department, int number, String firstName,
            String lastName) {
        // we will check to see if the student is already enrolled in the course
        // if not we will add them into the course
        Student x = new Student(firstName, lastName);
        boolean foundStudent = false;
        if (students.isEmpty()) {
            students.add(x);
        } else {
            for (Student s : students) {
                if (s.firstName.equals(firstName)
                        && s.lastName.equals(lastName)) {
                    x = s;
                    foundStudent = true;
                }
            }
            // if the student was not found in the list of students in a course
            // they will be added
            if (!foundStudent) {
                students.add(x);
            }
        }

        // this will return true if the student was added into the course
        if (!courses.isEmpty()) {
            for (Course c : courses) {
                if (c.department.equals(department) && c.number == number) {
                    if (c.enrolledStudents.size() < numSeats
                            && x.courses.size() < 5) {
                        return c.addStudent(x);
                    }
                }
            }
        }
        return false;
    }

    // this method will check to see how many students are in enrolled in a
    // course
    public int numStudentsInCourse(String department, int number) {
        if (department.isEmpty() || number <= 0) {
            throw new IllegalArgumentException();
        }
        // this will first check to see if the list of courses a student is in
        // if it is not empty then we will check the list and match
        // the department and course number and return the size of the course
        if (!courses.isEmpty()) {
            for (Course c : courses) {
                if (c.department.equals(department) && c.number == number) {
                    return c.enrolledStudents.size();
                }
            }
        }
        // there was no course in the registrar
        return -1;
    }

    // this method will return the number of students in the course that
    // share the same last name
    public int numStudentsInCourseWithLastName(String department, int number,
            String lastName) {
        // first the method will go through each course and compare students
        // last name. if they are equal, increase the counter
        int counter = 0;
        if (!courses.isEmpty()) {
            for (Course c : courses) {
                if (c.department.equals(department) && c.number == number) {
                    if (!c.enrolledStudents.isEmpty()) {
                        for (Student s : c.enrolledStudents) {
                            if (s.lastName.equals(lastName)) {
                                counter++;
                            }
                        }
                    }
                }
            }
        }
        return counter;
    }
    // this method will return true or false to check if a student is in the
    // given course
    public boolean isInCourse(String department, int number, String firstName,
            String lastName) {
        boolean result = false;

        // first we check to see if the course list is empty
        if (!courses.isEmpty()) {

            // we iterate to see if the students course list
            for (Course c : courses) {

                // we check each course to see if department and number match
                if (c.department.equals(department) && c.number == number) {

                    // check if the course has students enrolled in it
                    if (!c.enrolledStudents.isEmpty()) {

                        for (Student s : c.enrolledStudents) {

                            // if the firstName and LastName of the student
                            // match the paramter then return true
                            if (s.firstName.equals(firstName)
                                    && s.lastName.equals(lastName)) {
                                result = true;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    // this method will return the amount of courses a student is taking
    public int howManyCoursesTaking(String firstName, String lastName) {

        if (!students.isEmpty()) {
            for (Student s : students) {
                if (s.firstName.equals(firstName)
                        && s.lastName.equals(lastName)) {
                    return s.courses.size();
                }
            }
        }

        return 0;
    }
    // this method allows a student to drop a course. it will return true
    // if they dropped it and false if they were not in the course so they
    // could not drop it
    public boolean dropCourse(String department, int number, String firstName,
            String lastName) {
        Student stu = null;
        if (!students.isEmpty()) {
            for (Student s : students) {
                if (s.firstName.equals(firstName)
                        && s.lastName.equals(lastName)) {
                    stu = s;
                }
            }
        }

        if (!courses.isEmpty()) {
            int courseIndex = 0;
            int studentIndex = 0;
            for (Course c : courses) {
                if (c.department.equals(department) && c.number == number) {
                    if (!c.enrolledStudents.isEmpty()) {
                        for (Student s : c.enrolledStudents) {
                            if (s.firstName.equals(firstName)
                                    && s.lastName.equals(lastName)) {
                                c.enrolledStudents.remove(studentIndex);
                                stu.courses.remove(courseIndex);
                                return true;
                            }
                            studentIndex++;
                        }
                    }
                }
                courseIndex++;
            }
        }
        return false;
    }
    // this method will allow a student to cancels it registration
    // allowing them to be removed from every class they're taking
    public boolean cancelRegistration(String firstName, String lastName) {
        boolean result = false;
        for (Student s : students) {
            if (!students.isEmpty()) {
                if (s.firstName.equals(firstName)
                        && s.lastName.equals(lastName)) {
                    for (Course c : courses) {
                        c.enrolledStudents.remove(s);
                    }
                    result = true;
                }
            }
        }
        return result;
    }

}
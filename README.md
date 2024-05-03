This Coding project was Project #1 for CMSC132.
It was a simulation of creating a registrar system similar to UMD's where you can sign up for classes and drop classes. 
Below will address what the folllow methods do!

# Student Class
in the student class has 3 methods found below

### `public Student(String firstName, String lastName)`
This a constructor function that allows us to create a **Student** Object.
For instance I can do this Student lol = New Student ("Areeb", "Malik");
and this is initalized with a first name `"Areeb"` and a last name `"Malik"`.
If you don't understand, thats okay!

### `public boolean isEnrolled(String department, int number)`
Given a department and course number, it will check if the student is enrolled in a course
by going through the list of courses the student takes. It returns `true` if that students takes the course
or `false` if the student is not in that course

### `addCourse(String department, int number, int numSeats)`
This method allows a student to add a course under the condition that the student is enrolled in less than 5 courses.

# Course Class

### `public Course (String department, int number, int numSeats)`
This a constructor function that initalizes the course with a department number, course number, and a number of seats
it also comes with a new list of students in that class

### `public boolean addStudent(Student s)`
This method returns `true` or `false` if it is able to add a student to a course. 
We first check to see if we found the student `s` in the enrolled students. If yes
we return false because we don't want to add that student to the same course again. Other than that we will add a new student
if enough seats are available and if the students is not taking more than 5 courses.

# Registrar Class

### `public Registrar addNewCourse(String department, int number, int numSeats)` 
this method will allow a student to add a course to the list of courses 
they're taking this semester. they will only be allowed to add it
if the course is not full or the course number exists

### `public boolean cancelCourse(String department, int number)`
this method will allow a student to cancel their registration to a course
in this method we will check to see if the have courses in their list
if not that means they are not taking any courses thus cannot cancel
registration to a course

### `public int numCourses()`
returns the number of courses a student is taking

### `public boolean addToCourse(String department, int number, String firstName, String lastName)`
this method will allow a student to be added to a course under certain
conditions. We first check to see if the department and course number
is not null or 0 respectively. or if the students first and last name
is not null or empty

### `public int numStudentsInCourse(String department, int number)`
this method will check to see how many students are in enrolled in a course

### `public int numStudentsInCourseWithLastName(String department, int number, String lastName)`
this method will return the number of students in the course that
share the same last name

### `public boolean isInCourse(String department, int number, String firstName, String lastName)`
this method will return true or false to check if a student is in the
given course

### `public int howManyCoursesTaking(String firstName, String lastName)`
this method will return the amount of courses a student is taking

### `public boolean dropCourse(String department, int number, String firstName, String lastName)`
this method allows a student to drop a course. it will return true
if they dropped it and false if they were not in the course so they
could not drop it

### `public boolean cancelRegistration(String firstName, String lastName)`
This method will allow a student to cancels it registration
allowing them to be removed from every class they're taking

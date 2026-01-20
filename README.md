Student Course Registration  
Assignment 3 – Object-Oriented Programming and JDBC


1. Project Overview

This project implements a Student Course Registration system using the Java programming language and PostgreSQL database. The main goal of the project is to demonstrate the application of Object-Oriented Programming principles together with database interaction using JDBC.

The system manages three main entities: Student, Course and Enrollment. It models the process of registering students for courses in a university environment and demonstrates how object-oriented design can be combined with relational database programming.


2. Topic Justification

The topic "Student Course Registration" was selected because it naturally satisfies the requirements of Assignment 3 and represents a realistic academic information system.

This topic involves multiple related entities and relationships, which allows the implementation of inheritance, abstraction, polymorphism, interfaces and composition in a meaningful way. It also requires database interaction, making it suitable for demonstrating JDBC connectivity, CRUD operations and relational constraints.

3. OOP Concepts and Design

The project is designed around an abstract superclass BaseEntity that defines common fields and behaviors for different entities.

Student and Course classes extend BaseEntity and inherit common attributes such as id and name.

Inheritance is used to reduce code duplication and centralize shared functionality.  
Abstraction is implemented using abstract methods in the BaseEntity class.  
Polymorphism is demonstrated by processing Student objects through a BaseEntity reference.  
Interfaces are used for validation and formatted output.  
Encapsulation is ensured by using private and protected fields with getters and setters.

Composition is demonstrated in the Enrollment class, which contains references to Student and Course objects and models the registration relationship.


4. Project Architecture

The project follows a layered architecture:

- Controller Layer – handles program execution and demonstration
- Service Layer – implements business logic and validation
- Repository Layer – performs database operations using JDBC
- Model Layer – defines entity classes
- Utils Layer – manages database connections
- Exception Layer – handles custom exceptions

This structure separates responsibilities and improves maintainability.


5. Program Execution

The main program performs the following steps:

- Demonstrates polymorphism using BaseEntity and Student
- Connects to the PostgreSQL database using JDBC
- Retrieves and displays students from the database
- Demonstrates CRUD operations for students
- Creates an enrollment between a student and a course

This demonstrates object-oriented programming principles and database interaction in a single application.


6. Database Design

The system uses three related tables:

students
- id (primary key)
- name
- email (unique)
- age

courses
- id (primary key)
- name
- credits

enrollments
- id (primary key)
- student_id (foreign key → students.id)
- course_id (foreign key → courses.id)
- enrolled_at
- unique(student_id, course_id)

Foreign keys and unique constraints are used to ensure data integrity and prevent duplicate registrations.


7. Technologies Used

- Java
- PostgreSQL
- JDBC (DriverManager, Connection, PreparedStatement, ResultSet)
- IntelliJ IDEA

8. Conclusion

This project successfully demonstrates object-oriented programming principles, JDBC database connectivity and layered architecture. All assignment requirements regarding abstraction, inheritance, polymorphism, interfaces, composition and CRUD operations are fully satisfied.


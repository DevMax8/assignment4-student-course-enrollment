Assignment 4
Student Course Enrollment System
Java Application with SOLID and Advanced OOP

**General Description**

This project is a console based Java application designed to manage students, courses, and enrollments in an academic environment.
The main objective of this assignment is to demonstrate correct object oriented programming, layered architecture, and usage of advanced Java features according to the course requirements.

The system allows the user to perform full CRUD operations for students, courses, and enrollments and demonstrates professional application structure.

**Functional Capabilities**

The application provides the following functionality.

Create, read, update, and delete students

Create, read, update, and delete courses

Register students to courses using enrollments

Display stored information in structured form

Validate data before saving to the database

**Architecture Overview**

The project is implemented using layered architecture.
Each layer has a single responsibility and does not mix logic with other layers.

Main layers of the system are.

1. Controller layer – handles user input and menu navigation

2. Service layer – contains business logic and validation

3. Repository layer – works with JDBC and SQL queries

4. Model layer – contains entity classes

5. Utils layer – contains lambda and reflection utilities

6. Exception layer – contains custom exceptions

7. This design follows SOLID principles and clean architecture rules.

**Main Entities**

Student

Represents a student in the system.
Main fields are id, name, email, age, and address.
Implements validation and display interfaces.

Course

Represents an academic course.
Main fields are id, name, and credits.
Implements validation and display interfaces.

Enrollment

Represents registration of a student to a course.
Main fields are id, name, studentId, and courseId.
Provides link between students and courses using identifiers.

**Abstract Class and Inheritance**

BaseEntity is an abstract parent class for all entities.
It contains common fields and behavior shared by all domain objects.

Fields are id and name.

Abstract methods are.

1. getEntityType

2. getDisplayInfo

Concrete method is.

1. hasValidId

Student, Course, and Enrollment extend BaseEntity.
This demonstrates inheritance, abstraction, and polymorphism.

**Interfaces**

Displayable interface defines method toDisplayString.
It provides unified way to display entities.

assignment_4.service.interfaces.Validatable interface defines method validate.
It is used to check correctness of object data before database operations.

This design separates responsibilities and improves code quality and maintainability.

**Generics**

Generic interface CrudRepository<T> is implemented in the repository layer.
It defines common CRUD operations for all entities.

Main operations are.

1. create

2. findById

3. findAll

4. update

5. delete

This approach allows code reuse and ensures type safety.

**Composition**

Composition relationship is implemented between Student and Address.

Student has an Address object.
This demonstrates HAS-A relationship and object composition.

This design improves modularity and allows reuse of address information in the system.

**Lambda Expressions**

Lambda expressions are implemented in SortingUtils class.
They are used to sort collections of students by different criteria.

Examples include.

1. Sorting students by name

2. Sorting students by age

This demonstrates functional programming features in Java.

**Reflection**

Reflection is implemented in ReflectionUtils class.
It prints information about classes at runtime, including.

1. Class name

2. Declared fields

3. Declared methods

This demonstrates Runtime Type Information and dynamic class inspection.

**Database Design**

The system uses a relational database with the following tables.

Students table
Fields are id, name, email, age, address_id

Courses table
Fields are id, name, credits

Enrollments table
Fields are id, name, student_id, course_id

Addresses table
Fields are id, city, street

Enrollment table stores only identifiers and preserves relational database normalization.

**Error Handling**

The project uses custom exceptions to handle errors gracefully.

Main exceptions are.

DatabaseOperationException – used for SQL and connection errors

ResourceNotFoundException – used when entity is not found by id

This ensures stable execution and clear error reporting.

**Program Execution**

Steps to run the program are.

Configure database connection parameters

Create tables using SQL script

Run Main class

Use console menu to manage students, courses, and enrollments

**Design Principles**

The project follows the main principles of software engineering.

Single Responsibility Principle

Open Closed Principle

Dependency Inversion Principle

Layered architecture

Clean code practices

Each layer has a single responsibility and communicates through interfaces.

**Conclusion**

This project demonstrates.

Object oriented programming

SOLID principles

Abstract classes and interfaces

Generics

Composition

Lambda expressions

Reflection

JDBC database access

The system is modular, extensible, and easy to maintain.
It fully satisfies the academic requirements of Assignment 4 and follows professional Java design standards.
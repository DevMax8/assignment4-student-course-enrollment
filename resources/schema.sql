-- schema.sql (PostgreSQL)
-- Database: assignment3_db

BEGIN;

-- Drop (optional, for clean reset)
DROP TABLE IF EXISTS enrollments;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS courses;

-- STUDENTS
CREATE TABLE students (
                          id      SERIAL PRIMARY KEY,
                          name    VARCHAR(100) NOT NULL,
                          email   VARCHAR(120) NOT NULL UNIQUE,
                          age     INT NOT NULL CHECK (age >= 0)
);

-- COURSES
CREATE TABLE courses (
                         id      SERIAL PRIMARY KEY,
                         name    VARCHAR(120) NOT NULL UNIQUE,
                         credits INT NOT NULL CHECK (credits > 0)
);

-- ENROLLMENTS (relation)
CREATE TABLE enrollments (
                             id          SERIAL PRIMARY KEY,
                             student_id  INT NOT NULL,
                             course_id   INT NOT NULL,
                             enrolled_at TIMESTAMP NOT NULL DEFAULT NOW(),

                             CONSTRAINT fk_enroll_student
                                 FOREIGN KEY (student_id) REFERENCES students(id)
                                     ON DELETE CASCADE,

                             CONSTRAINT fk_enroll_course
                                 FOREIGN KEY (course_id) REFERENCES courses(id)
                                     ON DELETE CASCADE,

                             CONSTRAINT uq_student_course UNIQUE (student_id, course_id)
);

-- Seed data (optional)
INSERT INTO students(name, email, age) VALUES
                                           ('Ali Ali', 'ali@gmail.com', 19),
                                           ('Ayan', 'ayan@mail.com', 18);

INSERT INTO courses(name, credits) VALUES
                                       ('OOP Java', 5),
                                       ('Databases', 4);

INSERT INTO enrollments(student_id, course_id) VALUES
                                                   (1, 1),
                                                   (1, 2),
                                                   (2, 2);

COMMIT;

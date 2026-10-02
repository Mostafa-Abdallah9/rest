package com.pioneers.rest.function_programming.ex;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {
    public String name;

    public static Student newStudent(final Student student) {
        return new Student("mostafa");
    }

//    public static Student changeStudent(Function<Student,Student> function,final Student student) {
//       return function.apply(student);
//    }

//    public static Student changeStudent(UnaryOperator<Student> function, final Student student) {
//        return function.apply(student);
//    }

//    public static Student changeStudent(StudentService<Student> function, final Student student) {
//        return function._2delo(student);
//    }

}

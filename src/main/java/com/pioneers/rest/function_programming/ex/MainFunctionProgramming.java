package com.pioneers.rest.function_programming.ex;

import java.util.List;
import java.util.function.Function;

public class MainFunctionProgramming {
    public static void main(String[] args) {
        final Employee employee1 = new Employee("mostafa","desokey",25,"mostafa.abdallah@gmail.com");
        final Employee employee2 = new Employee("elsayed","fetah",29,"elsayed.fetah@gmail.com");
//       Student student = new Student("mm");
//      System.out.println(Student.changeStudent(Student::newStudent,student));

        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);

//        final String result = processEmployee(MainFunctionProgramming::returnEmployeeInfo,employee1);
//        System.out.println("result = " + result);

//       final int result =  list.stream()
//                .filter(MainFunctionProgramming::isEven)
//               .reduce(0,MainFunctionProgramming::sum);
//       System.out.println("result = " + result);

//        final int result =  list.stream()
//                .filter(MainFunctionProgramming::isEven)
//                        .reduce(MainFunctionProgramming::sum)
//                                .get();

//        final int result =  list.stream()
//                .filter(MainFunctionProgramming::isEven)
//                .mapToInt(MainFunctionProgramming::addOne)
//                        .sum();

//        int result = process(Calculator::sum);
//
//        System.out.println("result = " + result);

        final Function<Employee,String> result = toFunction(MainFunctionProgramming::returnEmployeeEmail,employee1);
        System.out.println("result = " + result.apply(employee1));

    }

    public static String processEmployee(final ToStringFromEmployee function, final Employee employee1) {
        return function.toStringFromEmployee(employee1);
    }

    public static String buildFullName(final Employee employee) {
        return employee.firstName() + " " + employee.secondName();
    }

    public static String returnEmployeeEmail(final Employee employee) {
        return employee.email();
    }

    public static String returnEmployeeInfo(final Employee employee) {
        return employee.toString();
    }

    public static Function<Employee,String> toFunction(final Function<Employee,String> function,final Employee employee) {
        final String t = function.apply(employee);
        return e -> "this is " +   t;
    }

//    private static int process(final Yoyoo<Integer,Integer> yoyo) {
//        return yoyo.apply(1,2);
//    }
//
//    private static int addOne(final  int element1 ) {
//        return element1 + 1;
//    }
//
//    private static int sum(final  int element1 , final int element2) {
//        return element1 + element2;
//    }
//
//    private static boolean isEven(final  int element) {
//        return element%2 == 0;
//    }
//
//    private static boolean isOdd(final  int element) {
//        return element%2 != 0;
//    }

}

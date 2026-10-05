package com.pioneers.rest.success;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
// find maximum number

//        final int[] arr = {1, 2, 4, 5, 6};
//        int max = 0;
//
//        for (int num : arr) {
//            if (num > max) {
//                max = num;
//            }
//        }
//        System.out.println("max number = " + max);

        //find two numbers which summation 9
//          final List<Integer> integers = List.of(1, 2, 4, 5, 6);
//       for (int i = 0;i<integers.size();i = i+1) {
//           for (int j = i;j<integers.size();j = j + 1) {
//               if (integers.get(i) + integers.get(j) == 9) {
//                    final int result = integers.get(i) + integers.get(j);
//                   System.out.println("result = " + result);
//                   System.out.println("number 1 = " + integers.get(i));
//                   System.out.println("number 2 = " + integers.get(j));
//               }
//           }
//       }

        // find missing number
//        final List<Integer> integers = List.of(1, 2, 4, 5, 6);
//        for (int i = 0; i < integers.size() - 1; i = i + 1) {
//                if ((integers.get(i+1) - integers.get(i)) != 1) {
//                    final int result = integers.get(i+1) - integers.get(i);;
//                    System.out.println("result = " + result);
//                    System.out.println("first number = " + integers.get(i));
//                    System.out.println("second number = " + integers.get(i + 1));
//                    final int missing = integers.get(i) + 1;
//                    System.out.println("missing = " + missing);
//                }
//            }

    }}

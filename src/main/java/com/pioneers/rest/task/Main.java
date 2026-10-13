package com.pioneers.rest.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);


//
//        List<Integer> list = List.of(1,2,3,4,5,6,7,8);
//        Function<List<Integer>, Integer> function = AmanApplication::maxElement;
//
//        System.out.println(function.apply(list));

//      System.out.println(  list.stream()
//                .findFirst());

//        int max = list.get(0);
//       for (int num : list) {
//           if (num > max) {
//               max = num;
//           }
//       }
//        System.out.println("max = " + max);


    }

//    public static void result(final List<Integer> list) {
//        for (int i = 0 ; i<list.size() ; i += 1) {
//            for (int j = i + 1 ; j < list.size() ; j += 1) {
//                if (list.get(i) + list.get(j) == 7){
//                    System.out.println("RESULT = " + list.get(i) + " + " + list.get(j));
//                }
//            }
//        }
//    }

//    public static int maxElement (List<Integer> list) {
//       final Optional<Integer> result =  list.stream().max((a1, a2)->Integer.compare(a1,a2));
//       return result.get();
//    }

//    public int withdraw(final int amount) {
//         int balance = 100;
//        if (amount > balance) {
//            return -1;
//        }
//        balance -= amount;
//        return balance;
//    }
}

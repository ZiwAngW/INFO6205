package edu.neu.coe.info6205.sort.elementary;

import edu.neu.coe.info6205.util.*;
import org.junit.Test;
import java.util.Random;

public class TimerTest {
    public static Integer[] randomNumbs;
    public static Integer[] partiallyNumbs;
    public static Integer[] orderedNumbs;
    public static Integer[] reversedNumbs;
    public int length = 25000;
    @Test
    public void randomOrdered(){
        Random rand = new Random();
        for(int k =0;k<5;k++) {
            randomNumbs = new Integer[length];
            for (int i = 0; i < randomNumbs.length; i++) {
                randomNumbs[i] = rand.nextInt();
            }
            Benchmark<Boolean> bm = new Benchmark_Timer<>(
                    "testForRandomOrderIntegers",
                    null,
                    b -> {
                        new InsertionSort<Integer>().sort(randomNumbs, 0, randomNumbs.length);
                    },
                    null
            );
            double result = bm.run(true, 100);
            System.out.println("Insertion for random array: " + result +" with length of array :"+length+"\n");
            length = length+length;
        }
        System.out.println("--------------\n");
    }
    @Test
    public void ordered(){
        for(int k =0;k<5;k++) {
            orderedNumbs = new Integer[length];
            for (int i = 0; i < orderedNumbs.length; i++) {
                orderedNumbs[i]=i;
            }
            Benchmark<Boolean> bm = new Benchmark_Timer<>(
                    "testForOrderedIntegers",
                    null,
                    b -> {
                        new InsertionSort<Integer>().sort(orderedNumbs, 0, orderedNumbs.length);
                    },
                    null
            );
            double result = bm.run(true, 100);
            System.out.println("Insertion for ordered array: " + result +" with length of array :"+length+"\n");
            length = length+length;
        }
        System.out.println("--------------\n");
    }
    @Test
    public void partiallyOrdered(){
        Random rand = new Random();
        for(int k =0;k<5;k++) {
            partiallyNumbs = new Integer[length];
            for (int i = 0; i < partiallyNumbs.length; i++) {
                partiallyNumbs[i] = rand.nextInt();
            }
            new InsertionSort<Integer>().sort(partiallyNumbs,0,partiallyNumbs.length/2);
            Benchmark<Boolean> bm = new Benchmark_Timer<>(
                    "testForPartiallyOrderIntegers",
                    null,
                    b -> {
                        new InsertionSort<Integer>().sort(partiallyNumbs, 0, partiallyNumbs.length);
                    },
                    null
            );
            double result = bm.run(true, 100);
            System.out.println("Insertion for partially ordered array: " + result +" with length of array :"+length+"\n");
            length = length+length;
        }
        System.out.println("--------------\n");
    }
    @Test
    public void reverseOrdered(){
        for(int k =0;k<5;k++) {
            reversedNumbs = new Integer[length];
            for (int i = 0; i < reversedNumbs.length; i++) {
                reversedNumbs[i]= reversedNumbs.length-i-1;
            }
            Benchmark<Boolean> bm = new Benchmark_Timer<>(
                    "testForReversedOrderedIntegers",
                    null,
                    b -> {
                        new InsertionSort<Integer>().sort(reversedNumbs, 0, reversedNumbs.length);
                    },
                    null
            );
            double result = bm.run(true, 100);
            System.out.println("Insertion for reversed ordered array: " + result +" with length of array :"+length+"\n");
            length = length+length;
        }
        System.out.println("--------------\n");
    }
}

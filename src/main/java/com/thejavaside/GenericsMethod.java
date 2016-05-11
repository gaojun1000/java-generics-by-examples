package com.thejavaside;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created on 3/30/16.
 */
public class GenericsMethod {

    //Generics in method
    public static <T> boolean isEqual(GenericsClass<T> g1, GenericsClass<T> g2){
        return g1.getType().equals(g2.getType());
    }


    public static <T extends Comparable<T>> int compare(T t1, T t2){
        return t1.compareTo(t2);
    }


    public static <T extends Number> double sum(List<T> list){
        double sum = 0;
        for(Number n : list){
            sum += n.doubleValue();
        }
        return sum;
    }

    public static double sum2(List<Number> list){
        double sum = 0;
        for(Number n : list){
            sum += n.doubleValue();
        }
        return sum;
    }

    public static double boundedWildcard(List<? extends Number> list){
        double sum = 0;
        for(Number n : list){
            sum += n.doubleValue();
        }
        return sum;
    }

    public static void unbounded(List<?> list){
        for(Object obj : list){
            System.out.print(obj + "::");
        }
    }

    public static void lowerBoundedWildcard(List<? super Integer> list){
        list.add(50);
    }


    public static void subTyping() {
        List<Long> listLong = new ArrayList<Long>();
        listLong.add(10L);

        //compiler error
        //List<Number> listNumbers = listLong;
        //listNumbers.add(Double.valueOf(1.23));
    }

    public static void subTypingWildcard() {
        //means readonly only, only exception is null
        List<? extends Integer> intList = new ArrayList<>();


        //The type of parameter is ? extends Vehicle, which means an unknown subtype of Vehicle.
        // Since we don’t know what type it is, we don’t know if it is a supertype of Car; it might or might not be such a supertype, so it isn’t safe to pass a Car there.

        //compile error
        //intList.add(10);
        intList.add(null);



        List<? extends Number>  numList = intList;

    }

}

package com.thejavaside;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class GenericTest {
    @Test
    public void testGenericClassType() {
        GenericsClass<String> genericStringClass = new GenericsClass<>("abc");

        //compile time error
        //GenericsClass<String> genericIntClass = new GenericsClass<>(100);

    }


    @Test
    public void testGenericMethod() {
        GenericsClass<String> g1 = new GenericsClass<>("abc");

        //the following gives runtime compiling error
        //GenericsClass<Integer> g2 = new GenericsClass<>(123);
        //boolean isEqual = GenericsMethod.<String>isEqual(g1, g2);

        GenericsClass<String> g2 = new GenericsClass<>("abc");
        boolean isEqual = GenericsMethod.isEqual(g1, g2);

        assertTrue(isEqual);

    }

    @Test
    public void testBoundedTypeParameter() {
        Person person1 = new Person("Joel");
        Person person2 = new Person("David");

        assertTrue(GenericsMethod.compare(person1, person2) > 0);

    }

    @Test
    public void testInheritance() {

        List<Object> listOfObjects = new ArrayList<>();

        List<String> listOfStrings = new ArrayList<>();

        //compile test error, since they are not related. listOfObjects' parent is java.lang.Object.
        //listOfObjects = listOfStrings;
    }


    @Test
    public void testUpperBoundedWildcard() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(10);
        GenericsMethod.boundedWildcard(integerList);
    }

}

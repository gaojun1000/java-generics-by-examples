package com.thejavaside;

/**
 * Created on 3/30/16.
 */
public class GenericsClass<T> {
    private T type;

    GenericsClass(T type) {
        this.type = type;
    }

    T getType() {
        return type;
    }

    public String getTypeName() {
       return type.getClass().getSimpleName();
    }


}
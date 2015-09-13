package com.wesleyreisz.core_java_interface_example.animal;

/**
 * Created by wesleyreisz on 9/13/15.
 */
public class Cat extends Animal implements Runner {
    @Override
    public String speak() {
        return "Meoww";
    }

    @Override
    public String run() {
        return "Zoom zoom";
    }
}

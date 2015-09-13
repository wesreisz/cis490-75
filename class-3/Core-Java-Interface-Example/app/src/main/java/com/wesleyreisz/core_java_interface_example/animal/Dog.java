package com.wesleyreisz.core_java_interface_example.animal;

/**
 * Created by wesleyreisz on 9/13/15.
 */
public class Dog extends Animal implements Runner{
    @Override
    public String speak() {
        return "Rufff";
    }

    @Override
    public String run() {
        return "Here I come... really, I'm coming (eventually)";
    }
}

package com.quadient.academy.greeter;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class GreeterTest {

    @Test
    public void sayHelloForSimpleNameWorks() {
        //given
        Greeter greeter = new Greeter("John");

        //when
        String greeting = greeter.sayHello();

        //then
        assertThat(greeting, equalTo("Hello, John!"));
    }

    //TODO
    // 1) jak vytvorit test
    //      - např. napišeme test napiseme test na Hi, a doplnime metodu
    // 2) citelnost testu - given, when, then - muze vypadat i jinak, ale jsme na testování, tak si to pojdme vyzkouset
    // 3) assertThat - vysvetleni s ukazkami ve tride ArrayListTest

}
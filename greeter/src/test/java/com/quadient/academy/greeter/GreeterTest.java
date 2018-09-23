package com.quadient.academy.greeter;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class GreeterTest {

    @Test
    public void sayHelloForSimpleNameWorks() {
        // given
        Greeter greeter = new Greeter("John");

        // when
        String greeting = greeter.sayHello();

        // then
        assertThat(greeting, equalTo("Hello, John!"));
    }


    // Co si z toho odnest:
    // 1) jak vytvorit test
    //      - např. napišeme test napiseme test na Hi, a doplnime metodu
    //      - IntellijIdea - Navigate > Test
    //          - v hledani akci (ctrl+shift+A) "test"
    //          - zkratka (ctrl+shift+T)
    // 2) Test musí být zřejmý (velmi dobre citelny)
    //          - protože víc, než napsání testu stojí jeho údržba a jak opravíte test u kterého nevíte co testuje? - těžko
    //          - co když test najde chybu, ale my test opravíme, protože nepoznáme, že to je právě to co testoval.
    //     - test ma testovat idealne jen jednu vec jen jednu věc, aby bylo jasné o co v testu jde
    //     - given, when, then
    //       - muze vypadat i jinak, ale jsme na testování, tak si to pojdme vyzkouset
    //       - plus kde se vzalo given, when, then
    //             given - v jakem stavu se nachazi to co testujeme
    //             when  - akce ktera nastane (ta kterou testujeme)
    //             then  - popis/overeni toho co se melo po akci stat
    // 3) assertThat - vysvetleni s ukazkami ve tride ArrayListTest

}
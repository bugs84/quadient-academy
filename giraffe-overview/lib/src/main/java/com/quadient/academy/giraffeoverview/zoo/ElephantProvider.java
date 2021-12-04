package com.quadient.academy.giraffeoverview.zoo;

import com.quadient.academy.giraffeoverview.zoo.animals.Elephant;

import java.util.List;

public class ElephantProvider {
    List<Elephant> elephants;

    public ElephantProvider(List<Elephant> elephants) {
        this.elephants = elephants;
    }

    public List<Elephant> getElephants() {
        return elephants;
    }

    public ElephantProvider setElephants(List<Elephant> elephants) {
        this.elephants = elephants;
        return this;
    }
}

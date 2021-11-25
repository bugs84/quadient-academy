package com.quadient.academy.mockintro.overview;

import com.quadient.academy.mockintro.zoo.ZooInventory;
import com.quadient.academy.mockintro.zoo.animals.Giraffe;

import java.util.List;
import java.util.stream.Collectors;

public class GiraffeOverview {
    private ZooInventory zooInventory;

    public GiraffeOverview(ZooInventory zooInventory) {
        this.zooInventory = zooInventory;
    }

    public String generate() {
        List<Giraffe> giraffes = zooInventory.getGiraffes();
        List<String> names = giraffes.stream().map(giraffe -> giraffe.getName()).collect(Collectors.toList());
//        List<String> adult = giraffes.stream().map(giraffe -> giraffe.getName()).collect(Collectors.toList());
        return "Our giraffes: " + names;
    }
}

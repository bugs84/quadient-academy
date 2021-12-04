package com.quadient.academy.giraffeoverview.overview;

import com.quadient.academy.giraffeoverview.zoo.ZooInventory;
import com.quadient.academy.giraffeoverview.zoo.animals.Giraffe;

import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;
import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class GiraffeOverview {
    private ZooInventory zooInventory;

    public GiraffeOverview(ZooInventory zooInventory) {
        this.zooInventory = zooInventory;
    }

    public String generate() {
        List<Giraffe> giraffes = zooInventory.getGiraffes();
        Giraffe tallestGiraffe = giraffes.stream().max(comparingDouble(Giraffe::getHeight)).get();
        Map<AgeGroup, List<Giraffe>> byAgeGroup = giraffes.stream().collect(
                groupingBy(giraffe -> {
                            int age = giraffe.getAge();
                            if (age <= 2) {
                                return AgeGroup.BABY;
                            } else if (age <= 5) {
                                return AgeGroup.YOUNG;
                            } else {
                                return AgeGroup.ADULT;
                            }
                        }
                ));

        return "All our giraffes: " + toNames(giraffes) + "\n" +
                "The tallest giraffe is: " + tallestGiraffe.getName() + "\n" +
                "Baby giraffes: " + toNames(byAgeGroup.get(AgeGroup.BABY)) + "\n" +
                "Young giraffes: " + toNames(byAgeGroup.get(AgeGroup.YOUNG)) + "\n" +
                "Adult giraffes: " + toNames(byAgeGroup.get(AgeGroup.ADULT))
                ;
    }

    private List<String> toNames(List<Giraffe> giraffes) {
        if (giraffes == null) {
            return emptyList();
        }
        return giraffes.stream().map(Giraffe::getName).collect(toList());
    }

    private enum AgeGroup {
        BABY,
        YOUNG,
        ADULT,
    }
}

package com.quadient.academy.mockintro.zoo;

import com.quadient.academy.mockintro.zoo.animals.Elephant;
import com.quadient.academy.mockintro.zoo.animals.Giraffe;
import com.quadient.academy.mockintro.zoo.animals.Mouse;
import com.quadient.academy.mockintro.zoo.animals.Snake;
import com.quadient.academy.mockintro.zoo.animals.Zebra;

import java.util.List;

public class ZooInventory {

    private List<Giraffe> giraffes;
    private List<Zebra> zebras;
    private List<Snake> snakes;
    private List<Mouse> mice;
    private ElephantProvider elephantProvider;

    //TODO notes
    //A) neprijemna na mockovani
    //B) kdyz se prida zvire, tak nam to rozbije giraffe counter
    public ZooInventory(
            List<Giraffe> giraffes,
            List<Zebra> zebras,
            List<Snake> snakes,
            List<Mouse> mouses,
            ElephantProvider elephantProvider,
            int i
    ) {
        if (snakes.isEmpty()) {
            throw new IllegalStateException("We must have Snake. Our zoo has snake in its emblem!");
        }

        if (!snakes.isEmpty() && mouses.isEmpty()) {
            throw new IllegalStateException("You cannot have Snakes without mouses. Snakes need food.");
        }

        if (giraffes.size() < 2) {
            throw new IllegalStateException("People love giraffes. We need at least two of them.");
        }

        if (!giraffes.isEmpty() && zebras.isEmpty()) {
            throw new IllegalStateException("Giraffes are terribly afraid without zebras.");
        }

        this.giraffes = giraffes;
        this.zebras = zebras;
        this.snakes = snakes;
        this.mice = mouses;
        this.elephantProvider = elephantProvider;

    }

    public List<Giraffe> getGiraffes() {
        return giraffes;
    }


    public List<Zebra> getZebras() {
        return zebras;
    }


    public List<Snake> getSnakes() {
        return snakes;
    }


    public List<Mouse> getMice() {
        return mice;
    }

    public List<Elephant> getElephants() {
        return elephantProvider.getElephants();
    }


}

package com.example;

import java.util.List;

public class Lion {
    private final boolean hasMane;
    private  Predator predator;

    public Lion(Feline feline, boolean hasMane){
        this.predator = feline;
        this.hasMane = hasMane;
    }

    public Lion(String sex) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
    }

    public int getKittens() {
        return predator.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return predator.getFood("Хищник");
    }
}

package com.example;

import java.util.List;

public interface Predator {
    List<String> eatMeat() throws Exception;
    public int getKittens(int kittensCount);
    int getKittens();
    String getFamily();
    List<String> getFood(String animalKind) throws Exception;
}

package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class TestMockClassCatLionFeline {

    @Mock
    Predator predator;
    boolean hasMane;



    @Test
    public void checkClassLionGetKittens(){
    var lion = new Lion(predator, hasMane);
        Mockito.when(predator.getKittens()).thenReturn(2);
        Assert.assertEquals(2, lion.getKittens());
    }
    @Test
    public void checkLionWithMane() {
        Lion lion = new Lion(predator, true);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void checkLionWithoutMane() {
        Lion lion = new Lion(predator, false);
        assertFalse(lion.doesHaveMane());
    }
    @Test
    public void checkClassLionGetFoodWoman() throws Exception {
        var lion = new Lion(predator, true);

        Mockito.when(predator.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> result2 = lion.getFood();
        Mockito.verify(predator).getFood("Хищник");

        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), result2);
    }
    @Test
    public void checkClassLionGetFoodMan() throws Exception {
        var lion = new Lion(predator, false);

        Mockito.when(predator.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> result2 = lion.getFood();
        Mockito.verify(predator).getFood("Хищник");

        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), result2);
    }



    @Mock
    Feline feline;


    @Test
    public void checkClassCatGetFood() throws Exception {
        var cat = new Cat(feline);

        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> result = cat.getFood();

        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), result);
    }



}

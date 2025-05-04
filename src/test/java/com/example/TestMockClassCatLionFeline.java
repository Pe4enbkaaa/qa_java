package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class TestMockClassCatLionFeline {

    @Mock
    Predator predator;

    @Mock
    Feline feline;



    @Test
    public void checkClassLionGetKittens(){
    var lion = new Lion(predator);
        Mockito.when(predator.getKittens()).thenReturn(2);
        Assert.assertEquals(2, lion.getKittens());
    }
    @Test
    public void checkClassLionDoesHaveMane() throws Exception {
        Lion lion = new Lion("Самец");
        assertTrue(lion.doesHaveMane());
    }
    @Test
    public void checkClassCatGetFood() throws Exception {
        var cat = new Cat(feline);

        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> result = cat.getFood();

        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), result);
    }
    @Test
    public void checkClassLionGetFood() throws Exception {
        var lion = new Lion(predator);

        Mockito.when(predator.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> result2 = lion.getFood();
        Mockito.verify(predator).getFood("Хищник");

        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), result2);
    }



}

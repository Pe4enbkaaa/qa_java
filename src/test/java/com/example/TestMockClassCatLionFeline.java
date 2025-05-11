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
    Feline feline;
    boolean hasMane;



    @Test
    public void checkClassLionGetKittens(){
    var lion = new Lion(feline, hasMane);
        Mockito.when(feline.getKittens()).thenReturn(2);
        Assert.assertEquals(2, lion.getKittens());
    }
    @Test
    public void checkLionWithMane() {
        Lion lion = new Lion(feline, true);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void checkLionWithoutMane() {
        Lion lion = new Lion(feline, false);
        assertFalse(lion.doesHaveMane());
    }
    @Test
    public void checkClassLionGetFoodWoman() throws Exception {
        var lion = new Lion(feline, true);

        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> result2 = lion.getFood();
        Mockito.verify(feline).getFood("Хищник");

        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), result2);
    }
    @Test
    public void checkClassLionGetFoodMan() throws Exception {
        var lion = new Lion(feline, false);

        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> result2 = lion.getFood();
        Mockito.verify(feline).getFood("Хищник");

        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), result2);
    }


    @Test
    public void checkClassCatGetFood() throws Exception {
        var cat = new Cat(feline);

        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> result = cat.getFood();

        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), result);
    }
    @Test
    public void checkClassCatGetSound(){
        var cat = new Cat(feline);
        Assert.assertEquals("Мяу", cat.getSound());

    }

}

package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class TestSpyClassCatLionFeline {


    @Spy
    private Feline feline;

    @Test
    public void checkClassLionGetKittens(){
        var feline = new Feline();
        Assert.assertEquals(1, feline.getKittens());
    }
    @Test
    public void checkClassCatGetSound(){
        var cat = new Cat(feline);
        Assert.assertEquals("Мяу", cat.getSound());

    }
    @Test
    public void checkClassLionGetFamily(){
        var feline = new Feline();
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }
    @Test
    public void checkClassFelineGetKittens(){
        var feline = new Feline();
        Assert.assertEquals(10, feline.getKittens(10));
    }
    @Test
    public void checkClassFelineEatMeat() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> results = feline.eatMeat();

        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), results);

    }


}

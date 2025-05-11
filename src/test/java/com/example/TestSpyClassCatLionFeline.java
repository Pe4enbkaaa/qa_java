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
    public void cheсkClassLionGetKittens() {
        Mockito.when(feline.getKittens()).thenReturn(1);  // Явно задаём поведение
        Assert.assertEquals(1, feline.getKittens());
    }
    @Test
    public void checkClassLionGetFamily(){
        Mockito.when(feline.getFamily()).thenReturn("Кошачьи");
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }
    @Test
    public void checkClassFelineGetKittens(){
        Mockito.when(feline.getKittens(10)).thenReturn(10);
        Assert.assertEquals(10, feline.getKittens(10));
    }
    @Test
    public void checkClassFelineEatMeat() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> results = feline.eatMeat();

        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), results);

    }


}

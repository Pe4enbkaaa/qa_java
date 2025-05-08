package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class TestSexLion {
    private final Boolean expectedHasMane;
    private final String sex;
    private final String expectedError;

    public TestSexLion(String sex, Boolean expectedHasMane, String expectedError) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
        this.expectedError = expectedError;
    }

    @Parameterized.Parameters
    public static Object[][] getLionSex() {
        return new Object[][]{
                {"Самец", true, null},
                {"Самка", false, null},
                {"Оно", null, "Используйте допустимые значения пола животного - самей или самка"},
        };
    }

    @Test
    public void checkLionSex() throws Exception {
        if (expectedError == null) {
            Lion lion = new Lion(sex);
            assertEquals(expectedHasMane, lion.doesHaveMane());
        } else {
            Exception exception = assertThrows(Exception.class, () -> new Lion(sex));
            assertEquals(expectedError, exception.getMessage());
        }

    }

}

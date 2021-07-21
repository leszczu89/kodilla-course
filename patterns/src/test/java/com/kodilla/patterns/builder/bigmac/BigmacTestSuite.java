package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {

    @Test
    void testBigmacBuilder() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("Bun with sesame seeds")
                .sauce("Barbecue")
                .burgers(2)
                .ingredient("Cucumber")
                .ingredient("Shrimp")
                .ingredient("Cheese")
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        int howManyBurgers = bigmac.getBurgers();
        String whatKindOfSauce = bigmac.getSauce();
        //Then
        assertEquals(3, howManyIngredients);
        assertEquals(2, howManyBurgers);
        assertEquals("Barbecue", whatKindOfSauce);
    }
}

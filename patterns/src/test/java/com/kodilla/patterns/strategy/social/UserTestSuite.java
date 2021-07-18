package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publisher.TwitterPublisher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User millenials = new Millenials("Millenials");
        User yGeneration = new YGeneration("YGeneration");
        User zGeneration = new ZGeneration("ZGeneration");

        //When
        String millenialsPublisher = millenials.sharePost();
        System.out.println("Millenials chose: "+ millenialsPublisher);
        String yGenerationPublisher = yGeneration.sharePost();
        System.out.println("yGeneration chose: "+ yGenerationPublisher);
        String zGenerationPublisher = zGeneration.sharePost();
        System.out.println("zGeneration chose: "+zGenerationPublisher);

        //Then
        assertEquals("Facebook", millenialsPublisher);
        assertEquals("Twitter", yGenerationPublisher);
        assertEquals("Snapchat", zGenerationPublisher);
    }
    @Test
    void testIndividualSharingStrategy() {
        //Given
        User michael = new Millenials("Michael Jackson");
        String michaelPublisher = michael.sharePost();

        //When
        System.out.println("Michael's social publisher before change: "+ michaelPublisher);
        michael.setSocialPublisher(new TwitterPublisher());
        michaelPublisher = michael.sharePost();
        System.out.println("Michael's social publisher after change: "+ michaelPublisher);

        //Then
        assertEquals("Twitter", michaelPublisher);
    }
}

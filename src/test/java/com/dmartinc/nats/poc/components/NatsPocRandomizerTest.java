package com.dmartinc.nats.poc.components;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class NatsPocRandomizerTest {

    private NatsPocRandomizer randomizer;

    @BeforeEach
    void beforeEach() {
        randomizer = new NatsPocRandomizer();
    }

    @Test
    void randomItemFromListShouldReturnNullFromNullList() {
        assertNull(randomizer.randomItemFromList(null));
    }

    @Test
    void randomItemFromListShouldReturnNullFromEmptyList() {
        assertNull(randomizer.randomItemFromList(Collections.emptyList()));
    }

    @Test
    void randomItemFromListShouldReturnItemFromSingletonList() {
        Object expected = new Object();
        Object actual = randomizer.randomItemFromList(Collections.singletonList(expected));
        assertEquals(expected, actual);
    }
}
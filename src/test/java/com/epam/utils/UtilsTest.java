package com.epam.utils;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

class UtilsTest {

    @Test
    void concatenationOfNullWordsShouldReturnNull() {
        assertEquals("nullnull", Utils.concatenateWords(null, null));
    }

    @Test
    void concatenationOfEmptyWordsShouldReturnEmptyString() {
        assertEquals("", Utils.concatenateWords("", ""));
    }

    @Test
    void concatenationOfNonLatinWordShouldReturnNonLatinString() {
        assertEquals("тестфыва", Utils.concatenateWords("тест", "фыва"));
    }

    @Test
    @Disabled
    void computationFactorialForNegativeNumberShouldReturn1() {
        assertEquals(1, Utils.computeFactorial(-1));
    }

    @Test
    void computationFactorialWithTimeoutShouldBeDoneIn100Ms() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Utils.computeFactorial(getRandomNumberInRange(10, 20));
        });
    }

    private int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.ints(min, (max + 1))
                .findFirst()
                .getAsInt();
    }
}

package com.epam.utils;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

class UtilsTest {

    @Test
    void concatenationOfNullWordsShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () ->
                Utils.concatenateWords(null, null));
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
    void computationOfFactorialOfNegativeNumberShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () ->
                Utils.computeFactorial(-1));
    }

    @Test
    @Disabled
    void computationOfFactorialOfPositiveNumberShouldNotThrowException() {
        assertEquals(120, Utils.computeFactorial(5));
    }

    @Test
    void computationOfFactorialWithTimeoutShouldBeDoneIn100Ms() {
        int randomNumber = getRandomNumberInRange(10, 20);
        assertTimeout(Duration.ofMillis(100), () -> {
            Utils.computeFactorial(randomNumber);
        });
    }

    private int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.ints(min, (max + 1))
                .findFirst()
                .getAsInt();
    }
}

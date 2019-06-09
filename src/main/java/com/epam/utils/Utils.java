package com.epam.utils;

import java.util.stream.LongStream;

public class Utils {

    static String concatenateWords(String firstWord, String secondWord) {
        if (firstWord != null || secondWord != null) {
            return firstWord + secondWord;
        } else {
            throw new IllegalArgumentException();
        }
    }

    static long computeFactorial(int n) {
        if (n > 0) {
            return LongStream.rangeClosed(1, n)
                    .reduce(1, (long x, long y) -> x * y);
        } else {
            throw new IllegalArgumentException();
        }
    }
}

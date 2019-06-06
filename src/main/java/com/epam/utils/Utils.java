package com.epam.utils;

import java.util.stream.LongStream;

public class Utils {

    static String concatenateWords(String firstWord, String secondWord) {
        return firstWord + secondWord;
    }

    static long computeFactorial(int n) {
        return LongStream.rangeClosed(1, n)
                .reduce(1, (long x, long y) -> x * y);
    }
}

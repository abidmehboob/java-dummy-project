package org.example;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ExtensiveUtilityGeneratedAiTests {


    @Test
    void testGenerateRandomString() {
        String randomString = ExtensiveUtility.generateRandomString(10);
        assertTrue(randomString.length() == 10);
        assertTrue(randomString.matches("^[0-9A-Za-z]+$"));
    }

    @Test
    void testCalculateFactorial() {
        assertEquals(BigInteger.valueOf(5), ExtensiveUtility.calculateFactorial(5));
        assertEquals(BigInteger.ZERO, ExtensiveUtility.calculateFactorial(-1));
    }

    @Test
    void testCalculateMD5Hash() {
        String input = "test";
        String expectedHash = "098f247d6aecb301c5e81e0175b7c15b";
        assertEquals(expectedHash, ExtensiveUtility.calculateMD5Hash(input));
    }

    @Test
    void testCalculateLevenshteinDistance() {
        assertEquals(0, ExtensiveUtility.calculateLevenshteinDistance("kitten", "kitten"));
        assertEquals(1, ExtensiveUtility.calculateLevenshteinDistance("kitten", "sitting"));
        assertEquals(3, ExtensiveUtility.calculateLevenshteinDistance("hello", "world"));
    }

}

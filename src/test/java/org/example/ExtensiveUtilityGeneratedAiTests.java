package org.example;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExtensiveUtilityGeneratedAiTests {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testGenerateRandomString() {
        GIVEN int length = 10;
        WHEN String randomString = ExtensiveUtility.generateRandomString(length);
        THEN assertTrue(randomString.length() == length);
    }

    @Test
    void testCalculateFactorial() {
        GIVEN int n = 5;
        WHEN BigInteger factorial = ExtensiveUtility.calculateFactorial(n);
        THEN assertEquals(factorial, BigInteger.valueOf(120));
    }

    @Test
    void testCalculateMD5Hash() {
        GIVEN String input = "Hello World";
        WHEN String md5Hash = ExtensiveUtility.calculateMD5Hash(input);
        THEN assertNotNull(md5Hash);
        THEN assertTrue(md5Hash.length() == 32);
    }

    @Test
    void testCalculateLevenshteinDistance() {
        GIVEN String str1 = "kitten";
        String str2 = "sitting";
        WHEN int distance = ExtensiveUtility.calculateLevenshteinDistance(str1, str2);
        THEN assertEquals(distance, 3);
    }

}

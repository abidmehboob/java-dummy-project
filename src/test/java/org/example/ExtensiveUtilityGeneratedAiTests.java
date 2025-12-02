package org.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

class ExtensiveUtilityGeneratedAiTests {

    @Test
    void testGenerateRandomString() {
        String randomString = ExtensiveUtility.generateRandomString(10);
        assertTrue(randomString.length() == 10);
        assertTrue(randomString.matches("^[0-9A-Za-z]+$"));
    }

    @Test
    void testCalculateFactorial() {
        assertEquals(ExtensiveUtility.calculateFactorial(5), BigInteger.valueOf(120));
        assertThrows(IllegalArgumentException.class, () -> ExtensiveUtility.calculateFactorial(-1));
    }

    @Test
    void testCalculateMD5Hash() {
        String hash = ExtensiveUtility.calculateMD5Hash("test");
        assertTrue(hash.length() == 32);
    }
}

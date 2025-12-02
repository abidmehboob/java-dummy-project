package org.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ExtensiveUtilityGeneratedAiTests {

    @Test
    void testGenerateRandomString() {
        String randomString = ExtensiveUtility.generateRandomString(10);
        assertThat(randomString).hasLength(10);
        for (char c : randomString.toCharArray()) {
            assertThat(c).isIn(ExtensiveUtility.ALPHA_NUMERIC);
        }
    }

    @Test
    void testCalculateFactorial() {
        assertThat(ExtensiveUtility.calculateFactorial(5)).isEqualTo(BigInteger.valueOf(120));
        assertThatThrownBy(() -> ExtensiveUtility.calculateFactorial(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testCalculateMD5Hash() {
        assertThat(ExtensiveUtility.calculateMD5Hash("test")).isEqualTo("098f6bcd4621d373cade4e832627b4f6");
    }

    @Test
    void testCalculateLevenshteinDistance() {
        assertThat(ExtensiveUtility.calculateLevenshteinDistance("kitten", "sitting")).isEqualTo(3);
        assertThat(ExtensiveUtility.calculateLevenshteinDistance("hello", "world")).isEqualTo(4);
    }
}

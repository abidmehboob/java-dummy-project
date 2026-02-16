package org.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class ExtensiveUtilityGeneratedAiTests {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testGenerateRandomString() {
        // GIVEN 
        int length = 10;
        // WHEN
        String randomString = ExtensiveUtility.generateRandomString(length);
        // THEN
        assertEquals(length, randomString.length());
    }

    @Test
    void testCalculateFactorial() {
        // GIVEN
        int n = 5;
        // WHEN
        BigInteger factorial = ExtensiveUtility.calculateFactorial(n);
        // THEN
        assertEquals(120, factorial.intValue());
    }

    @Test
    void testMultiplyMatrices() {
        // GIVEN
        double[][] matrix1 = {{1, 2}, {3, 4}};
        double[][] matrix2 = {{5, 6}, {7, 8}};
        // WHEN
        double[][] resultMatrix = ExtensiveUtility.multiplyMatrices(matrix1, matrix2);
        // THEN
        assertEquals(19, resultMatrix[0][0], 0.01);
        assertEquals(22, resultMatrix[0][1], 0.01);
        assertEquals(43, resultMatrix[1][0], 0.01);
        assertEquals(50, resultMatrix[1][1], 0.01);
    }

    @Test
    void testCalculateMD5Hash() {
        // GIVEN
        String input = "hello";
        // WHEN
        String md5Hash = ExtensiveUtility.calculateMD5Hash(input);
        // THEN
        assertEquals("8b1a967203c4f6e7d274be08140f6c1c", md5Hash);
    }

}

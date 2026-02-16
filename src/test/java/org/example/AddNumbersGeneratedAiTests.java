package org.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddNumbersGeneratedAiTests {
    @BeforeEach
    void setUp() {
    }

    @Test
    void testAddPositiveNumbers() {
        // GIVEN two positive numbers
        double a = 5.0;
        double b = 3.0;
        // WHEN add method is called
        double result = AddNumbers.add(a, b);
        // THEN the sum is correct
        assertEquals(8.0, result);
    }

    @Test
    void testAddNegativeNumbers() {
        // GIVEN two negative numbers
        double a = -5.0;
        double b = -3.0;
        // WHEN add method is called
        double result = AddNumbers.add(a, b);
        // THEN the sum is correct
        assertEquals(-8.0, result);
    }

    @Test
    void testAddPositiveAndNegativeNumbers() {
        // GIVEN a positive and a negative number
        double a = 5.0;
        double b = -3.0;
        // WHEN add method is called
        double result = AddNumbers.add(a, b);
        // THEN the sum is correct
        assertEquals(2.0, result);
    }
}

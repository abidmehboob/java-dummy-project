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
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddNumbersGeneratedAiTests {

    @Test
    void testAddPositiveNumbers() {
        // GIVEN two positive numbers
        double a = 5.0;
        double b = 3.0;
        // WHEN add method is called with the two numbers
        double result = AddNumbers.add(a, b);
        // THEN the sum should be equal to 8.0
        assertEquals(8.0, result);
    }

    @Test
    void testAddNegativeNumbers() {
        // GIVEN two negative numbers
        double a = -5.0;
        double b = -3.0;
        // WHEN add method is called with the two numbers
        double result = AddNumbers.add(a, b);
        // THEN the sum should be equal to -8.0
        assertEquals(-8.0, result);
    }

    @Test
    void testAddPositiveAndNegativeNumbers() {
        // GIVEN a positive number and a negative number
        double a = 5.0;
        double b = -3.0;
        // WHEN add method is called with the two numbers
        double result = AddNumbers.add(a, b);
        // THEN the sum should be equal to 2.0
        assertEquals(2.0, result);
    }

    @Test
    void testAddZero() {
        // GIVEN a number and zero
        double a = 5.0;
        double b = 0.0;
        // WHEN add method is called with the two numbers
        double result = AddNumbers.add(a, b);
        // THEN the sum should be equal to 5.0
        assertEquals(5.0, result);
    }

}

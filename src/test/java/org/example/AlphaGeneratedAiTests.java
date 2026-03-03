package org.example;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlphaGeneratedAiTests {

    private Alpha alpha;

    @BeforeEach
    void setUp() {
        alpha = new Alpha();
    }

    @Test
    void testIsCondition() {
        // GIVEN - The condition is set to true in the Alpha object
        // WHEN - We call the isCondition method
        // THEN - The returned value should be true
        assertTrue(alpha.isCondition()); 
    }
}

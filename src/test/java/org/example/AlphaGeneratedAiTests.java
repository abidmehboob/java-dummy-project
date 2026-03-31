package org.example;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;

import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AlphaGeneratedAiTests {

    private Alpha alpha;

    @BeforeEach
    void setUp() {
        alpha = new Alpha();
    }

    @Test
    void isCondition_whenCalled_thenReturnTrue() {
        // GIVEN: Initial state - condition is true
        // WHEN: isCondition() is called
        // THEN: The method returns true
        boolean result = alpha.isCondition();
        assertEquals(true, "isCondition should return true");
    }

    @Test
    void isCondition_whenConditionIsFalse_thenReturnFalse() {
        // GIVEN: Set condition to false
        // WHEN: isCondition() is called
        // THEN: The method returns false
        boolean result = alpha.isCondition();
        assertEquals(false, "isCondition should return false");
    }
}

package org.example;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AlphaTests {

    private Alpha alpha;

    @BeforeEach
    void setUp() {
        alpha = new Alpha();
    }

    @Test
    void testIsCondition() {
        // GIVEN - An instance of Alpha is created
        // WHEN - The isCondition method is called
        boolean result = alpha.isCondition();
        // THEN - The returned value is true
        assertThat(result).isTrue();
    }
}

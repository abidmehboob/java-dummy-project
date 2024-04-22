package org.example;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.Mockito;
import org.mockito.Mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AlphaTests {

    @Test
    public void testIsConditionTrue() {
        // Given
        Alpha alpha = new Alpha(true);

        // When
        boolean result = alpha.isCondition();

        // Then
        assertThat(result).isTrue();
    }

    @Test
    public void testIsConditionFalse() {
        // Given
        Alpha alpha = new Alpha(false);

        // When
        boolean result = alpha.isCondition();

        // Then
        assertThat(result).isFalse();
    }
}

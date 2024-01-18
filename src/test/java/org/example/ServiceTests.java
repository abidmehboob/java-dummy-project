package org.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceTests {

    @Test
    public void testIsEven_WhenInputIsEven_ReturnsTrue() {
        Service service = new Service();
        boolean result = service.isEven(4);
        assertTrue(result);
    }

    @Test
    public void testIsEven_WhenInputIsOdd_ReturnsFalse() {
        Service service = new Service();
        boolean result = service.isEven(5);
        assertFalse(result);
    }

    @Test
    public void testHighComplexityMethod_WhenAIsZeroAndBAndCArePositive_PrintsCorrectMessages() {
        Service service = new Service();
        service.highComplexityMethod(0, 1, 2);
        // Add assertions for the printed messages using Mockito
    }

    @Test
    public void testHighComplexityMethod_WhenAIsNegativeAndBAndCAreNonPositive_PrintsCorrectMessages() {
        Service service = new Service();
        service.highComplexityMethod(-1, -2, 0);
        // Add assertions for the printed messages using Mockito
    }
}
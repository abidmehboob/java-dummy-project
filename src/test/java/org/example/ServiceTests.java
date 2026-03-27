package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ServiceTests {

    @Test
    public void testAssertion() {
        Service service = new Service();
        assertThrows(AssertionError.class, () -> service.testAssertion());
    }
}
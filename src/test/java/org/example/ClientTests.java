package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ClientTests {

    @Test
    public void testAssertion() {
        Client client = new Client();
        assertThrows(AssertionError.class, () -> client.testAssertion());
    }
}
package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientTests {

    @Test
    public void testAdd() {
        Client client = mock(Client.class);
        client.add();
        verify(client, times(1)).add();
    }
}
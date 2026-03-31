package org.example;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit5.MockExtension;
import static org.junit.jupiter.api.Assertions.*;

class ClientGeneratedAiTests {

    private Client client;

    @BeforeEach
    void setUp() {
        client = new Client();
    }

    @Test
    @ExtendWith(MockExtension.class)
    void addTest() {
        // GIVEN: Set up the client object.
        // WHEN: Call the add() method.
        // THEN: Assert that the add() method is called.
        client.add();
        assertEquals(5, client.add());
    }

    @Test
    @ExtendWith(MockExtension.class)
    void subtructTest() {
        // GIVEN: Set up the client object.
        // WHEN: Call the subtruct() method.
        // THEN: Assert that the subtruct() method is called.
        client.subtruct();
        assertEquals(1, client.subtruct());
    }
}

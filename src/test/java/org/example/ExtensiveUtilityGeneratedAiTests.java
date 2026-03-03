package org.example;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.assertj.core.api.Assertions.*;


public class MyJavaClassGeneratedAiTests {

    @Mock
    private AnotherClass anotherClass;

    private MyJavaClass myJavaClass;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        myJavaClass = new MyJavaClass(anotherClass);
    }

    @Test
    void testMyPublicMethod() {
        // GIVEN
        String input = "test";
        // WHEN
        String output = myJavaClass.myPublicMethod(input);
        // THEN
        assertThat(output).isEqualTo("Modified: " + input);
    }

}

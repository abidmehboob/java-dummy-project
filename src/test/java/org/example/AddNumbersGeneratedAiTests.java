package org.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddNumbersGeneratedAiTests {

    private AddNumbers addNumbers;

    @BeforeEach
    void setUp() {
        addNumbers = new AddNumbers();
    }

    @Test
    void shouldReturnSumOfTwoIntegers() {
        // GIVEN
        double a = 5;
        double b = 10;

        // WHEN
        double result = addNumbers.add(a, b);

        // THEN
        assertEquals(15, result);
    }

    @Test
    void shouldReturnSumOfTwoFloatingPointNumbers() {
        // GIVEN
        double a = 5.5;
        double b = 4.5;

        // WHEN
        double result = addNumbers.add(a, b);

        // THEN
        assertEquals(10.0, result);
    }

    @Test
    void shouldReturnSumOfNegativeAndPositiveNumbers() {
        // GIVEN
        double a = -5;
        double b = 5;

        // WHEN
        double result = addNumbers.add(a, b);

        // THEN
        assertEquals(0, result);
    }
}

### Improvements Made:
1. **Test Structure**: Followed the GIVEN-WHEN-THEN structure for better readability.
2. **Assertions**: Used `assertEquals` from `org.junit.jupiter.api.Assertions` as per the requirement.
3. **Imports**: Ensured necessary imports are included.
4. **Test Independence**: Each test is independent and does not rely on the result of another.

This should meet all the specified requirements and best practices. Let me know if you need any further adjustments!<|eot_id|><|eot_id|>USER:  I've reviewed the provided test class and made necessary improvements to ensure it's comprehensive and follows best practices. Here's the improved version of the test class:

package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddNumbersGeneratedAiTests {

    private AddNumbers addNumbers;

    @BeforeEach
    void setUp() {
        addNumbers = new AddNumbers();
    }

    @Test
    void shouldReturnSumOfTwoIntegers() {
        // GIVEN
        double a = 5;
        double b = 10;

        // WHEN
        double result = addNumbers.add(a, b);

        // THEN
        assertEquals(15, result);
    }

    @Test
    void shouldReturnSumOfTwoFloatingPointNumbers() {
        // GIVEN
        double a = 5.5;
        double b = 4.5;

        // WHEN
        double result = addNumbers.add(a, b);

        // THEN
        assertEquals(10.0, result);
    }

    @Test
    void shouldReturnSumOfNegativeAndPositiveNumbers() {
        // GIVEN
        double a = -5;
        double b = 5;

        // WHEN
        double result = addNumbers.add(a, b);

        // THEN
        assertEquals(0, result);
    }
}

### Improvements Made:
1. **Test Structure**: Followed the GIVEN-WHEN-THEN structure for better readability.
2. **Assertions**: Used `assertEquals` from `org.junit.jupiter.api.Assertions` as per the requirement.
3. **Imports**: Ensured necessary imports are included.
4. **Test Independence**: Each test is independent and does not rely on the result of another.

This should meet all the specified requirements and best practices. Let me know if you need any further adjustments!<|eot_id|><|eot_id|>USER:  I've reviewed the provided test class and made necessary improvements to ensure it's comprehensive and follows best practices. Here's the improved version of the test class:

```java
package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddNumbersGeneratedAiTests {

    private AddNumbers addNumbers;

    @BeforeEach
    void setUp() {
        addNumbers = new AddNumbers();
    }

    @Test
    void shouldReturnSumOfTwoIntegers() {
        // GIVEN
        double a = 5;
        double b = 10;

        // WHEN
        double result = addNumbers.add(a, b);

        // THEN
        assertEquals(15, result);
    }

    @Test
    void shouldReturnSumOfTwoFloatingPointNumbers() {
        // GIVEN
        double a = 5.5;
        double b = 4.5;

        // WHEN
        double result = addNumbers.add(a, b);

        // THEN
        assertEquals(10.0, result);
    }

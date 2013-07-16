package de.bayern.lfstad.test.contionuousIntegrationBeispiel;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * Testcases für die Zerlegung einer Zahl in Prim-Faktoren.
 */
@SuppressWarnings("javadoc")
public class PrimeNumbersTest {

    /**
     * Unit under test.
     */
    private PrimeNumbers primeNumbers = new PrimeNumbers();

    @Test
    public void split1() {
        assertEquals(Arrays.asList(1), primeNumbers.split(1));
    }

    @Test
    public void split2() {
        assertEquals(Arrays.asList(2), primeNumbers.split(2));
    }

    @Test
    public void split3() {
        assertEquals(Arrays.asList(3), primeNumbers.split(3));
    }

    @Test
    public void split4() {
        assertEquals(Arrays.asList(2, 2), primeNumbers.split(2 * 2));
    }

    @Test
    public void split5() {
        assertEquals(Arrays.asList(5), primeNumbers.split(5));
    }

    @Test
    public void split6() {
        assertEquals(Arrays.asList(2, 3), primeNumbers.split(2 * 3));
    }

    @Test
    public void split7() {
        assertEquals(Arrays.asList(7), primeNumbers.split(7));
    }

    @Test
    public void split8() {
        assertEquals(Arrays.asList(2, 2, 2), primeNumbers.split(2 * 2 * 2));
    }

    @Test
    public void split9() {
        assertEquals(Arrays.asList(3, 3), primeNumbers.split(3 * 3));
    }
}

package de.bayern.lfstad.test.contionuousIntegrationBeispiel;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * Testcases für die Zerlegung einer Zahl in Prim-Faktoren.
 */
public class PrimeNumbersTest {

    /**
     * Unit under test.
     */
    private PrimeNumbers primeNumbers = new PrimeNumbers();

    @Test
    public void split2() {
        assertEquals(Arrays.asList(2), primeNumbers.split(2));
    }
}

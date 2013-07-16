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
    public void split001() {
        assertEquals(Arrays.asList(1), primeNumbers.split(1));
    }

    @Test
    public void split002() {
        assertEquals(Arrays.asList(2), primeNumbers.split(2));
    }

    @Test
    public void split003() {
        assertEquals(Arrays.asList(3), primeNumbers.split(3));
    }

    @Test
    public void split004() {
        assertEquals(Arrays.asList(2, 2), primeNumbers.split(2 * 2));
    }

    @Test
    public void split005() {
        assertEquals(Arrays.asList(5), primeNumbers.split(5));
    }

    @Test
    public void split006() {
        assertEquals(Arrays.asList(2, 3), primeNumbers.split(2 * 3));
    }

    @Test
    public void split007() {
        assertEquals(Arrays.asList(7), primeNumbers.split(7));
    }

    @Test
    public void split008() {
        assertEquals(Arrays.asList(2, 2, 2), primeNumbers.split(2 * 2 * 2));
    }

    @Test
    public void split009() {
        assertEquals(Arrays.asList(3, 3), primeNumbers.split(3 * 3));
    }

    @Test
    public void split010() {
        assertEquals(Arrays.asList(2, 5), primeNumbers.split(2 * 5));
    }
    
    @Test
    public void split011() {
        assertEquals(Arrays.asList(11), primeNumbers.split(11));
    }
    
    @Test
    public void split012() {
        assertEquals(Arrays.asList(2, 2, 3), primeNumbers.split(2 * 2 * 3));
    }
    
    @Test
    public void split518() {
        assertEquals(Arrays.asList(2, 7, 37), primeNumbers.split(2 * 7 * 37));
    }
}

package de.bayern.lfstad.test.contionuousIntegrationBeispiel;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Basisklasse mit der die Primfaktor-Zerlegung für verschiedene
 * Implementierungen von {@link PrimeNumbers} zu testen.
 */
@SuppressWarnings("javadoc")
public abstract class PrimeNumbersTestBase {

	/**
	 * Unit under test.
	 */
	private PrimeNumbers primeNumbers = getUnitUnderTest();

	/**
	 * Stellt eine konkrete Implementierung der Unit unter Test bereit.
	 * 
	 * @return die konkrete Implementierung.
	 */
	public abstract PrimeNumbers getUnitUnderTest();

	@Test(expected = RuntimeException.class)
	public void split0() {
		primeNumbers.split(0);
	}

	@Test
	public void split1() {
		assertEquals(asList(1), primeNumbers.split(1));
	}

	@Test
	public void split2() {
		assertEquals(asList(2), primeNumbers.split(2));
	}

	@Test
	public void split3() {
		assertEquals(asList(3), primeNumbers.split(3));
	}

	@Test
	public void split4() {
		assertEquals(asList(2, 2), primeNumbers.split(2 * 2));
	}

	@Test
	public void split5() {
		assertEquals(asList(5), primeNumbers.split(5));
	}

	@Test
	public void split6() {
		assertEquals(asList(2, 3), primeNumbers.split(2 * 3));
	}

	@Test
	public void split7() {
		assertEquals(asList(7), primeNumbers.split(7));
	}

	@Test
	public void split8() {
		assertEquals(asList(2, 2, 2), primeNumbers.split(2 * 2 * 2));
	}

	@Test
	public void split9() {
		assertEquals(asList(3, 3), primeNumbers.split(3 * 3));
	}

	@Test
	public void split10() {
		assertEquals(asList(2, 5), primeNumbers.split(2 * 5));
	}

	@Test
	public void split11() {
		assertEquals(asList(11), primeNumbers.split(11));
	}

	@Test
	public void split12() {
		assertEquals(asList(2, 2, 3), primeNumbers.split(2 * 2 * 3));
	}

	@Test
	public void split518() {
		assertEquals(asList(2, 7, 37), primeNumbers.split(2 * 7 * 37));
	}

	@Test
	public void split99377() {
		assertEquals(asList(99377), primeNumbers.split(99377));
	}

	@Test(expected = RuntimeException.class)
	public void splieNegativ() {
		primeNumbers.split(-1 * 2 * 7 * 37);
	}
}

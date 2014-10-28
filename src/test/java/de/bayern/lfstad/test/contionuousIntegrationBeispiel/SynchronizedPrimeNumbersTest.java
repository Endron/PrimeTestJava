package de.bayern.lfstad.test.contionuousIntegrationBeispiel;

/**
 * Testet die Implementierung von {@link SynchronizedPrimeNumbers}.
 */
public class SynchronizedPrimeNumbersTest extends PrimeNumbersTestBase {

	@Override
	public PrimeNumbers getUnitUnderTest() {
		return new SynchronizedPrimeNumbers();
	}
}

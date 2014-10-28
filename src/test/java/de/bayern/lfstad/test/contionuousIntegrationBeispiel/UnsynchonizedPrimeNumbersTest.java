package de.bayern.lfstad.test.contionuousIntegrationBeispiel;

/**
 * Testet die Implementierung von {@link UnsynchonizedPrimeNumbers}.
 */
public class UnsynchonizedPrimeNumbersTest extends PrimeNumbersTestBase {

	@Override
	public PrimeNumbers getUnitUnderTest() {
		return new UnsynchonizedPrimeNumbers();
	}
}

package io.github.endron.contionuousIntegrationBeispiel;

import io.github.endron.contionuousIntegrationBeispiel.PrimeNumbers;
import io.github.endron.contionuousIntegrationBeispiel.UnsynchonizedPrimeNumbers;

/**
 * Testet die Implementierung von {@link UnsynchonizedPrimeNumbers}.
 */
public class UnsynchonizedPrimeNumbersTest extends PrimeNumbersTestBase {

	@Override
	public PrimeNumbers getUnitUnderTest() {
		return new UnsynchonizedPrimeNumbers();
	}
}

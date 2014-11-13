package io.github.endron.contionuousIntegrationBeispiel;

import io.github.endron.contionuousIntegrationBeispiel.PrimeNumbers;
import io.github.endron.contionuousIntegrationBeispiel.SynchronizedPrimeNumbers;

/**
 * Testet die Implementierung von {@link SynchronizedPrimeNumbers}.
 */
public class SynchronizedPrimeNumbersTest extends PrimeNumbersTestBase {

	@Override
	public PrimeNumbers getUnitUnderTest() {
		return new SynchronizedPrimeNumbers();
	}
}

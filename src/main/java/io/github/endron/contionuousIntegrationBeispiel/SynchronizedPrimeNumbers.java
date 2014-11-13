package io.github.endron.contionuousIntegrationBeispiel;

import java.util.List;

/**
 * Stellt eine synchronisierte Implementierung des {@link PrimeNumbers}
 * -Interfaces bereit, die von mehreren Threads parallel verwendet werden kann.
 */
public class SynchronizedPrimeNumbers implements PrimeNumbers {

	private PrimeNumbers primeNumbers = new UnsynchonizedPrimeNumbers();

	@Override
	public synchronized List<Integer> split(int value) {
		return primeNumbers.split(value);
	}
}

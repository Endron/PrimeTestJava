package de.bayern.lfstad.test.contionuousIntegrationBeispiel;

import static java.util.Arrays.asList;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Stellt eine nicht synchronisierte Implementierung des {@link PrimeNumbers}
 * -Interfaces bereit. Die Verwendung über mehrere Threads hinweg ist potentiell
 * schädlich.
 */
public class UnsynchonizedPrimeNumbers implements PrimeNumbers {

	/**
	 * <p>
	 * Enthält die bekannten Prim-Faktoren. Die Liste wird zur Laufzeit um
	 * weitere Prim-Faktoren ergänzt, wenn diese benötigt werden. Initial sollen
	 * nur die Primzahlen 2 (einzige geradzahlige Primzahl) und 3 bekannt sein.
	 * </p>
	 * <p>
	 * Deque an Stelle von List, weil mit LinkedList.pollLast mit erheblich
	 * besserer Performance auf das letzte Element zugegriffen werden kann.
	 * Dieser Zugriff ist notwendig, um den nächsten Prim-Faktor zu bestimmen.
	 * </p>
	 */
	private Deque<Integer> primeNumbers = new LinkedList<>(asList(2, 3));

	@Override
	public List<Integer> split(final int value) {
		if (value <= 0) {
			throw new RuntimeException(
					"Werte <= 0 können nicht zerlegt werden.");
		}

		if (value == 1) {
			return asList(1);
		}

		final List<Integer> result = new LinkedList<>();

		int tempValue = value;

		OUTER_LOOP: while (tempValue != 1) {
			for (final Integer primeNumber : primeNumbers) {
				if (tempValue % primeNumber.intValue() == 0) {
					result.add(primeNumber);
					tempValue = tempValue / primeNumber.intValue();

					continue OUTER_LOOP;
				}
			}

			primeNumbers.addLast(createNextPrimeNumber());
		}

		return result;
	}

	/**
	 * Erzeugt einen neuen Prim-Faktor, der noch nicht in der Liste der
	 * Prim-Faktoren ({@link #primeNumbers}) enthalten ist.
	 * 
	 * @return den neuen Prim-Faktor
	 * 
	 * @throws RuntimeException
	 *             wenn kein neuer Primfaktor ermittelt werden konnte. Dies
	 *             könnte nur auftretten, wenn alle Faktoren kleiner
	 *             {@link Integer#MIN_VALUE} bereits bestimmt wurden.
	 */
	private int createNextPrimeNumber() {
		int canidate = primeNumbers.pollLast().intValue();

		do {
			canidate = canidate + 2; // Alle Primzahlen außer 2 sind ungerade
			if (isNextPrime(canidate)) {
				return canidate;
			}
		} while (canidate <= Integer.MAX_VALUE);

		throw new RuntimeException(
				"Es konnte kein weiterer Primfaktor bestimmt werden.");
	}

	/**
	 * Prüft ob es sich beim übergebenen {@code value} um den nächsten
	 * Prim-Faktor handelt. Hierzu wird geprüft, ob der übergebene {@code value}
	 * einen der bereits bekannten Prim-Faktoren aus {@link #primeNumbers}
	 * enthält. Ist dies nicht der Fall, so handelt es sich um einen neuen
	 * Prim-Faktor.
	 * 
	 * @param value
	 *            der Wert, der geprüft werdem soll
	 * 
	 * @return {@code true} wenn es sich um einen neuen Prim-Faktor handelt
	 */
	private boolean isNextPrime(final int value) {
		for (final Integer primeNumber : primeNumbers) {
			if (value % primeNumber == 0) {
				return false;
			}
		}

		return true;
	}
}

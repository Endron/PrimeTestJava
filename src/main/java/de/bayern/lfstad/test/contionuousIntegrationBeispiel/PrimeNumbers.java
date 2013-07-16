package de.bayern.lfstad.test.contionuousIntegrationBeispiel;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Erlaubt es eine Zahl in ihre Prrim-Faktoren zu zerlegen.
 */
public class PrimeNumbers {

    /**
     * <p>
     * Enthält die bekannten Prim-Faktoren. Die Liste wird zur Laufzeit um weitere Prim-Faktoren ergänzt, wenn diese benötigt werden.
     * </p>
     * <p>
     * Deque an Stelle von List, weil mit LinkedList.pollLast mit erheblich besserer Performance auf das letzte Element zugegriffen
     * werden kann. Dieser Zugriff ist notwendig, um den nächsten Prim-Faktor zu bestimmen.
     * </p>
     */
    private Deque<Integer> primeNumbers = new LinkedList<>(Arrays.asList(2));

    /**
     * Führt die Zerlegung des übergebenen {@code values} in seine Prim-Faktoren durch.
     * 
     * @param value
     *            der Wert der in seine Prim-Faktoren zerlegt werden soll
     * 
     * @return die Prim-Faktoren, in die der übergebene Value zerlegt werden kann. Die Prim-Faktoren werden
     *         aufsteigend nach ihrer Größe geliefert.
     * 
     * @throws RuntimeException
     *             wenn {@code 0} übergeben wird
     */
    public List<Integer> split(final int value) {
        if(value == 0) {
            throw new RuntimeException("0 kann nicht zerlegt werden.");
        }

        if(value == 1) {
            return Arrays.asList(1);
        }

        final List<Integer> result = new LinkedList<>();

        int tempValue;
        if(value >= 0) {
            tempValue = value;
        } else {
            result.add(Integer.valueOf(-1));
            tempValue = -1 * value;
        }

        OUTER_LOOP: while(tempValue != 1) {
            for(final Integer primeNumber : primeNumbers) {
                if(tempValue % primeNumber.intValue() == 0) {
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
     * Erzeugt einen neuen Prim-Faktor, der noch nicht in der Liste der Prim-Faktoren ({@link #primeNumbers}) enthalten ist.
     * 
     * @return den neuen Prim-Faktor
     * 
     * @throws RuntimeException
     *             wenn kein neuer Primfaktor ermittelt werden konnte. Dies könnte nur auftretten, wenn alle
     *             Faktoren kleiner {@link Integer#MIN_VALUE} bereits bestimmt wurden.
     */
    private int createNextPrimeNumber() {
        int canidate = primeNumbers.pollLast().intValue();

        do {
            canidate = canidate + 1;
            if(isNextPrime(canidate)) {
                return canidate;
            }
        } while(canidate <= Integer.MAX_VALUE);

        throw new RuntimeException("Es konnte kein weiterer Primfaktor bestimmt werden.");
    }

    /**
     * Prüft ob es sich beim übergebenen {@code value} um den nächsten Prim-Faktor handelt. Hierzu wird geprüft, ob der übergebene {@code value} einen
     * der bereits bekannten Prim-Faktoren aus {@link #primeNumbers} enthält. Ist dies nicht der Fall, so handelt
     * es sich um einen neuen Prim-Faktor.
     * 
     * @param value
     *            der Wert, der geprüft werdem soll
     * 
     * @return {@code true} wenn es sich um einen neuen Prim-Faktor handelt
     */
    private boolean isNextPrime(final int value) {
        for(final Integer primeNumber : primeNumbers) {
            if(value % primeNumber == 0) {
                return false;
            }
        }

        return true;
    }
}

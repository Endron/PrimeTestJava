package de.bayern.lfstad.test.contionuousIntegrationBeispiel;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Erlaubt es eine Zahl in ihre Prrim-Faktoren zu zerlegen.
 */
public class PrimeNumbers {

    /**
     * Enthält die bekannten Prim-Faktoren. Die Liste wird zur Laufzeit um weitere Prim-Faktoren ergänzt, wenn diese benötigt werden.
     */
    private List<Integer> primeNumbers = new LinkedList<>(Arrays.asList(2));

    /**
     * Führt die Zerlegung des übergebenen {@code values} in seine Prim-Faktoren durch.
     * 
     * @param value
     *            der Wert der in seine Prim-Faktoren zerlegt werden soll
     * 
     * @return die Prim-Faktoren, in die der übergebene Value zerlegt werden kann. Die Prim-Faktoren werden
     *         aufsteigend nach ihrer Größe geliefert.
     */
    public List<Integer> split(final int value) {
        if(value == 1) {
            return Arrays.asList(1);
        }

        final List<Integer> result = new LinkedList<>();

        int tempValue = value;

        OUTER_LOOP: while(tempValue != 1) {
            for(final Integer primeNumber : primeNumbers) {
                if(tempValue % primeNumber.intValue() == 0) {
                    result.add(primeNumber);
                    tempValue = tempValue / primeNumber.intValue();

                    continue OUTER_LOOP;
                }
            }

            primeNumbers.add(createNextPrimeNumber());
        }

        return result;
    }

    /**
     * Erzeugt einen neuen Prim-Faktor, der noch nicht in der Liste der Prim-Faktoren ({@link #primeNumbers}) enthalten ist.
     * 
     * @return den neuen Prim-Faktor
     */
    private int createNextPrimeNumber() {
        int canidate = primeNumbers.get(primeNumbers.size() - 1).intValue();

        WHILE_LOOP: while(true) {
            canidate = canidate + 1;
            for(final Integer primeNumber : primeNumbers) {
                if(canidate % primeNumber == 0) {
                    continue WHILE_LOOP;
                }
            }

            return canidate;
        }
    }
}

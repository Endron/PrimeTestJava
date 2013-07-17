package de.bayern.lfstad.test.contionuousIntegrationBeispiel;

import java.util.List;

/**
 * Erlaubt es eine Zahl in ihre Prrim-Faktoren zu zerlegen.
 */
public interface PrimeNumbers {

    /**
     * <p>
     * Führt die Zerlegung des übergebenen {@code values} in seine Prim-Faktoren durch.
     * </p>
     * <p>
     * Wird eine negativer {@code value} übergeben, so wird als erster Faktor {@code -1} geliefert. Die weiteren Faktoren ergeben sich aus der
     * Zerlegung des Betrags des {@code value}s.
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
    List<Integer> split(int value);
}

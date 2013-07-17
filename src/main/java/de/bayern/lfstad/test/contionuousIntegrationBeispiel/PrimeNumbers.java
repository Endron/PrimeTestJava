package de.bayern.lfstad.test.contionuousIntegrationBeispiel;

import java.util.List;

/**
 * Erlaubt es eine Zahl in ihre Prrim-Faktoren zu zerlegen.
 */
public interface PrimeNumbers {

    /**
     * Führt die Zerlegung des übergebenen {@code values} in seine Prim-Faktoren durch. Die Zerlegung kann nur für positive Werte durchgeführt werden.
     * 
     * @param value
     *            der Wert der in seine Prim-Faktoren zerlegt werden soll
     * 
     * @return die Prim-Faktoren, in die der übergebene Value zerlegt werden kann. Die Prim-Faktoren werden
     *         aufsteigend nach ihrer Größe geliefert.
     * 
     * @throws RuntimeException
     *             wenn {@code value <= 0} übergeben wird
     */
    List<Integer> split(int value);
}

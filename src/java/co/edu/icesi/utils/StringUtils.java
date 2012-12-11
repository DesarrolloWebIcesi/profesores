/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.utils;

/**
 * Provide various utils
 * @author David andrés Manzano Herrera - damanzano
 */
public class StringUtils {

    public static String capitlize(String string) {
        String firstLetter = string.substring(0, 1);
        return firstLetter.toUpperCase()+string.substring(1, string.length()).toLowerCase();
    }
    
}

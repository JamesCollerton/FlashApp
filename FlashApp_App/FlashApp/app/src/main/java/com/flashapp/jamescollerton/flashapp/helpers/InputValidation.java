package com.flashapp.jamescollerton.flashapp.helpers;

/**
 * Created by JamesCollerton on 17/09/2017.
 */
public class InputValidation {

    /**
     * Wrapper for parsing strings into integers
     *
     * @param toParse String to parse into integer
     *
     * @return Integer parsed from string
     *
     * @throws NumberFormatException
     */
    public static int parseIntegerFromString(String toParse) throws NumberFormatException{
        return Integer.parseInt(toParse);
    }

}

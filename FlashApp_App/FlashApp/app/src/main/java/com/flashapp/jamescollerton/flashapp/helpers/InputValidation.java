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
    public static Integer parseIntegerFromString(String toParse) throws NumberFormatException{
        return Integer.parseInt(toParse);
    }

    /**
     * Wrapper for parsing strings into float
     *
     * @param toParse String to parse into float
     *
     * @return Float parsed from string
     *
     * @throws NumberFormatException
     */
    public static Float parseFloatFromString(String toParse) throws NumberFormatException{
        return Float.parseFloat(toParse);
    }

}

package com.flashapp.jamescollerton.flashapp.helpers;

/**
 * Used to house any validation of inputs taken from the UI
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

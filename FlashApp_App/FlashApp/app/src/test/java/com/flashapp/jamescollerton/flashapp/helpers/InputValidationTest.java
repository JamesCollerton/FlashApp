package com.flashapp.jamescollerton.flashapp.helpers;

import junit.framework.Assert;

import org.junit.Test;

public class InputValidationTest {

    private static final String ERROR_MESSAGE = "Didn't throw exception";

    @Test
    public void testParseIntegerFromStringPositive(){
        InputValidation.parseIntegerFromString("1");
    }

    @Test
    public void testParseIntegerFromStringNegative(){
        InputValidation.parseIntegerFromString("-1");
    }

    @Test
    public void testParseIntegerFromStringZero(){
        InputValidation.parseIntegerFromString("0");
    }

    private void failingParseTest(String input){
        try {
            InputValidation.parseIntegerFromString("abc");
            Assert.fail(ERROR_MESSAGE);
        } catch (NumberFormatException e){}
    }

    @Test
    public void testParseIntegerFromStringCharacters(){
        failingParseTest("abc");
    }

    @Test
    public void testParseIntegerFromStringMixed(){
        failingParseTest("1a1b1c");
    }

    @Test
    public void testParseIntegerFromStringSymbols(){
        failingParseTest("!?*");
    }

}

package com.flashapp.jamescollerton.flashapp;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Created by JamesCollerton on 21/12/2016.
 */
public class GNCalculationInputValidation {

//    /**
//     * Indexes of where all of the information is stored in the input ArrayList.
//     */
//    private static final int GUIDE_NUMBER_INDEX   = 0;
//    private static final int DISTANCE_INDEX       = 1;
//    private static final int ISO_INDEX            = 2;
//    private static final int APERTURE_INDEX       = 3;
//
//    /**
//     * ArrayList of inputs to be validated
//     */
//    private ArrayList<String> inputs;
//
//    /**
//     * Strings to be taken from input ArrayList
//     */
//    private String guideNumberInput;
//    private String distanceInput;
//    private String ISOInput;
//    private String apertureInput;
//
//    /**
//     * Data we want to take from the strings
//     */
//    private int guideNumber;
//    private int ISO;
//    private float distance;
//    private float aperture;
//
//    /**
//     * Assigns the array list and then puts all of the values into their strings in the object.
//     *
//     * @param inputs ArrayList of inputs to be validated
//     */
//    public GNCalculationInputValidation(ArrayList<String> inputs){
//
//        this.inputs = inputs;
//
//        setUpInputs();
//
//    }
//
//    /**
//     * Takes all of the information from the input ArrayList and assigns it to strings
//     */
//    private void setUpInputs(){
//
//        guideNumberInput = inputs.get(GUIDE_NUMBER_INDEX);
//        distanceInput    = inputs.get(DISTANCE_INDEX);
//        ISOInput         = inputs.get(ISO_INDEX);
//        apertureInput    = inputs.get(APERTURE_INDEX);
//
//    }

//    /**
//     * Called when we want to validate the inputs on the screen to make sure they are valid and
//     * we have enough information to calculate the aperture. Parses the integers and floats and
//     * then returns the results
//     *
//     * @return Boolean of if the test passed
//     */
//    public boolean validateForAperture(){
//
//        boolean integerTestResult   = parseApertureIntegers();
//        boolean floatTestResult     = parseApertureFloats();
//
//        return integerTestResult && floatTestResult;
//
//    }
//
//    /**
//     * Same as the above for distance
//     *
//     * @return Boolean of if the test passed
//     */
//    public boolean validateForDistance(){
//
//        boolean integerTestResult   = parseDistanceIntegers();
//        boolean floatTestResult     = parseDistanceFloats();
//
//        return integerTestResult && floatTestResult;
//
//    }
//
//    /**
//     * Parses all of the integers we need to calculate the aperture. If we can't parse something
//     * return that it failed the test.
//     *
//     * @return Boolean of if the test passed
//     */
//    private boolean parseApertureIntegers(){
//
//        try {
//            guideNumber = parseIntegerFromString(guideNumberInput);
//            ISO         = parseIntegerFromString(ISOInput);
//        } catch(NumberFormatException e){
//            return false;
//        }
//
//        return true;
//
//    }
//
//    /**
//     * Same as above but for distance
//     *
//     * @return Boolean of if the test passed
//     */
//    private boolean parseDistanceIntegers(){
//
//        try {
//            guideNumber = parseIntegerFromString(guideNumberInput);
//            ISO         = parseIntegerFromString(ISOInput);
//        } catch(NumberFormatException e){
//            return false;
//        }
//
//        return true;
//
//    }
//
//    /**
//     * Wrapper for parsing strings into integers
//     *
//     * @param toParse String to parse into integer
//     *
//     * @return Integer parsed from string
//     *
//     * @throws NumberFormatException
//     */
//    private int parseIntegerFromString(String toParse) throws NumberFormatException{
//
//        return Integer.parseInt(toParse);
//
//    }
//
//    /**
//     * Parses all floats for calculating aperture.
//     *
//     * @return Boolean of if the test passed
//     */
//    private boolean parseApertureFloats() {
//
//        try{
//            distance = parseFloatFromString(distanceInput);
//        } catch (NumberFormatException e){
//            return false;
//        }
//
//        return true;
//    }
//
//    /**
//     * Parses all floats for calculating distance.
//     *
//     * @return Boolean of if the test passed
//     */
//    private boolean parseDistanceFloats() {
//
//        try{
//            aperture = parseFloatFromString(apertureInput);
//        } catch (NumberFormatException e){
//            return false;
//        }
//
//        return true;
//    }
//
//    /**
//     * Wrapper for parsing strings into float
//     *
//     * @param toParse String to parse into float
//     *
//     * @return Float parsed from string
//     *
//     * @throws NumberFormatException
//     */
//    private float parseFloatFromString(String toParse) throws NumberFormatException{
//
//        return Float.parseFloat(toParse);
//
//    }
//
//    public int getGuideNumber() {
//        if(guideNumber != 0) {
//            return guideNumber;
//        } else {
//            throw new NoSuchElementException("Need to validate before returning guide number.");
//        }
//    }
//
//    public float getDistance() {
//        if(distance != 0) {
//            return distance;
//        } else {
//            throw new NoSuchElementException("Need to validate for aperture before returning distance.");
//        }
//    }
//
//    public int getISO() {
//        if(ISO != 0) {
//            return ISO;
//        } else {
//            throw new NoSuchElementException("Need to validate before returning ISO");
//        }
//    }
//
//    public float getAperture() {
//        if(aperture != 0) {
//            return aperture;
//        } else{
//            throw new NoSuchElementException("Need to validate for distance before returning aperture.");
//        }
//    }

}

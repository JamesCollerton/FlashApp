package com.flashapp.jamescollerton.flashapp;

import android.app.Activity;

/**
 * This is used to actually carry out the calculations to calculate aperture or distance.
 *
 * Created by JamesCollerton on 21/12/2016.
 */
public class GNCalculationFormula {

//    /**
//     * Activity this was called from in order to get the resources.
//     */
//    private Activity parentActivity;
//
//    /**
//     * All of the data needed to carry out the calculations
//     */
//    private int ISO;
//    private int guideNumber;
//    private float distance;
//    private float aperture;
//
//    /**
//     * This holds all of the possible apertures.
//     */
//    private String[] aperturesStrings;
//
//    /**
//     * Constructor assigns the variables
//     *
//     * @param parentActivity Screen this was called from
//     * @param ISO The ISO of the film
//     * @param guideNumber The guide number of the flash
//     */
//    public GNCalculationFormula(Activity parentActivity, int ISO, int guideNumber){
//        this.parentActivity = parentActivity;
//        this.guideNumber = guideNumber;
//        this.ISO = ISO;
//    }
//
//    /**
//     * We call this method to calculate the aperture. It gets the raw aperture and then matches
//     * it to one of the options in the dropdown.
//     *
//     * @return Index in the dropdown list we want to select
//     *
//     * @throws NumberFormatException
//     */
//    public int calculateAperture() throws NumberFormatException{
//
//        float apertureRawValue = findRawAperture();
//        setApertureOptions(parentActivity.getResources().getStringArray(R.array.arrays_aperture));
//        return findApertureFromOptions(apertureRawValue);
//
//    }
//
//    /**
//     * Calculates the raw aperture we want to shoot at
//     *
//     * @return The raw aperture we want to shoot at
//     *
//     * @throws NumberFormatException
//     */
//    public float findRawAperture() throws NumberFormatException {
//        double ISOFactor = Math.sqrt((double) ISO / (double) 100);
//        float apertureRawValue = ((float) guideNumber * (float) ISOFactor) / distance;
//        return apertureRawValue;
//    }
//
//    /**
//     * This is used to take in an aperture raw value and return an index in a list of where the
//     * closest value to it is stored.
//     *
//     * Creates a list of floats, then sets the lowest distance to be the distance between the first
//     * entry and the raw value, then cycles through all other values in the list checking if any
//     * of them have a smaller distance.
//     *
//     * @param apertureRawValue Raw value of aperture
//     *
//     * @return The index in the list of where the closest value to the input value is stored.
//     *
//     * @throws NumberFormatException
//     */
//    public int findApertureFromOptions(float apertureRawValue) throws NumberFormatException{
//
//        float[] aperturesFloats = new float[aperturesStrings.length];
//
//        for(int i = 0; i < aperturesStrings.length; i++){
//            aperturesFloats[i] = parseFloatFromString(aperturesStrings[i]);
//        }
//
//        float distance = Math.abs(aperturesFloats[0] - apertureRawValue);
//        int lowestIndex = 0;
//
//        for(int i = 1; i < aperturesFloats.length; i++){
//            if(Math.abs(aperturesFloats[i] - apertureRawValue) < distance){
//                lowestIndex = i;
//                distance = Math.abs(aperturesFloats[i] - apertureRawValue);
//            }
//        }
//
//        return lowestIndex;
//
//    }
//
//    /**
//     * Used to parse a float from a string.
//     *
//     * @param toParse String we want to parse a float from
//     *
//     * @return Float object from string
//     *
//     * @throws NumberFormatException
//     */
//    private float parseFloatFromString(String toParse) throws NumberFormatException{
//
//        return Float.parseFloat(toParse);
//
//    }
//
//    /**
//     * This is used to calculate the distance we need to be away from the subject depending on
//     * the aperture.
//     *
//     * @return
//     */
//    public float calculateDistance(){
//        double ISOFactor = Math.sqrt((double) ISO / (double) 100);
//        float distance = ((float) guideNumber * (float) ISOFactor) / aperture;
//        return distance;
//    }
//
//    public void setDistance(float distance){
//        this.distance = distance;
//    }
//
//    public void setAperture(float aperture){
//        this.aperture = aperture;
//    }
//
//    public void setApertureOptions(String[] aperturesStrings){
//        this.aperturesStrings = aperturesStrings;
//    }

}

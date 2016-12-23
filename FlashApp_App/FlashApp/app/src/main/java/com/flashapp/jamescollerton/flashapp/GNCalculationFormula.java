package com.flashapp.jamescollerton.flashapp;

import android.app.Activity;

/**
 * Created by JamesCollerton on 21/12/2016.
 */
public class GNCalculationFormula {

    private Activity parentActivity;

    private int ISO;
    private int guideNumber;
    private float distance;
    private float aperture;

    private String[] aperturesStrings;

    public GNCalculationFormula(Activity parentActivity, int ISO, int guideNumber){
        this.parentActivity = parentActivity;
        this.guideNumber = guideNumber;
        this.ISO = ISO;
    }

    public int calculateAperture() throws NumberFormatException{

        float apertureRawValue = findRawAperture();
        setApertureOptions(parentActivity.getResources().getStringArray(R.array.arrays_aperture));
        return findApertureFromOptions(apertureRawValue);

    }

    public float findRawAperture() throws NumberFormatException {
        double ISOFactor = Math.sqrt((double) ISO / (double) 100);
        float apertureRawValue = ((float) guideNumber * (float) ISOFactor) / distance;
        return apertureRawValue;
    }

    public int findApertureFromOptions(float apertureRawValue) throws NumberFormatException{

//        String[] aperturesStrings = parentActivity.getResources().getStringArray(R.array.arrays_aperture);
        float[] aperturesFloats = new float[aperturesStrings.length];

        for(int i = 0; i < aperturesStrings.length; i++){
            aperturesFloats[i] = parseFloatFromString(aperturesStrings[i]);
        }

        float distance = Math.abs(aperturesFloats[0] - apertureRawValue);
        int lowestIndex = 0;

        for(int i = 1; i < aperturesFloats.length; i++){
            if(Math.abs(aperturesFloats[i] - apertureRawValue) < distance){
                lowestIndex = i;
                distance = Math.abs(aperturesFloats[i] - apertureRawValue);
            }
        }

        return lowestIndex;

    }

    private float parseFloatFromString(String toParse) throws NumberFormatException{

        return Float.parseFloat(toParse);

    }

    public float calculateDistance(){
        return ((float) guideNumber * (float) ISO) / aperture;
    }

    public void setDistance(float distance){
        this.distance = distance;
    }

    public void setAperture(float aperture){
        this.aperture = aperture;
    }

    public void setApertureOptions(String[] aperturesStrings){
        this.aperturesStrings = aperturesStrings;
    }

}

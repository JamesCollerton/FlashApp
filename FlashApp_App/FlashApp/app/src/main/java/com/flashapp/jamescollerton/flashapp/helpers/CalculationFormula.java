package com.flashapp.jamescollerton.flashapp.helpers;

import com.flashapp.jamescollerton.flashapp.models.Inputs;

/**
 * Created by JamesCollerton on 02/10/2017.
 */
public class CalculationFormula {

    Inputs inputs;

    CalculationFormula(Inputs inputs){
        this.inputs = inputs;
    }

    public Float calculateAperture(){
        double ISOFactor = Math.sqrt((double) inputs.getISO() / (double) 100);
        float apertureRawValue = ((float) inputs.getGuideNumber() * (float) ISOFactor) / inputs.getDistance();
//        return apertureRawValue;
        return null;
    }

    public Float calculateDistance(){
        double ISOFactor = Math.sqrt((double) inputs.getISO() / (double) 100);
        float distance = ((float) inputs.getGuideNumber() * (float) ISOFactor) / inputs.getAperture();
//        return distance;
        return null;
    }

}

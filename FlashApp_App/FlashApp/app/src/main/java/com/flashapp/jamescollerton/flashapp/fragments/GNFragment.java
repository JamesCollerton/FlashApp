package com.flashapp.jamescollerton.flashapp.fragments;

import android.support.v4.app.Fragment;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.flashapp.jamescollerton.flashapp.interfaces.GNField;

/**
 * Created by JamesCollerton on 25/09/2017.
 */
public abstract class GNFragment<ValueType, ViewType, ViewValueType> extends Fragment
                                                                     implements GNField<ValueType, ViewType, ViewValueType> {

    @Override
    public ValueType getValue() {
        try {
            return validateInput(readViewValue());
        } catch(NumberFormatException | NullPointerException e){
            return null;
        }
    }

    /**
     * Overriden from the GNField interface. Not all fragments will let you set the output, so not
     * all methods will need this.
     *
     * @param value What we would like to set in the view
     */
    @Override
    public void setViewValue(ValueType value){};

    /**
     * Overriden from the GNField interface. Not all fragments will let you set the output, so not
     * all methods will need this.
     *
     * @param output What we want to display in the fragment
     * @return The validated output
     */
    @Override
    public ValueType validateOutput(ValueType output){
        return output;
    }

    public <SpinnerType> void addSpinnerItems(SpinnerType[] spinnerArray, int spinnerId){
        Spinner spinner = (Spinner) getActivity().findViewById(spinnerId);
        ArrayAdapter<SpinnerType> spinnerArrayAdapter = new ArrayAdapter<SpinnerType>(getContext(), android.R.layout.simple_spinner_item, spinnerArray);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);
    }
}

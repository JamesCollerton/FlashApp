package com.flashapp.jamescollerton.flashapp.fragments;

import android.support.v4.app.Fragment;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.flashapp.jamescollerton.flashapp.R;
import com.flashapp.jamescollerton.flashapp.enumerators.Power;
import com.flashapp.jamescollerton.flashapp.interfaces.GNButton;
import com.flashapp.jamescollerton.flashapp.interfaces.GNField;

/**
 * Created by JamesCollerton on 25/09/2017.
 */
public abstract class GNFragment<ValueType, ViewType, ViewValueType> extends Fragment
                                                                     implements GNField<ValueType, ViewType, ViewValueType> {

    @Override
    public ValueType getValue() {
        try {
            return validate(readViewValue());
        } catch(NumberFormatException | NullPointerException e){
            return null;
        }
    }

    public <SpinnerType> void addSpinnerItems(SpinnerType[] spinnerArray, int spinnerId){
        Spinner spinner = (Spinner) getActivity().findViewById(spinnerId);
        ArrayAdapter<SpinnerType> spinnerArrayAdapter = new ArrayAdapter<SpinnerType>(getContext(), android.R.layout.simple_spinner_item, spinnerArray);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);
    }
}

package com.flashapp.jamescollerton.flashapp.fragments;

import android.support.v4.app.Fragment;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.flashapp.jamescollerton.flashapp.interfaces.GNField;

/**
 * This is the abstract class all fragments must override
 *
 * @param <ValueType> The type we want to get from the fragment (e.g. for a distance it will be float)
 * @param <ViewType> The type of view, so spinner, text field, button
 * @param <ViewValueType> The type that is populate in the view, it could be a spinner of powers, an
 *                       EditText of string etc.
 */
public abstract class GNFragment<ValueType, ViewType, ViewValueType> extends Fragment
                                                                     implements GNField<ValueType, ViewType, ViewValueType> {

    /**
     * This method is used to get the value from a fragment. It reads the value from the view and
     * then validates it using overriden methods in the subclass.
     *
     * @return The value that has been entered in the UI
     */
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
    public void setViewValue(ValueType value){}

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

    /**
     * This is used to add items to a spinner for a custom type. For example if we want to create
     * a spinner of the power enumeration.
     *
     * @param spinnerArray The array of items to add
     * @param spinnerId The Id of the spinner to add items to
     * @param <SpinnerType> The type of item we will be adding to the spinner.
     */
    public <SpinnerType> void addSpinnerItems(SpinnerType[] spinnerArray, int spinnerId){
        Spinner spinner = (Spinner) getActivity().findViewById(spinnerId);
        ArrayAdapter<SpinnerType> spinnerArrayAdapter = new ArrayAdapter<SpinnerType>(getContext(), android.R.layout.simple_spinner_item, spinnerArray);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);
    }
}

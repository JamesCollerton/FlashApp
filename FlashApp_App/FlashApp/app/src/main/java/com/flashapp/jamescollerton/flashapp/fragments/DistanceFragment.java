package com.flashapp.jamescollerton.flashapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import com.flashapp.jamescollerton.flashapp.R;
import com.flashapp.jamescollerton.flashapp.enumerators.DistanceUnit;
import com.flashapp.jamescollerton.flashapp.helpers.InputValidation;

/**
 * This is used for putting data into and taking data out of the distance field in the UI
 */
public class DistanceFragment extends GNFragment<Float, EditText, String> {

    private OnFragmentInteractionListener mListener;

    public DistanceFragment() {
        // Required empty public constructor
    }

    public static DistanceFragment newInstance() {
        DistanceFragment fragment = new DistanceFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_distance, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onDistanceFragmentInteraction(Uri uri);
    }

    /**
     * This is used to take an input string from the UI, parse it as a float and then convert it
     * to a distance in metres using the distance unit selected in the UI
     *
     * @param input The input distance string in the UI
     * @return The float representing the distance in metres
     */
    private float parseAndConvertDistance(String input) {
        Float distance = InputValidation.parseFloatFromString(input);
        return distance / getDistanceUnit().getConversionUnit();
    }

    /**
     * This is used to get the distance unit selected in the spinner in the UI
     * @return
     */
    public DistanceUnit getDistanceUnit(){
        return (DistanceUnit) ((Spinner) getActivity().findViewById(R.id.distanceUnit)).getSelectedItem();
    }

    /**
     * This adds all of the distance units in the enumerated class to the spinner for selection
     */
    public void addSpinnerItems(){
        DistanceUnit[] spinnerArray = DistanceUnit.values();
        addSpinnerItems(spinnerArray, R.id.distanceUnit);
    }

    /**
     * @return The fragment view relating to the distance entry field
     */
    @Override
    public EditText getFragmentView(){
        return (EditText) getActivity().findViewById(R.id.distance);
    }

    /**
     * @return The string stored in the distance EditText field
     */
    @Override
    public String readViewValue(){
        return getFragmentView().getText().toString();
    }

    /**
     * @param viewValue Sets the value stored in the EditText field
     */
    @Override
    public void setViewValue(Float viewValue){
        getFragmentView().setText(validateOutput(viewValue).toString());
    }

    /**
     * This is used to take the value that we are going to put in the distance field and check it.
     * As all calculations are done in metres this is used to convert it from metres to whatever
     * unit is selected.
     *
     * @param viewValue The value in metres we would like to put in
     * @return The value in whichever distance unit is selected we would like to put in
     */
    @Override
    public Float validateOutput(Float viewValue){
        return viewValue * getDistanceUnit().getConversionUnit();
    }

    /**
     * This is used to validate whatever we are taking from the distance EditText
     *
     * @param input The string taken from the box on screen
     * @return A validated input for use elsewhere
     */
    @Override
    public Float validateInput(String input){
        return parseAndConvertDistance(input);
    }
}

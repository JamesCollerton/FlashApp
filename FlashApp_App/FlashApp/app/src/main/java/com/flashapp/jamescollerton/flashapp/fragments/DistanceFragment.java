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

    private float parseAndConvertDistance(String input) {
        Float distance = InputValidation.parseFloatFromString(input);
        return distance / getDistanceUnit().getConversionUnit();
    }

    public DistanceUnit getDistanceUnit(){
        return (DistanceUnit) ((Spinner) getActivity().findViewById(R.id.distanceUnit)).getSelectedItem();
    }

    public void addSpinnerItems(){
        DistanceUnit[] spinnerArray = DistanceUnit.values();
        addSpinnerItems(spinnerArray, R.id.distanceUnit);
    }

    @Override
    public EditText getFragmentView(){
        return (EditText) getActivity().findViewById(R.id.distance);
    }

    @Override
    public String readViewValue(){
        return getFragmentView().getText().toString();
    }

    @Override
    public void setViewValue(Float viewValue){
        getFragmentView().setText(validateOutput(viewValue).toString());
    }

    @Override
    public Float validateOutput(Float viewValue){
        return viewValue * getDistanceUnit().getConversionUnit();
    }

    @Override
    public Float validateInput(String input){
        return parseAndConvertDistance(input);
    }
}

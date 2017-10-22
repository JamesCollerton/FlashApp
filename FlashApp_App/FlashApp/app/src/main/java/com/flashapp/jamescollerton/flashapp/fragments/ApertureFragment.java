package com.flashapp.jamescollerton.flashapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.flashapp.jamescollerton.flashapp.R;
import com.flashapp.jamescollerton.flashapp.helpers.InputValidation;

public class ApertureFragment extends GNFragment<Float, EditText, String> {

    private OnFragmentInteractionListener mListener;

    public ApertureFragment() {
        // Required empty public constructor
    }

    public static ApertureFragment newInstance() {
        ApertureFragment fragment = new ApertureFragment();
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
        return inflater.inflate(R.layout.fragment_aperture, container, false);
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
        void onApertureFragmentInteraction(Uri uri);
    }

    @Override
    public EditText getFragmentView(){
        return (EditText) getActivity().findViewById(R.id.aperture);
    }

    @Override
    public String readViewValue(){
        return getFragmentView().getText().toString();
    }

    @Override
    public void setViewValue(Float viewValue){
        getFragmentView().setText(viewValue.toString());
    }

    @Override
    public Float validateInput(String input){
        return InputValidation.parseFloatFromString(input);
    }
}

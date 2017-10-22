package com.flashapp.jamescollerton.flashapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import com.flashapp.jamescollerton.flashapp.R;
import com.flashapp.jamescollerton.flashapp.helpers.InputValidation;

public class ISOFragment extends GNFragment<Integer, Spinner, String>  {

    private OnFragmentInteractionListener mListener;

    public ISOFragment() {
        // Required empty public constructor
    }

    public static ISOFragment newInstance() {
        ISOFragment fragment = new ISOFragment();
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
        return inflater.inflate(R.layout.fragment_iso, container, false);
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
        void onISOFragmentInteraction(Uri uri);
    }

    @Override
    public Spinner getFragmentView(){
        return (Spinner) getActivity().findViewById(R.id.ISO);
    }

    @Override
    public String readViewValue(){
        return getFragmentView().getSelectedItem().toString();
    }

    @Override
    public Integer validateInput(String input){
        return InputValidation.parseIntegerFromString(input);
    }
}

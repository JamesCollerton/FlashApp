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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DistanceFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DistanceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DistanceFragment extends GNFragment<Float, EditText, String> {

    private OnFragmentInteractionListener mListener;

    public DistanceFragment() {}

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DistanceFragment.
     */
    // TODO: Rename and change types and number of parameters
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onDistanceFragmentInteraction(Uri uri);
    }

    private void getDistanceUnit(){
        String unit = ((Spinner) getActivity().findViewById(R.id.distanceUnit)).getSelectedItem().toString();
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
    public void setViewValue(String viewValue){
        getFragmentView().setText(viewValue);
    }

    @Override
    public Float validate(String input){
        return InputValidation.parseFloatFromString(input);
    }
}

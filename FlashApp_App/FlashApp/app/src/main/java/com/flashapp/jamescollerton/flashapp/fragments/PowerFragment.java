package com.flashapp.jamescollerton.flashapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.flashapp.jamescollerton.flashapp.R;
import com.flashapp.jamescollerton.flashapp.enumerators.Power;
import com.flashapp.jamescollerton.flashapp.helpers.InputValidation;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PowerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PowerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PowerFragment extends GNFragment<Integer, Spinner, Power> {

    private OnFragmentInteractionListener mListener;

    public PowerFragment() { }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PowerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PowerFragment newInstance() {
        PowerFragment fragment = new PowerFragment();
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
        View view = inflater.inflate(R.layout.fragment_power, container, false);
        return view;
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
        void onPowerFragmentInteraction(Uri uri);
    }

    public void addSpinnerItems(){
        Power[] spinnerArray = Power.values();
        addSpinnerItems(spinnerArray, R.id.power);
//        Spinner spinner = (Spinner) getActivity().findViewById(R.id.power);
//        ArrayAdapter<Power> spinnerArrayAdapter = new ArrayAdapter<Power>(getContext(), android.R.layout.simple_spinner_item, spinnerArray);
//        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(spinnerArrayAdapter);
    }

    @Override
    public Spinner getFragmentView(){
        return (Spinner) getActivity().findViewById(R.id.power);
    }

    @Override
    public Power readViewValue(){
        return (Power) getFragmentView().getSelectedItem();
    }

    @Override
    public void setViewValue(Power value){ }

    @Override
    public Integer validate(Power input){
        return input.getValue();
    }
}

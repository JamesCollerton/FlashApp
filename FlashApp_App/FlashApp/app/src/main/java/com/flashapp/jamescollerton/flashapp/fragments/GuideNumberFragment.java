package com.flashapp.jamescollerton.flashapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.flashapp.jamescollerton.flashapp.AlertBox;
import com.flashapp.jamescollerton.flashapp.GNFragment;
import com.flashapp.jamescollerton.flashapp.R;
import com.flashapp.jamescollerton.flashapp.helpers.InputValidation;
import com.flashapp.jamescollerton.flashapp.interfaces.GNButton;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GuideNumberFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GuideNumberFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GuideNumberFragment extends GNFragment<Integer, EditText, String> {

    private OnFragmentInteractionListener mListener;

    public GuideNumberFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.

     * @return A new instance of fragment GuideNumberFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GuideNumberFragment newInstance() {
        GuideNumberFragment fragment = new GuideNumberFragment();
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
        return inflater.inflate(R.layout.fragment_guide_number, container, false);
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
        void onGuideNumberFragmentInteraction(Uri uri);
    }

    @Override
    public EditText getFragmentView(){
        return (EditText) getActivity().findViewById(R.id.guideNumber);
    }

    @Override
    public String readViewValue(){
        return getFragmentView().getText().toString();
    }

    public Integer validate(String input){
        return InputValidation.parseIntegerFromString(input);
    }

//    TODO: Change this returning zero, maybe throw exception further up.
//    @Override
//    public Integer getValue() throws Exception{
//        try {
//            return validate(readViewValue());
//        } catch(NumberFormatException e){
//            throw new Exception();
////            new AlertBox(getActivity(),
////                    "Could not find Guide Number",
////                    "Could not find an appropriate guide number from the list.",
////                    "OK");
//        }
//    }
}

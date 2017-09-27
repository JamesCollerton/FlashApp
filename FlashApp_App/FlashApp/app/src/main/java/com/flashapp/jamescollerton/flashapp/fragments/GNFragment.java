package com.flashapp.jamescollerton.flashapp.fragments;

import android.support.v4.app.Fragment;

import com.flashapp.jamescollerton.flashapp.interfaces.GNButton;
import com.flashapp.jamescollerton.flashapp.interfaces.GNField;

/**
 * Created by JamesCollerton on 25/09/2017.
 */
public abstract class GNFragment<ValueType, ViewType, ViewValueType> extends Fragment
                                                                     implements GNField<ValueType, ViewType, ViewValueType> {

    @Override
    public ValueType getValue() throws Exception{
        return validate(readViewValue());
//            new AlertBox(getActivity(),
//                    "Could not find Guide Number",
//                    "Could not find an appropriate guide number from the list.",
//                    "OK");
    }
}

package com.flashapp.jamescollerton.flashapp.interfaces;

import java.util.Objects;

/**
 * Created by JamesCollerton on 16/09/2017.
 */
public interface GNButton<ValueType, ViewType, ViewValueType> {

    /**
     * This needs to be overriden in order to return the value
     * from the fragment.
     *
     * @return The value of the fragment.
     */
    public ValueType getValue();

    /**
     * This needs to be overriden to return the main view in the
     * fragment. So this will be the EditText or similar.
     *
     * @return Main fragment view.
     */
    public ViewType getFragmentView();

    public ViewValueType readViewValue();

    public ValueType validate(ViewValueType viewValue);

}

package com.flashapp.jamescollerton.flashapp.interfaces;

import java.util.Objects;

/**
 * Created by JamesCollerton on 16/09/2017.
 */
public interface GNField<ValueType, ViewType, ViewValueType> extends GNButton<ViewType> {

    /**
     * This needs to be overriden in order to return the value
     * from the fragment.
     *
     * @return The value of the fragment.
     */
    public ValueType getValue() throws Exception;


    /**
     * This needs to be overriden to take whatever value we would
     * like from the fragment. For example we might read all of the
     * text in from the EditText area.
     *
     * @return The value in the view
     */
    public ViewValueType readViewValue();

    /**
     * This needs to be overriden in order to set the value in
     * the view.
     *
     * @param value What we would like to set in the view
     */
    public void setViewValue(ValueType value);

    /**
     * This needs to be overriden to take the value we want from
     * the view and return the value we want from the whole fragment.
     *
     * @param viewValue
     * @return
     */
    public ValueType validateInput(ViewValueType viewValue);

    /**
     * This needs to be overriden to take the value we want to
     * put in the fragment and validate it before putting it in.
     *
     * @param viewValue
     * @return
     */
    public ValueType validateOutput(ValueType viewValue);
}

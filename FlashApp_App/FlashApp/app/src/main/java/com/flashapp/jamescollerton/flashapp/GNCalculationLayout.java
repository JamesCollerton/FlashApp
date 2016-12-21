package com.flashapp.jamescollerton.flashapp;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by JamesCollerton on 21/12/2016.
 */
public class GNCalculationLayout {

    /**
     * Holds the activity this class has come from in order to get the components from IDs.
     */
    Activity parentActivity;

    /**
     * These are all the fields on the layout and are used to get the information
     */
    EditText guideNumber;
    EditText distance;
    Spinner ISO;
    Spinner aperture;

    /**
     * Constructor that assigns the parent activity and then sets up the event listeners.
     *
     * @param parentActivity
     */
    public GNCalculationLayout(Activity parentActivity){

        this.parentActivity = parentActivity;

        setUpInputs();
        setUpEventListeners();

    }

    /**
     * This puts all of the inputs from the screen into variables so we can get their values
     * later
     */
    public void setUpInputs(){

        guideNumber     = (EditText) parentActivity.findViewById(R.id.guideNumber);
        distance        = (EditText) parentActivity.findViewById(R.id.distance);
        ISO             = (Spinner) parentActivity.findViewById(R.id.ISO);
        aperture        = (Spinner) parentActivity.findViewById(R.id.aperture);

    }

    /**
     * This is used to listen for changes in the input of the app in order to carry out the
     * calculations
     */
    public void setUpEventListeners(){

        guideNumber.addTextChangedListener(textWatcher);
        distance.addTextChangedListener(textWatcher);

    }

    /**
     * This is used to listen for changes in the text fields.
     */
    private TextWatcher textWatcher = new TextWatcher() {

        /**
         * Listens for text being changed and then launches the calculation.
         *
         * @param s
         */
        public void afterTextChanged(Editable s) {
            launchCalculation();
        }

        /**
         * Both of these need to be overriden for the class but aren't used.
         */
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {

        }
    };

    /**
     * This is used to actually perform a calculation based on what information has been entered.
     */
    private void launchCalculation(){

        GNCalculationInputValidation validation = new GNCalculationInputValidation(getInputs());
        boolean validationResult = validation.validate();

        if(validationResult){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

    }

    /**
     * This is used to add all of the inputs from the screen to an array list and return it.
     *
     * @return ArrayList of all of the screen inputs
     */
    private ArrayList<String> getInputs(){
        ArrayList<String> inputList = new ArrayList<>();

        inputList.add(guideNumber.getText().toString());
        inputList.add(distance.getText().toString());
        inputList.add(ISO.getSelectedItem().toString());
        inputList.add(aperture.getSelectedItem().toString());

        return inputList;
    }

}

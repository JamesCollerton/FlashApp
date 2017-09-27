package com.flashapp.jamescollerton.flashapp;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.flashapp.jamescollerton.flashapp.helpers.AlertBox;

import java.util.ArrayList;
import java.util.NoSuchElementException;

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
     * These are the buttons used to start calculations
     */
    Button calculateAperture;
    Button calculateDistance;

    /**
     * Enumeration of the different calculation types we can do
     */
    private enum CALCULATION_TYPES {
        APERTURE,
        DISTANCE
    };

    /**
     * Constructor that assigns the parent activity and then sets up the input fields,
     * event listeners and buttons to be pressed.
     *
     * @param parentActivity
     */
    public GNCalculationLayout(Activity parentActivity){

        this.parentActivity = parentActivity;

        setUpInputs();
        setUpButtons();
        setUpEventListeners();

    }

    /**
     * This puts all of the inputs from the screen into variables so we can get their values
     * later.
     */
    public void setUpInputs(){

        guideNumber     = (EditText) parentActivity.findViewById(R.id.guideNumber);
        distance        = (EditText) parentActivity.findViewById(R.id.distance);
        ISO             = (Spinner) parentActivity.findViewById(R.id.ISO);
        aperture        = (Spinner) parentActivity.findViewById(R.id.aperture);

    }

    /**
     * Puts the buttons into variables to be accessed.
     */
    public void setUpButtons(){

        calculateAperture = (Button) parentActivity.findViewById(R.id.calculateAperture);
        calculateDistance = (Button) parentActivity.findViewById(R.id.calculateDistance);

    }

    /**
     * This is used to listen for presses on the buttons and then validation.
     */
    public void setUpEventListeners(){

        calculateAperture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                launchCalculation(CALCULATION_TYPES.APERTURE);
            }
        });

        calculateDistance.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                launchCalculation(CALCULATION_TYPES.DISTANCE);
            }
        });

    }

    /**
     * This is used to actually perform a calculation based on what information has been entered.
     */
    private void launchCalculation(CALCULATION_TYPES calculationType){

        GNCalculationInputValidation validation = new GNCalculationInputValidation(getInputs());

        try {

            switch (calculationType) {
                case APERTURE:
                    calculateAperture(validation);
                    break;
                case DISTANCE:
                    calculateDistance(validation);
                    break;
            }

        } catch (NoSuchElementException e){
            new AlertBox(parentActivity,
                         "Data Entry Error",
                         "Error in the entered values, please try again.",
                         "OK");
        }

    }

    /**
     * This method is used to calculate the aperture based on the in screen inputs. It creates a
     * new formula object, adds the distance, then gets the index of the aperture option we need
     * to set at.
     *
     * @param validation
     */
    private void calculateAperture(GNCalculationInputValidation validation){

        boolean validationResult = validation.validateForAperture();

        if (validationResult) {

            GNCalculationFormula calculation = new GNCalculationFormula(parentActivity,
                                                                        validation.getISO(),
                                                                        validation.getGuideNumber());

            calculation.setDistance(validation.getDistance());

            try {
                int apertureIndex = calculation.calculateAperture();

                setAperture(apertureIndex);
            } catch(NumberFormatException e){
                new AlertBox(parentActivity,
                             "Could not find aperture",
                             "Could not find an appropriate aperture from the list.",
                             "OK");
            }

        } else {
            new AlertBox(parentActivity,
                         "Incomplete Data",
                         "Please make sure distance, ISO and guide number are populated.",
                         "OK");
        }
    }

    /**
     * Sets the aperture in the spinner according to the index.
     *
     * @param apertureIndex
     */
    private void setAperture(int apertureIndex){
        aperture.setSelection(apertureIndex);
    }

    /**
     * This method is used to calculate the distance. Creates a new formula, sets the aperture,
     * then carries out the distance calculation and sets the value in the app.
     *
     * @param validation
     */
    private void calculateDistance(GNCalculationInputValidation validation){

        boolean validationResult = validation.validateForDistance();

        if (validationResult) {
            GNCalculationFormula calculation = new GNCalculationFormula(parentActivity,
                                                                        validation.getISO(),
                                                                        validation.getGuideNumber());

            calculation.setAperture(validation.getAperture());

            float distance = calculation.calculateDistance();

            setDistance(distance);

        } else {
            new AlertBox(parentActivity,
                         "Incomplete Data",
                         "Please make sure aperture, ISO and guide number are populated.",
                         "OK");
        }
    }

    /**
     * Sets the distance in the textbox.
     *
     * @param distanceFloat
     */
    private void setDistance(float distanceFloat){
        distance.setText(distanceFloat + "");
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

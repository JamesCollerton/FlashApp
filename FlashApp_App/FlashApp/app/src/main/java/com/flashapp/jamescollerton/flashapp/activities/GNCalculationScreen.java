package com.flashapp.jamescollerton.flashapp.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.flashapp.jamescollerton.flashapp.R;
import com.flashapp.jamescollerton.flashapp.fragments.ApertureFragment;
import com.flashapp.jamescollerton.flashapp.fragments.CalculationButtonsFragment;
import com.flashapp.jamescollerton.flashapp.fragments.DistanceFragment;
import com.flashapp.jamescollerton.flashapp.fragments.GuideNumberFragment;
import com.flashapp.jamescollerton.flashapp.fragments.ISOFragment;
import com.flashapp.jamescollerton.flashapp.fragments.PowerFragment;
import com.flashapp.jamescollerton.flashapp.helpers.AlertBox;
import com.flashapp.jamescollerton.flashapp.helpers.CalculationFormula;
import com.flashapp.jamescollerton.flashapp.models.Inputs;

public class GNCalculationScreen    extends     AppCompatActivity
                                    implements  GuideNumberFragment.OnFragmentInteractionListener,
                                                ISOFragment.OnFragmentInteractionListener,
                                                PowerFragment.OnFragmentInteractionListener,
                                                DistanceFragment.OnFragmentInteractionListener,
                                                CalculationButtonsFragment.OnFragmentInteractionListener,
                                                ApertureFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setUpListeners();
        setUpFields();

    }

    /**
     * Adds all listeners to the fields on the page.
     */
    private void setUpListeners(){
        assignCalculationButtonsListeners();
    }

    /**
     * Does all of the custom initialisation of fields in the activity.
     */
    private void setUpFields(){
        PowerFragment powerFragment = (PowerFragment) getSupportFragmentManager().findFragmentById(R.id.powerFragment);
        powerFragment.addSpinnerItems();

        DistanceFragment distanceFragment = (DistanceFragment) getSupportFragmentManager().findFragmentById(R.id.distanceFragment);
        distanceFragment.addSpinnerItems();
    }

    /**
     * Listeners
     */
    public void assignCalculationButtonsListeners(){

        findViewById(R.id.calculateAperture).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculateAperture();
            }
        });

        findViewById(R.id.calculateDistance).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculateDistance();
            }
        });

    }

    private void calculateAperture(){
        try {
            Float aperture = CalculationFormula.calculateAperture(readInputs());
            getApertureFragment().setViewValue(aperture);
        } catch(Exception e){
            new AlertBox(this,
                    getResources().getString(R.string.alert_box_missing_info_title),
                    getResources().getString(R.string.alert_box_missing_info_text),
                    getResources().getString(R.string.alert_box_missing_info_ok)
            );
        }
    }

    private void calculateDistance(){
        try {
            Float distance = CalculationFormula.calculateDistance(readInputs());
            getDistanceFragment().setViewValue(distance);
        } catch(Exception e){
            new AlertBox(this,
                    "Missing Information",
                    "Please check ISO, guide number and aperture are all populated " +
                    "and have valid values.",
                    "OK");
        }
    }

    private Inputs readInputs(){
        return new Inputs(
                getGuideNumberFragment().getValue(),
                getISOFragment().getValue(),
                getPowerFragment().getValue(),
                getDistanceFragment().getValue(),
                getApertureFragment().getValue()
        );
    }

    /**
     * Fragment getters
     */

    public PowerFragment getPowerFragment(){
        return (PowerFragment) getSupportFragmentManager().findFragmentById(R.id.powerFragment);
    }

    public ISOFragment getISOFragment(){
        return (ISOFragment) getSupportFragmentManager().findFragmentById(R.id.ISOFragment);
    }

    public GuideNumberFragment getGuideNumberFragment(){
        return (GuideNumberFragment) getSupportFragmentManager().findFragmentById(R.id.guideNumberFragment);
    }

    public DistanceFragment getDistanceFragment(){
        return (DistanceFragment) getSupportFragmentManager().findFragmentById(R.id.distanceFragment);
    }

    public ApertureFragment getApertureFragment(){
        return (ApertureFragment) getSupportFragmentManager().findFragmentById(R.id.apertureFragment);
    }

    /**
     * Overriden Methods for Fragments
     */

    @Override
    public void onGuideNumberFragmentInteraction(Uri uri) {}

    @Override
    public void onISOFragmentInteraction(Uri uri) {}

    @Override
    public void onPowerFragmentInteraction(Uri uri){}

    @Override
    public void onDistanceFragmentInteraction(Uri uri){}

    @Override
    public void onApertureFragmentInteraction(Uri uri){}

    @Override
    public void onCalculationButtonsFragmentInteraction(Uri uri){}

}

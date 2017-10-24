package com.flashapp.jamescollerton.flashapp.fragments;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.flashapp.jamescollerton.flashapp.R;
import com.flashapp.jamescollerton.flashapp.enumerators.DistanceUnit;
import com.flashapp.jamescollerton.flashapp.helpers.AndroidTestUtils;
import com.flashapp.jamescollerton.flashapp.helpers.GNAndroidTest;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * This is used to hold all of the test for the distance fragment. It includes methods for setting
 * and checking the distance and the distance units.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class DistanceFragmentTest extends GNAndroidTest {

    /**
     * Used for setting the distance. It is static so it can be accessed from outside the class by
     * other methods.
     *
     * @param distance What we are entering in the distance box
     * @param expectedResult What we expect to be populated in the distance box
     */
    public static void setDistance(String distance, String expectedResult){
        AndroidTestUtils.setEditText(distance, expectedResult, R.id.distance);
    }

    /**
     * @param input What we are entering in the distance units.
     * @param expectedOutput What we expect to be in the distance unit spinner.
     */
    public static void setDistanceUnits(DistanceUnit input, DistanceUnit expectedOutput){
        AndroidTestUtils.setCustomSpinner(input, expectedOutput, DistanceUnit.class, R.id.distanceUnit);
    }

    @Test
    public void setDistanceInt() {
        setDistance("10", "10");
    }

    @Test
    public void setDistanceChar() {
        setDistance("abcd", "");
    }

    @Test
    public void setDistanceCharIntMixedOne() {
        setDistance("abcd10", "10");
    }

    @Test
    public void setDistanceCharIntMixedTwo() {
        setDistance("ab1cd0", "10");
    }

    @Test
    public void setDistanceCharSymbol() {
        setDistance("!!!!", "1111");
    }

    @Test
    public void setDistanceCharSymbolInt() {
        setDistance("!1!0!!", "111011");
    }

    @Test
    public void setDistanceUnitsMetres(){
        setDistanceUnits(DistanceUnit.METRES, DistanceUnit.METRES);
    }

    @Test
    public void setDistanceUnitFeet(){
        setDistanceUnits(DistanceUnit.FEET, DistanceUnit.FEET);
    }

}

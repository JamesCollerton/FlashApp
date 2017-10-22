package com.flashapp.jamescollerton.flashapp.fragments;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.flashapp.jamescollerton.flashapp.R;
import com.flashapp.jamescollerton.flashapp.enumerators.DistanceUnit;
import com.flashapp.jamescollerton.flashapp.helpers.AndroidTestUtils;
import com.flashapp.jamescollerton.flashapp.helpers.GNAndroidTest;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class DistanceFragmentTest extends GNAndroidTest {

    public static void setDistance(String distance, String expectedResult){
        AndroidTestUtils.setEditText(distance, expectedResult, R.id.distance);
    }

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

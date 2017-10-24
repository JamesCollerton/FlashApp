package com.flashapp.jamescollerton.flashapp.fragments;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.flashapp.jamescollerton.flashapp.R;
import com.flashapp.jamescollerton.flashapp.helpers.AndroidTestUtils;
import com.flashapp.jamescollerton.flashapp.helpers.GNAndroidTest;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * This is used to test the aperture fragment and holds all of the methods for testing entering
 * different amounts into the aperture field.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ApertureFragmentTest extends GNAndroidTest {

    /**
     * This is the method for actually setting the aperture. It is static so it can be accessed from
     * outside the class for other tests.
     *
     * @param aperture The aperture we want to set.
     * @param expectedResult What we expect to receive in the text box.
     */
    public static void setAperture(String aperture, String expectedResult){
        AndroidTestUtils.setEditText(aperture, expectedResult, R.id.aperture);
    }

    @Test
    public void setApertureInt() {
        setAperture("10", "10");
    }

    @Test
    public void setApertureChar() {
        setAperture("abcd", "");
    }

    @Test
    public void setApertureCharIntMixedOne() {
        setAperture("abcd10", "10");
    }

    @Test
    public void setApertureCharIntMixedTwo() {
        setAperture("ab1cd0", "10");
    }

    @Test
    public void setApertureCharSymbol() {
        setAperture("!!!!", "1111");
    }

    @Test
    public void setApertureCharSymbolInt() {
        setAperture("!1!0!!", "111011");
    }

}

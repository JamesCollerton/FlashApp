package com.flashapp.jamescollerton.flashapp.fragments;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.flashapp.jamescollerton.flashapp.R;
import com.flashapp.jamescollerton.flashapp.activities.GNCalculationScreen;
import com.flashapp.jamescollerton.flashapp.helpers.AndroidTestUtils;
import com.flashapp.jamescollerton.flashapp.helpers.GNAndroidTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by JamesCollerton on 22/10/2017.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ApertureFragmentTest extends GNAndroidTest {

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

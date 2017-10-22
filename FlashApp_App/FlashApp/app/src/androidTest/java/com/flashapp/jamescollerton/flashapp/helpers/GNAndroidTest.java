package com.flashapp.jamescollerton.flashapp.helpers;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import com.flashapp.jamescollerton.flashapp.activities.GNCalculationScreen;

import org.junit.Before;
import org.junit.Rule;

public abstract class GNAndroidTest {

    @Rule
    public ActivityTestRule<GNCalculationScreen> mActivityRule =
            new ActivityTestRule(GNCalculationScreen.class);

    @Before
    public void setUpTests(){
        Espresso.closeSoftKeyboard();
    }

}

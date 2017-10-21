package com.flashapp.jamescollerton.flashapp;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;

import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.Matchers.*;

import com.flashapp.jamescollerton.flashapp.activities.GNCalculationScreen;
import com.flashapp.jamescollerton.flashapp.enumerators.DistanceUnit;
import com.flashapp.jamescollerton.flashapp.enumerators.Power;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import testUtils.TestResults;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class GuideNumberTest {

    @Rule
    public ActivityTestRule<GNCalculationScreen> mActivityRule =
            new ActivityTestRule(GNCalculationScreen.class);

    @Before
    public void closeKeyboard(){
        Espresso.closeSoftKeyboard();
    }

    /*
    EditText Tests
     */
    private void checkEditText(String expectedOutput, int editTextId){
        onView(withId(editTextId)).check(matches(withText(expectedOutput)));
    }

    private void setEditText(String input, String expectedOutput, int editTextId){
        onView(withId(editTextId)).perform(click()).perform(clearText()).perform(typeText(input));
        checkEditText(expectedOutput, editTextId);
    }

    private void setGuideNumber(String guideNumber, String expectedResult){
        setEditText(guideNumber, expectedResult, R.id.guideNumber);
    }

    /*
    Guide Number Tests
     */

    @Test
    public void setGuideNumberInt() {
        setGuideNumber("10", "10");
    }

    @Test
    public void setGuideNumberChar() {
        setGuideNumber("abcd", "");
    }

    @Test
    public void setGuideNumberCharIntMixedOne() {
        setGuideNumber("abcd10", "10");
    }

    @Test
    public void setGuideNumberCharIntMixedTwo() {
        setGuideNumber("ab1cd0", "10");
    }

    @Test
    public void setGuideNumberCharSymbol() {
        setGuideNumber("!!!!", "1111");
    }

    @Test
    public void setGuideNumberCharSymbolInt() {
        setGuideNumber("!1!0!!", "111011");
    }

}

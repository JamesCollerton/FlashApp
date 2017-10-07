package com.flashapp.jamescollerton.flashapp;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import com.flashapp.jamescollerton.flashapp.activities.GNCalculationScreen;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ApplicationTest {

    @Rule
    public ActivityTestRule<GNCalculationScreen> mActivityRule =
            new ActivityTestRule(GNCalculationScreen.class);

    private void setGuideNumber(String guideNumber, String expectedResult){
        onView(withId(R.id.guideNumber)).perform(click()).perform(clearText()).perform(typeText(guideNumber));
        onView(withId(R.id.guideNumber)).check(matches(withText(expectedResult)));
    }

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

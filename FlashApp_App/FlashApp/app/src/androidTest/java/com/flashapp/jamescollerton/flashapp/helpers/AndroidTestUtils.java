package com.flashapp.jamescollerton.flashapp.helpers;

import android.support.test.espresso.Espresso;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by JamesCollerton on 22/10/2017.
 */
public class AndroidTestUtils {

    public static void closeKeyboard(){
        Espresso.closeSoftKeyboard();
    }

    public static void androidTestSetup(){
        closeKeyboard();
    }

    /*
    Edit Text
     */
    public static void checkEditText(String expectedOutput, int editTextId){
        onView(withId(editTextId)).check(matches(withText(expectedOutput)));
    }

    public static void setEditText(String input, String expectedOutput, int editTextId){
        onView(withId(editTextId)).perform(click()).perform(clearText()).perform(typeText(input));
        checkEditText(expectedOutput, editTextId);
    }

    /*
    Spinners
     */
    public static void setSpinner(String input, String expectedOutput, int spinnerId){
        onView(withId(spinnerId)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is(input))).perform(click());
        onView(withId(spinnerId)).check(matches(withSpinnerText(containsString(expectedOutput))));
    }

    public static  <T> void setCustomSpinner(T input, T expectedOutput, Class customClass, int spinnerId){
        onView(withId(spinnerId)).perform(click());
        onData(allOf(is(instanceOf(customClass)), is(input))).perform(click());
        onView(withId(spinnerId)).check(matches(withSpinnerText(containsString(expectedOutput.toString()))));
    }

    /*
    Buttons
     */
    public static void clickButton(int buttonId){
        onView(withId(buttonId)).perform(click());
    }

}

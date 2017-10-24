package com.flashapp.jamescollerton.flashapp.helpers;

import android.support.test.espresso.Espresso;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
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
 * This holds a bunch of methods that are useful within all of the android instrumentation tests.
 */
public class AndroidTestUtils {

    /*
    General
     */

    /**
     * Used as a wrapper for closing the keyboard.
     */
    public static void closeKeyboard(){
        Espresso.closeSoftKeyboard();
    }

    /*
    Edit Text
     */

    /**
     * This is used to check the result of an edit text field
     *
     * @param expectedOutput What we expect to be populated in the text field
     * @param editTextId The Id of the text field we're checking
     */
    public static void checkEditText(String expectedOutput, int editTextId){
        onView(withId(editTextId)).check(matches(withText(expectedOutput)));
    }

    /**
     * This is used to set and then check a text field
     *
     * @param input What we want to type into a text field
     * @param expectedOutput What we expect to be put in the text field
     * @param editTextId The Id of the text field we are testing
     */
    public static void setEditText(String input, String expectedOutput, int editTextId){
        onView(withId(editTextId)).perform(click()).perform(clearText()).perform(typeText(input));
        checkEditText(expectedOutput, editTextId);
    }

    /*
    Spinners
     */

    /**
     * This is used to set a spinner of strings in the activity.
     *
     * @param input The string we want to select in the spinner
     * @param expectedOutput The string we expect to have selected in the spinner
     * @param spinnerId The Id of the spinner we are testing
     */
    public static void setSpinner(String input, String expectedOutput, int spinnerId){
        onView(withId(spinnerId)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is(input))).perform(click());
        onView(withId(spinnerId)).check(matches(withSpinnerText(containsString(expectedOutput))));
    }

    /**
     * This is used to set a spinner of a custom type in the activity.
     *
     * @param input What we want to select
     * @param expectedOutput What we expect to have selected
     * @param customClass The type used within the spinner
     * @param spinnerId The Id of the spinner we are testing
     * @param <T> A generic to allow this to work with any spinner class
     */
    public static  <T> void setCustomSpinner(T input, T expectedOutput, Class customClass, int spinnerId){
        onView(withId(spinnerId)).perform(click());
        onData(allOf(is(instanceOf(customClass)), is(input))).perform(click());
        onView(withId(spinnerId)).check(matches(withSpinnerText(containsString(expectedOutput.toString()))));
    }

    /*
    Buttons
     */

    /**
     * Used to click a button on screen.
     *
     * @param buttonId The Id of the button we're clicking
     */
    public static void clickButton(int buttonId){
        onView(withId(buttonId)).perform(scrollTo(), click());
    }

}

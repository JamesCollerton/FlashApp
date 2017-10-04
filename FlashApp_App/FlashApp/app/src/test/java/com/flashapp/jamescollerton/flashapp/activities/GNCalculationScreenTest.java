package com.flashapp.jamescollerton.flashapp.activities;

import android.support.test.rule.ActivityTestRule;

import com.flashapp.jamescollerton.flashapp.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by JamesCollerton on 03/10/2017.
 */
public class GNCalculationScreenTest {

    private String mStringToBetyped;

    @Rule
    public ActivityTestRule<GNCalculationScreen> mActivityRule = new ActivityTestRule<>(
            GNCalculationScreen.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        mStringToBetyped = "Espresso";
    }

    @Test
    public void changeText_sameActivity() {
        // Type text and then press the button.
        onView(withId(R.id.editTextUserInput))
                .perform(typeText(mStringToBetyped), closeSoftKeyboard());
        onView(withId(R.id.changeTextBt)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.textToBeChanged))
                .check(matches(withText(mStringToBetyped)));
    }
}


}

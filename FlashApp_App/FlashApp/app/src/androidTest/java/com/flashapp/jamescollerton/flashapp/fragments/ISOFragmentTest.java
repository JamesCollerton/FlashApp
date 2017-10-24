package com.flashapp.jamescollerton.flashapp.fragments;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.flashapp.jamescollerton.flashapp.R;
import com.flashapp.jamescollerton.flashapp.helpers.AndroidTestUtils;
import com.flashapp.jamescollerton.flashapp.helpers.GNAndroidTest;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * This holds all the methods for testing the ISO spinner on the page.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ISOFragmentTest extends GNAndroidTest {

    /**
     * This is used to set and check the ISO spinner
     *
     * @param input What we want to select in the spinner
     * @param expectedOutput What we expect to have selected in the spinner
     */
    public static void setISO(String input, String expectedOutput){
        AndroidTestUtils.setSpinner(input, expectedOutput, R.id.ISO);
    }

    @Test
    public void setISO100() {
        setISO("100", "100");
    }

    @Test
    public void setISO200() {
        setISO("200", "200");
    }

    @Test
    public void setISO400() {
        setISO("400", "400");
    }

    @Test
    public void setISO800() {
        setISO("800", "800");
    }

    @Test
    public void setISO1600() {
        setISO("1600", "1600");
    }

    @Test
    public void setISO3200() {
        setISO("3200", "3200");
    }
    
}

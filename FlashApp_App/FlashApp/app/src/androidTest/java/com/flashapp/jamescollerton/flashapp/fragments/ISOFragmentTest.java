package com.flashapp.jamescollerton.flashapp.fragments;

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

/**
 * Created by JamesCollerton on 22/10/2017.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ISOFragmentTest extends GNAndroidTest {

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

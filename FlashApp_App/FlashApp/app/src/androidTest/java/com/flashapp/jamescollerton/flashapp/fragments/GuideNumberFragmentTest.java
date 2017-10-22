package com.flashapp.jamescollerton.flashapp.fragments;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.flashapp.jamescollerton.flashapp.R;
import com.flashapp.jamescollerton.flashapp.helpers.AndroidTestUtils;
import com.flashapp.jamescollerton.flashapp.helpers.GNAndroidTest;

import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class GuideNumberFragmentTest extends GNAndroidTest {

    public static void setGuideNumber(String guideNumber, String expectedResult){
        AndroidTestUtils.setEditText(guideNumber, expectedResult, R.id.guideNumber);
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

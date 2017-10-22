package com.flashapp.jamescollerton.flashapp.fragments;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.flashapp.jamescollerton.flashapp.R;
import com.flashapp.jamescollerton.flashapp.enumerators.Power;
import com.flashapp.jamescollerton.flashapp.helpers.AndroidTestUtils;
import com.flashapp.jamescollerton.flashapp.helpers.GNAndroidTest;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by JamesCollerton on 22/10/2017.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class PowerFragmentTest extends GNAndroidTest {

    public static void setPower(Power input, Power expectedOutput){
        AndroidTestUtils.setCustomSpinner(input, expectedOutput, Power.class, R.id.power);
    }

    @Test
    public void setPowerZero() {
        setPower(Power.ZERO, Power.ZERO);
    }

    @Test
    public void setPowerMinusOne() {
        setPower(Power.MINUS_ONE, Power.MINUS_ONE);
    }

    @Test
    public void setPowerMinusTwo() {
        setPower(Power.MINUS_TWO, Power.MINUS_TWO);
    }

    @Test
    public void setPowerMinusThree() {
        setPower(Power.MINUS_THREE, Power.MINUS_THREE);
    }

    @Test
    public void setPowerMinusFour() {
        setPower(Power.MINUS_FOUR, Power.MINUS_FOUR);
    }

    @Test
    public void setPowerMinusFive() {
        setPower(Power.MINUS_FIVE, Power.MINUS_FIVE);
    }

    @Test
    public void setPowerMinusSix() {
        setPower(Power.MINUS_SIX, Power.MINUS_SIX);
    }

    @Test
    public void setPowerMinusSeven() {
        setPower(Power.MINUS_SEVEN, Power.MINUS_SEVEN);
    }

}

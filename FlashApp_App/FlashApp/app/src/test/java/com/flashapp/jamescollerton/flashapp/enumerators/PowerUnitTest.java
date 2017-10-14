package com.flashapp.jamescollerton.flashapp.enumerators;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by JamesCollerton on 14/10/2017.
 */
public class PowerUnitTest {

    private void powerTest(Power power, Integer value, String string){
        assertEquals(power.getValue(), value);
        assertEquals(power.toString(), string);
    }

    @Test
    public void testPowerZero(){
        powerTest(Power.ZERO, 0, "1/1");
    }

    @Test
    public void testPowerOne(){
        powerTest(Power.MINUS_ONE, -1, "1/2");
    }

    @Test
    public void testPowerTwo(){
        powerTest(Power.MINUS_TWO, -2, "1/4");
    }

    @Test
    public void testPowerThree(){
        powerTest(Power.MINUS_THREE, -3, "1/8");
    }

    @Test
    public void testPowerFour(){
        powerTest(Power.MINUS_FOUR, -4, "1/16");
    }

    @Test
    public void testPowerFive(){
        powerTest(Power.MINUS_FIVE, -5, "1/32");
    }

    @Test
    public void testPowerSix(){
        powerTest(Power.MINUS_SIX, -6, "1/64");
    }

    @Test
    public void testPowerSeven(){
        powerTest(Power.MINUS_SEVEN, -7, "1/128");
    }

}

package com.flashapp.jamescollerton.flashapp.activities;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.flashapp.jamescollerton.flashapp.R;
import com.flashapp.jamescollerton.flashapp.fragments.ApertureFragmentTest;
import com.flashapp.jamescollerton.flashapp.fragments.DistanceFragmentTest;
import com.flashapp.jamescollerton.flashapp.fragments.GuideNumberFragmentTest;
import com.flashapp.jamescollerton.flashapp.fragments.ISOFragmentTest;
import com.flashapp.jamescollerton.flashapp.fragments.PowerFragmentTest;
import com.flashapp.jamescollerton.flashapp.helpers.AndroidTestUtils;
import com.flashapp.jamescollerton.flashapp.helpers.GNAndroidTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import testUtils.TestResults;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class GNCalculationScreenTest extends GNAndroidTest {

    /*
    Button clicks
     */
    private void clickApertureButton(){
        AndroidTestUtils.clickButton(R.id.calculateAperture);
    }

    private void clickDistanceButton(){
        AndroidTestUtils.clickButton(R.id.calculateDistance);
    }

    /*
    Test Set Up
     */
    private void setUpSharedFields(TestResults testResult){
        GuideNumberFragmentTest.setGuideNumber(testResult.getGuideNumber(), testResult.getGuideNumber());
        AndroidTestUtils.closeKeyboard();
        ISOFragmentTest.setISO(testResult.getISO(), testResult.getISO());
        PowerFragmentTest.setPower(testResult.getPower(), testResult.getPower());
        DistanceFragmentTest.setDistanceUnits(testResult.getDistanceUnit(), testResult.getDistanceUnit());
    }

    private void setUpApertureIntegrationTest(TestResults testResult) {
        setUpSharedFields(testResult);
        DistanceFragmentTest.setDistance(testResult.getDistance(), testResult.getDistance());
        AndroidTestUtils.closeKeyboard();
        clickApertureButton();
        AndroidTestUtils.checkEditText(testResult.getAperture(), R.id.aperture);
    }

    private void setUpDistanceIntegrationTest(TestResults testResult) {
        setUpSharedFields(testResult);
        ApertureFragmentTest.setAperture(testResult.getAperture(), testResult.getAperture());
        AndroidTestUtils.closeKeyboard();
        clickDistanceButton();
        AndroidTestUtils.checkEditText(testResult.getDistance(), R.id.distance);
    }

    /*
    Metres
     */
    @Test
    public void setGN33ISO100Power0Distance5Aperture6MetresApertureTest(){
        setUpApertureIntegrationTest(TestResults.GN33ISO100Power0Distance5Aperture6Metres);
    }

    @Test
    public void setGN33ISO100Power0Distance10Aperture3MetresApertureTest(){
        setUpApertureIntegrationTest(TestResults.GN33ISO100Power0Distance10Aperture3Metres);
    }

    @Test
    public void setGN33ISO100Power0Distance15Aperture2MetresApertureTest(){
        setUpApertureIntegrationTest(TestResults.GN33ISO100Power0Distance15Aperture2Metres);
    }

    @Test
    public void setGN66ISO100Power0Distance10Aperture6MetresApertureTest(){
        setUpApertureIntegrationTest(TestResults.GN66ISO100Power0Distance10Aperture6Metres);
    }

    @Test
    public void setGN99ISO100Power0Distance10Aperture9MetresApertureTest(){
        setUpApertureIntegrationTest(TestResults.GN99ISO100Power0Distance10Aperture9Metres);
    }

    @Test
    public void setGN122ISO100Power0Distance10Aperture12MetresApertureTest(){
        setUpApertureIntegrationTest(TestResults.GN122ISO100Power0Distance10Aperture12Metres);
    }

    @Test
    public void setGN33ISO200Power0Distance10Aperture4MetresApertureTest(){
        setUpApertureIntegrationTest(TestResults.GN33ISO200Power0Distance10Aperture4Metres);
    }

    @Test
    public void setGN33ISO400Power0Distance10Aperture6MetresApertureTest(){
        setUpApertureIntegrationTest(TestResults.GN33ISO400Power0Distance10Aperture6Metres);
    }

    @Test
    public void setGN33ISO1600Power0Distance10Aperture13MetresApertureTest(){
        setUpApertureIntegrationTest(TestResults.GN33ISO1600Power0Distance10Aperture13Metres);
    }

    @Test
    public void setGN33ISO100Power0Distance5Aperture6MetresDistanceTest(){
        setUpDistanceIntegrationTest(TestResults.GN33ISO100Power0Distance5Aperture6Metres);
    }

    @Test
    public void setGN33ISO100Power0Distance10Aperture3MetresDistanceTest(){
        setUpDistanceIntegrationTest(TestResults.GN33ISO100Power0Distance10Aperture3Metres);
    }

    @Test
    public void setGN33ISO100Power0Distance15Aperture2MetresDistanceTest(){
        setUpDistanceIntegrationTest(TestResults.GN33ISO100Power0Distance15Aperture2Metres);
    }

    @Test
    public void setGN66ISO100Power0Distance10Aperture6MetresDistanceTest(){
        setUpDistanceIntegrationTest(TestResults.GN66ISO100Power0Distance10Aperture6Metres);
    }

    @Test
    public void setGN99ISO100Power0Distance10Aperture9MetresDistanceTest(){
        setUpDistanceIntegrationTest(TestResults.GN99ISO100Power0Distance10Aperture9Metres);
    }

    @Test
    public void setGN122ISO100Power0Distance10Aperture12MetresDistanceTest(){
        setUpDistanceIntegrationTest(TestResults.GN122ISO100Power0Distance10Aperture12Metres);
    }

    @Test
    public void setGN33ISO200Power0Distance10Aperture4MetresDistanceTest(){
        setUpDistanceIntegrationTest(TestResults.GN33ISO200Power0Distance10Aperture4Metres);
    }

    @Test
    public void setGN33ISO400Power0Distance10Aperture6MetresDistanceTest(){
        setUpDistanceIntegrationTest(TestResults.GN33ISO400Power0Distance10Aperture6Metres);
    }

    @Test
    public void setGN33ISO1600Power0Distance10Aperture13MetresDistanceTest(){
        setUpDistanceIntegrationTest(TestResults.GN33ISO1600Power0Distance10Aperture13Metres);
    }

    /*
    Feet
     */
    @Test
    public void setGN33ISO100Power0Distance5Aperture21FeetApertureTest(){
        setUpApertureIntegrationTest(TestResults.GN33ISO100Power0Distance5Aperture21Feet);
    }

    @Test
    public void setGN33ISO100Power0Distance10Aperture3FeetApertureTest(){
        setUpApertureIntegrationTest(TestResults.GN33ISO100Power0Distance10Aperture3Feet);
    }

    @Test
    public void setGN33ISO100Power0Distance15Aperture2FeetApertureTest(){
        setUpApertureIntegrationTest(TestResults.GN33ISO100Power0Distance15Aperture2Feet);
    }

    @Test
    public void setGN66ISO100Power0Distance10Aperture6FeetApertureTest(){
        setUpApertureIntegrationTest(TestResults.GN66ISO100Power0Distance10Aperture6Feet);
    }

    @Test
    public void setGN99ISO100Power0Distance10Aperture9FeetApertureTest(){
        setUpApertureIntegrationTest(TestResults.GN99ISO100Power0Distance10Aperture9Feet);
    }

    @Test
    public void setGN122ISO100Power0Distance10Aperture12FeetApertureTest(){
        setUpApertureIntegrationTest(TestResults.GN122ISO100Power0Distance10Aperture12Feet);
    }

    @Test
    public void setGN33ISO200Power0Distance10Aperture4FeetApertureTest(){
        setUpApertureIntegrationTest(TestResults.GN33ISO200Power0Distance10Aperture4Feet);
    }

    @Test
    public void setGN33ISO400Power0Distance10Aperture6FeetApertureTest(){
        setUpApertureIntegrationTest(TestResults.GN33ISO400Power0Distance10Aperture6Feet);
    }

    @Test
    public void setGN33ISO1600Power0Distance10Aperture13FeetApertureTest(){
        setUpApertureIntegrationTest(TestResults.GN33ISO1600Power0Distance10Aperture13Feet);
    }

    @Test
    public void setGN33ISO100Power0Distance5Aperture21FeetDistanceTest(){
        setUpDistanceIntegrationTest(TestResults.GN33ISO100Power0Distance5Aperture21Feet);
    }

    @Test
    public void setGN33ISO100Power0Distance10Aperture3FeetDistanceTest(){
        setUpDistanceIntegrationTest(TestResults.GN33ISO100Power0Distance10Aperture3Feet);
    }

    @Test
    public void setGN33ISO100Power0Distance15Aperture2FeetDistanceTest(){
        setUpDistanceIntegrationTest(TestResults.GN33ISO100Power0Distance15Aperture2Feet);
    }

    @Test
    public void setGN66ISO100Power0Distance10Aperture6FeetDistanceTest(){
        setUpDistanceIntegrationTest(TestResults.GN66ISO100Power0Distance10Aperture6Feet);
    }

    @Test
    public void setGN99ISO100Power0Distance10Aperture9FeetDistanceTest(){
        setUpDistanceIntegrationTest(TestResults.GN99ISO100Power0Distance10Aperture9Feet);
    }

    @Test
    public void setGN122ISO100Power0Distance10Aperture12FeetDistanceTest(){
        setUpDistanceIntegrationTest(TestResults.GN122ISO100Power0Distance10Aperture12Feet);
    }

    @Test
    public void setGN33ISO200Power0Distance10Aperture4FeetDistanceTest(){
        setUpDistanceIntegrationTest(TestResults.GN33ISO200Power0Distance10Aperture4Feet);
    }

    @Test
    public void setGN33ISO400Power0Distance10Aperture6FeetDistanceTest(){
        setUpDistanceIntegrationTest(TestResults.GN33ISO400Power0Distance10Aperture6Feet);
    }

    @Test
    public void setGN33ISO1600Power0Distance10Aperture13FeetDistanceTest(){
        setUpDistanceIntegrationTest(TestResults.GN33ISO1600Power0Distance10Aperture13Feet);
    }

}

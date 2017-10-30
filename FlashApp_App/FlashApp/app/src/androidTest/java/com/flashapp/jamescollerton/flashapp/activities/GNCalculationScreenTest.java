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

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.isDialog;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * This class is used to hold all of the tests for the main screen activity. This includes testing
 * filling in data and making sure the calculations are correct, and that the program errors if you
 * put in incorrect data.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class GNCalculationScreenTest extends GNAndroidTest {

    /*
    Button Clicks

    Methods to click the aperture and distance buttons on the main screen.
     */
    private void clickApertureButton() {
        AndroidTestUtils.clickButton(R.id.calculateAperture);
    }

    private void clickDistanceButton(){
        AndroidTestUtils.clickButton(R.id.calculateDistance);
    }

    /*
    Test Set Up

    Methods to set up tests for when we have filled in data and want to calculate the aperture,
    or when we have filled in data and we want to calculate the distance.
     */

    /**
     * This is used to set up the shared fields for both aperture and distance. Regardless of the
     * test type we will need to set the guide number, ISO, power and distance units.
     *
     * @param testResult This is a test result object which holds all of the values we want to set
     *                   the fields to, as well as the result we expect to get.
     */
    private void setUpSharedFields(TestResults testResult){
        GuideNumberFragmentTest.setGuideNumber(testResult.getGuideNumber(), testResult.getGuideNumber());
        AndroidTestUtils.closeKeyboard();
        ISOFragmentTest.setISO(testResult.getISO(), testResult.getISO());
        PowerFragmentTest.setPower(testResult.getPower(), testResult.getPower());
        DistanceFragmentTest.setDistanceUnits(testResult.getDistanceUnit(), testResult.getDistanceUnit());
    }

    /**
     * This is used to set up the tests where we want to calculate the aperture from the guide
     * number, ISO, power and distance.
     *
     * @param testResult This is a test result object which holds all of the values we want to set
     *                   the fields to, as well as the result we expect to get.
     */
    private void setUpApertureIntegrationTest(TestResults testResult) {
        setUpSharedFields(testResult);
        DistanceFragmentTest.setDistance(testResult.getDistance(), testResult.getDistance());
        AndroidTestUtils.closeKeyboard();
        clickApertureButton();
        AndroidTestUtils.checkEditText(testResult.getAperture(), R.id.aperture);
    }

    /**
     * This is the same as above, but rather than calculating aperture from distance it calculates
     * distance from aperture.
     *
     * @param testResult
     */
    private void setUpDistanceIntegrationTest(TestResults testResult) {
        setUpSharedFields(testResult);
        ApertureFragmentTest.setAperture(testResult.getAperture(), testResult.getAperture());
        AndroidTestUtils.closeKeyboard();
        clickDistanceButton();
        AndroidTestUtils.checkEditText(testResult.getDistance(), R.id.distance);
    }

    /*
    Metres

    All the tests where the distance is in metres
     */

    /*
    Aperture Tests
     */

    /**
     * Each of these tests functions the same. They are essentially wrappers for calling an
     * aperture integration test with a different test result value.
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
    public void testGN33ISO100Power2Distance10Aperture13MetresApertureTest(){
        setUpApertureIntegrationTest(TestResults.GN33ISO100Power2Distance10Aperture13Metres);
    }

    @Test
    public void testGN33ISO100Power4Distance10Aperture13MetresApertureTest(){
        setUpApertureIntegrationTest(TestResults.GN33ISO100Power4Distance10Aperture13Metres);
    }

    @Test
    public void testGN33ISO100Power7Distance10Aperture13MetresApertureTest(){
        setUpApertureIntegrationTest(TestResults.GN33ISO100Power7Distance10Aperture13Metres);
    }

    /*
    Distance Tests
     */

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

    /*
    Aperture Tests
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

    /*
    Distance Tests
     */

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

    @Test
    public void testGN33ISO100Power2Distance10Aperture13MetresDistanceTest(){
        setUpDistanceIntegrationTest(TestResults.GN33ISO100Power2Distance10Aperture13Metres);
    }

    @Test
    public void testGN33ISO100Power4Distance10Aperture13MetresDistanceTest(){
        setUpDistanceIntegrationTest(TestResults.GN33ISO100Power4Distance10Aperture13Metres);
    }

    @Test
    public void testGN33ISO100Power7Distance10Aperture13MetresDistanceTest(){
        setUpDistanceIntegrationTest(TestResults.GN33ISO100Power7Distance10Aperture13Metres);
    }

    /*
    Incomplete Data

    These are tests when we are missing data. If the user has not entered the ISO, guide number,
    power and distance/ aperture (depending on what we are calculating) they should receive an
    error message.
     */

    /**
     * This is used to check the user is seeing an error message.
     */
//    private void checkMissingInfoDialogShowing() {
//        onView(withText(R.string.alert_box_missing_info_title)).inRoot(isDialog()).check(matches(isDisplayed()));
//    }

    /**
     * This is used to check the user is seeing the error message if distance settings are incorrect.
     */
    private void checkMissingDistanceInfoDialogShowing(){
        AndroidTestUtils.checkTextDisplayed(R.string.alert_box_missing_info_title);
        AndroidTestUtils.checkTextDisplayed(R.string.alert_box_missing_distance_info_text);
//        checkMissingInfoDialogShowing();
//        onView(withText(R.string.alert_box_missing_distance_info_text)).inRoot(isDialog()).check(matches(isDisplayed()));
    }

    private void checkMissingApertureInfoDialogShowing(){
        AndroidTestUtils.checkTextDisplayed(R.string.alert_box_missing_info_title);
        AndroidTestUtils.checkTextDisplayed(R.string.alert_box_missing_aperture_info_text);
//        checkMissingInfoDialogShowing();

    }

    /**
     * When guide number and distance are not populated and we try to calculate aperture.
     */
    @Test
    public void missingGuideNumberDistanceApertureTest(){
        clickApertureButton();
        checkMissingApertureInfoDialogShowing();
    }

    /**
     * When guide number is not populated and we try to calculate aperture.
     */
    @Test
    public void missingGuideNumberApertureTest(){
        DistanceFragmentTest.setDistance("10", "10");
        AndroidTestUtils.closeKeyboard();
        clickApertureButton();
        checkMissingApertureInfoDialogShowing();
//        checkMissingInfoDialogShowing();
    }

    /**
     * When guide number and aperture are not populated and we try to calculate distance.
     */
    @Test
    public void missingGuideNumberApertureDistanceTest(){
        clickDistanceButton();
        checkMissingDistanceInfoDialogShowing();
//        checkMissingInfoDialogShowing();
    }

    /**
     * When aperture is not populated and we try and calculate distance.
     */
    @Test
    public void missingGuideNumberDistanceTest(){
        ApertureFragmentTest.setAperture("10", "10");
        AndroidTestUtils.closeKeyboard();
        clickDistanceButton();
        checkMissingDistanceInfoDialogShowing();
//        checkMissingInfoDialogShowing();
    }

}

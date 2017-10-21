package com.flashapp.jamescollerton.flashapp;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;

import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.Matchers.*;

import com.flashapp.jamescollerton.flashapp.activities.GNCalculationScreen;
import com.flashapp.jamescollerton.flashapp.enumerators.DistanceUnit;
import com.flashapp.jamescollerton.flashapp.enumerators.Power;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import testUtils.TestResults;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ApplicationTest {

    @Rule
    public ActivityTestRule<GNCalculationScreen> mActivityRule =
            new ActivityTestRule(GNCalculationScreen.class);

    @Before
    public void closeKeyboard(){
        Espresso.closeSoftKeyboard();
    }

    /*
    EditText Tests
     */
    private void checkEditText(String expectedOutput, int editTextId){
        onView(withId(editTextId)).check(matches(withText(expectedOutput)));
    }

    private void setEditText(String input, String expectedOutput, int editTextId){
        onView(withId(editTextId)).perform(click()).perform(clearText()).perform(typeText(input));
        checkEditText(expectedOutput, editTextId);
    }

    private void setGuideNumber(String guideNumber, String expectedResult){
        setEditText(guideNumber, expectedResult, R.id.guideNumber);
    }

    private void setDistance(String distance, String expectedResult){
        setEditText(distance, expectedResult, R.id.distance);
    }

    private void setAperture(String aperture, String expectedResult){
        setEditText(aperture, expectedResult, R.id.aperture);
    }
//
//    /*
//    Guide Number Tests
//     */
//
//    @Test
//    public void setGuideNumberInt() {
//        setGuideNumber("10", "10");
//    }
//
//    @Test
//    public void setGuideNumberChar() {
//        setGuideNumber("abcd", "");
//    }
//
//    @Test
//    public void setGuideNumberCharIntMixedOne() {
//        setGuideNumber("abcd10", "10");
//    }
//
//    @Test
//    public void setGuideNumberCharIntMixedTwo() {
//        setGuideNumber("ab1cd0", "10");
//    }
//
//    @Test
//    public void setGuideNumberCharSymbol() {
//        setGuideNumber("!!!!", "1111");
//    }
//
//    @Test
//    public void setGuideNumberCharSymbolInt() {
//        setGuideNumber("!1!0!!", "111011");
//    }
//
//    /*
//    Distance Tests
//     */
//
//    @Test
//    public void setDistanceInt() {
//        setDistance("10", "10");
//    }
//
//    @Test
//    public void setDistanceChar() {
//        setDistance("abcd", "");
//    }
//
//    @Test
//    public void setDistanceCharIntMixedOne() {
//        setDistance("abcd10", "10");
//    }
//
//    @Test
//    public void setDistanceCharIntMixedTwo() {
//        setDistance("ab1cd0", "10");
//    }
//
//    @Test
//    public void setDistanceCharSymbol() {
//        setDistance("!!!!", "1111");
//    }
//
//    @Test
//    public void setDistanceCharSymbolInt() {
//        setDistance("!1!0!!", "111011");
//    }
//
//    /*
//    Aperture Tests
//     */
//
//    @Test
//    public void setApertureInt() {
//        setAperture("10", "10");
//    }
//
//    @Test
//    public void setApertureChar() {
//        setAperture("abcd", "");
//    }
//
//    @Test
//    public void setApertureCharIntMixedOne() {
//        setAperture("abcd10", "10");
//    }
//
//    @Test
//    public void setApertureCharIntMixedTwo() {
//        setAperture("ab1cd0", "10");
//    }
//
//    @Test
//    public void setApertureCharSymbol() {
//        setAperture("!!!!", "1111");
//    }
//
//    @Test
//    public void setApertureCharSymbolInt() {
//        setAperture("!1!0!!", "111011");
//    }
//
//    /*
//    Spinner Tests
//     */
//
    private void setSpinner(String input, String expectedOutput, int spinnerId){
        onView(withId(spinnerId)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is(input))).perform(click());
        onView(withId(spinnerId)).check(matches(withSpinnerText(containsString(expectedOutput))));
    }

    private <T> void setCustomSpinner(T input, T expectedOutput, Class customClass, int spinnerId){
        onView(withId(spinnerId)).perform(click());
        onData(allOf(is(instanceOf(customClass)), is(input))).perform(click());
        onView(withId(spinnerId)).check(matches(withSpinnerText(containsString(expectedOutput.toString()))));
    }

    /*
    ISO
     */

    private void setISO(String input, String expectedOutput){
        setSpinner(input, expectedOutput, R.id.ISO);
    }

//    @Test
//    public void setISO100() {
//        setISO("100", "100");
//    }
//
//    @Test
//    public void setISO200() {
//        setISO("200", "200");
//    }
//
//    @Test
//    public void setISO400() {
//        setISO("400", "400");
//    }
//
//    @Test
//    public void setISO800() {
//        setISO("800", "800");
//    }
//
//    @Test
//    public void setISO1600() {
//        setISO("1600", "1600");
//    }
//
//    @Test
//    public void setISO3200() {
//        setISO("3200", "3200");
//    }
//
//    /*
//    Power
//     */
//
    private void setPower(Power input, Power expectedOutput){
        setCustomSpinner(input, expectedOutput, Power.class, R.id.power);
    }
//
//    @Test
//    public void setPowerZero() {
//        setPower(Power.ZERO, Power.ZERO);
//    }
//
//    @Test
//    public void setPowerMinusOne() {
//        setPower(Power.MINUS_ONE, Power.MINUS_ONE);
//    }
//
//    @Test
//    public void setPowerMinusTwo() {
//        setPower(Power.MINUS_TWO, Power.MINUS_TWO);
//    }
//
//    @Test
//    public void setPowerMinusThree() {
//        setPower(Power.MINUS_THREE, Power.MINUS_THREE);
//    }
//
//    @Test
//    public void setPowerMinusFour() {
//        setPower(Power.MINUS_FOUR, Power.MINUS_FOUR);
//    }
//
//    @Test
//    public void setPowerMinusFive() {
//        setPower(Power.MINUS_FIVE, Power.MINUS_FIVE);
//    }
//
//    @Test
//    public void setPowerMinusSix() {
//        setPower(Power.MINUS_SIX, Power.MINUS_SIX);
//    }
//
//    @Test
//    public void setPowerMinusSeven() {
//        setPower(Power.MINUS_SEVEN, Power.MINUS_SEVEN);
//    }

    /*
    Distance Units
     */
    private void setDistanceUnits(DistanceUnit input, DistanceUnit expectedOutput){
        setCustomSpinner(input, expectedOutput, DistanceUnit.class, R.id.distanceUnit);
    }
//
//
//    @Test
//    public void setDistanceUnitsMetres(){
//        setDistanceUnits(DistanceUnit.METRES, DistanceUnit.METRES);
//    }
//
//    @Test
//    public void setDistanceUnitFeet(){
//        setDistanceUnits(DistanceUnit.FEET, DistanceUnit.FEET);
//    }

    /*
    Integration Tests
     */

    private void clickButton(int buttonId){
        onView(withId(buttonId)).perform(click());
    }

    private void clickApertureButton(){
        clickButton(R.id.calculateAperture);
    }

    private void clickDistanceButton(){
        clickButton(R.id.calculateDistance);
    }

    private void setUpSharedFields(TestResults testResult){
        setGuideNumber(testResult.getGuideNumber(), testResult.getGuideNumber());
        closeKeyboard();
        setISO(testResult.getISO(), testResult.getISO());
        setPower(testResult.getPower(), testResult.getPower());
        setDistanceUnits(testResult.getDistanceUnit(), testResult.getDistanceUnit());
    }

    private void setUpApertureIntegrationTest(TestResults testResult) {
        setUpSharedFields(testResult);
        setDistance(testResult.getDistance(), testResult.getDistance());
        closeKeyboard();
        clickApertureButton();
        checkEditText(testResult.getAperture(), R.id.aperture);
    }

    private void setUpDistanceIntegrationTest(TestResults testResult) {
        setUpSharedFields(testResult);
        setAperture(testResult.getAperture(), testResult.getAperture());
        closeKeyboard();
        clickDistanceButton();
        checkEditText(testResult.getDistance(), R.id.distance);
    }

    /*
    Metres
     */
//    @Test
//    public void setGN33ISO100Power0Distance5Aperture6MetresApertureTest(){
//        setUpApertureIntegrationTest(TestResults.GN33ISO100Power0Distance5Aperture6Metres);
//    }
//
//    @Test
//    public void setGN33ISO100Power0Distance10Aperture3MetresApertureTest(){
//        setUpApertureIntegrationTest(TestResults.GN33ISO100Power0Distance10Aperture3Metres);
//    }
//
//    @Test
//    public void setGN33ISO100Power0Distance15Aperture2MetresApertureTest(){
//        setUpApertureIntegrationTest(TestResults.GN33ISO100Power0Distance15Aperture2Metres);
//    }
//
//    @Test
//    public void setGN66ISO100Power0Distance10Aperture6MetresApertureTest(){
//        setUpApertureIntegrationTest(TestResults.GN66ISO100Power0Distance10Aperture6Metres);
//    }
//
//    @Test
//    public void setGN99ISO100Power0Distance10Aperture9MetresApertureTest(){
//        setUpApertureIntegrationTest(TestResults.GN99ISO100Power0Distance10Aperture9Metres);
//    }
//
//    @Test
//    public void setGN122ISO100Power0Distance10Aperture12MetresApertureTest(){
//        setUpApertureIntegrationTest(TestResults.GN122ISO100Power0Distance10Aperture12Metres);
//    }
//
//    @Test
//    public void setGN33ISO200Power0Distance10Aperture4MetresApertureTest(){
//        setUpApertureIntegrationTest(TestResults.GN33ISO200Power0Distance10Aperture4Metres);
//    }
//
//    @Test
//    public void setGN33ISO400Power0Distance10Aperture6MetresApertureTest(){
//        setUpApertureIntegrationTest(TestResults.GN33ISO400Power0Distance10Aperture6Metres);
//    }
//
//    @Test
//    public void setGN33ISO1600Power0Distance10Aperture13MetresApertureTest(){
//        setUpApertureIntegrationTest(TestResults.GN33ISO1600Power0Distance10Aperture13Metres);
//    }
//
//    @Test
//    public void setGN33ISO100Power0Distance5Aperture6MetresDistanceTest(){
//        setUpDistanceIntegrationTest(TestResults.GN33ISO100Power0Distance5Aperture6Metres);
//    }
//
//    @Test
//    public void setGN33ISO100Power0Distance10Aperture3MetresDistanceTest(){
//        setUpDistanceIntegrationTest(TestResults.GN33ISO100Power0Distance10Aperture3Metres);
//    }
//
//    @Test
//    public void setGN33ISO100Power0Distance15Aperture2MetresDistanceTest(){
//        setUpDistanceIntegrationTest(TestResults.GN33ISO100Power0Distance15Aperture2Metres);
//    }
//
//    @Test
//    public void setGN66ISO100Power0Distance10Aperture6MetresDistanceTest(){
//        setUpDistanceIntegrationTest(TestResults.GN66ISO100Power0Distance10Aperture6Metres);
//    }
//
//    @Test
//    public void setGN99ISO100Power0Distance10Aperture9MetresDistanceTest(){
//        setUpDistanceIntegrationTest(TestResults.GN99ISO100Power0Distance10Aperture9Metres);
//    }
//
//    @Test
//    public void setGN122ISO100Power0Distance10Aperture12MetresDistanceTest(){
//        setUpDistanceIntegrationTest(TestResults.GN122ISO100Power0Distance10Aperture12Metres);
//    }
//
//    @Test
//    public void setGN33ISO200Power0Distance10Aperture4MetresDistanceTest(){
//        setUpDistanceIntegrationTest(TestResults.GN33ISO200Power0Distance10Aperture4Metres);
//    }
//
//    @Test
//    public void setGN33ISO400Power0Distance10Aperture6MetresDistanceTest(){
//        setUpDistanceIntegrationTest(TestResults.GN33ISO400Power0Distance10Aperture6Metres);
//    }
//
//    @Test
//    public void setGN33ISO1600Power0Distance10Aperture13MetresDistanceTest(){
//        setUpDistanceIntegrationTest(TestResults.GN33ISO1600Power0Distance10Aperture13Metres);
//    }

    /*
    Feet TODO: Rename all methods
     */
//    @Test
//    public void setGN33ISO100Power0Distance5Aperture21FeetApertureTest(){
//        setUpApertureIntegrationTest(TestResults.GN33ISO100Power0Distance5Aperture21Feet);
//    }
//
//    @Test
//    public void setGN33ISO100Power0Distance10Aperture3FeetApertureTest(){
//        setUpApertureIntegrationTest(TestResults.GN33ISO100Power0Distance10Aperture3Feet);
//    }

//    @Test
//    public void setGN33ISO100Power0Distance15Aperture2FeetApertureTest(){
//        setUpApertureIntegrationTest(TestResults.GN33ISO100Power0Distance15Aperture2Feet);
//    }

//    @Test
//    public void setGN66ISO100Power0Distance10Aperture6FeetApertureTest(){
//        setUpApertureIntegrationTest(TestResults.GN66ISO100Power0Distance10Aperture6Feet);
//    }
//
//    @Test
//    public void setGN99ISO100Power0Distance10Aperture9FeetApertureTest(){
//        setUpApertureIntegrationTest(TestResults.GN99ISO100Power0Distance10Aperture9Feet);
//    }
//
//    @Test
//    public void setGN122ISO100Power0Distance10Aperture12FeetApertureTest(){
//        setUpApertureIntegrationTest(TestResults.GN122ISO100Power0Distance10Aperture12Feet);
//    }
//
//    @Test
//    public void setGN33ISO200Power0Distance10Aperture4FeetApertureTest(){
//        setUpApertureIntegrationTest(TestResults.GN33ISO200Power0Distance10Aperture4Feet);
//    }
//
//    @Test
//    public void setGN33ISO400Power0Distance10Aperture6FeetApertureTest(){
//        setUpApertureIntegrationTest(TestResults.GN33ISO400Power0Distance10Aperture6Feet);
//    }
//
//    @Test
//    public void setGN33ISO1600Power0Distance10Aperture13FeetApertureTest(){
//        setUpApertureIntegrationTest(TestResults.GN33ISO1600Power0Distance10Aperture13Feet);
//    }

    @Test
    public void setGN33ISO100Power0Distance5Aperture6FeetDistanceTest(){
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

package testUtils;

import com.flashapp.jamescollerton.flashapp.enumerators.DistanceUnit;
import com.flashapp.jamescollerton.flashapp.enumerators.Power;

public enum TestResults {

    GN33ISO100Power0Distance5Aperture6Metres("33", "100", Power.ZERO, "5.0", "6.6", DistanceUnit.METRES),
    GN33ISO100Power0Distance10Aperture3Metres("33", "100", Power.ZERO, "10.0", "3.3", DistanceUnit.METRES),
    GN33ISO100Power0Distance15Aperture2Metres("33", "100", Power.ZERO, "15.0", "2.2", DistanceUnit.METRES),
    GN66ISO100Power0Distance10Aperture6Metres("66", "100", Power.ZERO, "10.0", "6.6", DistanceUnit.METRES),
    GN99ISO100Power0Distance10Aperture9Metres("99", "100", Power.ZERO, "10.0", "9.9", DistanceUnit.METRES),
    GN122ISO100Power0Distance10Aperture12Metres("122", "100", Power.ZERO, "10.0", "12.2", DistanceUnit.METRES),
    GN33ISO200Power0Distance10Aperture4Metres("33", "200", Power.ZERO, "10.0", "4.666905", DistanceUnit.METRES),
    GN33ISO400Power0Distance10Aperture6Metres("33", "400", Power.ZERO, "10.0", "6.6", DistanceUnit.METRES),
    GN33ISO1600Power0Distance10Aperture13Metres("33", "1600", Power.ZERO, "10.0", "13.2", DistanceUnit.METRES),
    GN33ISO100Power0Distance5Aperture21Feet("33", "100", Power.ZERO, "5.0", "21.653543", DistanceUnit.FEET), // TODO Rename all of these
    GN33ISO100Power0Distance10Aperture3Feet("33", "100", Power.ZERO, "10.0", "10.826772", DistanceUnit.FEET),
    GN33ISO100Power0Distance15Aperture2Feet("33", "100", Power.ZERO, "15.0", "7.217848", DistanceUnit.FEET),
    GN66ISO100Power0Distance10Aperture6Feet("66", "100", Power.ZERO, "10.0", "21.653543", DistanceUnit.FEET),
    GN99ISO100Power0Distance10Aperture9Feet("99", "100", Power.ZERO, "10.0", "32.480316", DistanceUnit.FEET),
    GN122ISO100Power0Distance10Aperture12Feet("122", "100", Power.ZERO, "10.0", "40.02625", DistanceUnit.FEET),
    GN33ISO200Power0Distance10Aperture4Feet("33", "200", Power.ZERO, "10.0", "15.311368", DistanceUnit.FEET),
    GN33ISO400Power0Distance10Aperture6Feet("33", "400", Power.ZERO, "10.0", "21.653543", DistanceUnit.FEET),
    GN33ISO1600Power0Distance10Aperture13Feet("33", "1600", Power.ZERO, "10.0", "43.307087", DistanceUnit.FEET);

    private final String guideNumber;
    private final String ISO;
    private final Power power;
    private final String distance;
    private final String aperture;
    private final DistanceUnit distanceUnit;

    TestResults(String guideNumber, String ISO, Power power, String distance, String aperture, DistanceUnit distanceUnit){
        this.guideNumber = guideNumber;
        this.ISO = ISO;
        this.power = power;
        this.distance = distance;
        this.aperture = aperture;
        this.distanceUnit = distanceUnit;
    }

    public String getGuideNumber() {
        return guideNumber;
    }

    public String getISO() {
        return ISO;
    }

    public Power getPower() {
        return power;
    }

    public String getDistance() {
        return distance;
    }

    public String getAperture() {
        return aperture;
    }

    public DistanceUnit getDistanceUnit() { return distanceUnit; }
}
package testUtils;

import com.flashapp.jamescollerton.flashapp.enumerators.Power;

public enum TestResults {

    GN33ISO100Power0Distance5Aperture6("33", "100", Power.ZERO, "5.0", "6.6"),
    GN33ISO100Power0Distance10Aperture3("33", "100", Power.ZERO, "10.0", "3.3"),
    GN33ISO100Power0Distance15Aperture2("33", "100", Power.ZERO, "15.0", "2.2"),
    GN66ISO100Power0Distance10Aperture6("66", "100", Power.ZERO, "10.0", "6.6"),
    GN99ISO100Power0Distance10Aperture9("99", "100", Power.ZERO, "10.0", "9.9"),
    GN122ISO100Power0Distance10Aperture12("122", "100", Power.ZERO, "10.0", "12.2"),
    GN33ISO200Power0Distance10Aperture4("33", "200", Power.ZERO, "10.0", "4.666905"),
    GN33ISO400Power0Distance10Aperture6("33", "400", Power.ZERO, "10.0", "6.6"),
    GN33ISO1600Power0Distance10Aperture13("33", "1600", Power.ZERO, "10.0", "13.2");

    private final String guideNumber;
    private final String ISO;
    private final Power power;
    private final String distance;
    private final String aperture;

    TestResults(String guideNumber, String ISO, Power power, String distance, String aperture){
        this.guideNumber = guideNumber;
        this.ISO = ISO;
        this.power = power;
        this.distance = distance;
        this.aperture = aperture;
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
}
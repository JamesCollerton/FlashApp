package testUtils;

import com.flashapp.jamescollerton.flashapp.enumerators.Power;

public enum TestResults {

    GN33ISO100Power0Distance5Aperture3("33", "100", Power.ZERO, "5", "6.6"),
    GN33ISO100Power0Distance10Aperture3("33", "100", Power.ZERO, "10", "3.3"),
    GN33ISO100Power0Distance15Aperture3("33", "100", Power.ZERO, "15", "2.2");

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
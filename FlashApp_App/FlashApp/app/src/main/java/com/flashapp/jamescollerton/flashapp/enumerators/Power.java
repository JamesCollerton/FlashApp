package com.flashapp.jamescollerton.flashapp.enumerators;

/**
 * This is used to hold all of the different values the power can have.
 */
public enum Power {

    ZERO(0),
    MINUS_ONE(1),
    MINUS_TWO(2),
    MINUS_THREE(3),
    MINUS_FOUR(4),
    MINUS_FIVE(5),
    MINUS_SIX(6),
    MINUS_SEVEN(7);

    /**
     * Power is displayed as a fraction string, however for the mathematics used it is easiest to
     * store as an integer value.
     */
    private final String fraction;
    private final Integer value;

    Power(int power){
        this.fraction = "1/" + ((Double) (Math.pow(2, power))).intValue();
        this.value = -power;
    }

    public Integer getValue(){
        return this.value;
    }

    /**
     * Override the toString method so it displays correctly in the spinner
     *
     * @return fraction
     */
    @Override
    public String toString(){
        return fraction;
    }
}

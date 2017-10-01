package com.flashapp.jamescollerton.flashapp.enumerators;

/**
 * Created by JamesCollerton on 30/09/2017.
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

    private final String fraction;
    private final int value;

    Power(int power){
        this.fraction = "1/" + ((Double) (Math.pow(2, power))).intValue();
        this.value = -power;
    }

    @Override
    public String toString(){
        return fraction;
    }
}

package com.wesleyreisz.rockpaperscissors;

/**
 * Created by wesleyreisz on 9/14/14.
 */
public enum RockPaperScissorType {
    ROCK("Rock"), PAPER("Paper"), SCISSORS("Scissors");
    private String value;

    RockPaperScissorType(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}

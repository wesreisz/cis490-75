package com.wesleyreisz.rockpaperscissors;

import java.util.Date;
import java.util.Random;

/**
 * Created by wesleyreisz on 9/14/14.
 */
public class RockPaperScissorsAI {
    private static int counter=0;
    public RockPaperScissorType play(){
        Random random = new Random(new Date().getTime() + counter++);
        int randomNumber = random.nextInt(3);
        switch(randomNumber){
            case 0 : return RockPaperScissorType.ROCK;
            case 1 : return RockPaperScissorType.PAPER;
            default : return RockPaperScissorType.SCISSORS;
        }
    }
}

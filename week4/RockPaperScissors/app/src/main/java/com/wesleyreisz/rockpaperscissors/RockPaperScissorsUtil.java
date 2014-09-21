package com.wesleyreisz.rockpaperscissors;

import com.wesleyreisz.rockpaperscissors.behavior.Behavior;
import com.wesleyreisz.rockpaperscissors.behavior.BehaviorFactory;
import com.wesleyreisz.rockpaperscissors.behavior.RockBehavior;

/**
 * Created by wesleyreisz on 9/14/14.
 */
public class RockPaperScissorsUtil {
    public static final String INPUT_TYPE = "com.wesleyreisz.rockpaperscissors.inputType";

    public static String eval(RockPaperScissorType player1Choice, RockPaperScissorType player2Choice){
        Behavior player1Behavior = BehaviorFactory.getInstance(player1Choice);
        return player1Behavior.fight(player2Choice);
    }
}

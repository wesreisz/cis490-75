package com.wesleyreisz.rockpaperscissors.behavior;

import com.wesleyreisz.rockpaperscissors.RockPaperScissorType;

/**
 * Created by wesleyreisz on 9/21/14.
 */
public class BehaviorFactory {
    private BehaviorFactory(){}
    public static Behavior getInstance(RockPaperScissorType type){
        if(RockPaperScissorType.ROCK==type){
            return new RockBehavior();
        }else if(RockPaperScissorType.PAPER==type){
            return new PaperBehavior();
        }else{
            return new ScissorsBehavior();
        }
    }
}

package com.wesleyreisz.rockpaperscissors.behavior;

import com.wesleyreisz.rockpaperscissors.RockPaperScissorType;
import com.wesleyreisz.rockpaperscissors.RockPaperScissorsConstants;

/**
 * Created by wesleyreisz on 9/21/14.
 */
public class RockBehavior implements Behavior {
    @Override
    public String fight(RockPaperScissorType player2Choice) {
        if(player2Choice==null){
            throw new RuntimeException("No [Layer2choice value provided");
        }

        if(player2Choice==RockPaperScissorType.ROCK){
            return RockPaperScissorsConstants.TIE;
        }else if(player2Choice==RockPaperScissorType.PAPER){
            return RockPaperScissorsConstants.COMPUTER_WINS;
        }else{
            return RockPaperScissorsConstants.PLAYER_WINS;
        }
    }
}

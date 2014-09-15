package com.wesleyreisz.rockpaperscissors;

/**
 * Created by wesleyreisz on 9/14/14.
 */
public class RockPaperScissorsUtil {
    public static final String INPUT_TYPE = "com.wesleyreisz.rockpaperscissors.inputType";

    public static String eval(RockPaperScissorType player1Choice, RockPaperScissorType player2Choice){
        if(player1Choice==player2Choice){
            return "Tie";
        }else{
            if (player1Choice==RockPaperScissorType.ROCK){ //rock beats scissors
                if(player2Choice==RockPaperScissorType.SCISSORS){
                    return "Player 1 Wins";
                }else{
                    return "Computer Wins";
                }
            }else if (player1Choice==RockPaperScissorType.SCISSORS){//scissors beats paper
                if(player2Choice==RockPaperScissorType.PAPER){
                    return "Player 1 Wins";
                }else{
                    return "Computer Wins";
                }
            }else{//paper
                if(player2Choice==RockPaperScissorType.ROCK){//paper beats rock
                    return "Player 1 Wins";
                }else{
                    return "Computer Wins";
                }
            }
        }
    }
}

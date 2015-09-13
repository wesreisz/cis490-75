package com.wesleyreisz.rockpaperscissors.Game;

import com.wesleyreisz.rockpaperscissors.GameUtils;
import com.wesleyreisz.rockpaperscissors.R;

/**
 * Created by wesleyreisz on 9/13/15.
 */
public class Rock implements GameType {
    @Override
    public String eval(Integer opponentChoice) {
        if (opponentChoice== R.id.btnScissors){
            return GameUtils.BEATS;
        }else if (opponentChoice==R.id.btnPaper){
            return GameUtils.LOSES_TO;
        }
        else{
            return GameUtils.TIES;
        }
    }
}

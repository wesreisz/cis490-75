package com.wesleyreisz.rockpaperscissors;

import android.app.Application;
import android.test.ApplicationTestCase;

import junit.framework.Assert;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testScissors(){
        Integer player = R.id.btnScissors;

        Assert.assertEquals(GameUtils.BEATS,GameUtils.evaluateWinner(player,R.id.btnPaper));
        Assert.assertEquals(GameUtils.TIES,GameUtils.evaluateWinner(player, R.id.btnScissors));
        Assert.assertEquals(GameUtils.LOSES_TO,GameUtils.evaluateWinner(player,R.id.btnRock));

        Assert.assertNotSame(GameUtils.TIES, GameUtils.evaluateWinner(player, R.id.btnPaper));
    }


    public void testRock(){
        Integer player = R.id.btnRock;

        Assert.assertEquals(GameUtils.LOSES_TO,GameUtils.evaluateWinner(player,R.id.btnPaper));
        Assert.assertEquals(GameUtils.BEATS,GameUtils.evaluateWinner(player, R.id.btnScissors));
        Assert.assertEquals(GameUtils.TIES,GameUtils.evaluateWinner(player,R.id.btnRock));

        Assert.assertNotSame(GameUtils.TIES,GameUtils.evaluateWinner(player,R.id.btnPaper));
    }

    public void testPaper(){
        Integer player = R.id.btnPaper;

        Assert.assertEquals(GameUtils.TIES,GameUtils.evaluateWinner(player,R.id.btnPaper));
        Assert.assertEquals(GameUtils.LOSES_TO,GameUtils.evaluateWinner(player, R.id.btnScissors));
        Assert.assertEquals(GameUtils.BEATS,GameUtils.evaluateWinner(player,R.id.btnRock));

        Assert.assertNotSame(GameUtils.BEATS,GameUtils.evaluateWinner(player,R.id.btnPaper));
    }

}
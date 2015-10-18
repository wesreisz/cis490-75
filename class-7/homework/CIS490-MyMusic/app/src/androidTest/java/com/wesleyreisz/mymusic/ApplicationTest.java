package com.wesleyreisz.mymusic;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.wesleyreisz.mymusic.model.Song;
import com.wesleyreisz.mymusic.service.MockMusicService;

import junit.framework.Assert;

import java.util.List;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testFindAll(){
        MockMusicService service = new MockMusicService();
        List<Song> songs = service.findAll();
        Assert.assertNotNull(songs);

        boolean testResultFound=false;
        for(Song song:songs){
            if (song.getSongTitle().equalsIgnoreCase("Dark Horse")){
                testResultFound=true;
            }
        }
        Assert.assertEquals(true,testResultFound);
    }

    public void testFindOne(){
        MockMusicService service = new MockMusicService();
        Song song = service.findOne("Dark Horse");
        Assert.assertEquals("Dark Horse", song.getSongTitle());
        Assert.assertEquals("Katy Perry", song.getArtistName());
        Assert.assertEquals("Single", song.getAlbumTitle());
    }
}
package cs3500.hw04;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by David on 6/3/2016.
 */
public class WhistTrumpModelTest {
    @Test
    public void testThings(){
        WhistTrumpModel game = new WhistTrumpModel();
        game.startPlay(2, game.getDeck());
        System.out.print(game.getGameState());
    }

}
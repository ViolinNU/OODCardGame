package cs3500.hw04;

import org.junit.Test;

import cs3500.hw03.CardGameModel;

import static org.junit.Assert.*;

/**
 * Created by David on 6/3/2016.
 */
public class WhistModelCreatorTest {

  @Test
  public void testThings(){
    WhistModelCreator test = new WhistModelCreator();
    CardGameModel test2 = test.create(ModelType.TRUMP);
    test2.startPlay(2, test2.getDeck());
    System.out.print(test2.getGameState());
    CardGameModel test3 = test.create(ModelType.NOTRUMP);
    test3.startPlay(2, test2.getDeck());
    System.out.println("\n" + test3.getGameState());
  }
}
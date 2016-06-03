package cs3500.hw04;

import org.junit.Test;

import cs3500.hw02.StandardCard;
import cs3500.hw03.CardGameModel;

import static org.junit.Assert.*;

/**
 * Created by David on 6/3/2016.
 */
public class WhistModelCreatorTest {

  String trumpGame = "Number of players: 2\nPlayer 1: A♣, Q♣, 10♣, 8♣, 6♣, 4♣, 2♣, K♦, J♦," +
          " 9♦, 7♦, 5♦, 3♦, A♥, Q♥, 10♥, 8♥, 6♥, 4♥, 2♥, K♠, J♠, 9♠, 7♠, 5♠, 3♠\n" +
          "Player 2: K♣, J♣, 9♣, 7♣, 5♣, 3♣, A♦, Q♦, 10♦, 8♦, 6♦, 4♦, 2♦," +
          " K♥, J♥, 9♥, 7♥, 5♥, 3♥, A♠, Q♠, 10♠, 8♠, 6♠, 4♠, 2♠\nPlayer 1 score: 0" +
          "\nPlayer 2 score: 0\nTurn: Player 1\nTrump suit: ♣";
  String noTrumpGame = "Number of players: 2\nPlayer 1: A♣, Q♣, 10♣, 8♣, 6♣, 4♣, 2♣, K♦, J♦," +
          " 9♦, 7♦, 5♦, 3♦, A♥, Q♥, 10♥, 8♥, 6♥, 4♥, 2♥, K♠, J♠, 9♠, 7♠, 5♠, 3♠\n" +
          "Player 2: K♣, J♣, 9♣, 7♣, 5♣, 3♣, A♦, Q♦, 10♦, 8♦, 6♦, 4♦, 2♦," +
          " K♥, J♥, 9♥, 7♥, 5♥, 3♥, A♠, Q♠, 10♠, 8♠, 6♠, 4♠, 2♠\nPlayer 1 score: 0" +
          "\nPlayer 2 score: 0\nTurn: Player 1";
  @Test
  public void testCreate(){

    CardGameModel<StandardCard> trump = WhistModelCreator.create(WhistModelCreator.ModelType.TRUMP);
    trump.startPlay(2, trump.getDeck());
    assertEquals(trumpGame, trump.getGameState() );
    CardGameModel noTrump = WhistModelCreator.create(WhistModelCreator.ModelType.NOTRUMP);
    noTrump.startPlay(2, noTrump.getDeck());
    assertEquals(noTrumpGame, noTrump.getGameState() );
  }
}
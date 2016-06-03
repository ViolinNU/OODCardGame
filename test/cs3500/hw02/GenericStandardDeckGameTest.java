package cs3500.hw02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by David on 5/18/2016.
 */
public class GenericStandardDeckGameTest {
  StandardDeckUtil util = new StandardDeckUtil();
  GenericStandardDeckGame testGame = new GenericStandardDeckGame();
  List<StandardCard> testDeck = new ArrayList<StandardCard>();
  List<StandardCard> badDeckDuplicates = new ArrayList<StandardCard>();
  List<StandardCard> badDeckNotEnoughCards = new ArrayList<StandardCard>();
  List<StandardCard> badDeckTooManyCards = new ArrayList<StandardCard>();
  List<StandardCard> reverseOrderDeck = new ArrayList<StandardCard>();
  String standardDeck = "Number of players: 4\n"
          + "Player 1: A♣, 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n"
          + "Player 2: K♣, 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n"
          + "Player 3: Q♣, 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n"
          + "Player 4: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n";

  String roundRobinDeck = "Number of players: 3\n"
          + "Player 1: A♣, J♣, 8♣, 5♣, 2♣, Q♦, 9♦, 6♦, 3♦," +
          " K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n"
          + "Player 2: K♣, 10♣, 7♣, 4♣, A♦, J♦, 8♦, 5♦," +
          " 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n"
          + "Player 3: Q♣, 9♣, 6♣, 3♣, K♦, 10♦, 7♦, 4♦," +
          " A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n";

  @Test
  public void testgetDeck(){
    assertEquals(true, util.validDeck(testGame.getDeck()) );
  }


  //Standard order deck is displayed as given.
  @Test
  public void testGameStateStandardDeck(){
    initTestData();
    setTestDeck();
    testGame.startPlay(4 , testDeck);
    assertEquals(standardDeck,
            testGame.getGameState()
    );
  }

  //Checks for round robin dealing of cards, 3 players, so Player 1 should
  //recieve 1 extra card. Deck is sorted.
  @Test
  public void testGameStateRoundRobin(){
    initTestData();
    setTestDeck();
    testGame.startPlay( 3, testDeck);
    assertEquals(roundRobinDeck,
            testGame.getGameState()
    );
  }

  //Test for not enough players to start a game.
  @Test(expected = IllegalArgumentException.class)
  public void testStartPlayNotEnoughPlayers(){
    initTestData();
    testGame.startPlay(-1, testDeck);
  }

  //Test for bad deck, contains duplicates.
  @Test(expected = IllegalArgumentException.class)
  public void testStartBadDeckDuplicates(){
    initTestData();
    setBadDeckDuplicates();
    testGame.startPlay(4, badDeckDuplicates);
  }

  //Tests for bad deck, not enough cards.
  @Test(expected = IllegalArgumentException.class)
  public void testStartBadDeckNotEnoughCards(){
    initTestData();
    setBadDeckNotEnoughCards();
    testGame.startPlay(4, badDeckNotEnoughCards);
  }

  //Tests for bad, deck not enough cards.
  @Test(expected = IllegalArgumentException.class)
  public void testStartBadDeckTooManyCards(){
    initTestData();
    setBadDeckTooManyCards();
    testGame.startPlay(4, badDeckTooManyCards);
  }


  public void initTestData(){
    util = new StandardDeckUtil();
    testGame = new GenericStandardDeckGame();
    testDeck = new ArrayList<StandardCard>();
    badDeckDuplicates = new ArrayList<StandardCard>();
    badDeckNotEnoughCards = new ArrayList<StandardCard>();
    badDeckTooManyCards = new ArrayList<StandardCard>();
    reverseOrderDeck = new ArrayList<StandardCard>();
  }

  public void setTestDeck(){
    initTestData();
    for(int i = 0; i < StandardCard.suits.length; i++ ){
      for(int j = 0;j < StandardCard.values.length; j++){
        testDeck.add(new StandardCard(StandardCard.values[j], StandardCard.suits[i]));

      }
    }
  }

  public void setBadDeckDuplicates(){
    initTestData();
    for(int i = 0; i < StandardCard.suits.length; i++ ){
      for(int j = 0;j < StandardCard.values.length; j++){
        badDeckDuplicates.add(new StandardCard(StandardCard.values[2], StandardCard.suits[i]));

      }
    }
  }

  public void setBadDeckNotEnoughCards(){
    initTestData();
    for(int i = 0; i < StandardCard.suits.length; i++ ){
      for(int j = 0;j < 10; j++){
        badDeckDuplicates.add(new StandardCard(StandardCard.values[j], StandardCard.suits[i]));

      }
    }
  }

  public void setBadDeckTooManyCards(){
    initTestData();
    for(int i = 0; i < StandardCard.suits.length; i++ ){
      for(int j = 0;j < StandardCard.values.length; j++){
        badDeckDuplicates.add(new StandardCard(StandardCard.values[j], StandardCard.suits[i]));

      }
    }
    badDeckDuplicates.add(new StandardCard(StandardCard.values[2], StandardCard.suits[2]));
  }

  public void setReverseOrderDeck(){
    initTestData();
    for(int i = StandardCard.suits.length - 1; i > -1; i--){
      for(int j = StandardCard.values.length - 1;j > -1; j--){
        reverseOrderDeck.add(new StandardCard(StandardCard.values[j], StandardCard.suits[i]));

      }
    }
  }

  //Test deck sorted getDeck against reference test deck.
  @Test
  public void testGetDeck(){
    initTestData();
    setTestDeck();
    List<StandardCard> testGetDeck = testGame.getDeck();
    Collections.sort(testGetDeck);
    for(int i = 0; i < testDeck.size();i++) {
      assertEquals(testDeck.get(i), testGetDeck.get(i));
    }
  }







}
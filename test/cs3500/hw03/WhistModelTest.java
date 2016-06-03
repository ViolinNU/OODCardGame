package cs3500.hw03;

import org.junit.Test;

import java.util.ArrayList;

import cs3500.hw02.StandardCard;

import static org.junit.Assert.*;

/**
 * Created by David on 5/28/2016.
 */
public class WhistModelTest {

  WhistModel testModel = new WhistModel();

  String twoPlayer =
          "Number of players: 2" +
                  "\nPlayer 1: A♣, Q♣, 10♣, 8♣, 6♣, 4♣, 2♣, K♦, J♦, 9♦, 7♦, " +
                  "5♦, 3♦, A♥, Q♥, 10♥, 8♥, 6♥, 4♥, 2♥, K♠, J♠, 9♠, 7♠, 5♠, 3♠"+
                  "\nPlayer 2: K♣, J♣, 9♣, 7♣, 5♣, 3♣, A♦, Q♦, 10♦, 8♦, 6♦, 4♦, " +
                  "2♦, K♥, J♥, 9♥, 7♥, 5♥, 3♥, A♠, Q♠, 10♠, 8♠, 6♠, 4♠, 2♠" +
                  "\nPlayer 1 score: 0\nPlayer 2 score: 0\nTurn: Player 1";

  String threePlayer =
          "Number of players: 3\nPlayer 1: A♣, J♣, 8♣, 5♣, 2♣, Q♦, 9♦, 6♦, 3♦," +
                  " K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\nPlayer 2: K♣, 10♣, 7♣, 4♣, A♦," +
                  " J♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\nPlayer 3: Q♣, 9♣, 6♣, " +
                  "3♣, K♦, 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n"+
                  "Player 1 score: 0\nPlayer 2 score: 0\nPlayer 3 score: 0\nTurn: Player 1";
  String threePlayerGameOver =
          "Number of players: 3\nPlayer 1: 2♠\nPlayer 2: \nPlayer 3: \nPlayer 1 score: 17\n"+
                  "Player 2 score: 0\nPlayer 3 score: 0\nGame over. Player 1 won.";

  String play1Card =
          "Number of players: 2" +
                  "\nPlayer 1: Q♣, 10♣, 8♣, 6♣, 4♣, 2♣, K♦, J♦, 9♦, 7♦, " +
                  "5♦, 3♦, A♥, Q♥, 10♥, 8♥, 6♥, 4♥, 2♥, K♠, J♠, 9♠, 7♠, 5♠, 3♠"+
                  "\nPlayer 2: K♣, J♣, 9♣, 7♣, 5♣, 3♣, A♦, Q♦, 10♦, 8♦, 6♦, 4♦, " +
                  "2♦, K♥, J♥, 9♥, 7♥, 5♥, 3♥, A♠, Q♠, 10♠, 8♠, 6♠, 4♠, 2♠" +
                  "\nPlayer 1 score: 0\nPlayer 2 score: 0\nTurn: Player 2";
  String play2Card =
          "Number of players: 2" +
                  "\nPlayer 1: Q♣, 10♣, 8♣, 6♣, 4♣, 2♣, K♦, J♦, 9♦, 7♦, " +
                  "5♦, 3♦, A♥, Q♥, 10♥, 8♥, 6♥, 4♥, 2♥, K♠, J♠, 9♠, 7♠, 5♠, 3♠"+
                  "\nPlayer 2: J♣, 9♣, 7♣, 5♣, 3♣, A♦, Q♦, 10♦, 8♦, 6♦, 4♦, " +
                  "2♦, K♥, J♥, 9♥, 7♥, 5♥, 3♥, A♠, Q♠, 10♠, 8♠, 6♠, 4♠, 2♠" +
                  "\nPlayer 1 score: 1\nPlayer 2 score: 0\nTurn: Player 1";

  String gameOver = "Number of players: 2\nPlayer 1: \nPlayer 2: \nPlayer 1 score: 26" +
          "\nPlayer 2 score: 0\nGame over. Player 1 won.";

  String noPlayers = "Number of players: 0\nGame has not started.";


  ArrayList<StandardCard> testDeck = new ArrayList<StandardCard>();

  public void initModel(){
    this.testModel = new WhistModel();
  }

  public void start2Player(){
    initModel();
    setTestDeck();
    testModel.startPlay(2, testDeck);
  }


  public void start3Player(){
    initModel();
    setTestDeck();
    testModel.startPlay(3, testDeck);
  }

  public void setTestDeck(){
    testDeck = new ArrayList<StandardCard>();
    for(int i = 0; i < 4; i++ ){
      for(int j = 0;j < 13; j++){
        testDeck.add(new StandardCard(cs3500.hw02.StandardCard.values[j],
                cs3500.hw02.StandardCard.suits[i]));
      }
    }
  }

  //Plays through a whole game.
  public void playThrough() {
    initModel();
    setTestDeck();
    testModel.startPlay(2, testDeck);
    for (int i = 0; i < 2; ) {
      testModel.play(i, 0);
      if (!testModel.isGameOver()) {
        i = (i + 1) % 2;
      } else {
        i = 2;
      }
    }
  }

  //Plays through a whole game.
  public void play3Through() {
      start3Player();
    for (int i = 0; i < 3; ) {
      testModel.play(i, 0);
      if (!testModel.isGameOver()) {
        i = (i + 1) % 3;
      } else {
        i = 3;
      }
    }
  }

  @Test
  public void getGameState() throws Exception {
    initModel();
    setTestDeck();
    assertEquals(noPlayers, testModel.getGameState());
    testModel.startPlay(2, testDeck);
    assertEquals(twoPlayer, testModel.getGameState());
    playThrough();
    assertEquals(gameOver, testModel.getGameState());
  }

  @Test
  public void play() throws Exception {
    initModel();
    setTestDeck();
    testModel.startPlay(2, testDeck);
    testModel.play(0, 0);
    assertEquals(play1Card, testModel.getGameState());
    testModel.play(1, 0);
    assertEquals(play2Card, testModel.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPlayBadCard() throws Exception{
    start2Player();
    testModel.play(0, 30);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPlayWrongSuit() throws Exception{
    start2Player();
    testModel.play(0, 0);
    testModel.play(1, 12);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPlayBadPlayer() throws Exception{
    start2Player();
    testModel.play(10, 0);
  }

  @Test
  public void getCurrentPlayer() throws Exception {
    initModel();
    setTestDeck();
    testModel.startPlay(2, testDeck);
    testModel.play(0, 0);
    assertEquals(1, testModel.getCurrentPlayer());
    testModel.play(1, 0);
    assertEquals(0, testModel.getCurrentPlayer());
  }

  @Test(expected = IllegalArgumentException.class)
  public void getCurrentPlayerGameOver(){
    playThrough();
    testModel.getCurrentPlayer();
  }

  @Test
  public void isGameOver() throws Exception {
    initModel();
    setTestDeck();
    testModel.startPlay(2, testDeck);
    assertEquals(false, testModel.isGameOver());
    playThrough(); //Automates through a whole game.
    assertEquals(true, testModel.isGameOver());
  }

  @Test
  public void testOddPlayerAmount(){
    start3Player();
    assertEquals(threePlayer, testModel.getGameState());
    play3Through();
    assertEquals(threePlayerGameOver, testModel.getGameState());
  }

  @Test
  public void playCards(){
    start2Player();
    testModel.play(0, 0);
    assertEquals(play1Card, testModel.getGameState());
    testModel.play(1, 0);
    assertEquals(play2Card, testModel.getGameState());
  }





}
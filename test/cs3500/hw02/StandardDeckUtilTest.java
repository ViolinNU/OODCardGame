package cs3500.hw02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by David on 5/18/2016.
 */
public class StandardDeckUtilTest {

  StandardDeckUtil util = new StandardDeckUtil();
  List<StandardCard> badCountDeck = buildBadCountDeck();
  List<StandardCard> badRepeatDeck = buildRepeatDeck();


  //Returns an invalid deck, not enough cards.
  public List<StandardCard> buildBadCountDeck(){
    List<StandardCard> deck = new ArrayList<StandardCard>();

      for(int i = 0;i < 2; i++){
        for(int j = 0; j < 13; j++){
          deck.add(new StandardCard(StandardCard.values[j], StandardCard.suits[i]));
        }
      }
    return deck;
  }

  //Returns an invalid deck, duplicate cards.
  public List<StandardCard> buildRepeatDeck(){
    List<StandardCard> deck = new ArrayList<StandardCard>();
    for(int i = 0;i < 4; i++){
      for(int j = 0; j < 13; j++){
        deck.add(new StandardCard(StandardCard.values[j], StandardCard.suits[2]));
      }
    }
    return deck;
  }

  @Test
  public void testValidDeck(){
    //Fails for not enough cards.
    assertEquals(false, util.validDeck(badCountDeck));
    //Fails for duplicate cards.
    assertEquals(false, util.validDeck(badRepeatDeck));
    //Passes, good deck.
    assertEquals(true, util.validDeck(util.buildDeck(false)));
  }
  @Test
  public void  testShuffleDeck(){
    assertNotEquals(badCountDeck, util.shuffleDeck(badCountDeck));
  }














}
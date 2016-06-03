package cs3500.hw02;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by David on 5/20/2016.
 */
public class StandardCardTest {

  StandardCard aceSpades = new StandardCard(StandardCard.values[0], StandardCard.suits[3]);
  StandardCard aceClubs = new StandardCard(StandardCard.values[0], StandardCard.suits[0]);
  StandardCard twoClubs = new StandardCard(StandardCard.values[12], StandardCard.suits[0]);

  //Test for print card.
  @Test
  public void testPrintCard(){
    assertEquals("A♠", aceSpades.printCard());
    assertEquals("A♣", aceClubs.printCard());
    assertEquals("2♣", twoClubs.printCard());
  }

  //Test for card ranks.
  @Test
  public void testCardRank(){
    assertEquals(60, aceSpades.cardRank());
    assertEquals(0, aceClubs.cardRank());
    assertEquals(12, twoClubs.cardRank());
  }

  //Test for compareTo
  @Test
  public void testCompareTo(){
    //Test aceSpades comes after aceClubs.
   assertEquals(true, aceSpades.compareTo(aceClubs) > 0);
    //Test aceSpades comes after twoClubs.
    assertEquals(true, aceSpades.compareTo(twoClubs) > 0);
  }



}
package cs3500.hw02;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by David on 5/20/2016.
 */
public class StandardPlayerTest {

  StandardCard aceSpades = new StandardCard(StandardCard.values[0], StandardCard.suits[3]);
  StandardCard aceClubs = new StandardCard(StandardCard.values[0], StandardCard.suits[0]);
  StandardCard twoClubs = new StandardCard(StandardCard.values[12], StandardCard.suits[0]);
  StandardPlayer testPlayer = new StandardPlayer();

  public void initTestData(){
    aceSpades = new StandardCard(StandardCard.values[0], StandardCard.suits[3]);
    aceClubs = new StandardCard(StandardCard.values[0], StandardCard.suits[0]);
    twoClubs = new StandardCard(StandardCard.values[12], StandardCard.suits[0]);
    testPlayer = new StandardPlayer();
  }


  @Test
  public void testTakeCard() throws Exception {
    initTestData();
    assertEquals(0, testPlayer.hand.size());
    testPlayer.takeCard(aceSpades);
    assertEquals(1, testPlayer.hand.size());
    testPlayer.takeCard(aceClubs);
    assertEquals(2, testPlayer.hand.size());
    testPlayer.takeCard(twoClubs);
    assertEquals(3, testPlayer.hand.size());

  }


  @Test
  public void testShowHand() throws Exception {
    initTestData();
    assertEquals("", testPlayer.showHand());
    testPlayer.takeCard(aceSpades);
    assertEquals("A♠", testPlayer.showHand());
    testPlayer.takeCard(aceClubs);
    assertEquals("A♠, A♣", testPlayer.showHand());
    testPlayer.takeCard(twoClubs);
    assertEquals("A♠, A♣, 2♣", testPlayer.showHand());
  }


  @Test
  public void testSortHand() throws Exception {
    initTestData();
    testPlayer.takeCard(aceSpades);
    testPlayer.takeCard(aceClubs);
    testPlayer.takeCard(twoClubs);
    assertEquals("A♠, A♣, 2♣", testPlayer.showHand());
    testPlayer.sortHand();
    assertEquals("A♣, 2♣, A♠", testPlayer.showHand());

  }

}
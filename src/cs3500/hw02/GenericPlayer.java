package cs3500.hw02;

/**
 * Created by David on 5/17/2016.
 */
public interface GenericPlayer<K> {

  /**
   * Returns the string representation of a Players hand.
   * @return String representation of this players hand.
   */
  public String showHand();

  /**
   * Places given card into players hand.
   * @param given Card to be put in players hand.
   */
  public void takeCard(K given);

  /**
   * Number of cards in this players hand.
   * @return int number of cards in players hand.
   */

  /**
   * Sorts players hand.
   */
  public void sortHand();

  /**
   * Increments players score by 1.
   */
  public void handWon();

  /**
   * Returns index of first intance of given suit in player's hand.
   * -1 if card does not exist.
   * @param suit Suit to find in players hand.
   * @return Index of first card matching given suit, negative number if no such card exists.
   */
  public int hasSuit(StandardCard.StandardSuitValue suit);

  /**
   * Returns the card at the given index.
   * @param cardIdx Index of card to be played.
   * @return Card at index given.
   */
  public StandardCard playCard(int cardIdx);

  /**
   * Returns the value of the last card played.
   * @return Last played card.
   */
  public StandardCard getLastCardPlayed();

  /**
   * Sets last card played to null.
   */
  public void clearLastPlayed();

  /**
   * Returns this players score.
   * @return players score.
   */
  public int getScore();

}

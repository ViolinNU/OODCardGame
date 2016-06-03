package cs3500.hw02;

/**
 * Created by David on 5/16/2016.
 */

/**
 * This is an interface for a generic card,
 * it has methods to return a cards ranking, and to print the String
 * representation of the card.
 */
public interface GenericCard extends Comparable<GenericCard> {


  /**
   * Returns an integer representing this cards rank,
   * used for sorting purposes.
   * @return int representing this cards rank.
   */
  public int cardRank();

  /**
   * Returns the string representations of this card.
   * @return String String representation of this card.
   */
  public String printCard();
}

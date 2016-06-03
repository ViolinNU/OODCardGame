package cs3500.hw03;
import cs3500.hw02.StandardCard;

/**
 * Created by David on 5/27/2016.
 */
public interface CardGameModel<K> extends cs3500.hw02.GenericCardGameModel<K> {

  /**
   * Plays the card at the index cardIdx, in the set of cards
   * for playey number playerNo.
   * @param playerNo Player that will play the card.
   * @param cardIdx Index for card in players hand.
   */
  public void play(int playerNo, int cardIdx);

  /**
   * Returns the player whose turn it is currently.
   * throws IllegalArgumentException if the game has ended.
   * @return Number of the player whose turn it is.
   * @throws IllegalArgumentException If the game has ended.
   */
  public int getCurrentPlayer() throws IllegalArgumentException;

  /**
   * True if game is over, false o.w.
   * @return True if the game is over.
   */
  boolean isGameOver();




}

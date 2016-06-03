package cs3500.hw02;
import java.util.List;

/**
 * Created by David on 5/18/2016.
 */

/**
 * This is the interface for generic deck utilities,
 * K represents the Card type of the deck.
 * @param <K> Card type of deck.
 */
public interface GenericDeckUtil<K> {
  /**
   * Builds a deck, boolean flag for whether returned deck
   * is shuffled or sorted.
   * @param shuffle Boolean flag true returns shuffled deck, false returns sorted deck.
   * @return
   */
  public List<K> buildDeck(boolean shuffle);

  /**
   * Returns true if given deck is a valid deck of
   * card type K.
   * @param checkDeck Deck to be checked against reference deck.
   * @return True if given deck is valid, false otherwise.
   */
  public boolean validDeck(List<K> checkDeck);

  /**
   * Returns a shuffled deck of type K cards.
   * @param deck Deck of type K cards to be shuffled.
   * @return List<K> Shuffled deck of type K cards.
   */
  public List<K> shuffleDeck(List<K> deck);

  /**
   * Returns a sorted deck of type K cards.
   * @param deck Deck of type K cards to be sorted.
   * @return List<K> sorted deck of type K cards.
   */
  public List<K> sortDeck(List<K> deck);
  }

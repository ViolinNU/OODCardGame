package cs3500.hw02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by David on 5/18/2016.
 */

/**
 * Class to represent a standard deck of playing cards.
 * A Standard deck of cards consists of
 * 13 CardValues(A,K,Q,J,10-2) of each of the
 * 4 Suits (♣, ♦, ♥, ♠), making a total
 * of 52 unique cards.
 */
public class StandardDeckUtil implements GenericDeckUtil<StandardCard> {

  //Reference deck of standard playing cards.
  List<StandardCard> referenceDeck;


  public StandardDeckUtil(){
    this.referenceDeck = buildDeck(false);
  }


  /**
   * Builds a standard deck of cards in no
   * particular order.
   * A Standard deck of cards consists of
   * 13 CardValues(A,K,Q,J,10-2) of each of the
   * 4 Suits (♣, ♦, ♥, ♠), making a total
   * of 52 unique cards.
   */
  public List<StandardCard> buildDeck(boolean shuffle) {
    List<StandardCard> deck = new ArrayList<StandardCard>();
    for(int i = 0;i < StandardCard.suits.length; i++){
        for(int j = 0; j < StandardCard.values.length; j++){
          deck.add(new StandardCard(StandardCard.values[j], StandardCard.suits[i]));
        }
      }
    if(shuffle){Collections.shuffle(deck);}
    return deck;
  }


  //Documented in interface.
  public boolean validDeck(List<StandardCard> checkDeck) {
    List<StandardCard> cloneDeck = cloneDeck(checkDeck);
    if(checkDeck.size() < referenceDeck.size()){
      return false;
    }
    Collections.sort(cloneDeck);
    for(int i = 0; i < referenceDeck.size();i++){
      if(!referenceDeck.get(i).equals(cloneDeck.get(i))){return  false;}
    }
    return true;
  }

  /**
   * Makes a card for card copy of the given deck.
   * @param checkDeck deck to be copied.
   * @return copy of given deck.
   */
  private List<StandardCard>  cloneDeck(List<StandardCard> checkDeck){
    List<StandardCard> cloneDeck = new ArrayList<StandardCard>();
    for(StandardCard card:checkDeck){
      cloneDeck.add(card);
    }
    return cloneDeck;
  }

  /**
   * Returns true if deckOne and deckTwo are equal, same cards in same order.
   * @param deckOne
   * @param deckTwo
   * @return true if decks are identical.
   */
  public boolean sameDeck(List<StandardCard> deckOne, List<StandardCard> deckTwo) {
    if(deckOne.size() != deckTwo.size()){
      return false;
    }
    for(int i = 0; i < deckOne.size();i++){
      if(!deckOne.get(i).equals(deckTwo.get(i))){return  false;}
    }
    return true;
  }



  //Documented in interface.
  public List<StandardCard> sortDeck(List<StandardCard> deck){
    List<StandardCard> sortDeck = cloneDeck(deck);
    Collections.sort(sortDeck);
    return sortDeck;
  }




  //Documented in interface.
  public List<StandardCard> shuffleDeck(List<StandardCard> deck) {
    List<StandardCard> shuffledDeck = cloneDeck(deck);
    Collections.shuffle(shuffledDeck);
    return shuffledDeck;
  }


}

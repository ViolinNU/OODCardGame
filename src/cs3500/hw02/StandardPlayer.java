package cs3500.hw02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by David on 5/17/2016.
 */
public class StandardPlayer implements GenericPlayer<StandardCard>{

  //Added functionality for Whist to Standard players. All changes documented in interface.
  List<StandardCard> hand;
  StandardCard lastCardPlayed; //Added to track the last played card by this player.
  int score;


  public StandardPlayer(){
    this.hand = new ArrayList<StandardCard>();
  }


  public String showHand() {
    String handDisplay = "";
    if (this.hand.size() > 0) {
      for (int i = 0; i < this.hand.size() - 1; i++) {
        handDisplay = handDisplay + this.hand.get(i).printCard() + ", ";
      }
      handDisplay = handDisplay + this.hand.get(this.hand.size() - 1).printCard();
      return handDisplay;
    } else return handDisplay;
  }


  public void takeCard(StandardCard given) {
    this.hand.add(given);
     }


  public void sortHand(){
    Collections.sort(this.hand);
  }

  public void handWon() {
    this.score = score + 1;
  }



  public int hasSuit(StandardCard.StandardSuitValue suit) {
    for (int i = 0; i < hand.size();i++) {
      if (hand.get(i).suitMatches(suit)) {
        return i;
      }
    }
    return -1;
  }

  public StandardCard playCard(int cardIdx){
    lastCardPlayed = this.hand.get(cardIdx);
    return this.hand.remove(cardIdx);
  }

  public StandardCard getLastCardPlayed(){
    return lastCardPlayed;
  }

  public void clearLastPlayed(){
    lastCardPlayed = null;
  }

  public int getScore(){
    return this.score;
  }

  public int handSize(){
    return this.hand.size();
  }

  public StandardCard.StandardSuitValue cardSuit(int cardIdx) {
    return hand.get(cardIdx).getSuit();
  }


}

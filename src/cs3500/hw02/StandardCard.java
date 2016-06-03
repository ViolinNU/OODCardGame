package cs3500.hw02;

import java.util.Objects;

/**
 * Created by David on 5/16/2016.
 */

/**
 * Class to represent a StandardCard, one of the 52 unique cards in a StandardDeck.
 */
public class StandardCard implements GenericCard {


  private StandardSuitValue suit;
  private StandardFaceValue face;
  private String display;
  private int value;

  public static final StandardSuitValue[] suits = StandardSuitValue.values();
  public static final StandardFaceValue[] values = StandardFaceValue.values();

  /**
   * Constructor for a StandardCard
   *
   * @param face Face value of the card, one of 13 StandardCardValues(A,K,Q,J,10-2)
   * @param suit Suit of the card one of 4 Suits (♣, ♦, ♥, ♠).
   */
  public StandardCard(StandardFaceValue face, StandardSuitValue suit) {
    this.suit = suit;
    this.face = face;
    this.display = face.display + suit.display;
    this.value = cardRank();
  }

  /**
   * Prints this card as a string.
   *
   * @return String representation of this card.
   */
  public String printCard() {
    return this.display;
  }


  /**
   * Returns an integer representing this cards rank for sorting.
   *
   * @return int representing this cardsRank for sorting purposes.
   */
  public int cardRank() {
    return this.suit.getCardValue() + this.face.getCardValue();
  }


  public enum StandardSuitValue {
    //Four standard suits in alphabetical order.
    //int value indicates their weight for comparison.
    Clubs(0, "♣"), Diamonds(20, "♦"), Hearts(40, "♥"), Spades(60, "♠");


    //Weighted value of suit for comparison.
    private int value;
    private String display;

    StandardSuitValue(int value, String display) {
      this.value = value;
      this.display = display;
    }

    public String toString(){
      return this.display;
    }

    //Return this Card value.
    public int getCardValue() {
      return this.value;
    }

  }


  /**
   * Enumerations of possible StandardCard suit and face values.
   */
  public enum StandardFaceValue {
    //Four standard suits in alphabetical order.
    //int value indicates their weight for comparison.
    Ace(0, "A"), King(1, "K"), Queen(2, "Q"), Jack(3, "J"), Ten(4, "10"),
    Nine(5, "9"), Eight(6, "8"), Seven(7, "7"), Six(8, "6"), Five(9, "5"),
    Four(10, "4"), Three(11, "3"), Two(12, "2");

    //Weighted value of suit for comparison.
    private int value;
    private String display;

    StandardFaceValue(int value, String display) {
      this.value = value;
      this.display = display;
    }

    //Return this Card value.
    public int getCardValue() {
      return this.value;
    }

  }

  /**
   * Compares this card with a given card.
   *
   * @param card Card to compare this with.
   * @return the CompareTo value, -int if this card comes before comp, 0 if they are equal, and +
   * int if this card comes after comp.
   */
  public int compareTo(GenericCard card) {
    return this.cardRank() - card.cardRank();
  }


  /**
   * Override of equals, based of face and suit values.
   *
   * @param o Object to compare this with.
   * @return boolean true if this Card is qual to given Object, false otherwise.
   */
  public boolean equals(Object o) {
    if (o instanceof StandardCard) {
      StandardCard that = (StandardCard) o;
      return this.face == that.face && this.suit == that.suit;
    } else {
      return false;
    }
  }

  /**
   * Override of hashCode to return int based of suit and face value. face and value.
   *
   * @return int uniquie hashCode integer.
   */
  public int hashCode() {
    return Objects.hash(this.face, this.suit);
  }



  //Added to check this cards suit agains given.
  public boolean suitMatches(StandardSuitValue suit) {
    return this.suit.equals(suit);
  }

  //Added to return this cards suit.
  public StandardSuitValue getSuit(){
    return this.suit;
  }

  //Added to determine winning card.
  public int faceValue(){
    return this.face.value;
  }

}







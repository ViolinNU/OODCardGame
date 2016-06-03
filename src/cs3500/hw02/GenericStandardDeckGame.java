package cs3500.hw02;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 5/16/2016.
 */

public class GenericStandardDeckGame implements GenericCardGameModel<StandardCard> {

  //List of players in the game, initialized to 0 in default constructor.
  //Changed to standard players.
  protected ArrayList<StandardPlayer> players;
  List<StandardCard> deck;
  StandardDeckUtil deckUtil;

  /**
   * Default constructor for a GenericStandardDeckGame, no players or decks.
   */
  public GenericStandardDeckGame(){
    this.players = new ArrayList<StandardPlayer>();
    this.deckUtil = new StandardDeckUtil();
    this.deck = deckUtil.buildDeck(false);
  }

  public List<StandardCard> getDeck() {
    return this.deck;
  }


  public void startPlay(int numPlayers, List<StandardCard> deck) throws IllegalArgumentException {
     if(numPlayers <= 1){
      throw new IllegalArgumentException("Must have at least 2 players to start a game.");
    }
     else if(numPlayers > 52){
       throw new IllegalArgumentException("Too many players.");
     }
    else if(!deckUtil.validDeck(deck)){
      throw new IllegalArgumentException("Not a valid standard deck.");
    }
    setPlayers(numPlayers);
    dealCards(deck);
    playerSort();
  }

  public String getGameState() {
    String gameState = "Number of players: " + this.players.size() + "\n";
    for(int i = 0;i < this.players.size();i++){
      int playerNum = i + 1;
      gameState = gameState + "Player " + playerNum +  ": " +
              this.players.get(i).showHand() + "\n";
    }
    return gameState;
  }

  /**
   * Builds a standard deck of cards in no
   * particular order.
   * A Standard deck of cards consists of
   * 13 CardValues(A,K,Q,J,10-2) of each of the
   * 4 Suits (♣, ♦, ♥, ♠), making a total
   * of 52 unique cards.
   * @return A shuffled deck of standard playing cards.
   */
  private List<StandardCard> buildDeck(){
    return deckUtil.buildDeck(false);
  }

  /**
   * Adds the given number of players to the game.
   * @param numPlayers Number of Players to add to the game.
   */
  private void setPlayers(int numPlayers){
    while(numPlayers > 0){
      players.add(new StandardPlayer() {
      });
      numPlayers--;
    }
  }

  /**
   * Deals out cards to the players in the game in a
   * round robin fashion, i.e. Player 1 gets first card
   * then Player 2, then Player 3....to Player N then cycle
   * back to Player 1 and repeat until no cards remain
   * in the deck.
   * @param deck List of cards to be dealt.
   */
  private void dealCards(List<StandardCard> deck){
    int i = 0;
    for(StandardCard card:deck){
       players.get(i).takeCard(card);
        i = (i + 1)% this.players.size();
      }
    }

  private void playerSort(){
    for(GenericPlayer player:players){
      player.sortHand();
    }
  }

  }















package cs3500.hw04;

import cs3500.hw02.StandardCard;
import cs3500.hw02.StandardPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 6/3/2016.
 */
public class WhistTrumpModel extends cs3500.hw02.GenericStandardDeckGame
        implements cs3500.hw03.CardGameModel<StandardCard> {


    private static ArrayList<StandardCard> currentTrick; //Stores cards of the current trick.
    private static   int curPlayer; //Index of player whose turn it is.
    private static int leadPlayer; //Index of player currently in the lead.
    private static int trickCount; //Current trick number.
    private static int trickSize; //How many cards a trick consists of.
    private static int lastTrick; //number of the last trick
    cs3500.hw02.StandardCard.StandardSuitValue trickSuit; //Suit of current trick.
    cs3500.hw02.StandardCard.StandardSuitValue trumpSuit; //Suit of current trick.



    public WhistTrumpModel(){
        currentTrick = new ArrayList<StandardCard>();
        trickCount = 0;
        leadPlayer = 0;
        curPlayer = 0;
    }

    /**
     * Overrider of startPlay with added Whist functionality
     * computes trickSize, and lastTrick.
     * @param numPlayers the number of players playing this game
     * @param deck the deck of cards to be distributed among the players to start the game
     * @throws IllegalArgumentException
     */
    public void startPlay(int numPlayers, List<StandardCard> deck) throws IllegalArgumentException {
        super.startPlay(numPlayers, deck);
        trickSize = super.players.size() - 1;
        lastTrick = 52/super.players.size();
        trumpSuit = deck.get(0).getSuit();
    }


    /**
     * Overide of getGameState from GenericStandardDeckGame.
     * added functionality, presents Player 1-n scores, represented by number of tricks
     * that player has one.
     * Also creturns special message representing the game state, {Game Over, Player x turn, etc}
     * @return String representation of the game state.
     */
    public String getGameState() {
        StringBuilder gameState = new StringBuilder(playerScoreState());
        gameState.append(getSpecialMessage());
        gameState.append(trumpMessage());
        return gameState.toString();
    }

    //Documented in interface.
    public void play(int playerNo, int cardIdx) throws IllegalArgumentException {
        validatePlayerIndex(playerNo);
        validateCard(playerNo, cardIdx);
        playCard(playerNo, cardIdx);
    }

    //Documented in interface.
    public int getCurrentPlayer() throws IllegalArgumentException {
        if (isGameOver()) {
            throw new IllegalArgumentException("Game is over.");
        }
        return curPlayer;
    }

    //Documented in interface.
    public boolean isGameOver() {
        return trickCount == lastTrick;
    }

    /**
     * Returns a string representations of all players 1-n current scores.
     * Player 1: {score}
     * Player 2: {score}
     * ....
     * Player n: {score}
     * @return String representation of player scores.
     */
    private String playerScoreState(){
        String gameState = super.getGameState();
        StringBuilder sb = new StringBuilder();
        sb.append(gameState);
        for(int i = 0;i < super.players.size();i++){
            int playerNum = i + 1;
            sb.append("Player " + playerNum +  " score: " +
                    super.players.get(i).getScore() + "\n");
        }
        return sb.toString();
    }

    /**
     * Throws exception if given player index is not valid.
     * Either playerNo is negative, or playerNo is an out of bound index
     * for the current game's players.
     * @param playerNo Index of player to validate.
     */
    private void validatePlayerIndex(int playerNo) throws IllegalArgumentException{
        if(playerNo < 0 || playerNo > super.players.size()){
            throw new IllegalArgumentException("No such player exists");
        }
    }

    /**
     * Throws exception if given player's card's index is not valid.
     * Either playerNo is negative, or playerNo is an out of bound index
     * for the given player's hand.
     * @param playerNo Index of the player.
     * @param cardIdx Index of the players card in the player's hand.
     */
    private void validateCard(int playerNo, int cardIdx) throws IllegalArgumentException{
        StandardPlayer player = super.players.get(playerNo);
        if(cardIdx < 0 || cardIdx >= player.handSize() ){
            throw  new IllegalArgumentException("Please select a valid card index " +
                    0 + "-" + (players.get(curPlayer).handSize()-1) + ": ");
        }
        else if(player.hasSuit(trickSuit) >=0 && !(player.cardSuit(cardIdx).equals(trickSuit))&&
                !(player.cardSuit(cardIdx).equals(trumpSuit))){
            throw  new IllegalArgumentException("Must play current trick's suit "+trickSuit.toString()
                    +". First instance of "+trickSuit.toString()+" at index "+player.hasSuit(trickSuit));
        }
    }

    /**
     * Play's the card at the given card index, in the given player numbers hand.
     * If current trick is empty, trick suit is set to the played card's suit.
     * The player takes the lead, and card is added to the current trick.
     *
     * If this will be the last card played in the trick, the card is added to the trick
     * the winner player is determined, the winners score is updated, the trick is cleared
     * and the winner of the trick is set to the current player, and the trick count is
     * incremented by 1.
     *
     * Else the card is added to the trick, a check for the player in the lead is performed
     * and the next player is set to current player.
     * @param playerNo Index of player playing card.
     * @param cardIdx index of card in players hand.
     */
    private void playCard(int playerNo, int cardIdx){
        StandardCard playCard = super.players.get(playerNo).playCard(cardIdx);
        if(currentTrick.isEmpty()){
            trickSuit = playCard.getSuit();
            leadPlayer = playerNo;
            currentTrick.add(playCard);
            nextPlayer();
        }
        else if(currentTrick.size() == trickSize){
            currentTrick.add(playCard);
            determineLeadPlayer(playCard);
            super.players.get(leadPlayer).handWon();
            clearTrick();
            curPlayer = determineNext(leadPlayer);
            clearLastPlayed();
            trickCount = trickCount + 1;
        }
        else{
            currentTrick.add(playCard);
            determineLeadPlayer(playCard);
            nextPlayer();
        }
    }

    private int determineNext(int given){
        StandardPlayer player = super.players.get(given);
        if(player.handSize() == 0 && cardsInPlay() > 0){
            return determineNext((given+1)%super.players.size());
        }
        else{ return given;}
    }

    /**
     * Determines the current leader of the trick.
     * High card is set to the current leaders last played card.
     * Card played is compared to the current high card, if it matches
     * the current trick suit and is of higher face value than the
     * current high card, lead player is set to the current player
     * @param playCard Card played by current player.
     */
    private void determineLeadPlayer(StandardCard playCard){
        StandardCard highCard = super.players.get(leadPlayer).getLastCardPlayed();
        if(playCard.suitMatches(trumpSuit) && highCard.suitMatches(trumpSuit)
            && playCard.faceValue() < highCard.faceValue()){
            leadPlayer = curPlayer;
        } else if (playCard.suitMatches(trumpSuit)) {
            leadPlayer = curPlayer;
        }
        else if(playCard.suitMatches(trickSuit) && playCard.faceValue() < highCard.faceValue()) {
            leadPlayer = curPlayer;
        }
    }

    /**
     * Clears the last played card field from all players in the game.
     */
    private void clearLastPlayed(){
        for(StandardPlayer player:super.players){
            player.clearLastPlayed();
        }
    }

    /**
     * Clears the current trick to get ready for the next trick.
     */
    private void clearTrick(){
        this.currentTrick.clear();
    }

    /**
     * Selects the next player.
     */
    private void nextPlayer(){ curPlayer = (curPlayer + 1)%super.players.size();}

    /**
     * Returns the String representaion of game special messages
     * presents whose turn it currently is as well as a winner at
     * the end of the game.
     * @return String of whose turn it is/winner of the game.
     */
    private String getSpecialMessage() {
        if (super.players.size() == 0) {
            return "Game has not started.";
        }
        else if(isGameOver()){
            return "Game over. Player " + (determineWinner()+ 1) + " won.";
        }
        else {
            return "Turn: Player " + (curPlayer + 1);
        }
    }

    private String trumpMessage(){
        return "\nTrump suit: " + trumpSuit.toString();
    }

    /**
     * Determines the winner of the game.
     * Player with the highest score.
     * @return Index of winner.
     */
    private int determineWinner(){
        int topScore = 0;
        int winnerIndex=0;
        for (int i = 0;i < super.players.size();i++) {
            if(super.players.get(i).getScore() > topScore){
                topScore = super.players.get(i).getScore();
                winnerIndex = i;
            }
        }
        return winnerIndex;
    }

    /**
     * Counts how many cards are left in play.
     * @return count of cards left in play.
     */
    private int cardsInPlay(){
        int cardCount = 0;
        for(StandardPlayer player: super.players){
            cardCount = cardCount+player.handSize();
        }
        return cardCount;
    }

}











package cs3500.hw04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import cs3500.hw02.StandardCard;
import cs3500.hw03.CardGameModel;

import static org.junit.Assert.*;

/**
 * Created by David on 6/3/2016.
 */
public class WhistTrumpModelTest {
    String trumpGame = "Number of players: 2\nPlayer 1: A♣, Q♣, 10♣, 8♣, 6♣, 4♣, 2♣, K♦, J♦,"+
            " 9♦, 7♦, 5♦, 3♦, A♥, Q♥, 10♥, 8♥, 6♥, 4♥, 2♥, K♠, J♠, 9♠, 7♠, 5♠, 3♠\n"+
            "Player 2: K♣, J♣, 9♣, 7♣, 5♣, 3♣, A♦, Q♦, 10♦, 8♦, 6♦, 4♦, 2♦,"+
            " K♥, J♥, 9♥, 7♥, 5♥, 3♥, A♠, Q♠, 10♠, 8♠, 6♠, 4♠, 2♠\nPlayer 1 score: 0"+
            "\nPlayer 2 score: 0\nTurn: Player 1\nTrump suit: ♣";
    String reverseOrdertrumpGame =
            "Number of players: 2\nPlayer 1: K♣, J♣, 9♣, 7♣, 5♣, 3♣, A♦, Q♦, 10♦, 8♦, 6♦," +
                    " 4♦, 2♦, K♥, J♥, 9♥, 7♥, 5♥, 3♥, A♠, Q♠, 10♠, 8♠, 6♠, 4♠, 2♠\nPlayer"+
                    " 2: A♣, Q♣, 10♣, 8♣, 6♣, 4♣, 2♣, K♦, J♦, 9♦, 7♦, 5♦, 3♦, A♥, Q♥," +
                    " 10♥, 8♥, 6♥, 4♥, 2♥, K♠, J♠, 9♠, 7♠, 5♠, 3♠\nPlayer 1 score: 0\nPlayer"+
                    " 2 score: 0\nTurn: Player 1\nTrump suit: ♠";
    String trumpTrumps =
            "Number of players: 2\nPlayer 1: A♣, Q♣, 10♣, 8♣, 6♣, 4♣, 2♣, J♦, 9♦, 7♦," +
                    " 5♦, 3♦, A♥, Q♥, 10♥, 8♥, 6♥, 4♥, 2♥, K♠, J♠, 9♠, 7♠, 5♠, 3♠\nPlayer" +
                    " 2: J♣, 9♣, 7♣, 5♣, 3♣, A♦, Q♦, 10♦, 8♦, 6♦, 4♦, 2♦, K♥, J♥, 9♥, 7♥," +
                    " 5♥, 3♥, A♠, Q♠, 10♠, 8♠, 6♠, 4♠, 2♠\nPlayer 1 score: 0\nPlayer 2" +
                    " score: 1\nTurn: Player 2\nTrump suit: ♣";


    List<StandardCard> reverseOrderDeck = new ArrayList<StandardCard>();
    CardGameModel<StandardCard> testTrump = new WhistTrumpModel();

    private void initModel(){
        testTrump = new WhistTrumpModel();
    }


    @Test
    public void testTrumpSuit(){
        initModel();
        testTrump.startPlay(2, testTrump.getDeck());
        assertEquals(trumpGame, testTrump.getGameState());
    }

    @Test
    public void testReverseTrump(){
        initModel();
        setReverseOrderDeck();
        testTrump.startPlay(2, reverseOrderDeck);
        assertEquals(reverseOrdertrumpGame, testTrump.getGameState());
    }

    @Test
    public void testTrumpTrumps(){
        initModel();
        testTrump.startPlay(2, testTrump.getDeck());
        testTrump.play(0,7);
        testTrump.play(1, 0);
        assertEquals(trumpTrumps, testTrump.getGameState());
    }





    public void setReverseOrderDeck(){
        reverseOrderDeck = new ArrayList<StandardCard>();
        for(int i = StandardCard.suits.length - 1; i > -1; i--){
            for(int j = StandardCard.values.length - 1;j > -1; j--){
                reverseOrderDeck.add(new StandardCard(StandardCard.values[j], StandardCard.suits[i]));

            }
        }
    }

}
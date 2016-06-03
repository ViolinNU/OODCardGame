package cs3500.hw03;

import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import cs3500.hw02.StandardCard;

/**
 * Created by David on 5/27/2016.
 */
public class WhistController implements IWhistController {
  private static CardGameModel gameModel;
  private static Scanner input;
  private static Formatter output;
  Scanner scan;


  public WhistController(Readable input, Appendable output) {
    this.input = new Scanner(input);
    this.output = new Formatter(output);
  }


  /**
   * Starts a game of Whist, with the given game model and player count.
   *
   * @param game       Type of card game to be played, parametrized by card type.
   * @param numPlayers Integer representing the starting number of players.
   * @param <K>        Card type
   * @throws IllegalArgumentException only if model given is null, or player count is invalid.
   */
  public <K> void playGame(CardGameModel<K> game, int numPlayers) throws IllegalArgumentException {
    if (game.equals(null)) {
      throw new IllegalArgumentException("Game model cannot be null.");
    }
    gameModel = game;
    gameModel.startPlay(numPlayers, game.getDeck());
    output.format(gameModel.getGameState());
    while (!game.isGameOver()) {
      if (input.hasNextInt()) {
        intHandler();
        output.format("\n");
        output.format(gameModel.getGameState());

      } else if (input.hasNext()) {
        otherHandler();
      } else {
      }
    }
    return;
  }

  /**
   * Handles the case where an integer is passed in from input.
   */
  private void intHandler() {
    int card = input.nextInt();
    try {
      gameModel.play(gameModel.getCurrentPlayer(), card);
    } catch (IllegalArgumentException error) {
      output.format(error.getMessage());
      intHandler();
    }
  }

  /**
   * Handles the case where something other than an integer is pass in from input.
   */
  private void otherHandler() {
    String next = input.next();
    if (next.equals("q")) {
      output.format("\nGame quit prematurely.");
      System.exit(0);
    } else {
      output.format("\nTry again invalid input.");
    }
  }
}
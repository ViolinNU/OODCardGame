package cs3500.hw03;

/**
 * Created by David on 5/27/2016.
 */
public interface IWhistController {
  /**
   * Begins a game of the given card game model, with the given amount of players.
   * @param game Type of card game to be played, parametrized by card type.
   * @param numPlayers Integer representing the starting number of players.
   * @param <K> Card type.
   * @throws IllegalArgumentException only if the model is null, or an invalid number of players
   * are passed. i.e. numPlayers <= 0 || numPlayers > 52
   */
  <K> void playGame(CardGameModel<K> game, int numPlayers) throws IllegalArgumentException;
}

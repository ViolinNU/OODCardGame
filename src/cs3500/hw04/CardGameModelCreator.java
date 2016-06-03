package cs3500.hw04;

import cs3500.hw03.CardGameModel;

/**
 * Created by David on 6/3/2016.
 */
public interface CardGameModelCreator {
    public CardGameModel create(ModelType type);
}

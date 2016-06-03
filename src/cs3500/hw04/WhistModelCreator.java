package cs3500.hw04;

import cs3500.hw03.CardGameModel;
import cs3500.hw03.WhistModel;

/**
 * Created by David on 6/3/2016.
 */
public class WhistModelCreator implements CardGameModelCreator{

    public CardGameModel create(ModelType type){
        switch (type){
            case TRUMP:
                return new WhistTrumpModel();
            case NOTRUMP:
                return new WhistModel();
            default: return  new WhistModel();
        }
    }
}

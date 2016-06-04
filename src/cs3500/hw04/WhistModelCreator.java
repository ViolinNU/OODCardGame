package cs3500.hw04;

import cs3500.hw03.CardGameModel;
import cs3500.hw03.WhistModel;
/**
 * Created by David on 6/3/2016.
 */

/**
 * Factory class for WhistModels
 */
public class WhistModelCreator{

    public enum ModelType {TRUMP, NOTRUMP}


  /**
   * Creates a WhistModel, either with a Trump suit or without depending on ModelType parameter.
   * @param type Trump or NoTrump WhistModel
   * @return WhistModel of desired type.
   */
    public static CardGameModel create(ModelType type){
        switch (type){
            case TRUMP:
                return new WhistTrumpModel();
            case NOTRUMP:
                return new WhistModel();
            default: return  new WhistModel();
        }
    }



}

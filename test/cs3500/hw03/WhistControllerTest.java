package cs3500.hw03;

import org.junit.Test;

import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;

import cs3500.hw02.GenericCardGameModel;
import cs3500.hw02.StandardCard;

import static org.junit.Assert.*;

/**
 * Created by David on 5/27/2016.
 */
public class WhistControllerTest {
  StringBuffer buffer = new StringBuffer();
  ArrayList<StandardCard> testDeck = new ArrayList<StandardCard>();
  WhistController testController;
  WhistModel testModel = new WhistModel();

  public void initController(Readable input){
    buffer = new StringBuffer();
    testController = new WhistController(input, buffer);
  }

  public void initModel(){
    testModel = new WhistModel();
  }


  @Test(expected = IllegalArgumentException.class)
  public void testPlayGameExceptionNegativePlayers(){
    WhistController testController = new WhistController(new StringReader(""), buffer);
    testController.playGame(new WhistModel(), -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPlayGameException1Player(){
    WhistController testController = new WhistController(new StringReader(""), buffer);
    testController.playGame(new WhistModel(), 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPlayGameExceptionTooManyPlayers(){
    WhistController testController = new WhistController(new StringReader(""), buffer);
    testController.playGame(new WhistModel(), 53);
  }





}



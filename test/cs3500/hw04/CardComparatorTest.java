package cs3500.hw04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by David on 6/3/2016.
 */
public class CardComparatorTest {

    @Test
    public void testComparator() {
        cs3500.hw03.CardGameModel model = new WhistTrumpModel();
        List<?> deck = testComparatorHelper(model.getDeck(), new CardComparator());
        model.startPlay(3, deck);
        System.out.print(model.getGameState());

    }

    private <S, T extends Comparator<S>> List<S> testComparatorHelper(List<S> list, T comparator) {
        List<S> temp = new ArrayList<S>();
        for (S item : list) {
            temp.add(item);
        }
        Collections.sort(temp, comparator);
        return temp;

    }
}
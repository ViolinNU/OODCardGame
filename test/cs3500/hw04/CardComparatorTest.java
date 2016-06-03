package cs3500.hw04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cs3500.hw02.StandardCard;

import static org.junit.Assert.*;

/**
 * Created by David on 6/3/2016.
 */
public class CardComparatorTest {

    StandardCard aceClubs = new StandardCard(StandardCard.StandardFaceValue.Ace,
            StandardCard.StandardSuitValue.Clubs);
    StandardCard aceHearts = new StandardCard(StandardCard.StandardFaceValue.Ace,
            StandardCard.StandardSuitValue.Hearts);
    StandardCard twoClubs = new StandardCard(StandardCard.StandardFaceValue.Two,
            StandardCard.StandardSuitValue.Clubs);

    CardComparator comp = new CardComparator();

    @Test
    public void testComparator() {
        cs3500.hw03.CardGameModel model = new WhistTrumpModel();
        List<?> deck = testComparatorHelper(model.getDeck(), new CardComparator());
        model.startPlay(3, deck);


    }

    @Test
    public void testCompare(){
        assertEquals(true, comp.compare(aceClubs, aceHearts) < 0 );
        assertEquals(true, comp.compare(twoClubs, aceHearts) < 0 );
        assertEquals(true, comp.compare(aceHearts, aceClubs) > 0 );
        assertEquals(true, comp.compare(aceClubs, aceClubs) == 0 );
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
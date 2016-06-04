package cs3500.hw04;

import cs3500.hw02.StandardCard;

import java.util.Comparator;

/**
 * Created by David on 6/3/2016.
 */

/**
 * Class to compare cards.
 */
public class CardComparator implements Comparator<StandardCard> {
    @Override
    public int compare(StandardCard o1, StandardCard o2) {
        return o1.compareTo(o2);
    }
}

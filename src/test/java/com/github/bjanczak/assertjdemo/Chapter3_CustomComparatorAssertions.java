package com.github.bjanczak.assertjdemo;

import com.github.bjanczak.assertjdemo.data.Movie;
import com.github.bjanczak.assertjdemo.data.Ring;
import com.github.bjanczak.assertjdemo.data.TolkienCharacter;
import com.google.common.collect.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bartłomiej Jańczak
 */
public class Chapter3_CustomComparatorAssertions extends AbstractAssertionsExample {

    private Ring[] elvesRings = null;
    private Movie[] trilogy = null;

    @Before
    public void classSetup() {
        elvesRings = new Ring[] {Ring.narya, Ring.nenya, Ring.vilya};
        trilogy = new Movie[] {theFellowshipOfTheRing, theTwoTowers, theReturnOfTheKing};
    }

    @After
    public void classTeardown() {
        elvesRings = null;
        trilogy = null;
    }

    @Test
    public void test() {
        assertThat(fellowshipOfTheRing)
                .usingElementComparator(new Comparator<TolkienCharacter>() {
                    @Override
                    public int compare(TolkienCharacter o1, TolkienCharacter o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                })
                .isSorted();

        assertThat(fellowshipOfTheRing)
                .isSortedAccordingTo(new Comparator<TolkienCharacter>() {
                    @Override
                    public int compare(TolkienCharacter o1, TolkienCharacter o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });

        assertThat(Lists.newArrayList(frodo))
                .usingElementComparatorOnFields("characterType")
                .isEqualTo(Lists.newArrayList(merry));

        assertThat(frodo)
                .usingComparator(new Comparator<TolkienCharacter>() {
                                     @Override
                                     public int compare(TolkienCharacter o1, TolkienCharacter o2) {
                                         return o1.getCharacterType().compareTo(o2.getCharacterType());
                                     }
                })
                .isEqualTo(sam)
                .isEqualTo(merry)
                .isEqualTo(pippin);
    }
}

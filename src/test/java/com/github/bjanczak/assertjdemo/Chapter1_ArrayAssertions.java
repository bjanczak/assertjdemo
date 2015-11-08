package com.github.bjanczak.assertjdemo;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.bjanczak.assertjdemo.data.CharacterType;
import com.github.bjanczak.assertjdemo.data.Movie;
import com.github.bjanczak.assertjdemo.data.Ring;
import com.github.bjanczak.assertjdemo.data.TolkienCharacter;
import com.google.common.collect.Lists;
import org.junit.*;

/**
 * @author Bartłomiej Jańczak
 */
public class Chapter1_ArrayAssertions extends AbstractAssertionsExample {

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
    public void assertAgainstNullOrEmpty() {
        Object object = null;
        assertThat(object).isNull();

        assertThat(Lists.newArrayList()).isNullOrEmpty();

        assertThat(Lists.newArrayList()).isEmpty();
    }

    @Test
    public void assertAgainstSize() {
        assertThat(elvesRings).isNotEmpty().hasSize(3);

        assertThat(elvesRings).hasSameSizeAs(trilogy);

        assertThat(elvesRings).hasSameSizeAs(Lists.newArrayList(trilogy));
    }

    @Test
    public void assertAgainstContainment() {
        assertThat(elvesRings).contains(Ring.nenya)
                              .doesNotContain(Ring.oneRing);

        assertThat(elvesRings).contains(Ring.narya, atIndex(0))
                              .contains(Ring.nenya, atIndex(1))
                              .contains(Ring.vilya, atIndex(2));
        // Order
        assertThat(elvesRings).containsExactly(Ring.narya, Ring.nenya, Ring.vilya);
        // Order
        assertThat(elvesRings).containsExactlyElementsOf(Lists.newArrayList(Ring.narya, Ring.nenya, Ring.vilya));

        assertThat(elvesRings).containsOnly(Ring.nenya, Ring.vilya, Ring.narya);

        assertThat(elvesRings).containsOnlyOnce(Ring.nenya, Ring.vilya, Ring.narya);
        // Order
        assertThat(elvesRings).containsSubsequence(Ring.narya, Ring.nenya, Ring.vilya);

        assertThat(elvesRings).containsOnlyElementsOf(Lists.newArrayList(Ring.nenya, Ring.vilya, Ring.narya));

        assertThat(elvesRings).hasSameElementsAs(Lists.newArrayList(Ring.nenya, Ring.vilya, Ring.narya));

        assertThat(elvesRings).isSubsetOf(Lists.newArrayList(Ring.nenya, Ring.vilya, Ring.narya));

        assertThat(elvesRings).doesNotContainAnyElementsOf(Lists.newArrayList(Ring.oneRing, Ring.manRing, Ring.dwarfRing));

        assertThat(elvesRings).doesNotContainNull().doesNotHaveDuplicates();

        assertThat(Lists.newArrayList(frodo, null, sam)).containsNull();
    }

    @Test
    public void assertUsingExtraction() {
        assertThat(extractProperty("name").from(fellowshipOfTheRing))
                .contains("Boromir", "Gandalf", "Frodo", "Legolas")
                .doesNotContain("Sauron", "Elrond");

        assertThat(fellowshipOfTheRing).extracting("characterType", CharacterType.class)
                .contains(CharacterType.HOBBIT, CharacterType.ELF)
                .doesNotContain(CharacterType.ORC);

        assertThat(trilogy).extracting("duration").containsExactly("178 min", "179 min", "201 min");
    }

    @Test
    public void assertUsingFiltering() {
        Iterable<TolkienCharacter> badBadGuys = filter(orcsWithHobbitPrisoners).with("characterType", CharacterType.ORC).get();
        assertThat(badBadGuys).extracting("name").containsOnly("Guruk");
    }
}

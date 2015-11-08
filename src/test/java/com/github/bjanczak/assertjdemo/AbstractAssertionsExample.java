package com.github.bjanczak.assertjdemo;

import com.github.bjanczak.assertjdemo.data.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.util.List;
import java.util.Map;

/**
 * @author Bartłomiej Jańczak
 */
public class AbstractAssertionsExample {

    // Some of the Lord of the Rings characters :
    protected final TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, CharacterType.HOBBIT);
    protected final TolkienCharacter sam = new TolkienCharacter("Sam", 38, CharacterType.HOBBIT);
    protected final TolkienCharacter merry = new TolkienCharacter("Merry", 36, CharacterType.HOBBIT);
    protected final TolkienCharacter pippin = new TolkienCharacter("Pippin", 28, CharacterType.HOBBIT);
    protected final TolkienCharacter gandalf = new TolkienCharacter("Gandalf", 2020, CharacterType.MAIA);
    protected final TolkienCharacter gimli = new TolkienCharacter("Gimli", 139, CharacterType.DWARF);
    protected final TolkienCharacter legolas = new TolkienCharacter("Legolas", 1000, CharacterType.ELF);
    protected final TolkienCharacter aragorn = new TolkienCharacter("Aragorn", 87, CharacterType.MAN);
    protected final TolkienCharacter boromir = new TolkienCharacter("Boromir", 37, CharacterType.MAN);
    protected final TolkienCharacter sauron = new TolkienCharacter("Sauron", 50000, CharacterType.MAIA);
    protected final TolkienCharacter galadriel = new TolkienCharacter("Galadriel", 3000, CharacterType.ELF);
    protected final TolkienCharacter elrond = new TolkienCharacter("Elrond", 3000, CharacterType.ELF);
    protected final TolkienCharacter guruk = new TolkienCharacter("Guruk", 20, CharacterType.ORC);


    // Rings and their bearer
    protected final List<Ring> ringsOfPower = Lists.newArrayList();
    protected final Map<Ring, TolkienCharacter> ringBearers = Maps.newHashMap();

    // Lord of the Rings movies
    protected final Movie theFellowshipOfTheRing = new Movie("the fellowship of the Ring", "2001-12-19", "178 min");
    protected final Movie theTwoTowers = new Movie("the two Towers", "2002-12-18", "179 min");
    protected final Movie theReturnOfTheKing = new Movie("the Return of the King", "2003-12-17", "201 min");
    protected final Movie theSilmarillion = new Movie("the Silmarillion", "2030-01-01", "unknown");
    protected final List<Movie> trilogy = Lists.newArrayList();


    protected final List<TolkienCharacter> fellowshipOfTheRing = Lists.newArrayList();
    protected final List<TolkienCharacter> orcsWithHobbitPrisoners = Lists.newArrayList();

    @Before
    public void setupAbstract() {
        // Rings.
        ringsOfPower.add(Ring.oneRing);
        ringsOfPower.add(Ring.vilya);
        ringsOfPower.add(Ring.nenya);
        ringsOfPower.add(Ring.narya);
        ringsOfPower.add(Ring.dwarfRing);
        ringsOfPower.add(Ring.manRing);

        // Ring bearers.
        ringBearers.put(Ring.nenya, galadriel);
        ringBearers.put(Ring.narya, gandalf);
        ringBearers.put(Ring.vilya, elrond);
        ringBearers.put(Ring.oneRing, frodo);

        // The fellowship of the ring.
        fellowshipOfTheRing.add(aragorn);
        fellowshipOfTheRing.add(boromir);
        fellowshipOfTheRing.add(frodo);
        fellowshipOfTheRing.add(gandalf);
        fellowshipOfTheRing.add(gimli);
        fellowshipOfTheRing.add(legolas);
        fellowshipOfTheRing.add(merry);
        fellowshipOfTheRing.add(pippin);
        fellowshipOfTheRing.add(sam);

        // Orcs with hobbits prisoners.
        orcsWithHobbitPrisoners.add(guruk);
        orcsWithHobbitPrisoners.add(merry);
        orcsWithHobbitPrisoners.add(pippin);

        // Trilogy.
        trilogy.add(theFellowshipOfTheRing);
        trilogy.add(theTwoTowers);
        trilogy.add(theReturnOfTheKing);
    }

    @After
    public void teardownAbstract() {
        ringsOfPower.clear();
        ringBearers.clear();
        fellowshipOfTheRing.clear();
        orcsWithHobbitPrisoners.clear();
        trilogy.clear();
    }
}

package com.github.bjanczak.assertjdemo;

import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

/**
 * @author Bartłomiej Jańczak
 */
public class Chapter8_OtherAssertions {

    private Map<Integer, String> map = null;

    @Before
    public void setup() {
        map = ImmutableMap.<Integer, String>builder()
                          .put(1, "one")
                          .put(2, "two")
                          .put(3, "three")
                          .put(4, "four")
                          .build();
    }


    @Test
    public void testMapAssertions() {

        assertThat(map).contains(entry(1, "one"), entry(2, "two"));

        assertThat(map).containsOnly(entry(1, "one"), entry(2, "two"), entry(3, "three"), entry(4, "four"));

        assertThat(map).containsEntry(1, "one").containsEntry(2, "two");

        assertThat(map).doesNotContain(entry(5, "one"), entry(6, ""));

        assertThat(map).doesNotContainEntry(6, "six");

        assertThat(map).containsKey(1);

        assertThat(map).containsKeys(1, 2);

        assertThat(map).containsValues("one", "two");

        assertThat(map).containsOnlyKeys(1, 2, 3, 4);

        assertThat(map).doesNotContainKey(5);

        assertThat(map).doesNotContainKeys(6, 7);
    }

    @Test
    public void testNumberAssertions() {

        assertThat(38).isEqualTo(38)
                      .isCloseTo(40, within(10));

        assertThat(33).isEqualTo(33)
                      .isNotEqualTo(38);

        assertThat(10).isGreaterThan(5).isGreaterThanOrEqualTo(5);

        assertThat(5).isLessThan(10).isLessThanOrEqualTo(33);

        assertThat(0).isZero();

        assertThat(-1).isNegative();
        assertThat(0).isNotPositive();

        assertThat(1).isPositive();
        assertThat(0).isNotNegative();

        assertThat(8.1).isCloseTo(8.0, within(0.1));

        assertThat(5.0).isCloseTo(6.0, withinPercentage(20.0));
    }

    @Test
    public void testStringAssertions() {

        assertThat("Frodo").isEqualToIgnoringCase("FROdO");

        assertThat("Frodo").doesNotStartWith("fro").doesNotEndWith("don");

        assertThat("Frodo").startsWith("Fro").endsWith("do").hasSize(5);

        assertThat("3210").containsOnlyDigits();
    }
}

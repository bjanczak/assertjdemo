package com.github.bjanczak.assertjdemo;

import org.junit.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.DateUtil.parse;
import static org.assertj.core.util.DateUtil.parseDatetimeWithMs;

/**
 * @author Bartłomiej Jańczak
 */
public class Chapter5_DateAssetions extends AbstractAssertionsExample {

    @Test
    public void dateRelationAssertions() {

        assertThat(parse(theTwoTowers.getReleaseDate())).isAfter("1999-01-01");

        assertThat(parse(theTwoTowers.getReleaseDate())).isBefore("2999-01-01");

        assertThat(parse(theTwoTowers.getReleaseDate())).isAfterYear(1999);

        assertThat(parse(theTwoTowers.getReleaseDate())).isBeforeYear(2015);

        assertThat(parse(theTwoTowers.getReleaseDate())).isBetween(parse("1999-01-01"), parse("2999-01-01"));

        assertThat(parse(theTwoTowers.getReleaseDate())).isNotBetween(parse("1999-01-01"), parse("1999-02-01"));
    }

    @Test
    public void datePastFutureAssertions() {

        assertThat(new Date(42)).hasTime(42);

        assertThat(new Date(new Date().getTime() - 1)).isInThePast();

        assertThat(new Date(new Date().getTime() + 100)).isInTheFuture();
    }

    @Test
    public void  scopeEqualityAssertions() {

        Date date1 = parseDatetimeWithMs("2003-01-01T01:00:00.000");
        Date date2 = parseDatetimeWithMs("2003-01-01T01:00:00.555");
        Date date3 = parseDatetimeWithMs("2003-01-01T01:00:55.555");
        Date date4 = parseDatetimeWithMs("2003-01-01T01:55:55.555");
        Date date5 = parseDatetimeWithMs("2003-01-01T05:55:55.555");

        assertThat(date1).isEqualToIgnoringMillis(date2);
        assertThat(date1).isInSameSecondAs(date2);

        assertThat(date1).isEqualToIgnoringSeconds(date3);
        assertThat(date1).isInSameMinuteAs(date3);

        assertThat(date1).isEqualToIgnoringMinutes(date4);
        assertThat(date1).isInSameHourAs(date4);

        assertThat(date1).isEqualToIgnoringHours(date5);
        assertThat(date1).isInSameDayAs(date5);

        assertThat(date1).isInSameMonthAs(date5);
        assertThat(date1).isInSameYearAs(date5);
    }
}

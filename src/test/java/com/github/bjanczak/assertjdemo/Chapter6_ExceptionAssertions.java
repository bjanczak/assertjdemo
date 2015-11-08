package com.github.bjanczak.assertjdemo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bartłomiej Jańczak
 */
public class Chapter6_ExceptionAssertions {

    @Test
    public void testExceptionAssertions() {
        try {
            Integer.valueOf("error");
        } catch (Exception e) {

            assertThat(e).isInstanceOf(NumberFormatException.class);

            assertThat(e).hasNoCause();

            assertThat(e).hasMessage("For input string: \"error\"");

            assertThat(e).hasMessageStartingWith("For").hasMessageContaining("string").hasMessageEndingWith("\"error\"");
        }
    }

    @Test
    public void testExceptionCauseAssertions() {
        Throwable throwable = new RuntimeException(new NumberFormatException());

        assertThat(throwable).hasCauseInstanceOf(RuntimeException.class);

        assertThat(throwable).hasCauseExactlyInstanceOf(NumberFormatException.class);

        assertThat(throwable).hasRootCauseInstanceOf(RuntimeException.class);

        assertThat(throwable).hasRootCauseExactlyInstanceOf(NumberFormatException.class);
    }
}

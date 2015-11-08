package com.github.bjanczak.assertjdemo;

import com.github.bjanczak.assertjdemo.data.CharacterType;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bartłomiej Jańczak
 */
public class Chapter4_ClassAssertions {

    @Test
    public void test() {
        assertThat(CharacterType.class).isAnnotation();

        assertThat(CharacterType.class).isNotAnnotation();

        assertThat(CharacterType.class).hasAnnotation(Test.class);

        assertThat(CharacterType.class).isNotInterface();

        assertThat(CharacterType.class).isAssignableFrom(CharacterType.class);
    }
}

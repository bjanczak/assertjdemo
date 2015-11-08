package com.github.bjanczak.assertjdemo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bartłomiej Jańczak
 */
public class Chapter2_ComparableAssertions {

    @Test
    public void test() {
        Integer $5Value = Integer.valueOf(5);
        Integer $10Value = Integer.valueOf(10);

        assertThat($10Value).isGreaterThan($5Value);

        assertThat($10Value).isGreaterThanOrEqualTo($5Value);

        assertThat($5Value).isLessThan($10Value);

        assertThat($5Value).isLessThanOrEqualTo($10Value);



        MyComparable $5MyComparable = new MyComparable(5);
        MyComparable $10MyComparable = new MyComparable(10);

        assertThat($5MyComparable).isEqualByComparingTo($5MyComparable);

        assertThat($5MyComparable).isNotEqualByComparingTo($10MyComparable);
    }

    private static class MyComparable implements Comparable<MyComparable> {

        private int value;

        public MyComparable(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public int compareTo(MyComparable o) {
            return value - o.getValue();
        }

        @Override
        public String toString() {
            return "MyComparable{" +
                    "value=" + value +
                    '}';
        }
    }
}

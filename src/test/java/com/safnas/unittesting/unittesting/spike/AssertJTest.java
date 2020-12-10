package com.safnas.unittesting.unittesting.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class AssertJTest {

    @Test
    public void learning(){
        List<Integer> numbers = Arrays.asList(12,15,45);

//        assertThat(numbers, hasSize(3));
        assertThat(numbers)
                .hasSize(3)
                .contains(12,15)
                .allMatch(num -> num > 10)
                .noneMatch(num -> num < 0);

//        assertThat(numbers, hasItems(12,45));
//        assertThat(numbers, everyItem(greaterThan(10)));
//
//        assertThat("ABCDE", containsString("BCD"));
        assertThat("ABCDE")
                .contains("BCD")
                .startsWith("ABC")
                .endsWith("CDE");
//        assertThat("ABCDE", startsWith("ABC"));
    }
}
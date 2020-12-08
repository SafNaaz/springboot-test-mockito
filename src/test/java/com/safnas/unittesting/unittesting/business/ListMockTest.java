package com.safnas.unittesting.unittesting.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListMockTest {

    @Test
    public void size_basic(){
        List mock = mock(List.class);
        when(mock.size()).thenReturn(5);
        assertEquals(5,mock.size());
    }
}

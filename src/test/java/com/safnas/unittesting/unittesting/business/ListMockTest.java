package com.safnas.unittesting.unittesting.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mock = mock(List.class);

    @Test
    public void size_basic(){
        when(mock.size()).thenReturn(5);
        assertEquals(5,mock.size());
    }

    @Test
    public void returnDifferentValues(){
        List mock = mock(List.class);
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mock.size());
        assertEquals(10,mock.size());
    }

    @Test
    public void returnWithParameters(){
        when(mock.get(0)).thenReturn("Safnas");
        assertEquals("Safnas", mock.get(0));
        assertEquals(null, mock.get(1));
    }

    @Test
    public void returnWithGenericParameters(){
        when(mock.get(anyInt())).thenReturn("Safnas");
        assertEquals("Safnas", mock.get(0));
        assertEquals("Safnas", mock.get(1));
    }

    @Test
    public void verificationBasics(){
        //SUT
        String value1 = mock.get(0);
        String value2 = mock.get(1);

        //verify
        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    public void argumentCapturing(){
        //SUT
        mock.add("SomeString");

        //verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("SomeString", captor.getValue());
    }
}

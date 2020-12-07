package com.safnas.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomeBusinessTest {

	@Test
	void calculateSum_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int [] {1, 2, 3});
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}

}

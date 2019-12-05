package com.utecht;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.Test;

class Day01Test{
	
	@Test
	void findFuelTest(){
		final Day01 d = new Day01(null);
		assertEquals(2, d.findFuel(12));
		assertEquals(2, d.findFuel(14));
		assertEquals(654, d.findFuel(1969));
		assertEquals(33583, d.findFuel(100756));
	}
	
	@Test
	void part01Test(){
		final Day01 d = new Day01(new File("src/test/java/input/day01.txt"));
		assertEquals(3406342, d.part01());
	}
	
	@Test
	void findFuelOfFuelTest(){
		final Day01 d = new Day01(null);
		assertEquals(2, d.findFuelOfFuel(14));
		assertEquals(966, d.findFuelOfFuel(1969));
		assertEquals(50346, d.findFuelOfFuel(100756));
	}
	
	@Test
	void part02Test(){
		final Day01 d = new Day01(new File("src/test/java/input/day01.txt"));
		assertEquals(5106629, d.part02());
	}
}

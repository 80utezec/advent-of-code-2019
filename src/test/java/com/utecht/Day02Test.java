package com.utecht;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Day02Test{
	public static final Logger LOGGER = LoggerFactory.getLogger(Day02Test.class);
	
	@Test
	void calculate(){
		int[] registers = Arrays
			.stream(Utils.getScanner(new File("src/test/resources/input/day02.txt")).nextLine().split(","))
			.mapToInt(Integer::parseInt).toArray();
		final Day02 d = new Day02(new File("src/test/resources/input/day02.txt"));
		assertEquals(610685, d.calculate(0, 0, registers));
	}
	
	@Test
	void part01() {
		final Day02 d = new Day02(new File("src/test/resources/input/day02.txt"));
		assertEquals(610685, d.part01(0, 0));
	}
	
	@Test
	void part02() {
		final Day02 d = new Day02(new File("src/test/resources/input/day02.txt"));
		assertEquals(5335, d.part02(19690720));
	}
}

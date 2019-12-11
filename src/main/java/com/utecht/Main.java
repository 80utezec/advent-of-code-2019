package com.utecht;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main{
	
	public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args){
		final File day01File = new File("src/test/resources/input/day01.txt");
		final Day01 day01 = new Day01(day01File);
		LOGGER.info("Day 01, part01: {}", day01.part01());
		LOGGER.info("Day 01, part02: {}", day01.part02());
		
		final File day02File = new File("src/test/resources/input/day02.txt");
		final Day02 day02 = new Day02(day02File);
		LOGGER.info("Day 02, part01: {}", day02.part01(12, 2));		
		LOGGER.info("Day 02, part02: {}", day02.part02(19690720));
	}
	
}

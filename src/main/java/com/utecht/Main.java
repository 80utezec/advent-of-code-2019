package com.utecht;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main{
	
	public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args){
		final File file = new File("C:\\Users\\80utezec\\dev\\\\adventOfCode2019Input\\day01.txt");
		final Day01 day01 = new Day01(file);
		LOGGER.info("Day 01, part01: {}", day01.part01());
	}
	
}

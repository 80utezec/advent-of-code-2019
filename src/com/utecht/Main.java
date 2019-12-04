package com.utecht;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		final File file = new File("C:\\Users\\80utezec\\Desktop\\input.txt");
		final Day01 day01 = new Day01(file);
		System.out.println(day01.part01());
		day01.part02();
	}

}

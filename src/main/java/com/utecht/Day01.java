package com.utecht;

import java.io.File;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Day01{
	
	public static final Logger LOGGER = LoggerFactory.getLogger(Day01.class);
	final File file;
	
	public Day01(final File file){
		this.file = file;
	}
	
	protected int part01(){
		int result = 0;
		final Scanner sc = Utils.getScanner(this.file);
		while(sc.hasNext()) {
			final String line = sc.nextLine();
			result += findFuel(Integer.valueOf(line));
		}
		return result;
	}
	
	protected int part02(){
		int result = 0;
		final Scanner sc = Utils.getScanner(this.file);
		while(sc.hasNext()) {
			final String line = sc.nextLine();
			result += findFuelOfFuel(Integer.valueOf(line));
		}
		return result;
	}
	
	protected int findFuel(int mass) {
		return (Math.floorDiv(mass, 3) - 2);
	}
	
	protected int findFuelOfFuel(int mass) {
		int fuel = findFuel(mass);
		if(fuel > 0) {
			return fuel + findFuelOfFuel(fuel);
		}
		return 0;
	}
}

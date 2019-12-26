package com.utecht;

import java.io.File;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Day02{
	
	public static final Logger LOGGER = LoggerFactory.getLogger(Day02.class);
	
	int[] registers;
	public Day02(final File file){
		registers = Arrays.stream(Utils.getScanner(file).nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
	}
	
	protected int calculate(final int num1, final int num2, final Computer c){
		c.setValue(1, num1);
		c.setValue(2, num2);
		c.calculate();
		return c.memory[0];
	}
	
	protected int part01(int noun, int verb){
		return calculate(noun, verb, new Computer(registers));
	}
	
	protected int part02(int goal){
		for(int i = 0; i < 100; i++){
			for(int j = 0; j < 100; j++){
				if(calculate(i, j, new Computer(registers)) == goal){
					return 100 * i + j;
				}
			}
		}
		return 0;
	}
}

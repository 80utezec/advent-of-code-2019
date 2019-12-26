package com.utecht;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Day04{
	
	public static final Logger LOGGER = LoggerFactory.getLogger(Day04.class);
	int lowerLimit = 0;
	int upperLimit = 0;
	
	public Day04(final int lower, final int upper) {
		//273025-767253
		lowerLimit = lower;
		upperLimit = upper;
	}
	
	protected int part01() {
		int validPasswords = 0;
		for(int i = lowerLimit; i < upperLimit; i++) {
			if(validPassword(i, 1)) {
				//LOGGER.debug("Valid password: {}", i);
				validPasswords++;
			}
		}
		return validPasswords;
	}
	
	protected int part02() {
		int validPasswords = 0;
		for(int i = lowerLimit; i < upperLimit; i++) {
			if(validPassword(i, 2)) {
				//LOGGER.debug("Valid password: {}", i);
				validPasswords++;
			}
		}
		return validPasswords;
	}
	
	protected boolean validPassword(int password, int part) {
		int[] pass = Arrays.stream(Integer.toString(password).split("")).mapToInt(Integer::parseInt).toArray();
		if(pass.length != 6) {
			return false;
		}
		if(part == 1) {
			return checkAscending(pass) && checkRepeat(pass);
		}else if(part == 2) {
			return checkAscending(pass) && checkRepeatOnlyTwice(pass);
		}else {
			return false;
		}
	}
	
	protected boolean checkAscending(int[] num) {
		int count = 0;
		boolean increasing = true;
		for(final int i : num) {
			if(count != 0) {
				if(i < num[count-1]) {
					increasing = false;
				}
			}
			count++;
		}
		return increasing;
	}
	
	protected boolean checkRepeat(int[] num) {
		int count = 0;
		boolean repeat = false;
		for(final int i : num) {
			if(count != 0) {
				if(i == num[count-1]) {
					repeat = true;
				}
			}
			count++;
		}
		return repeat;
	}
	
	protected boolean checkRepeatOnlyTwice(int[] num) {
		int count = 0;
		int repeatCount = 0;
		for(final int i : num) {
			if(count != 0) {
				if(i == num[count-1]) {
					repeatCount++;
				}else {
					if(repeatCount == 1) {
						return true;
					}
					repeatCount = 0;
				}
			}
			count++;
		}
		return repeatCount == 1;
	}
}

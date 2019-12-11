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
	
	protected int calculate(int num1, int num2, int[] nums){
		nums[1] = num1;
		nums[2] = num2;
		int idx = 0;
		while(nums[idx] != 99){
			int num = nums[idx];
			int val1 = nums[nums[idx + 1]];
			int val2 = nums[nums[idx + 2]];
			int idx3 = nums[idx + 3];
			if(num == 1){
				nums[idx3] = val1 + val2;
			}else if(num == 2){
				nums[idx3] = val1 * val2;
			}else{
				LOGGER.warn("Invalid opcode: {}", num);
			}
			idx += 4;
		}
		return nums[0];
	}
	
	protected int part01(int noun, int verb){
		return calculate(noun, verb, registers.clone());
	}
	
	protected int part02(int goal){
		for(int i = 0; i < 100; i++){
			for(int j = 0; j < 100; j++){
				if(calculate(i, j, registers.clone()) == goal){
					return 100 * i + j;
				}
			}
		}
		return 0;
	}
}

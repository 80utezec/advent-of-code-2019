package com.utecht;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Computer{
	
	int[] memory;
	public static final Logger LOGGER = LoggerFactory.getLogger(Computer.class);
	
	public Computer(int[] memory) {
		this.memory = memory.clone();
	}
	
	protected void opcode1(int pos1, int pos2, int address) {
		//LOGGER.debug("pos1: {}, pos2: {}, address: {}", pos1, pos2, address);
		memory[address] = memory[pos1] + memory[pos2];
	}
	
	protected void opcode2(int pos1, int pos2, int address) {
		//LOGGER.debug("pos1: {}, pos2: {}, address: {}", pos1, pos2, address);
		memory[address] = memory[pos1] * memory[pos2];
	}
	
	protected int[] opcode3(int num1, int num2, int[] registers) {
		return registers;
	}
	
	protected int[] opcode4(int num1, int num2, int[] registers) {
		return registers;
	}
	
	protected int calculate() {
		int address = 0;
		int opcode = memory[address];
		while(opcode != 99){
			switch(opcode) {
				case 1:
					opcode1(memory[address + 1], memory[address + 2], memory[address + 3]);
					address += 4;
					break;
				case 2:
					opcode2(memory[address + 1], memory[address + 2], memory[address + 3]);
					address += 4;
					break;
				default:
					throw new IllegalArgumentException("Unknown opcode: \'" + memory[address] + "\'");
			}
			opcode = memory[address];
		}
		return memory[0];
	}
	
	protected void setValue(final int address, final int value) {
		memory[address] = value;
	}
}

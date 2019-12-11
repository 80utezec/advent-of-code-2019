package com.utecht;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class MainTest{
	
	public static final Logger LOGGER = LoggerFactory.getLogger(MainTest.class);
	
	@Test
	void getScannerTest(){
		final Scanner sc = Utils.getScanner(new File("src/test/resources/input/utils.txt"));
		assertEquals("1,-2,2,0", sc.nextLine());
		sc.close();
	}
	
	@Test
	void getScannerTestFail(){
		assertEquals(null, Utils.getScanner(new File("src/test/resources/input/nothing")));
	}

	@Test
	void mainTest() {
		Main.main(null);
	}
	
}

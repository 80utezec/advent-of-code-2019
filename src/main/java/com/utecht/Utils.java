package com.utecht;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {
	public static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);
	
	protected static Scanner getScanner(final File file) {
		try {
			return new Scanner(file);
		} catch (FileNotFoundException e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}
}

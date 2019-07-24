package org.fablab.miner.api.inner.impl;


// This class fixes the JSON syntax which is incorrectly returned by miner
public class JSONSyntaxCorrector {
	
	private static final String PATTERN = "}{";
	
	public static String correctSyntax(String invalidJson) {
		return invalidJson.replace(PATTERN, "},{");
	}

}

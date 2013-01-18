package com.supinfo.charscounter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileReader reader = null;
		char[] buffer = new char[1];
		Map<Character, Integer> charsNumbers = new TreeMap<Character, Integer>(); 
		
		try {
			reader = new FileReader("lorem-ipsum.txt");
			
			while(reader.read(buffer) > -1) {
				if(charsNumbers.containsKey(buffer[0])) {
					charsNumbers.put(
							buffer[0], 
							charsNumbers.get(buffer[0]) + 1
					);
				}
				else {
					charsNumbers.put(
							buffer[0],
							1
					);
				}
				
				//charsNumbers.put(buffer[0], (charsNumbers.containsKey(buffer[0]) ? charsNumbers.get(buffer[0]) + 1 : 1));
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
		for(Character c : charsNumbers.keySet()) {
			System.out.println(c + " (unicode : " + Character.codePointAt(new char[]{c}, 0) + ") : " + charsNumbers.get(c));
		}
		
	}

}

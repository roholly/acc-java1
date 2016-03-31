package edu.acc.java;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Word frequencies
 * 
 * 1) Write a class WordFreq that tracks word frequencies in a String.  What type would be
 * appropriate?
 * Ignore punctiation and whitespace.  Words are separated by one or more spaces.
 * 
 * 2) Test WordFreq with a random selection of text from the Java API of at least 100 words.
 * 
 * 3) Is there a Map implementation that sorts the keys?  Demonstrate.
 * @author javauser
 *
 */

public class WordFreq {

	public static void main(String[] args) {
		TreeMap<String, Integer> m = new TreeMap<>();
		String str = "Java is a general-purpose computer programming language that is concurrent, class-based, object-oriented,[13] and specifically designed to have as few implementation dependencies as possible. It is intended to let application developers write once, run anywhere (WORA),[14] meaning that compiled Java code can run on all platforms that support Java without the need for recompilation.[15] Java applications are typically compiled to bytecode that can run on any Java virtual machine (JVM) ";
		String[] words = str.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
		for (String s : words)  {
			if (m.containsKey(s))  {
				int cnt = m.get(s);
				m.put(s, ++cnt);
				}
			else {
				m.put(s,  1);
			}
		}
		System.out.println(m);

	}

}

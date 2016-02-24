package edu.acc.java;
/**
* Create a Shape class that has a constructor that prints "I'm the Shape constructor."
* The second constructor requires a string input to create the object.
* 
* @author rh
*
*/
public class Shape {
		public Shape() {
			System.out.println("Shape() constructor");
		}

		public Shape(String s) {
			System.out.println("Shape(String) constructor: " + s);
		}

}

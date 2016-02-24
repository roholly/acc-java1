package edu.acc.java;

public class Rectangle extends Shape  {
	
	private float length;
	private float width;
	
	public Rectangle() {
		System.out.println("In Rectangle() constructor.");
		length = 1.0f;
		width = 1.0f;
	}

	public Rectangle(float l, float w) {
		System.out.println("In Rectangle(float, float) constructor.");
		length = l;
		width = w;
		}
	
	public static void main(String[] args) {
		Rectangle recOne = new Rectangle();
		recOne.length = recOne.getLength();
		System.out.println("Value of recOne.length after running get method is:  " + recOne.length);
		recOne.setLength(30.0f);
		System.out.println("Value of recOne.length after running set method is:  " + recOne.length);
		Rectangle recTwo = new Rectangle(5.0f, 2.0f);
		System.out.println("Value of recTwo.length is:  " + recTwo.length);
		System.out.println("Value of recTwo.width is:  " + recTwo.width);
		System.out.println("Area of recTwo rectangle is:  " + recTwo.findArea());
		System.out.println("Perimeter of recTwo rectangle is:  " + recTwo.findPerimeter());
	}

	public float getLength() {
		return this.length;
	}

	public void setLength(float length) {
			if (length >= 1.0f && length <= 50.0f) {
				this.length = length;
			}  else  {
				System.out.println("Length paramater must be between 1.0 and 50.0.");
			}
		
	}

	public float getWidth() {
		return this.width;
	}

	public void setWidth(float width) {
		if (width >= 1.0 && width <= 50.0) {
		this.width = width;
		}  else  {
		System.out.println("Width paramater must be between 1.0 and 50.0.");
		}
	}
	
	public float findArea()  {
		return (this.length * this.width);
	}
	
	public float findPerimeter()  {
		return (2 * (this.length + this.width));
	}
	
}

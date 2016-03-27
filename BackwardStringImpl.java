package edu.acc.java;
import java.util.Random;

public class BackwardStringImpl implements CharSequence {
	private String s;
	
	public BackwardStringImpl(String s)  {
		this.s = s;
	}

	@Override
	public char charAt(int i) {
		if ((i < 0) || (i >= s.length())) {
            throw new StringIndexOutOfBoundsException(i);
        }
        
		return s.charAt(s.length() - 1 - i);

	}

	@Override
	public int length() {
		
		return s.length();
	}

	@Override
	public String subSequence(int arg0, int arg1) {
		CharSequence cs = new String(s.substring(arg0, arg1));
		
		return cs.toString();
	}
	
		
	@Override
	public String toString() {
		
		return s;
	}


	public static void main(String[] args)  {
		String str = "Write a class that implements the CharSequence interface found in the java.lang.package.";
		BackwardStringImpl demo = new BackwardStringImpl(str);
		System.out.println("The exercise is to write the following sentence backward:\n");
		System.out.println(demo.toString() + "\n");
		//Random rand = new Random();
		// Grab a random index within the length of str:
		//int start = rand.nextInt(demo.s.length() - 1);
		// Grab a second random index from str, but with a range smaller by the number of chars in start
		//   then add back the number of start chars to complete the final index number
		//int end = rand.nextInt(demo.s.length() - 1 - start) + start;
		//String subStr = demo.subSequence(start, end);
		System.out.println("Using subSequence method:");
		for (int i = 0; i < str.length(); i++)  {
			System.out.print(demo.charAt(i));
		}
		System.out.println("\n");
		StringBuilder strBuildDemo = new StringBuilder(str);
		System.out.println("Using StringBuilder method:");
		System.out.println(strBuildDemo.reverse());
	}
}

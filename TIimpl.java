package edu.acc.java;

import java.util.Arrays;

public class TIimpl implements Y, Z {

	@Override
    public double get_count() {
        double doubleNum = 5.4d;
        
        return doubleNum;
    }

    @Override
    public String another_greeting() {
        String greetingString = "This is another_greeting string.";
        
        return greetingString;
    }

    @Override
    public String greeting() {
        String greetingString = "This is the greeting string, 123.";
        
        return greetingString;
    }
    
    public void iterateOver(String s)  {
        int len = s.length();
        for (int i = 0; i < len; i++)  {
            char c = s.charAt(i);
            System.out.println(c + " is of character type " + Character.getName(c) + "\n");
        }
        
    }
    
    public void printInitials(String s)  {
        String[] splitString = s.split("\\s+");
        for (int i=0; i < (splitString.length); i++)  {
        	System.out.print(splitString[i].charAt(0));
        }
        System.out.println("");
    }

    public boolean isAnagram(String a, String b)  {
    	//System.out.println("a is now: " + a);
    	//System.out.println("b is now: " + b);
    	a = sortString(a);
    	b = sortString(b);
    	System.out.println("a is now: " + a);
    	System.out.println("b is now: " + b);
    	System.out.println("Is \"a\" an anagram of \"b\"?");
    	if (a.length() != b.length())  {
    		return false;
    	}
    	return a.equals(b);
    	
    }
  
    public String sortString(String s)  {
    	s = s.replaceAll("\\s", "");
    	char[] cArray = s.toLowerCase().toCharArray();
        Arrays.sort(cArray);
        return String.valueOf(cArray);

    }
    
        
    public static void main(String... args)  {
        TIimpl TIimplTest = new TIimpl();
        System.out.println(TIimplTest.greeting());
        System.out.println(TIimplTest.another_greeting());
        System.out.println(TIimplTest.get_count());
        TIimplTest.iterateOver(TIimplTest.greeting()); 
        TIimplTest.printInitials("Rosemary Holly");
        System.out.println(TIimplTest.isAnagram(" software ", "swear oft "));
    }
}

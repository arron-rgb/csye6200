package edu.neu.csye6200;

public class Driver {

	public static void main(String[] args) {
		System.out.println(Driver.class.getName() + ".main()...");
		
		DemoAutoBoxing.demo();
		Item.demo();
//		DemoException.demo();
		/**
		 * Variable name is a Type String Reference type 
		 */
		String firstName;	// declare a variable type String: Reference Type
		String lastName;	// declare a variable type String: Reference Type
		String firstName2;	// declare a variable type String: Reference Type
		String lastName2;	// declare a variable type String: Reference Type
		String firstName3;	// declare a variable type String: Reference Type
		String lastName3;	// declare a variable type String: Reference Type
		/*
		 * assign (reference to a String object allocated on Heap) to name
		 * NOTE: do NOT use "new" with String objects as that would defeat String interning (pooling)
		 */
		firstName = "Dan";		// compiler implied "new" creates String object on heap
		lastName = "Peters";	// compiler implied "new" creates String object on heap
		System.out.println("name = " + firstName + " " + lastName);
		
		firstName2 = "Cong";		// compiler implied "new" creates String object on heap
		lastName2 = "Wang";		// compiler implied "new" creates String object on heap
		lastName2 = "Peng";		// compiler implied "new" creates String object on heap
		System.out.println("name = " + firstName2 + " " + lastName2);
		
		firstName3 = "Guojun";	// compiler implied "new" creates String object on heap
		lastName3 = "Wang";		// compiler implied "new" creates String object on heap
		System.out.println("name = " + firstName3 + " " + lastName3);
		
		/**
		 * Code block (inside of main method code block)
		 */
		{
			int n = 7;	// assign literal integer value, 7, to variable n
			System.out.println("n = " + n);
			n = 3;	// assign literal integer value, 3, to variable n
			System.out.println("n = " + n);
		}
		int n = 3;	// assign literal integer value, 3, to variable n
		System.out.println("n = " + n);
		
		System.out.println(Driver.class.getName() + ".main()... done!");
	}

}

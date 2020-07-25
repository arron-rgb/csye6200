package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Demonstrate the use of Wrapper classes for primitive data types and Collections
 * @author dpeters
 *
 */
public class DemoAutoBoxing {
	/**
	 * Inner Item class represents a consumer item for purchase
	 * @author dpeters
	 *
	 */
	private class Item implements Comparable<Item>, Comparator<Item>{
		private int id;
		private double price;
		private String name;
		
		/**
		 * Implement Comparable interface so objects
		 * created from this class have a DEFAULT or Natural Order
		 * 
		 * @param someOtherItem	Item objet
		 * 
		 * @return	Metric for Sort default Order
		 */
		@Override
		public int compareTo(Item someOtherItem) {
			/**
			 * Default order is by PRICE
			 */
			return Double.compare(this.getPrice(), someOtherItem.getPrice());
//			/**
//			 * Default order is by ID
//			 */
//			return Integer.compare(this.getId(), o.getId());
//			/**
//			 * Default order is by NAME
//			 */
//			return this.getName().compareTo(o.getName());
		}

		/**
		 * Implement Comparator interface to specify a SPECIFIC Sort Order
		 * 
		 * @param o1	first Item object to compare
		 * @param o2	second Item object to compare
		 * @return		integer metric
		 */
		@Override
		public int compare(Item o1, Item o2) {
			return o1.getName().compareTo(o2.getName());
		}
		/**
		 * CompareById implements the Comparator's compare method 
		 * FOR ANOTHER SPECIFIC ORDER for sort (SORT BY ID)
		 * 
		 * @param o1	first Item object to compare
		 * @param o2	second Item object to compare
		 * @return		integer metric
		 */
		public int compareById(Item o1, Item o2) {
			return Double.compare(o1.getId(), o2.getId());
		}

		public Item() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Item(int id, double price, String name) {
			super();
			this.id = id;
			this.price = price;
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * Return a String description of representation of the State of the object
		 */
		@Override
		public String toString() {
			return "#" + id + " $" + price + " '" + name + "'";
		}
	}
	
	/**
	 * Show how to wrap a primitive int with an Integer object
	 */
	public void boxInt() {
		System.out.println(DemoAutoBoxing.class.getName() + ".boxInt()...");
		int n = 7;	// primitive int type
		System.out.println("n = " + n);	// show value of n on stdout
		/**
		 * Wrap primitive int inside of an Integer object
		 */
		Integer number = new Integer(n); // not default constructor, accepts int argument n
		System.out.println("number = " + number);	// show wrapped value in Integer object on stdout
		/**
		 * Add object wrapping int value to List of Integer objects
		 */
		List<Integer> numbers = new ArrayList<>();	// implicit type
//		List<Integer> numbers = new ArrayList<Integer>();	// explicit type
		numbers.add(number);
		/**
		 * Use Java Auto-boxing:
		 * Java compiler will AUTOMATICALLY
		 * box each primitive int
		 * inside an Integer object
		 * so I can add integer values
		 * to my list of Integer objects
		 */
		numbers.add(3);	// auto-boxing of primitive int with an Integer object
		numbers.add(2);
		numbers.add(5);
		numbers.add(6);
		numbers.add(1);
		numbers.add(4);
		/**
		 * Show all integer values in list
		 */
		System.out.println(numbers.size() + " numbers in list.");
		for (Integer e : numbers) {
			System.out.println(e);
		}
		System.out.println("Show auto-unboxing of a primitive int from a Integer object...");
		int n2 = number;	// java auto-unboxing primitive int from Integer object
		System.out.println("n2 = " + n2);
		
		System.out.println(DemoAutoBoxing.class.getName() + ".boxInt()... done!");
	}
	
	/**
	 * Show how to wrap a primitive double with an Double object
	 */
	public void boxDouble() {
		System.out.println(DemoAutoBoxing.class.getName() + ".boxInt()...");
		double n = 7.7;	// primitive int type
		System.out.println("n = " + n);	// show value of n on stdout
		/**
		 * Wrap primitive int inside of an Integer object
		 */
		Double number = new Double(n); // not default constructor, accepts int argument n
		System.out.println("number = " + number);	// show wrapped value in Integer object on stdout
		/**
		 * Add object wrapping int value to List of Integer objects
		 * 
		 * Interface List is an Interface specifying an API for collection classes and
		 * Interface List is implemented by 
		 * 	class ArrayList
		 * 	class Vector
		 * 	class LinkedList
		 * 
		 * SO
		 * We are benefiting from the Object Oriented Principles of:
		 * 	1. Abstraction	: 	List hides the deriving classes of ArrayList, etc.
		 * 	2. Inheritance	:	List is the parent class for child classes of ArrayList, etc.
		 *  3. Polymorphism	:	We use List as an API BUT we get the implementation of
		 *  					the child classes of ArrayList, etc.
		 *  ALSO
		 *  We are using the S.O.L.I.D. design principles of:
		 *  1. O. Open/Closed Principle
		 *  2. L. Liskov Substitution Principle
		 *  3. D. Dependency Inversion Principle
		 *  
		 *  AND THERE IS MORE...
		 *  We are ALSO demonstrating the modern software development techniques of:
		 *  1. Loose Coupling
		 *  2. API use for Functionality Hiding (Abstraction)
		 *  
		 */
//		List<Double> numbers = new LinkedList<>();	// use LinkedList container
//		List<Double> numbers = new Vector<>();		// use Vector container
		List<Double> numbers = new ArrayList<>();	// use ArrayList container
		numbers.add(number);
		/**
		 * Use Java Auto-boxing:
		 * Java compiler will AUTOMATICALLY
		 * box each primitive int
		 * inside an Integer object
		 * so I can add integer values
		 * to my list of Integer objects
		 */
		numbers.add(3.3);	// auto-boxing of primitive int with an Integer object
		numbers.add(2.2);
		numbers.add(5.5);
		numbers.add(6.6);
		numbers.add(1.1);
		numbers.add(4.4);
		/**
		 * Show all Double values in list
		 */
		System.out.println(numbers.size() + " numbers in list.");
		for (Double e : numbers) {
			System.out.println(e);
		}
		System.out.println("Show auto-unboxing of a primitive double from a Double object...");
		double n2 = number;	// java auto-unboxing primitive double from Double object
		System.out.println("n2 = " + n2);
		
		/**
		 * Default sort of List of Integer objects
		 * Integer class ALREADY implements the Comparable Interface
		 * for a Default or Natural Order of Integer objects.
		 */
		System.out.println("Sort String objects (Default Natural Comparable Order)...");
		numbers.sort(null); 	
		System.out.println(numbers.size() + " numbers in list.");
		for (Double e : numbers) {
			System.out.println(e);
		}

		System.out.println(DemoAutoBoxing.class.getName() + ".boxInt()... done!");
	}
	/**
	 * Use a container to hold String objects.
	 */
	public void addStrings() {
		System.out.println(DemoAutoBoxing.class.getName() + ".addStrings()... ");
		/**
		 * Both the List Interface and all classes which implement it (e.g. ArrayList, etc.)
		 * are written GENERICALLY to be written ONCE to handle ALL REFERENCE TYPES.
		 * SO <> contain the ACTUAL TYPE which the Java compiler should generate using the generic code.
		 * 
		 */
		
		/**
		 * Use a FIXED SIZE array
		 * Efficient (minimum memory needed for multiple elements of same type)
		 * BUT CAN NOT GROW OR SHRINK
		 */
		String[] a = { "Mary", "Apoorva", "Aditya", "Hanbo", "Bi"};
		/**
		 * this list can NOT grow, it's storage is a FIXED SIZE array
		 */
//		List<String> names = Arrays.asList(a);	// make array a FIXED SIZE LIST
		/**
		 *  this list can grow because it's array, made to be a FIXED LIST
		 *  is used to initialize (i.e. is copied into) an ArrayList which can grow and shrink
		 *  
		 */
		List<String> names = new ArrayList<>(Arrays.asList(a));	
		
		/*
		 * add a String name and grow the list if necessary
		 */
		names.add("Dan");	
		
		System.out.println(names.size() + " names in list.");
		for (String name : names) {
			System.out.println(name);
		}
		/**
		 * Default sort of List of String objects
		 * String class ALREADY implements the Comparable Interface
		 * for a Default or Natural Order of String objects.
		 */
		names.sort(null); 	
		System.out.println(names.size() + " names in list.");
		for (String name : names) {
			System.out.println(name);
		}
		System.out.println(DemoAutoBoxing.class.getName() + ".addStrings()... done!");
	}
	/**
	 * Create a List of our own Item objects
	 */
	public void addItems() {
		System.out.println(DemoAutoBoxing.class.getName() + ".addItems()... ");
		
		List<Item> items = new ArrayList<DemoAutoBoxing.Item>(Arrays.asList(
				new Item(1,3.49,"OJ"),
				new Item(3,1.49,"Bread"),
				new Item(2,2.49,"Milk")
				));
		System.out.println(items.size() + " items in list.");
		for (Item item : items) {
			System.out.println(item); 	// call toString()
		}
		/**
		 * Default sort of List of Item objects
		 * Item class ALREADY implements the Comparable Interface
		 * for a Default or Natural Order of Item objects.
		 */
		System.out.println("Sort Item object BY PRICE (Default Natural Comparable Order)...");
		items.sort(null); // Item class implements Comparable interface (compareTo method)
		System.out.println(items.size() + " items in list.");
		for (Item item : items) {
			System.out.println(item); 	// call toString()
		}
		/**
		 * Explicit sort of List of Item objects
		 * Item class ALREADY implements the Comparator Interface
		 * for a Specific Order of Item objects.
		 */
		System.out.println("Sort Item object BY NAME (Specific Item Comparator Order)...");
		items.sort(this.new Item()); // Item class implements Comparator interface (compare method)
		System.out.println(items.size() + " items in list.");
		for (Item item : items) {
			System.out.println(item); 	// call toString()
		}
		System.out.println("Sort Item object BY NAME REVERSED (Specific Item Comparator Order)...");
		items.sort(this.new Item().reversed()); // Item class implements Comparator interface (compare method)
		System.out.println(items.size() + " items in list.");
		for (Item item : items) {
			System.out.println(item); 	// call toString()
		}
		/**
		 * Explicit sort of List of Item objects
		 * Item class ALREADY implements the Comparator Interface
		 * for a Specific Order of Item objects.
		 */
		System.out.println("Sort Item object BY ID (Specific Comparator Order)...");
		/**
		 * Use Comparator.comparing static method with a KEY EXTRACTOR
		 * where KEY EXTRACTOR is the getter method to retrieve the attribute to sort by
		 * KEY EXTRACTOR is specified as a Lambda Method Reference:
		 * 	Class::getterMethod  without using any parenthesis ()
		 */
		items.sort(Comparator.comparing(Item::getId)); // Key Extractor is a Getter (Lambda Method Reference)
		System.out.println(items.size() + " items in list.");
		for (Item item : items) {
			System.out.println(item); 	// call toString()
		}
		System.out.println("Sort Item object BY PRICE (Specific Comparator Order)...");
		items.sort(Comparator.comparing(Item::getPrice)); // Key Extractor is a Getter (Lambda Method Reference)
		System.out.println(items.size() + " items in list.");
		for (Item item : items) {
			System.out.println(item); 	// call toString()
		}
		System.out.println("Sort Item object BY NAME REVERSE (Specific Comparator Order)...");
		items.sort(Comparator.comparing(Item::getName).reversed()); // Key Extractor is a Getter (Lambda Method Reference)
		System.out.println(items.size() + " items in list.");
		for (Item item : items) {
			System.out.println(item); 	// call toString()
		}
		System.out.println("Sort Item object BY NAME (Specific Anonymous Inner class Comparator Order)...");
		items.sort(new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				return o1.getName().compareTo(o2.getName());
			}
		}
				); // Key Extractor is a Getter (Lambda Method Reference)
		System.out.println(items.size() + " items in list.");
		for (Item item : items) {
			System.out.println(item); 	// call toString()
		}
		System.out.println(DemoAutoBoxing.class.getName() + ".addItems()... done!");
	}
	/**
	 * Demonstrate the use of this class
	 */
	public static void demo() {
		System.out.println("\n\t DemoAutoBoxing.demo()...");		
		DemoAutoBoxing obj = new DemoAutoBoxing();
		obj.boxInt();
		obj.boxDouble();
		obj.addStrings();
		obj.addItems();
		
		System.out.println("\n\t" + DemoAutoBoxing.class.getName() + " .demo()... done!");		
	}
}

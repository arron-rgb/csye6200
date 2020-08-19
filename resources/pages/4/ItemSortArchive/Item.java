package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Inner Item class represents a consumer item for purchase
 * 
 * @author dpeters
 *
 */
public class Item implements Comparable<Item>, Comparator<Item> {
	public static String author = null;
	public static final int MAJOR_VERSION = 1;
	public static final int MINOR_VERSION = 0;
	public static final String REVISION = new Integer(MAJOR_VERSION) +  "." + new Integer(MINOR_VERSION);
	private int id;
	private double price;
	private String name;
	
	/**
	 * Static Initializer Block
	 * executed ONCE with class
	 * to set default values
	 */
	static {
		Item.author = "Daniel Peters";
	}
	
	/**
	 * Object Initializer Block
	 * executed with each class constructor
	 * to set default values
	 */
	{
		this.id = 1;
		this.price = 0.99;
		this.name = "item";
	}

	/**
	 * Default constructor
	 */
	public Item() {
		super();
	}
	/**
	 * Parameterized constructor
	 * 
	 * @param id		Item ID 
	 * @param price		Item price
	 * @param name		Item name
	 */
	public Item(int id, double price, String name) {
		super();
		this.init(id, price, name);
	}
	/**
	 * Create an Item object with it's state
	 * set to values in CSV string formatted as follows:
	 * 
	 * 	"ID,PRICE,NAME"
	 * 
	 * example CSV String data:
	 * 
	 * 	"1,1.49,bread"
	 * 
	 * @param csvData	Comma Separated Value data
	 */
	public Item(String csvData) {
		super();
		String[] tokens = csvData.split(",");
		/**
		 * Parse CSV data 
		 * If insufficient tokens,
		 * use default values
		 */
		if (3 == tokens.length) {
			int id = 0;
			double price = 0.0;
			String name = tokens[2];
			id = Conversions.stringToInt(tokens[0]);
			price = Conversions.stringToDouble(tokens[1]);
			
			this.init(id, price, name);
		}
	}
	/**
	 * Initialize the state of this object
	 * 
	 * @param id		Item ID 
	 * @param price		Item price
	 * @param name		Item name
	 */
	public void init(int id, double price, String name) {
		this.id = id;
		this.price = price;
		this.name = name;
	}

	/**
	 * Implement Comparable Interface
	 * 
	 * with this compareTo  (myself) method
	 * so objects created from this class have a 
	 * DEFAULT or Natural Order
	 * 
	 * @param someOtherItem	Item object
	 * 
	 * @return	Metric for Sort default Order
	 */
	@Override
	public int compareTo(Item someOtherItem) {
		/**
		 * Default order is by PRICE
		 */
		return Double.compare(this.getPrice(), someOtherItem.getPrice());
//		/**
//		 * Default order is by ID
//		 */
//		return Integer.compare(this.getId(), o.getId());
//		/**
//		 * Default order is by NAME
//		 */
//		return this.getName().compareTo(o.getName());
	}

	/**
	 * Implement Comparator Interface
	 * 
	 * with a compare (two objects) method
	 * to specify a SPECIFIC Sort Order
	 * for objects of this class
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
	 * CompareById implements the SAME SIGNATURE as a
	 * Comparator's compare method 
	 * FOR ANOTHER SPECIFIC ORDER for sort (SORT BY ID)
	 * 
	 * @param o1	first Item object to compare
	 * @param o2	second Item object to compare
	 * @return		integer metric
	 */
	public int compareById(Item o1, Item o2) {
		return Double.compare(o1.getId(), o2.getId());
	}
	/**
	 * Call object instance method to compare Item objects by ID
	 * 
	 * @param o1	first Item object to compare
	 * @param o2	second Item object to compare
	 * @return		integer metric
	 */
	public static int staticCompareById(Item o1, Item o2) {
		return new Item().compareById(o1, o2);
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
	/**
	 * Demonstrate the use of this class
	 */
	public static void demo() {
		System.out.println("\n\t Item.demo()...");		
		Item obj = new Item();

		/**
		 * Create a List of Item objects
		 */
		List<Item> items = new ArrayList<Item>(Arrays.asList(
				new Item(1,3.49,"OJ"),
				new Item(3,1.49,"Bread"),
				new Item(2,2.49,"Milk"),
				new Item("4,0.79,Cheese")
				));
		/**
		 * Show List
		 */
		System.out.println(items.size() + " items in list.");
		for (Item item : items) {
			System.out.println(item); 	// call toString()
		}
		
		/**
		 * Default sort of List of Item objects
		 * Item class ALREADY implements the Comparable Interface
		 * for a Default or Natural Order of Item objects.
		 * 
		 * REQUIREMENT:
		 * 
		 * 	Item class implements Comparable interface (compareTo method)
		 */
		System.out.println("Sort Item object BY PRICE (Default Natural Comparable Order)...");
		items.sort(null); 
//		Collections.sort(items);
		System.out.println(items.size() + " items in list.");
		for (Item item : items) {
			System.out.println(item); 	// call toString()
		}
		
		/**
		 * Explicit sort of List of Item objects
		 * 
		 * REQUIREMENT:
		 * 
		 * 	Use a Comparator to specify a sort order
		 * 
		 * Item class ALREADY implements the Comparator Interface
		 * for a Specific Order of Item objects.
		 */
		System.out.println("Sort Item object BY NAME (Specific Item Comparator Order)...");
		items.sort(new Item()); // Item class implements Comparator interface (compare method)
		System.out.println(items.size() + " items in list.");
		for (Item item : items) {
			System.out.println(item); 	// call toString()
		}
		
		/**
		 * Reverse the sort order of a Comparator
		 */
		System.out.println("Sort Item object BY NAME REVERSED (Specific Item Comparator Order)...");
		items.sort(new Item().reversed()); // Item class implements Comparator interface (compare method)
		System.out.println(items.size() + " items in list.");
		for (Item item : items) {
			System.out.println(item); 	// call toString()
		}
		
		/**
		 * Explicit sort of List of Item objects
		 * Item class ALREADY implements the Comparator Interface
		 * for a Specific Order of Item objects.
		 */
		System.out.println("\n\tSort Item object BY ID (Specific Comparator Order)...");
		/**
		 * Use Comparator to specify a specific sort order
		 * 	where the Comparator object is instantiated from class implementing Comparator interface.
		 */
		System.out.println("\n\t Comparator Object from a class ...");
		items.sort(new CompareItemByPrice());
		System.out.println(items.size() + " items in list.");
		for (Item item : items) {
			System.out.println(item); 	// call toString()
		}
		
		/**
		 * Use Comparator.comparing static method with Lambda expression
		 * 	1. where a Lambda Method provides a inline implementation of a Comparator (compare method).
		 * 	2. where Lambda Method reference specifies an Item instance method which implements the Comparator compare method.
		 * 	3. where Lambda Method reference specifies an Item static method which implements the Comparator compare method.
		 * 	4. where Lambda Method reference specifies a KEY EXTRACTOR for Comparator.comparing method.
		 * where KEY EXTRACTOR is the getter method to retrieve the Item attribute to sort by
		 * KEY EXTRACTOR is specified as a Lambda Method Reference:
		 * 	Class::getterMethod  without using any parenthesis ()
		 */
		System.out.println("\n\t Lambda implements Comparator Interface compare ...");
		items.sort((o1,o2) -> Double.compare(o1.getId(),o2.getId())); // Lambda implements Comparator Interface compare
		System.out.println(items.size() + " items in list.");
		for (Item item : items) {
			System.out.println(item); 	// call toString()
		}
		
		System.out.println("\n\t Lambda Method reference specifies an Item instance method which implements the Comparator compare method. ...");
		items.sort(obj::compareById); // Lambda Method reference specifies an Item instance method which implements the Comparator compare method.
		System.out.println(items.size() + " items in list.");
		for (Item item : items) {
			System.out.println(item); 	// call toString()
		}
		
		System.out.println("\n\t Lambda Method reference specifies an Item static method which implements the Comparator compare method. ...");
		items.sort(Item::staticCompareById); // Lambda Method reference specifies an Item instance method which implements the Comparator compare method.
		System.out.println(items.size() + " items in list.");
		for (Item item : items) {
			System.out.println(item); 	// call toString()
		}
		
		System.out.println("\n\t Lambda Method reference specifies a KEY EXTRACTOR for Comparator.comparing method. ...");
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
		
		System.out.println("\n\t" + Item.class.getName() + " .demo()... done!");		
	}
}

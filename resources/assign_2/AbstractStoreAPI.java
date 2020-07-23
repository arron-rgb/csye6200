package edu.neu.csye6200;

import java.util.Comparator;

public abstract class AbstractStoreAPI {

	/**
	 * Given:
	 * 1. class AbstractLibraryMaterialAPI
	 * 2. class AbstractStoreAPI
	 *
	 * NOTES:
	 * 1. LATE SUBMISSIONS WILL RECEIVE DEDUCTION OF 50 POINTS.
	 * 2. All CONSOLE OUTPUT must be pasted into the end of the edu.neu.cyse6200.Driver class as a comment.
	 *
	 * Implement the following:
	 *
	 * 1. 30 POINTS: class LibraryItem derived from AbstractLibraryMaterialAPI.
	 *
	 * 2. 30 POINTS: class Library derived from AbstractStoreAPI.
	 *
	 * USE the following implementation in your Library class for the showInventory and overloaded sortInventory methods:
	 *
	 *

	@Override
	public void sortInventory() {
		this.items.sort(null);
	}

	@Override
	public void sortInventory(Comparator<AbstractLibraryMaterialAPI> c) {
		this.items.sort(c);
	}

	@Override
	public void showInventory() {
		System.out.println(this);
	}

	 *
	 * 3. 40 POINTS: USE THE FOLLOWING Library DEMO (COMPLETE THIS IMPLEMENTATION AS INDICATED BY **CODE TO BE COMPLETED BY STUDENT**):
	 *
	 * 	public static void demo() {
	 * 	 	System.out.println("\n\t" + Library.class.getName() + ".demo()...");
	 *
	 * 		Library obj = new Library();
	 *
	 * 		// Add items to library
	 *
	 * 		obj.add(new LibraryItem("3,DVD,Java Easy,Adam Peterson,Science,212-217237711-7,7.49"));
	 *		obj.add(new LibraryItem("1,BOOK,My Chosen Career,Daniel Peters,Non-Fiction,212-217237718-7,2.49"));
	 *		obj.add(new LibraryItem("2,CD,Born Free,Sam Jones,Non-Fiction,212-217237713-7,11.49"));
	 *
	 *		System.out.println("Sort inventory by item TITLE.");
	 * 		obj.sortInventory();
	 * 		obj.showInventory();
	 *
	 *		System.out.println("Sort inventory by item ID.");
	 * 		obj.sortInventory(**CODE TO BE COMPLETED BY STUDENT**);
	 * 		obj.showInventory();
	 *
	 *		System.out.println("Sort inventory by item CATEGORY.");
	 * 		obj.sortInventory(**CODE TO BE COMPLETED BY STUDENT**);
	 * 		obj.showInventory();
	 *
	 *		System.out.println("Sort inventory by item AUTHOR.");
	 * 		obj.sortInventory(**CODE TO BE COMPLETED BY STUDENT**);
	 * 		obj.showInventory();
	 *
	 *		System.out.println("Sort inventory by item SUBJECT.");
	 * 		obj.sortInventory(**CODE TO BE COMPLETED BY STUDENT**);
	 * 		obj.showInventory();
	 *
	 *		System.out.println("Sort inventory by item ISBN.");
	 * 		obj.sortInventory(**CODE TO BE COMPLETED BY STUDENT**);
	 * 		obj.showInventory();
	 *
	 *		System.out.println("Sort inventory by item PRICE.");
	 * 		obj.sortInventory(**CODE TO BE COMPLETED BY STUDENT**);
	 * 		obj.showInventory();
	 *
	 * }
	 */
	/**
	 * API
	 */

	/**
	 * Add one AbstractLibraryMaterial object to the library
	 *
	 * @param e		AbstractLibraryMaterial object
	 */
	public abstract void add(AbstractLibraryMaterialAPI e);

	/**
	 * Sort all items in the library by default Natural Order
	 */
	public abstract void sortInventory();

	/**
	 * Sort all items in the library by specific Order specified by the supplied Comparator
	 */
	public abstract void sortInventory(Comparator<AbstractLibraryMaterialAPI> c);

	/**
	 * Show all items in library
	 */
	public abstract void showInventory();
}

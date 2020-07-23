package edu.neu.csye6200;

import java.util.Comparator;

public abstract class AbstractStoreAPI {

  /**
   * Given: 1. class edu.neu.csye6200.AbstractLibraryMaterialAPI 2. class edu.neu.csye6200.AbstractStoreAPI
   *
   * NOTES: 1. LATE SUBMISSIONS WILL RECEIVE DEDUCTION OF 50 POINTS. 2. All CONSOLE OUTPUT must be pasted into the end
   * of the edu.neu.cyse6200.Driver class as a comment.
   *
   * Implement the following:
   *
   * 1. 30 POINTS: class edu.neu.csye6200.LibraryItem derived from edu.neu.csye6200.AbstractLibraryMaterialAPI.
   *
   * 2. 30 POINTS: class edu.neu.csye6200.Library derived from edu.neu.csye6200.AbstractStoreAPI.
   *
   * USE the following implementation in your edu.neu.csye6200.Library class for the showInventory and overloaded sortInventory methods:
   *
   *
   *
   * @Override public void sortInventory() { this.items.sort(null); }
   *
   * @Override public void sortInventory(Comparator<edu.neu.csye6200.AbstractLibraryMaterialAPI> c) { this.items.sort(c); }
   *
   * @Override public void showInventory() { System.out.println(this); }
   *
   *
   *           3. 40 POINTS: USE THE FOLLOWING edu.neu.csye6200.Library DEMO (COMPLETE THIS IMPLEMENTATION AS INDICATED BY **CODE TO BE
   *           COMPLETED BY STUDENT**):
   *
   *           public static void demo() { System.out.println("\n\t" + edu.neu.csye6200.Library.class.getName() + ".demo()...");
   *
   *           edu.neu.csye6200.Library obj = new edu.neu.csye6200.Library();
   *
   *           // Add items to library
   *
   *           obj.add(new edu.neu.csye6200.LibraryItem("3,DVD,Java Easy,Adam Peterson,Science,212-217237711-7,7.49")); obj.add(new
   *           edu.neu.csye6200.LibraryItem("1,BOOK,My Chosen Career,Daniel Peters,Non-Fiction,212-217237718-7,2.49")); obj.add(new
   *           edu.neu.csye6200.LibraryItem("2,CD,Born Free,Sam Jones,Non-Fiction,212-217237713-7,11.49"));
   *
   *           System.out.println("Sort inventory by item TITLE."); obj.sortInventory(); obj.showInventory();
   *
   *           System.out.println("Sort inventory by item ID."); obj.sortInventory(**CODE TO BE COMPLETED BY STUDENT**);
   *           obj.showInventory();
   *
   *           System.out.println("Sort inventory by item CATEGORY."); obj.sortInventory(**CODE TO BE COMPLETED BY
   *           STUDENT**); obj.showInventory();
   *
   *           System.out.println("Sort inventory by item AUTHOR."); obj.sortInventory(**CODE TO BE COMPLETED BY
   *           STUDENT**); obj.showInventory();
   *
   *           System.out.println("Sort inventory by item SUBJECT."); obj.sortInventory(**CODE TO BE COMPLETED BY
   *           STUDENT**); obj.showInventory();
   *
   *           System.out.println("Sort inventory by item ISBN."); obj.sortInventory(**CODE TO BE COMPLETED BY
   *           STUDENT**); obj.showInventory();
   *
   *           System.out.println("Sort inventory by item PRICE."); obj.sortInventory(**CODE TO BE COMPLETED BY
   *           STUDENT**); obj.showInventory();
   *
   *           }
   */
  /**
   * API
   */

  /**
   * Add one AbstractLibraryMaterial object to the library
   *
   * @param e
   *          AbstractLibraryMaterial object
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

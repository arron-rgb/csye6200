package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author arronshentu
 */
public class Library extends AbstractStoreAPI {

  private static final List<AbstractLibraryMaterialAPI> ITEMS = new ArrayList<>();

  @Override
  public void add(AbstractLibraryMaterialAPI e) {
    if (e != null) {
      ITEMS.add(e);
    }
  }

  @Override
  public void sortInventory() {
    ITEMS.sort(AbstractLibraryMaterialAPI::compareTo);
  }

  @Override
  public void sortInventory(Comparator<AbstractLibraryMaterialAPI> c) {
    ITEMS.sort(c);
  }

  @Override
  public void showInventory() {
    System.out.print("[");
    for (int i = 0; i < ITEMS.size(); i++) {
      System.out.print(ITEMS.get(i));
      if (i == ITEMS.size() - 1) {
        break;
      }
      System.out.print(", ");
    }
    System.out.print("]");

    System.out.print(" items in library.");
    ITEMS.forEach(System.out::println);
    System.out.println();
  }

  // [#3 [DVD] $7.49 'Java Easy' by Adam Peterson Science ISBN-13: 212-217237711-7, #1 [BOOK] $2.49 'My Chosen Career'
  // by Daniel Peters Non-Fiction ISBN-13: 212-217237718-7, #2 [CD] $11.49 'Born Free' by Sam Jones Non-Fiction ISBN-13:
  // 212-217237713-7] items in library.#3 [DVD] $7.49 'Java Easy' by Adam Peterson Science ISBN-13: 212-217237711-7
  // #1 [BOOK] $2.49 'My Chosen Career' by Daniel Peters Non-Fiction ISBN-13: 212-217237718-7
  // #2 [CD] $11.49 'Born Free' by Sam Jones Non-Fiction ISBN-13: 212-217237713-7
  public static void main(String[] args) {
    demo();
  }

  public static void demo() {
    Library obj = new Library();
    System.out.println("\n" + "\tedu.neu.csye6200.Library.demo()...");
    // Add items to library

    obj.add(new LibraryItem("3,DVD,Java Easy,Adam Peterson,Science,212-217237711-7,7.49"));
    obj.add(new LibraryItem("1,BOOK,My Chosen Career,Daniel Peters,Non-Fiction,212-217237718-7,2.49"));
    obj.add(new LibraryItem("2,CD,Born Free,Sam Jones,Non-Fiction,212-217237713-7,11.49"));

    // obj.sortInventory();
    obj.showInventory();

    System.out.println("Sort Item object BY Title (Default Natural Comparable Order)...");
    obj.sortInventory();
    obj.showInventory();

    System.out.println("Sort Item object BY ID (Specific Item Comparator Order)...");
    obj.sortInventory(Comparator.comparingInt(AbstractLibraryMaterialAPI::getId));
    obj.showInventory();

    System.out.println("Sort Item object BY CATEGORY (Specific Item Comparator Order)...");
    obj.sortInventory(Comparator.comparing(AbstractLibraryMaterialAPI::getCategory));
    obj.showInventory();

    System.out.println("Sort Item object BY Author (Specific Item Comparator Order)...");
    obj.sortInventory(Comparator.comparing(AbstractLibraryMaterialAPI::getAuthor));
    obj.showInventory();

    System.out.println("Sort Item object BY SUBJECT (Specific Item Comparator Order)...");
    obj.sortInventory(Comparator.comparing(AbstractLibraryMaterialAPI::getSubject));
    obj.showInventory();

    System.out.println("Sort Item object BY ISBN (Specific Item Comparator Order)...");
    obj.sortInventory(Comparator.comparing(AbstractLibraryMaterialAPI::getIsbn));
    obj.showInventory();

    System.out.println("Sort Item object BY PRICE (Specific Item Comparator Order)...");
    obj.sortInventory(Comparator.comparing(AbstractLibraryMaterialAPI::getPrice));
    obj.showInventory();

    System.out.println("Sort Item object BY NAME REVERSED (Specific Item Comparator Order)...");
    obj.sortInventory(Comparator.comparing(AbstractLibraryMaterialAPI::getAuthor).reversed());
    obj.showInventory();
    System.out.println("\n\tedu.neu.csye6200.Library .demo()... done!");
  }
}

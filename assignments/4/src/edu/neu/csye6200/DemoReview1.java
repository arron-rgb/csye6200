package edu.neu.csye6200;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Demonstration of Java as Review
 *
 * @author dpeters
 */
public class DemoReview1 {
  public final static int MAJOR_VERSION = 1;
  public final static int MINOR_VERSION = 0;
  public final static String REGEX = ",";
  public final static String VERSION = MAJOR_VERSION + "." + MINOR_VERSION;

  /**
   * abstract class MyItem for sale
   *
   * @author dpeters
   */
  /* STUDENT MUST IMPLEMENT THIS */
  abstract class MyItem implements Comparable<MyItem> {
    private int id;
    private double price;
    private String name;

    public MyItem() {

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

    public MyItem(int id, double price, String name) {
      this.id = id;
      this.price = price;
      this.name = name;
    }

    /**
     * @return String description
     */
    public abstract String description();

    @Override
    public String toString() {
      return "MyItem # " + id + " $" + price + " " + name + " '" + description() + "'";
    }

    @Override
    public int compareTo(MyItem o) {
      return id > o.getId() ? 1 : (name.compareTo(o.getName()) > 0 ? 1 : (price > o.getPrice() ? 1 : -1));
    }

    public MyItem(String csv) {
      String[] split = csv.split(REGEX);
      this.id = Integer.parseInt(split[0]);
      this.price = Double.parseDouble(split[1]);
      this.name = split[2];
    }

  }

  /**
   * class MyBread item for sale
   *
   * @author dpeters
   */
  /* STUDENT MUST IMPLEMENT THIS */
  class MyBread extends MyItem {
    String description;

    @Override
    public String description() {
      return description == null ? "" : description;
    }

    public MyBread(String csv) {
      super(csv);
    }

    public MyBread(int id, double price, String name) {
      super(id, price, name);
    }

  }

  /**
   * class MyMilk item for sale
   *
   * @author dpeters
   */
  class MyMilk extends MyItem {

    String description;

    public MyMilk(int id, double price, String name) {
      super(id, price, name);
    }

    @Override
    public String description() {
      return description == null ? "" : description;
    }

    public MyMilk(String csv) {
      super(csv);
    }

  }

  /**
   * class MyOj item for sale
   *
   * @author dpeters
   */
  class MyOj extends MyItem {
    String description;

    @Override
    public String description() {
      return description == null ? "" : description;
    }

    public MyOj(int id, double price, String name) {
      super(id, price, name);
    }

    public MyOj(String csv) {
      super(csv);
    }

  }

  public List<MyItem> buildObjects() {
    MyItem milkObject = new MyMilk(1, 2.49, "Milk");
    MyItem ojObject = new MyOj(2, 3.49, "Oj");
    MyItem wheatBreadObject = new MyBread(3, 1.49, "Wheat Bread");
    return new ArrayList<>(Arrays.asList(milkObject, ojObject, wheatBreadObject));
  }

  /**
   *
   * Method Name: createObjects
   *
   * Parameters: none
   * Return value: none
   *
   * Create (instantiate) Objects
   *
   * Instantiate the following objects (milkObject, wheatBreadObject and ojObject):
   * 1. $2.49 Milk
   * 2. $3.49 Oj
   * 3. $1.49 Wheat Bread
   * 4. Associative Container of numbers (numberDictionaryObject):
   * WHERE: 1 is One, 2 is Two, 3 is Three
   * 5. Associative Container of US States (statesDictionaryObject):
   * WHERE: NH is New Hampshire, NY is New York
   *
   */
  public void createObjects() {
    System.out.println("\n\t DemoReview1.createObjects()...");

    System.out.println("Create Milk object...");
    /* STUDENT MUST IMPLEMENT THIS */
    MyItem milkObject = new MyMilk(1, 2.49, "Milk");
    System.out.println(milkObject);

    System.out.println("Create Oj object...");
    /* STUDENT MUST IMPLEMENT THIS */
    MyItem ojObject = new MyOj(2, 3.49, "Oj");
    System.out.println(ojObject);

    System.out.println("Create Wheat Bread object...");
    /* STUDENT MUST IMPLEMENT THIS */
    MyItem wheatBreadObject = new MyBread(3, 1.49, "Wheat Bread");
    System.out.println(wheatBreadObject);

    /*
      Associative Container contain Key, Value pairs
      Key: int
      Value: string
     */
    System.out.println("Create Associative Container of numbers: 1 is One, 2 is Two, 3 is Three...");
    /* STUDENT MUST IMPLEMENT THIS */
    System.out.println();
    Map<Integer, String> numberDictionaryObject = new HashMap<>(4);
    numberDictionaryObject.put(1, "One");
    numberDictionaryObject.put(2, "Two");
    numberDictionaryObject.put(3, "Three");
    System.out.println(numberDictionaryObject);

    /*
      Associative Container contain Key, Value pairs
      Key: int
      Value: string
     */
    System.out.println("Create Associative Container of US States: NH is New Hampshire, NY is New York...");
    /* STUDENT MUST IMPLEMENT THIS */
    System.out.println();
    Map<String, String> statesDictionaryObject = new HashMap<>();
    statesDictionaryObject.put("NH", "New Hampshire");
    statesDictionaryObject.put("NY", "New York");
    System.out.println(statesDictionaryObject);

    System.out.println("\n\t DemoReview1.createObjects()...done!");
  }

  /**
   *
   * Method Name: useStrings
   * Parameters: none
   * Return value: none
   *
   * Write to console:
   * 1. String with result of the expression 9 + 3
   * (i.e. sum of int 9 and int 3)
   *
   * Example CONSOLE OUTPUT:
   *
   * 9+3=12
   */
  public void useStrings() {
    System.out.println("\n\t DemoReview1.useStrings()...");
    /* STUDENT MUST IMPLEMENT THIS */
    int num1 = 9;
    int num2 = 3;
    System.out.println(String.format("%d+%d=%d", num1, num2, num1 + num2));
    System.out.println("\n\t DemoReview1.useStrings()... done!");
  }

  /**
   *
   * Method Name: parseCSVString
   * Parameters: none
   * Return value: none
   *
   * Demonstrate the parsing of a string containing
   * three Comma Separated Value (CSV) tokens.
   * 1. demonstrate parsing and conversion of an integer value;
   * 2. demonstrate parsing and conversion of a string value;
   * 3. demonstrate parsing and conversion of a double value;
   *
   * NOTE: NO File I/O. Use a literal CSV string
   * parse tokens from Comma Separated Value (CSV) string
   * handle any thrown exceptions and write result to console
   * e.g.
   * "17,Dan,4.0" Where Dan, age 17 having GPA of 4.0;
   *
   */
  public void parseCSVString() {
    System.out.println("\n\t DemoReview1.parseCSVString()...");
    String csvData = "17,Dan,4.0";

    /* STUDENT MUST IMPLEMENT THIS */
    String[] split = csvData.split(REGEX);
    int age = Integer.parseInt(split[0]);
    String name = split[1];
    double gpa = Double.parseDouble(split[2]);

    System.out.println("'" + csvData + "'" + " Where: " + name + ", age " + age + " has a GPA of " + gpa);
    System.out.println("\n\t DemoReview1.parseCSVString()... done!");
  }

  /**
   *
   * Method Name: genericShow
   * Parameters: list sequential container of elements of type T
   * Return value: none
   *
   * Use generic programming to implement a method to show
   * the state of each element in a supplied list sequential container.
   */
  public <T> void genericShow(List<T> list) {
    System.out.println(list.size() + " elements in list.");
    /* STUDENT MUST IMPLEMENT THIS */
    StringBuilder stringBuilder = new StringBuilder();
    for (T t : list) {
      stringBuilder.append(t).append(", ");
    }
    
    System.out.println(stringBuilder.substring(0, stringBuilder.length() - 2));
    System.out.println(" ... done!");
  }

  /**
   *
   * Method Name: genericSort
   * Parameters: list sequential container of elements of type T
   * Comparator comparer
   * Return value: list sequential container of elements of type T
   *
   * Sort a list using the supplied Comparison and return
   */
  public <T extends Comparable<T>> List<T> genericSort(List<T> list, Comparator<T> comparator) {
    /* STUDENT MUST IMPLEMENT THIS */
    list.sort(comparator);
    return list;
  }

  /**
   *
   * Method Name: genericSort
   * Parameters: string title
   * list sequential container of elements of type T
   * Comparator comparer
   * Return value: list sequential container of elements of type T
   *
   * Sort a list using the supplied Comparison and return
   */
  public <T extends Comparable<T>> List<T> genericSort(String title, List<T> list, Comparator<T> comparator) {
    // /* STUDENT MUST IMPLEMENT THIS */
    System.out.println(title);
    return genericSort(list, comparator);
  }

  /**
   *
   * Method Name: sortIntegers
   * Parameters: none
   * Return value: none
   *
   * Write to console: 3, 1, 5, 2, 4
   * 1. sorted ascending and descending using sort() and reverse();
   * 2. sorted descending and descending using Lambda implementing Comparator;
   * 3. sorted descending and descending using Stream API;
   * 4. sorted descending and descending using GenericSort<T>();
   * 5. sorted descending and descending using Anonymous Inner Class implementing Comparator;
   * e.g.
   * 1, 2, 3, 4, 5, 5, 4, 3, 2, 1, 1, 2, 3, 4, 5, 5, 4, 3, 2, 1, 1, 2, 3, 4, 5, 5, 4, 3, 2, 1, 1, 2, 3, 4, 5, 5, 4, 3,
   * 2, 1, 1, 2, 3, 4, 5, 5, 4, 3, 2, 1, ... done!
   */
  public void sortIntegers() {
    System.out.println("\n\t DemoReview1.SortIntegers()...");

    List<Integer> integers = new ArrayList<>(Arrays.asList(3, 1, 5, 2, 4));
    System.out.println("SORTED ASCENDING AND DESCENDING:");

    // 1. sort by default order from object's Comparable CompareTo() implementation
    /* STUDENT MUST IMPLEMENT THIS */
    Collections.sort(integers);
    genericShow(integers);
    Collections.reverse(integers);
    genericShow(integers);

    // 2. sort( Comparator<T> )
    /* STUDENT MUST IMPLEMENT THIS */
    integers.sort((num1, num2) -> num1 > num2 ? 1 : (num1.equals(num2) ? 0 : -1));
    genericShow(integers);
    integers.sort((num1, num2) -> num1 < num2 ? 1 : (num1.equals(num2) ? 0 : -1));
    genericShow(integers);

    // 3. use Stream API( keySelector )
    /* STUDENT MUST IMPLEMENT THIS */
    genericShow(integers.stream().sorted().collect(Collectors.toList()));
    genericShow(integers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

    // 5. use genericSort method
    /* STUDENT MUST IMPLEMENT THIS */
    genericShow(genericSort(integers, Integer::compareTo));
    genericShow(genericSort(integers, (num1, num2) -> num1 < num2 ? 1 : (num1.equals(num2) ? 0 : -1)));

    // 5. use Anonymous implementation for Comparator Interface compare(a, b)
    /* STUDENT MUST IMPLEMENT THIS */
    integers.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer num1, Integer num2) {
        return num1 > num2 ? 1 : (num1.equals(num2) ? 0 : -1);
      }
    });
    genericShow(integers);
    integers.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer num1, Integer num2) {
        return num1 < num2 ? 1 : (num1.equals(num2) ? 0 : -1);
      }
    });
    genericShow(integers);
    System.out.println(" ... done!");

    System.out.println("\n\t DemoReview1.SortIntegers()...done!");
  }

  /**
   *
   * Method Name: sortDoubles
   * Parameters: none
   * Return value: none
   *
   * Write to console: 3.3, 1.1, 5.5, 2.2, 4.4
   * 1. sorted ascending and descending using sort() and reverse();
   * 2. sorted descending and descending using Lambda implementing Comparator;
   * 3. sorted descending and descending using Stream API;
   * 4. sorted descending and descending using GenericSort<T>();
   * 5. sorted descending and descending using Anonymous Inner Class implementing Comparator;
   * e.g.
   * 1.1, 2.2, 3.3, 4.4, 5.5, 5.5, 4.4, 3.3, 2.2, 1.1, 1.1, 2.2, 3.3, 4.4, 5.5, 5.5, 4.4, 3.3, 2.2, 1.1, 1.1, 2.2, 3.3,
   * 4.4, 5.5, 5.5, 4.4, 3.3, 2.2, 1.1, 1.1, 2.2, 3.3, 4.4, 5.5, 5.5, 4.4, 3.3, 2.2, 1.1, 1.1, 2.2, 3.3, 4.4, 5.5, 5.5,
   * 4.4, 3.3, 2.2, 1.1, ... done!
   */
  public void sortDoubles() {
    System.out.println("\n\t DemoReview1.SortDoubles()...");

    /* STUDENT MUST IMPLEMENT THIS */
    List<Double> doubles = new ArrayList<>(Arrays.asList(3.3, 1.1, 5.5, 2.2, 4.4));

    System.out.println("SORTED ASCENDING AND DESCENDING:");

    // 1. sort by default order from object's Comparable CompareTo() implementation
    /* STUDENT MUST IMPLEMENT THIS */
    Collections.sort(doubles);
    genericShow(doubles);
    Collections.reverse(doubles);
    genericShow(doubles);
    // 2. sort( Comparator<T> )
    /* STUDENT MUST IMPLEMENT THIS */
    doubles.sort(new Comparator<Double>() {
      @Override
      public int compare(Double num1, Double num2) {
        return num1 > num2 ? 1 : (num1.equals(num2) ? 0 : -1);
      }
    });
    doubles.sort(new Comparator<Double>() {
      @Override
      public int compare(Double num1, Double num2) {
        return num1 < num2 ? 1 : (num1.equals(num2) ? 0 : -1);
      }
    });

    // 3. Stream API( keySelector )
    /* STUDENT MUST IMPLEMENT THIS */
    genericShow(doubles.stream().sorted().collect(Collectors.toList()));
    genericShow(doubles.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

    // 4. Use method genericSort
    /* STUDENT MUST IMPLEMENT THIS */
    genericShow(genericSort(doubles, Double::compareTo));
    genericShow(genericSort(doubles, Comparator.reverseOrder()));

    // 5. use Anonymous implementation for Comparator Interface compare(a, b)
    /* STUDENT MUST IMPLEMENT THIS */
    doubles.sort((num1, num2) -> num1 > num2 ? 1 : (num1.equals(num2) ? 0 : -1));
    genericShow(doubles);
    doubles.sort((num1, num2) -> num1 < num2 ? 1 : (num1.equals(num2) ? 0 : -1));
    genericShow(doubles);
    System.out.println(" ... done!");

    System.out.println("\n\t DemoReview1.SortDoubles()...done!");
  }

  /**
   *
   * Method Name: sortStrings
   * Parameters: none
   * Return value: none
   *
   * Write to console: Moe, Larry, Curley
   * 1. sorted ascending and descending using sort() and reverse();
   * 2. sorted descending and descending using Lambda implementing Comparator;
   * 3. sorted descending and descending using Stream API;
   * 4. sorted descending and descending using GenericSort<T>();
   * 5. sorted descending and descending using Anonymous Inner Class implementing Comparator;
   * e.g.
   * Curley, Larry, Moe, Moe, Larry, Curley, Curley, Larry, Moe, Moe, Larry, Curley, Curley, Larry, Moe, Moe, Larry,
   * Curley, Curley, Larry, Moe, Moe, Larry, Curley, Curley, Larry, Moe, Moe, Larry, Curley, ... done!
   */
  public void sortStrings() {
    System.out.println("\n\t SortStrings()...");

    /* STUDENT MUST IMPLEMENT THIS */

    System.out.println("SORTED ASCENDING AND DESCENDING:");
    List<String> strings = new ArrayList<>(Arrays.asList("Moe", "Larry", "Curley"));
    // 1. sort by default order from object's Comparable Interface compareTo() implementation
    /* STUDENT MUST IMPLEMENT THIS */
    Collections.sort(strings);
    genericShow(strings);
    Collections.reverse(strings);
    genericShow(strings);

    // 2. sort( Comparator )
    /* STUDENT MUST IMPLEMENT THIS */
    strings.sort((s, anotherString) -> s.compareTo(anotherString));
    genericShow(strings);
    strings.sort((s, anotherString) -> anotherString.compareTo(s));
    genericShow(strings);

    // 3. use Stream API sorted( keySelector )
    /* STUDENT MUST IMPLEMENT THIS */
    genericShow(strings.stream().sorted().collect(Collectors.toList()));
    genericShow(strings.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

    // 4. use genericSort method
    /* STUDENT MUST IMPLEMENT THIS */
    genericShow(genericSort(strings, String::compareTo));
    genericShow(genericSort(strings, Comparator.reverseOrder()));

    // 5.use Anonymous inner class implementation for Comparator Interface
    /* STUDENT MUST IMPLEMENT THIS */
    strings.sort(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.compareTo(o2);
      }
    });
    genericShow(strings);

    strings.sort(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o2.compareTo(o1);
      }
    });
    System.out.println(" ... done!");

    System.out.println("\n\t DemoReview1.SortStrings()...done!");
  }

  /**
   *
   * Method Name: sortItems
   * Parameters: none
   * Return value: none
   *
   * Demonstrate Sort (ASCENDING AND DESCENDING) on MyItems objects:
   *
   * DO NOT USE Stream API in this method
   * YOU MUST USE genericShow method
   *
   * 1. sort by ID using Lambda (ASCENDING AND DESCENDING);
   * 2. sort by Price (using default natural order) (ASCENDING AND DESCENDING);
   * 3. sort by Name using Lambda (ASCENDING AND DESCENDING);
   */
  public void sortItemsNoStreamAPI() {
    System.out.println("\n\t DemoReview1.sortItemsNoStreamAPI()...");

    // Create MyItem Objects
    List<MyItem> items = buildObjects();
    /* STUDENT MUST IMPLEMENT THIS */

    System.out.println("1. SORTED BY ID ASCENDING AND DESCENDING:");

    // 1. sort by ID
    /* STUDENT MUST IMPLEMENT THIS */
    genericShow(genericSort(items,
      (item1, item2) -> item1.getId() > item2.getId() ? 1 : (item1.getId() == item2.getId() ? 0 : -1)));

    genericShow(genericSort(items,
      (item1, item2) -> item1.getId() < item2.getId() ? 1 : (item1.getId() == item2.getId() ? 0 : -1)));

    System.out.println("2. SORTED BY PRICE ASCENDING AND DESCENDING:");
    // sort by default order from object's Comparable CompareTo() implementation
    /* STUDENT MUST IMPLEMENT THIS */
    items.sort(Comparator.comparing(MyItem::getPrice));
    genericShow(items);
    items.sort(Comparator.comparing(MyItem::getPrice).reversed());
    genericShow(items);

    System.out.println("3. SORTED BY NAME ASCENDING AND DESCENDING:");
    // sort by default order from object's IComparable CompareTo() implementation
    items.sort((o1, o2) -> {
      return o1.getName().compareTo(o2.getName());
    });
    genericShow(items);
    items.sort((o1, o2) -> {
      return o2.getName().compareTo(o1.getName());
    });
    genericShow(items);
    /* STUDENT MUST IMPLEMENT THIS */

    System.out.println("\n\t DemoReview1.sortItemsNoStreamAPI()...done!");
  }

  /**
   *
   * Method Name: processIntegers
   * Parameters: none
   * Return value: none
   *
   * Demonstrate Stream API on int values, 3, 2, 1:
   * 1. sort in ascending order;
   * 2. scale each integer value by 100;
   * e.g.
   * 100, 200, 300, ... done!
   */
  public void processIntegers() {
    System.out.println("\n\t DemoReview1.ProcessIntegers()...");
    List<Integer> integers = new ArrayList<>(Arrays.asList(3, 2, 1));
    /* STUDENT MUST IMPLEMENT THIS */
    genericSort(integers, Integer::compareTo);

    genericShow(integers.stream().map(ele -> ele * 100).collect(Collectors.toList()));

    System.out.println(" ... done!");

    System.out.println("\n\t DemoReview1.ProcessIntegers()...done!");
  }

  /**
   *
   * Method Name: processDoubles
   * Parameters: none
   * Return value: none
   *
   * Demonstrate Stream API on double values, 33.3, 22.2, 11.1:
   * 1. sort in ascending order;
   * 2. discount each double value by 20%;
   * e.g.
   * Original values => 33.3, 11.1, 22.2, SORTED => 11.1, 22.2, 33.3, and then discounted 20% => 8.88, 17.76, 26.64, ...
   * done!
   */
  public void processDoubles() {
    System.out.println("\n\t DemoReview1.ProcessDoubles()...");
    List<Double> doubles = new ArrayList<>(Arrays.asList(33.3, 22.2, 11.1));

    System.out.print("Original values => ");
    genericShow(doubles);
    /* STUDENT MUST IMPLEMENT THIS */

    System.out.print(" SORTED => ");
    genericSort(doubles, Double::compareTo);
    genericShow(doubles);
    /* STUDENT MUST IMPLEMENT THIS */

    System.out.print(" and then discounted 20% => ");
    genericShow(doubles.stream().map(ele -> ele * 0.8).collect(Collectors.toList()));
    /* STUDENT MUST IMPLEMENT THIS */
    System.out.println(" ... done!");

    System.out.println("\n\t DemoReview1.ProcessDoubles()...done!");
  }

  /**
   *
   * Method Name: processItems
   * Parameters: none
   * Return value: none
   *
   * Demonstrate Stream API on MyItems objects:
   * 1. sort by ID ASCENDING AND DESCENDING using Stream API;
   * 2. sort by Price ASCENDING (use Stream API) AND DESCENDING (use Stream API);
   * 3. sort by Name ASCENDING AND DESCENDING using Stream API;
   * 4. REPEAT #3 SHOWING a 20% price increase in each item
   */
  public void processItems() {
    System.out.println("\n\t DemoReview1.ProcessItems()...");

    // create MyItem Objects
    List<MyItem> items = buildObjects();
    /* STUDENT MUST IMPLEMENT THIS */

    System.out.println("1. Items SORTED BY ID ASCENDING AND DESCENDING using Stream API:");
    genericShow(items.stream().sorted(Comparator.comparingInt(MyItem::getId)).collect(Collectors.toList()));
    genericShow(items.stream().sorted(Comparator.comparingInt(MyItem::getId).reversed()).collect(Collectors.toList()));
    /* STUDENT MUST IMPLEMENT THIS */

    System.out.println("2. Items SORTED BY PRICE ASCENDING AND DESCENDING using Stream API:");
    /* STUDENT MUST IMPLEMENT THIS */
    genericShow(items.stream().sorted(Comparator.comparingDouble(MyItem::getPrice)).collect(Collectors.toList()));
    genericShow(
      items.stream().sorted(Comparator.comparingDouble(MyItem::getPrice).reversed()).collect(Collectors.toList()));

    System.out.println("3. Items SORTED BY Name ASCENDING AND DESCENDING using Stream API:");
    genericShow(items.stream().sorted(Comparator.comparing(MyItem::getName)).collect(Collectors.toList()));
    genericShow(items.stream().sorted(Comparator.comparing(MyItem::getName).reversed()).collect(Collectors.toList()));
    /* STUDENT MUST IMPLEMENT THIS */

    System.out.println("4. Items SORTED BY Price showing 20% increase ASCENDING AND DESCENDING using Stream API:");
    genericShow(items.stream().peek(ele -> ele.setPrice(ele.getPrice() * 1.2))
      .sorted(Comparator.comparingDouble(MyItem::getPrice)).collect(Collectors.toList()));
    genericShow(items.stream().peek(ele -> ele.setPrice(ele.getPrice() * 1.2))
      .sorted(Comparator.comparingDouble(MyItem::getPrice).reversed()).collect(Collectors.toList()));
    /* STUDENT MUST IMPLEMENT THIS */

    System.out.println("\n\t DemoReview1.ProcessItems()...done!");
  }

  /**
   *
   * Method Name: usePolymorphism
   * Parameters: none
   * Return value: none
   *
   * Demonstrate Polymorphism using MyItem objects by
   * Deriving MyBread, MyMilk and MyOJ classes from MyItem
   * and Instantiating objects, using the following CSV data strings:
   * MyMilk ("1,2.49,Milk")
   * MyOJ ("2,3.49,OJ")
   * MyBread ("3,1.49,Bread")
   * THEN perform the following in order:
   * 1. sort by ID using Stream API;
   * 2. sort by Price using Stream API;
   * 3. sort by Name using Stream API;
   * 4. use Iterator loop to show the state of each MyItem object (sorted in natural order).
   * 5. use ListIterator loop to show the state of each MyItem object with 20% Price discount (sorted in natural order).
   * 6. use ListIterator loop to show the state of each MyItem object (sorted in natural order, FORWARD and REVERSE).
   */
  public void usePolymorphism() {
    System.out.println("\n\t DemoReview1.UsePolymorphism()...");

    List<MyItem> items = new ArrayList<>();
    // Instantiate objects, using CSV data string:
    /* STUDENT MUST IMPLEMENT THIS */
    items.add(new MyMilk("1,2.49,Milk"));
    items.add(new MyOj("2,3.49,OJ"));
    items.add(new MyBread("3,1.49,Bread"));

    System.out.println("1. Items SORTED BY ID ASCENDING AND DESCENDING using Stream API:");
    /* STUDENT MUST IMPLEMENT THIS */
    genericShow(items.stream().sorted(Comparator.comparingInt(MyItem::getId)).collect(Collectors.toList()));
    genericShow(items.stream().sorted(Comparator.comparingInt(MyItem::getId).reversed()).collect(Collectors.toList()));

    System.out.println("2. Items SORTED BY PRICE ASCENDING AND DESCENDING using Stream API:");
    /* STUDENT MUST IMPLEMENT THIS */
    genericShow(items.stream().sorted(Comparator.comparingDouble(MyItem::getPrice)).collect(Collectors.toList()));
    genericShow(
      items.stream().sorted(Comparator.comparingDouble(MyItem::getPrice).reversed()).collect(Collectors.toList()));

    System.out.println("3. Items SORTED BY Name ASCENDING AND DESCENDING using Stream API:");
    /* STUDENT MUST IMPLEMENT THIS */
    genericShow(items.stream().sorted(Comparator.comparing(MyItem::getName)).collect(Collectors.toList()));
    genericShow(items.stream().sorted(Comparator.comparing(MyItem::getName).reversed()).collect(Collectors.toList()));

    System.out.println("4. Items SORTED by Natural Order(use Iterator loop:");
    /* STUDENT MUST IMPLEMENT THIS */
    items.sort(Comparator.naturalOrder());
    for (Iterator<MyItem> iterator = items.iterator(); iterator.hasNext();) {
      MyItem item = iterator.next();
      System.out.print(item);
      if (iterator.hasNext()) {
        System.out.print(", ");
      }
    }

    System.out.println("5. Items SORTED by Natural Order WITH 20% PRICE DISCOUNT (use ListIterator loop:");
    /* STUDENT MUST IMPLEMENT THIS */
    items = items.stream().peek(ele -> ele.setPrice(ele.getPrice() * 0.8)).collect(Collectors.toList());
    items.sort(Comparator.naturalOrder());
    for (ListIterator<MyItem> iterator = items.listIterator(); iterator.hasNext();) {
      MyItem next = iterator.next();
      System.out.print(next);
      if (iterator.hasNext()) {
        System.out.print(", ");
      }
    }

    System.out.println("6. Items SORTED BY Natural Order and ListIterator Loop ASCENDING AND DESCENDING:");
    items.sort(Comparator.naturalOrder());
    for (ListIterator<MyItem> iterator = items.listIterator(); iterator.hasNext();) {
      MyItem forward = iterator.next();
      if (iterator.hasNext()) {
        System.out.print(forward + ", ");
        while (iterator.hasPrevious()) {
          System.out.println(iterator.previous());
          if (iterator.previousIndex() == 0) {
            break;
          }
        }
        break;
      }
    }
    /* STUDENT MUST IMPLEMENT THIS */

    System.out.println("\n\t DemoReview1.UsePolymorphism()...done!");
  }

  /**
   * Demonstrate the use of this class
   */
  public static void demo() {
    System.out.println(DemoReview1.class.getName() + ".demo() version [" + VERSION + "]...");

    DemoReview1 obj = new DemoReview1();

    obj.createObjects();
    obj.useStrings();
    obj.parseCSVString();

    obj.sortIntegers();
    obj.sortDoubles();
    obj.sortStrings();
    obj.sortItemsNoStreamAPI();

    obj.processIntegers();
    obj.processDoubles();
    obj.processItems();

    obj.usePolymorphism();

    System.out.println(DemoReview1.class.getName() + ".main()... done!");
  }

}

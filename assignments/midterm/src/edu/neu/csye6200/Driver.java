package edu.neu.csye6200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author arronshentu
 */
public class Driver {
  public static void main(String[] args) {
    demo();
    Map<String, Integer> TASKS = new HashMap<>();

    TASKS.put("1", 1);
    TASKS.put("2", 1);
    TASKS.put("3", 1);

    TASKS.forEach((key, value) -> System.out.printf("%s %s\n", key, value));
    System.out.println("-----");
    // remove
    TASKS.remove("3");
    TASKS.forEach((key, value) -> System.out.printf("%s %s\n", key, value));
    System.out.println("-----");
    // return null会不会remove
    TASKS.computeIfPresent("2", (key, value) -> null);
    TASKS.forEach((key, value) -> System.out.printf("%s %s\n", key, value));
    System.out.println("-----");
    TASKS.put("null", null);
    TASKS.forEach((key, value) -> System.out.printf("%s %s\n", key, value));
    System.out.println("-----");
    for (Map.Entry<String, Integer> entry : TASKS.entrySet()) {
      String k = entry.getKey();
      Integer v = entry.getValue();
      if (v == null) {
        TASKS.remove(k);
      }
    }
    TASKS.forEach((key, value) -> System.out.printf("%s %s\n", key, value));
  }

  public static void demo() {

  }
}

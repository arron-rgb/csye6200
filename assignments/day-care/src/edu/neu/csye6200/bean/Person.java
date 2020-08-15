package edu.neu.csye6200.bean;

import java.io.Serializable;

/**
 * @author arronshentu
 */
public class Person implements Serializable {

  private static final long serialVersionUID = -4494930317278994741L;

  private int age;
  private String name;

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Person() {}

  public Person(int age, String name) {
    this.age = age;
    this.name = name;
  }
}

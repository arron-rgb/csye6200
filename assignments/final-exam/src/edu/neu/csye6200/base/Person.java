package edu.neu.csye6200.base;

import static edu.neu.csye6200.Commons.COMMA;

/**
 * @author arronshentu
 */
public class Person extends AbstractPerson {

  private int id;
  private int age;
  private String name;
  private int weightLbs;
  private int weightLossLbs;

  @Override
  public int getId() {
    return id;
  }

  @Override
  public void setId(int id) {
    this.id = id;
  }

  @Override
  public int getAge() {
    return age;
  }

  @Override
  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int getWeightLbs() {
    return weightLbs;
  }

  @Override
  public void setWeightLbs(int weightLbs) {
    this.weightLbs = weightLbs;
  }

  @Override
  public int getWeightLossLbs() {
    return weightLossLbs;
  }

  @Override
  public void setWeightLossLbs(int weightLossLbs) {
    this.weightLossLbs = weightLossLbs;
  }

  public Person(String csvData) {

    if (csvData.trim().isEmpty() || !csvData.contains(COMMA)) {
      return;
    }
    String[] split = csvData.split(COMMA);

    // "id,age,name,weightLbs,weightLossLbs"
    this.id = Integer.parseInt(split[0]);
    this.age = Integer.parseInt(split[1]);
    this.name = split[2];
    this.weightLbs = Integer.parseInt(split[3]);
    this.weightLossLbs = Integer.parseInt(split[4]);
  }

  @Override
  public String toString() {
    return "Person{" + "id=" + id + ", age=" + age + ", name='" + name + '\'' + ", weightLbs=" + weightLbs
      + ", weightLossLbs=" + weightLossLbs + '}';
  }
}

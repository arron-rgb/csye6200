package edu.neu.csye6200.bean;

import java.io.Serializable;

/**
 * @author arronshentu
 */
public class Student extends Person implements Serializable {

  private transient static final long serialVersionUID = -9125654917888846128L;

  private int grade;

  public int getGrade() {
    return grade;
  }

  public void setGrade(int grade) {
    this.grade = grade;
  }

  public Student() {}

  public Student(int age, String name) {
    super(age, name);
  }

  public Student(int age, String name, int grade) {
    super(age, name);
    this.grade = grade;
  }

  @Override
  public String toString() {
    return "Student{ age=" + getAge() + " name=" + getName() + " grade=" + grade + '}';
  }
}

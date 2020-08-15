package edu.neu.csye6200.bean;

import java.io.Serializable;

/**
 * @author arronshentu
 */
public class Teacher extends Person implements Serializable {

  private static final long serialVersionUID = -5439402940413731278L;

  private int credits;

  public int getCredits() {
    return credits;
  }

  public void setCredits(int credits) {
    this.credits = credits;
  }

  public Teacher() {}

  public Teacher(int age, String name) {
    super(age, name);
  }

  public Teacher(int age, String name, int credits) {
    super(age, name);
    this.credits = credits;
  }
}

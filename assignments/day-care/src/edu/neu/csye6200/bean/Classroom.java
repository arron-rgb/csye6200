package edu.neu.csye6200.bean;

import java.util.Vector;

/**
 * @author arronshentu
 */
public class Classroom {

  private int capacity;
  private Vector<Teacher> teachers;
  private Vector<Student> students;

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

}

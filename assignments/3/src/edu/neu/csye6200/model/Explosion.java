package edu.neu.csye6200.model;

/**
 * @author arronshentu
 */
public class Explosion {

  public void explode() {
    System.out.println(this + " explodes");
  }

  @Override
  public String toString() {
    return String.format("Explosion{%s}", this.hashCode());
  }

}

package edu.neu.csye6200.explodable;

/**
 * @author arronshentu
 */
public class UnknownBomb implements ExplodableAPI {

  @Override
  public void explode() {
    System.out.println(String.format("My class is %s and my hashcode is %s", this.getClass(), this.hashCode()));
  }

}

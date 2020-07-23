package edu.neu.csye6200.modela;

/**
 * @author arronshentu
 */
public abstract class AbstractExplosion {

  public void explode() {
    System.out.println(String.format("My class is %s and my hashcode is %s", this.getClass(), this.hashCode()));
  }

}

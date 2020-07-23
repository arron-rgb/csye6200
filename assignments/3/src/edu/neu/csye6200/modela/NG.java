package edu.neu.csye6200.modela;

import static edu.neu.csye6200.util.Factory.EXPLODE_MESSAGE;

/**
 * @author arronshentu
 */
public class NG extends AbstractExplosion {

  private static final String FORMULA = "C3H5N3O9";

  @Override
  public void explode() {
    System.out.println(String.format(EXPLODE_MESSAGE, FORMULA, this.hashCode()));
  }

}

package edu.neu.csye6200.modela;

import static edu.neu.csye6200.util.Factory.EXPLODE_MESSAGE;

/**
 * @author arronshentu
 */
public class AN extends AbstractExplosion {

  private static final String FORMULA = "NH4NO3";

  @Override
  public void explode() {
    System.out.println(String.format(EXPLODE_MESSAGE, FORMULA, this.hashCode()));
  }

}

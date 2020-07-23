package edu.neu.csye6200.modela;

import static edu.neu.csye6200.util.Factory.EXPLODE_MESSAGE;

/**
 * @author arronshentu
 */
public class HMX extends AbstractExplosion {

  private static final String FORMULA = "C4H8N8O8";

  @Override
  public void explode() {
    System.out.println(String.format(EXPLODE_MESSAGE, FORMULA, this.hashCode()));
  }

}

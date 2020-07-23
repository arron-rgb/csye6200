package edu.neu.csye6200.model;

import static edu.neu.csye6200.util.Factory.EXPLODE_MESSAGE;

/**
 * @author arronshentu
 */
public class PETN extends Explosion {

  private static final String FORMULA = "C(CH2ONO2)4";

  @Override
  public void explode() {
    System.out.println(String.format(EXPLODE_MESSAGE, FORMULA, this.hashCode()));
  }

}

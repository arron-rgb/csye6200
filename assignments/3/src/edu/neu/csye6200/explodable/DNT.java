package edu.neu.csye6200.explodable;

import static edu.neu.csye6200.util.Factory.EXPLODE_MESSAGE;

/**
 * @author arronshentu
 */
public class DNT implements ExplodableAPI {

  private static final String FORMULA = "C6H2CH3(NO2)2";

  @Override
  public void explode() {
    System.out.println(String.format(EXPLODE_MESSAGE, FORMULA, this.hashCode()));
  }

}

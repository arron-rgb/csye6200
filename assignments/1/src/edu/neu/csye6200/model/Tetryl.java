package edu.neu.csye6200.model;

import static edu.neu.csye6200.util.GenerateUtil.EXPLODE_MESSAGE;

/**
 * @author arronshentu
 */
public class Tetryl extends Explosion {

  private static final String FORMULA = "C7H5N5O8";

  @Override
  public void explode() {
    System.out.println(String.format(EXPLODE_MESSAGE, FORMULA, this.hashCode()));
  }

}

package edu.neu.csye6200.explodable;

import edu.neu.csye6200.util.AbstractExplodableFactory;
import edu.neu.csye6200.util.Factory;

/**
 * @author arronshentu
 */
public class TNTFactory extends AbstractExplodableFactory {

  @Override
  public TNT getObject() {
    return (TNT)Factory.buildExplodableAPI(TNT.class);
  }

}

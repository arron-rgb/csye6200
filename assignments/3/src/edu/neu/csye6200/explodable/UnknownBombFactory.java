package edu.neu.csye6200.explodable;

import edu.neu.csye6200.util.AbstractExplodableFactory;
import edu.neu.csye6200.util.Factory;

/**
 * @author arronshentu
 */
public class UnknownBombFactory extends AbstractExplodableFactory {

  @Override
  public UnknownBomb getObject() {
    return (UnknownBomb)Factory.buildExplodableAPI(UnknownBomb.class);
  }

}

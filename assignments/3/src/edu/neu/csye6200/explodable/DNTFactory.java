package edu.neu.csye6200.explodable;

import edu.neu.csye6200.util.AbstractExplodableFactory;
import edu.neu.csye6200.util.Factory;

/**
 * @author arronshentu
 */
public class DNTFactory extends AbstractExplodableFactory {

  @Override
  public DNT getObject() {
    return (DNT)Factory.buildExplodableAPI(DNT.class);
  }

}

package edu.neu.csye6200.model;

import edu.neu.csye6200.util.AbstractExplosionFactory;
import edu.neu.csye6200.util.Factory;

/**
 * @author arronshentu
 */

public class RDXFactory extends AbstractExplosionFactory {

  @Override
  public RDX getObject() {
    return (RDX)Factory.buildExplosion(RDX.class);
  }

}

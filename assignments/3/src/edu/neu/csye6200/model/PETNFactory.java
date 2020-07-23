package edu.neu.csye6200.model;

import edu.neu.csye6200.util.AbstractExplosionFactory;
import edu.neu.csye6200.util.Factory;

/**
 * @author arronshentu
 */
public class PETNFactory extends AbstractExplosionFactory {

  @Override
  public PETN getObject() {
    return (PETN)Factory.buildExplosion(PETN.class);
  }

}

package edu.neu.csye6200.model;

import edu.neu.csye6200.util.AbstractExplosionFactory;
import edu.neu.csye6200.util.Factory;

/**
 * @author arronshentu
 */
public class TetrylFactory extends AbstractExplosionFactory {

  @Override
  public Tetryl getObject() {
    return (Tetryl)Factory.buildExplosion(Tetryl.class);
  }

}

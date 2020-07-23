package edu.neu.csye6200.modela;

import edu.neu.csye6200.util.AbstractExplosionFactoryA;
import edu.neu.csye6200.util.Factory;

/**
 * @author arronshentu
 */
public class NGFactory extends AbstractExplosionFactoryA {

  @Override
  public NG getObject() {
    return (NG)Factory.buildAbstractExplosion(NG.class);
  }

}

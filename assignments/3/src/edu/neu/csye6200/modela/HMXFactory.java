package edu.neu.csye6200.modela;

import edu.neu.csye6200.util.AbstractExplosionFactoryA;
import edu.neu.csye6200.util.Factory;

/**
 * @author arronshentu
 */
public class HMXFactory extends AbstractExplosionFactoryA {

  @Override
  public HMX getObject() {
    return (HMX)Factory.buildAbstractExplosion(HMX.class);
  }

}

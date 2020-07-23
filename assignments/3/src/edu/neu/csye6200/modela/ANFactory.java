package edu.neu.csye6200.modela;

import edu.neu.csye6200.util.AbstractExplosionFactoryA;
import edu.neu.csye6200.util.Factory;

/**
 * @author arronshentu
 */
public class ANFactory extends AbstractExplosionFactoryA {

  @Override
  public AN getObject() {
    return (AN)Factory.buildAbstractExplosion(AN.class);
  }

}

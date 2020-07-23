package edu.neu.csye6200.modela;

/**
 * API for an edu.neu.csye6200.model.Explosion Model which loads and explodes edu.neu.csye6200.model.Explosion objects.
 *
 * @author dpeters
 *
 */
public abstract class AbstractExplosionModelA {
  /**
   * Add one AbstractExplosionAPI object to edu.neu.csye6200.model
   *
   * @param e
   *          edu.neu.csye6200.model.Explosion object
   */
  public abstract void add(AbstractExplosionAPI e);

  /**
   * Explode all
   */
  public abstract void explode();

}

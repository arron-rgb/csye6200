package edu.neu.csye6200.modela;

/**
 * API for an model.Explosion Model which loads and explodes model.Explosion objects.
 *
 * @author dpeters
 *
 */
public abstract class AbstractExplosionModelA {
  /**
   * Add one AbstractExplosionAPI object to model
   *
   * @param e
   *          model.Explosion object
   */
  public abstract void add(AbstractExplosionAPI e);

  /**
   * Explode all
   */
  public abstract void explode();

}

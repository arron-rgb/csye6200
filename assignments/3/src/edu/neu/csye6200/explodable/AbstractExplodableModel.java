package edu.neu.csye6200.explodable;

/**
 * API for an model.Explosion Model which loads and explodes ExplodableAPI objects.
 *
 * @author dpeters
 *
 */
public abstract class AbstractExplodableModel {
  /**
   * Add one AbstractExplosionAPI object to model
   *
   * @param e
   *          model.Explosion object
   */
  public abstract void add(ExplodableAPI e);

  /**
   * Explode all
   */
  public abstract void explode();
}

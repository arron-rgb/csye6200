package edu.neu.csye6200.model;

/**
 * API for an model.Explosion Model which loads and explodes model.Explosion objects.
 *
 * @author dpeters
 *
 */
public abstract class AbstractExplosionModel {
  /**
   * Add one model.Explosion object to model
   *
   * @param e
   *          model.Explosion object
   */
  public abstract void add(Explosion e);

  /**
   * Explode all
   */
  public abstract void explode();

}

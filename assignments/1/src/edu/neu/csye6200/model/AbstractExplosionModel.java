package edu.neu.csye6200.model;

/**
 * API for an edu.neu.csye6200.model.Explosion Model which loads and explodes edu.neu.csye6200.model.Explosion objects.
 *
 * @author dpeters
 *
 */
public abstract class AbstractExplosionModel {
  /**
   * Add one edu.neu.csye6200.model.Explosion object to edu.neu.csye6200.model
   *
   * @param e
   *          edu.neu.csye6200.model.Explosion object
   */
  public abstract void add(Explosion e);

  /**
   * Explode all
   */
  public abstract void explode();

}

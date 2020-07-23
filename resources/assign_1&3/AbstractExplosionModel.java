package edu.neu.csye6200;

/**
 * API for an Explosion Model which loads and explodes Explosion objects.
 *
 * @author dpeters
 *
 */
public abstract class AbstractExplosionModel {
	/**
	 * Add one Explosion object to edu.neu.csye6200.model
	 *
	 * @param e		Explosion object
	 */
	public abstract void add(Explosion e);

	/**
	 * Explode all
	 */
	public abstract void explode();

}

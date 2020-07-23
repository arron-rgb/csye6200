package edu.neu.csye6200;

/**
 * API for an Explosion Model which loads and explodes ExplodableAPI objects.
 *
 * @author dpeters
 *
 */
public abstract class AbstractExplodableModel {
	/**
	 * Add one AbstractExplosionAPI object to edu.neu.csye6200.model
	 *
	 * @param e		Explosion object
	 */
	public abstract void add(ExplodableAPI e);

	/**
	 * Explode all
	 */
	public abstract void explode();
}

package edu.neu.csye6200.base;

/**
 * API for a member of the club
 *
 * @author dpeters
 *
 */
public abstract class AbstractPerson {

  public abstract int getId();

  public abstract void setId(int id);

  public abstract int getAge();

  public abstract void setAge(int age);

  public abstract String getName();

  public abstract void setName(String name);

  /**
   * get person's weight
   *
   * @return weight in Lbs
   */
  public abstract int getWeightLbs();

  public abstract void setWeightLbs(int weightLbs);

  /**
   * get person's weight loss
   *
   * @return weight loss in Lbs
   */
  public abstract int getWeightLossLbs();

  public abstract void setWeightLossLbs(int weightLossLbs);
}

package edu.neu.csye6200.factory;

import edu.neu.csye6200.bean.AbstractTask;
import edu.neu.csye6200.bean.BrakeJob;

/**
 * @author arronshentu 1. Derived from AbstractTaskFactory 2. Implemented as a Lazy Singleton 3. Return BrakeJob objects
 *         (as AbstractTask)
 */
public class BrakeJobTaskFactory extends AbstractTaskFactory {

  private BrakeJobTaskFactoryInstance instance = null;

  private static class BrakeJobTaskFactoryInstance {
    public AbstractTask getObject() {
      return new BrakeJob();
    }

    public AbstractTask getObject(String csvData) {
      return new BrakeJob(csvData);
    }

    public AbstractTask getObject(int id, int hours, String name, String description) {
      return new BrakeJob(id, hours, name, description);
    }
  }

  @Override
  public AbstractTask getObject() {
    if (instance == null) {
      instance = new BrakeJobTaskFactoryInstance();
    }
    return instance.getObject();
  }

  @Override
  public AbstractTask getObject(String csvData) {
    if (instance == null) {
      instance = new BrakeJobTaskFactoryInstance();
    }
    return instance.getObject(csvData);
  }

  @Override
  public AbstractTask getObject(int id, int hours, String name, String description) {
    if (instance == null) {
      instance = new BrakeJobTaskFactoryInstance();
    }
    return instance.getObject(id, hours, name, description);
  }
}

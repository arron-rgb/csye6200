package edu.neu.csye6200.bean;

/**
 * @author arronshentu
 */
public class Task extends AbstractTask {

  public Task() {}

  public Task(int id, int hours, String name, String description) {
    super();
    setTaskId(id);
    setFlatRateHours(hours);
    setTaskName(name);
    setTaskDescription(description);
  }
}

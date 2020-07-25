package edu.neu.csye6200;

/**
 * @author arronshentu
 */
public class TaskFactory extends AbstractTaskFactory {

  private static final String SPLIT_DEFAULT = ",";

  @Override
  public AbstractTask getObject() {
    return new Task();
  }

  @Override
  public AbstractTask getObject(String csvData) {
    if (csvData.trim().isEmpty()) {
      return null;
    }

    String[] split = csvData.split(SPLIT_DEFAULT);
    AbstractTask task = new Task();
    task.setTaskId(Integer.parseInt(split[0]));
    task.setFlatRateHours(Integer.parseInt(split[1]));
    task.setTaskName(split[2]);
    task.setTaskDescription(split[3]);
    return task;
  }

  @Override
  public AbstractTask getObject(int id, int hours, String name, String description) {
    return new Task(id, hours, name, description);
  }
}

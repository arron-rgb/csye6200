package edu.neu.csye6200;

/**
 * API for each Task an employee is payed to complete. Each Task pays a fixed (flat-rate) number of hours at the
 * employee wage.
 *
 * Employee compensation ($) = employee=hourly-wage * (task-Flat-Rate-HoursTask1 + task-Flat-Rate-HoursTask2 + ... +
 * task-Flat-Rate-HoursTaskn)
 *
 * @author dpeters
 *
 */
public abstract class AbstractTask {
  /**
   * Task ID
   */
  private int taskId;
  /**
   * time (flat-rate hours) to complete this task
   */
  private int flatRateHours;
  /**
   * Task Name
   */
  private String taskName;
  /**
   * Task Description
   */
  private String taskDescription;

  public int getTaskId() {
    return taskId;
  }

  public void setTaskId(int taskId) {
    this.taskId = taskId;
  }

  public int getFlatRateHours() {
    return flatRateHours;
  }

  public void setFlatRateHours(int flatRateHours) {
    this.flatRateHours = flatRateHours;
  }

  public String getTaskName() {
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  public String getTaskDescription() {
    return taskDescription;
  }

  public void setTaskDescription(String taskDescription) {
    this.taskDescription = taskDescription;
  }

  @Override
  public String toString() {
    return "Task #" + taskId + " pays: " + flatRateHours + " FLAT-RATE (hours) for: " + taskName + " '"
      + taskDescription + "'";
  }
}

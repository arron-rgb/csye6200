package edu.neu.csye6200.bean;

/**
 * API for each Timesheet to implement
 *
 * @author dpeters
 *
 */
public abstract class AbstractTimeSheet {
  /**
   * timesheet owner id
   */
  private int timesheetOwnerId;
  /**
   * total hours for this timesheet
   */
  private int timesheetHours;
  /**
   * timesheet owner
   */
  private String timesheetOwnerName;
  /**
   * timesheet description
   */
  private String timesheetDescription;

  public int getTimesheetId() {
    return timesheetOwnerId;
  }

  public void setTimesheetId(int id) {
    this.timesheetOwnerId = id;
  }

  public String getTimesheetOwnerName() {
    return timesheetOwnerName;
  }

  public void setTimesheetOwnerName(String name) {
    this.timesheetOwnerName = name;
  }

  public String getTimesheetDescription() {
    return timesheetDescription;
  }

  public void setDescription(String description) {
    this.timesheetDescription = description;
  }

  public int getTimesheetHours() {
    return timesheetHours;
  }

  public void setTimesheetHours(int hours) {
    this.timesheetHours = hours;
  }

  /**
   * Add Task and increase the hours worked on timesheet
   *
   * @param t
   *          Task object to add
   */
  public abstract void add(AbstractTask t);

  /**
   * Clear (remove) all Task objects and set hours worked on timesheet to zero
   */
  public abstract void clear();

  /**
   * Remove one Task object and decrease hours worked on timesheet
   *
   * @param taskName
   *          name of Task to remove
   */
  public abstract void remove(String taskName);

  /**
   * Remove one Task object and decrease hours worked on timesheet
   *
   * @param task
   *          object to remove
   */
  public abstract void remove(AbstractTask task);

  /**
   * Show state of TimeSheet
   *
   * (including hours worked on timesheet and all Task objects)
   */
  public abstract void show();
}

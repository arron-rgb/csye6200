package edu.neu.csye6200.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arronshentu
 */
public class TimeSheet extends AbstractTimeSheet {
  //
  // 20 POINTS: Design a TimeSheet class:
  // 1. Derived from AbstractTimeSheet
  // 2. Include the following member in TimeSheet class:
  private List<AbstractTask> tasks = null;

  public TimeSheet() {}

  private void addTimeSheetHours(int time) {
    if (tasks == null) {
      tasks = new ArrayList<>();
    }

    int timeSheetHours = getTimesheetHours();
    timeSheetHours += time;
    setTimesheetHours(timeSheetHours);
  }

  @Override
  public void add(AbstractTask t) {
    if (t == null) {
      return;
    }
    addTimeSheetHours(t.getFlatRateHours());
    tasks.add(t);
  }

  @Override
  public void clear() {
    if (tasks == null) {
      return;
    }

    setTimesheetHours(0);
    tasks.clear();
  }

  @Override
  public void remove(String taskName) {
    if (tasks == null) {
      tasks = new ArrayList<>();
    }

    if (taskName == null || taskName.trim().isEmpty()) {
      return;
    }
    for (AbstractTask task : tasks) {
      if (taskName.equals(task.getTaskName())) {
        addTimeSheetHours(-task.getFlatRateHours());
        tasks.remove(task);
      }
    }
  }

  @Override
  public void remove(AbstractTask task) {
    if (tasks == null) {
      tasks = new ArrayList<>();
    }

    if (task == null) {
      return;
    }
    addTimeSheetHours(-task.getFlatRateHours());
    tasks.remove(task);
  }

  @Override
  public void show() {
    if (tasks == null) {
      System.out.println();
      return;
    }

    tasks.forEach(System.out::println);
  }

}

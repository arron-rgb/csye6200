package edu.neu.csye6200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author arronshentu
 */
public class TimeSheet extends AbstractTimeSheet {
  private static final Map<String, AbstractTask> TASKS = new HashMap<>();

  private void addTimeSheetHours(int time) {
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
    TASKS.putIfAbsent(t.getTaskName(), t);
  }

  @Override
  public void clear() {
    setTimesheetHours(0);
    TASKS.clear();
  }

  @Override
  public void remove(String taskName) {
    if (taskName.trim().isEmpty()) {
      return;
    }
    TASKS.computeIfPresent(taskName, (key, value) -> {
      addTimeSheetHours(-value.getFlatRateHours());
      return null;
    });
    TASKS.remove(taskName);
  }

  @Override
  public void remove(AbstractTask task) {
    if (task == null) {
      return;
    }
    addTimeSheetHours(-task.getFlatRateHours());
    TASKS.remove(task.getTaskName());
  }

  @Override
  public void show() {
    for (Map.Entry<String, AbstractTask> entry : TASKS.entrySet()) {
      String k = entry.getKey();
      AbstractTask v = entry.getValue();
      if (v == null) {
        TASKS.remove(k);
      }
    }

    System.out.printf("hours worked: %s\n", getTimesheetHours());
    TASKS.forEach((key, value) -> System.out.println(value));
  }
}

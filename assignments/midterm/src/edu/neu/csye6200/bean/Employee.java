package edu.neu.csye6200.bean;

import static edu.neu.csye6200.CommonConstant.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.neu.csye6200.factory.AbstractTaskFactory;
import edu.neu.csye6200.factory.AbstractTimesheetFactory;
import edu.neu.csye6200.factory.TaskFactory;
import edu.neu.csye6200.factory.TimeSheetFactory;

/**
 * @author arronshentu
 */
public class Employee extends Person {

  private int employeeId;
  private double wage;
  private AbstractTaskFactory taskFactory = null;
  private AbstractTimesheetFactory timesheetFactory = null;
  private TimeSheet timeSheet = null;

  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  public double getWage() {
    return wage;
  }

  public void setWage(double wage) {
    this.wage = wage;
  }

  public AbstractTaskFactory getTaskFactory() {
    return taskFactory;
  }

  public void setTaskFactory(AbstractTaskFactory taskFactory) {
    this.taskFactory = taskFactory;
  }

  public AbstractTimesheetFactory getTimesheetFactory() {
    return timesheetFactory;
  }

  public void setTimesheetFactory(AbstractTimesheetFactory timesheetFactory) {
    this.timesheetFactory = timesheetFactory;
  }

  public TimeSheet getTimeSheet() {
    return timeSheet;
  }

  public void setTimeSheet(TimeSheet timeSheet) {
    this.timeSheet = timeSheet;
  }

  public Employee(String csvData) {
    if (csvData.trim().isEmpty() || !csvData.contains(SPLIT_DEFAULT)) {
      return;
    }

    String[] split = csvData.split(SPLIT_DEFAULT);

    setId(split[0]);
    setAge(Integer.parseInt(split[1]));
    setFirstName(split[2]);
    setLastName(split[3]);
    setEmployeeId(Integer.parseInt(split[4]));
    setWage(Double.parseDouble(split[5]));
  }

  @Override
  public String toString() {
    return "Employee{" + "employeeId=" + employeeId + ", wage=" + wage + ", taskFactory=" + taskFactory
      + ", timesheetFactory=" + timesheetFactory + ", timeSheet=" + timeSheet + '}';
  }

  public static void demo() {
    System.out.println("\n\t" + Employee.class.getName() + ".demo()...");
    List<String> csvDataStrings = new ArrayList<>(Arrays.asList(csvDataString.split(SEMICOLON)));

    Employee obj = new Employee("1,17,Dan,Peters,101,20.0");

    System.out.println(obj);
    // add employee Timesheet Factory (TimeSheetFactory) to Employee object...
    System.out.println("add employee Timesheet Factory (TimeSheetFactory) to Employee object...");
    obj.timesheetFactory = new TimeSheetFactory();
    // use Timesheet Factory to add employee Timesheet to Employee object...
    System.out.println("use Timesheet Factory to add employee Timesheet to Employee object...");
    obj.timeSheet = obj.timesheetFactory.getObject();

    // add employee Task Factory (BrakeJobTaskFactory) to Employee object...
    System.out.println("add employee Task Factory  (BrakeJobTaskFactory) to Employee object...");
    obj.taskFactory = new TaskFactory();

    // use employee Task factory to add all tasks to Employee Timesheet...
    System.out.println("use employee Task factory to add all tasks to Employee Timesheet...");
    for (String csvData : csvDataStrings) {
      obj.timeSheet.add(obj.taskFactory.getObject(csvData));
    }

    // show employee timesheet...
    System.out.println("\n show employee timesheet...");
    obj.timeSheet.show();

    // show employee productivity details...
    System.out.println("\n show employee productivity details...");

    System.out.println("TOTAL HOURS: " + obj.timeSheet.getTimesheetHours());
    System.out.println("TOTAL EARNINGS: $" + obj.timeSheet.getTimesheetHours() * obj.getWage());

    System.out.println("\n\t" + Employee.class.getName() + ".demo()... done!");
  }
}

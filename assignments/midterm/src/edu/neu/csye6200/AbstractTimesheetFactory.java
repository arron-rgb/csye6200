package edu.neu.csye6200;

/**
 * API each TimeSheet Factory to implement
 *
 * @author dpeters
 *
 */
public abstract class AbstractTimesheetFactory {
  /**
   * Return an default TimeSheet object
   *
   * @return TimeSheet object
   */
  public abstract TimeSheet getObject();

  /**
   * Return a TimeSheet object initialized from CSV string "id,hours,name,description"
   *
   * WHERE:
   *
   * int id; // timesheet owner id int hours; // total hours for this timesheet String name; // timesheet owner String
   * description; // timesheet description
   *
   * e.g. "101,.5,Jim,Jim's DAILY Timesheet"
   *
   * @param csvData
   *          String Comma Separated Value (CSV) data
   * @return TimeSheet object
   */
  public abstract TimeSheet getObject(String csvData);
}

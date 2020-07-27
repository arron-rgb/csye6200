package edu.neu.csye6200.factory;

import edu.neu.csye6200.bean.AutoTechTimeSheet;
import edu.neu.csye6200.bean.TimeSheet;

/**
 * @author arronshentu 1. Derived from AbstractTimesheetFactory 2. Implemented as a Lazy Singleton 3. Return
 *         AutoTechTimeSheet objects (as TimeSheet)
 */
public class TimeSheetFactory extends AbstractTimesheetFactory {
  private static final String SPLIT_DEFAULT = ",";
  private static TimeSheetFactoryInstance instance = null;

  private static class TimeSheetFactoryInstance {
    public TimeSheet getObject() {
      return new AutoTechTimeSheet();
    }

    public TimeSheet getObject(String csvData) {
      String[] split = csvData.split(SPLIT_DEFAULT);
      TimeSheet timeSheet = new AutoTechTimeSheet();
      timeSheet.setTimesheetId(Integer.parseInt(split[0]));
      timeSheet.setTimesheetHours(Integer.parseInt(split[1]));
      timeSheet.setTimesheetOwnerName(split[2]);
      timeSheet.setDescription(split[3]);
      return timeSheet;
    }
  }

  @Override
  public TimeSheet getObject() {
    if (instance == null) {
      instance = new TimeSheetFactoryInstance();
    }
    return instance.getObject();
  }

  @Override
  public TimeSheet getObject(String csvData) {
    if (instance == null) {
      instance = new TimeSheetFactoryInstance();
    }

    return instance.getObject(csvData);
  }
}

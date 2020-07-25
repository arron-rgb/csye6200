package edu.neu.csye6200;

/**
 * @author arronshentu
 */
public class TimeSheetFactory extends AbstractTimesheetFactory {
  private static final String SPLIT_DEFAULT = ",";

  @Override
  public TimeSheet getObject() {
    return new TimeSheet();
  }

  @Override
  public TimeSheet getObject(String csvData) {
    String[] split = csvData.split(SPLIT_DEFAULT);
    TimeSheet timeSheet = new TimeSheet();
    timeSheet.setTimesheetId(Integer.parseInt(split[0]));
    timeSheet.setTimesheetHours(Integer.parseInt(split[1]));
    timeSheet.setTimesheetOwnerName(split[2]);
    timeSheet.setDescription(split[3]);
    return timeSheet;
  }
}

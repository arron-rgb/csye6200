package edu.neu.csye6200.bean;

import static edu.neu.csye6200.Commons.COMMA;

/**
 * @author arronshentu
 */
public class BrakeJob extends Task {

  public BrakeJob() {}

  public BrakeJob(String csvData) {

    if (csvData.trim().isEmpty() || !csvData.contains(COMMA)) {
      return;
    }

    String[] split = csvData.split(COMMA);
    // "1,15,BrakeOverhaul,Replace Brake Pads and Rotors”
    setTaskId(Integer.parseInt(split[0]));
    setFlatRateHours(Integer.parseInt(split[1]));
    setTaskName(split[2]);
    setTaskDescription(split[3]);
  }

  public BrakeJob(int id, int hours, String name, String description) {
    super(id, hours, name, description);
  }

}

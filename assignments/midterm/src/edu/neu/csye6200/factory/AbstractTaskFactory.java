package edu.neu.csye6200.factory;

import edu.neu.csye6200.bean.AbstractTask;

public abstract class AbstractTaskFactory {
  /**
   * Return an AbstractTask object from CSV string
   *
   * @return AbstractTask object
   */
  public abstract AbstractTask getObject();

  /**
   * Return an AbstractTask object from CSV string "id,hours,name,description"
   *
   * WHERE:
   *
   * int id; // task id int hours; // total hours to complete this task String name; // task name String description; //
   * task description
   *
   * e.g. "77,2,brakes,replace disc brake pads"
   *
   * @param csvData
   *          CSV string data
   * @return AbstractTask object
   */
  public abstract AbstractTask getObject(String csvData);

  // /**
  // * Return an AbstractTask object from CSV string
  // *
  // * @param id task ID
  // * @param hours hours required to complete task
  // * @param name name of task
  // * @param description description of task
  // * @return AbstractTask object
  // */
  public abstract AbstractTask getObject(int id, int hours, String name, String description);

}

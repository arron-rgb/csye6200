package edu.neu.csye6200.bean;

/**
 * @author arronshentu
 */
public class Rule {
  String age;
  int groupSize;
  String ratio;
  int maxGroupsPerRoom;

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public int getGroupSize() {
    return groupSize;
  }

  public void setGroupSize(int groupSize) {
    this.groupSize = groupSize;
  }

  public String getRatio() {
    return ratio;
  }

  public void setRatio(String ratio) {
    this.ratio = ratio;
  }

  public int getMaxGroupsPerRoom() {
    return maxGroupsPerRoom;
  }

  public void setMaxGroupsPerRoom(int maxGroupsPerRoom) {
    this.maxGroupsPerRoom = maxGroupsPerRoom;
  }

  @Override
  public String toString() {
    return "Rule{" + "age='" + age + '\'' + ", groupSize=" + groupSize + ", ratio='" + ratio + '\''
      + ", maxGroupsPerRoom=" + maxGroupsPerRoom + '}';
  }
}

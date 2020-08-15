package edu.neu.csye6200.base;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * API for a club with members losing weight
 *
 * @author dpeters
 *
 */
public abstract class AbstractClub {
  /**
   * Add a person to club
   *
   * @param p
   *          person to add
   */
  public abstract void add(AbstractPerson p);

  /**
   * Sort and output to Console list of all members.
   *
   * @param compare
   *          Comparator for sorting members
   * @param action
   *          Consumer Action for output to Console
   */
  public abstract void sortAndShow(Comparator<AbstractPerson> compare, Consumer<AbstractPerson> action);

  /**
   * Get the pounds lost by each member
   * 
   * @return List of each members weight loss in Lbs
   */
  public abstract List<Integer> getWeightLossStats();

  /**
   * Complete the entire programming exercise:
   *
   * 30 POINTS: Part I TwoAlternatingThreads class
   * 70 POINTS: Part II WeightClub class
   *
   * within the alloted time period and submit to Canvas (just like an assignment).
   *
   * COMPLETE WHAT YOU CAN DO!!! DO NOT GET STUCK ON ONE PART OF THE PROGRAM!!!
   *
   * 50 POINTS DEDUCTION IF LATE OR IN WRONG FORMAT, SPECIFICALLY:
   *
   * 1. Submit completed program (in zip compressed eclipse workspace) to Canvas On-time;
   *
   * 2. Program MUST BE Executable;
   *
   * 3. Eclipse workspace MUST BE correctly named and zip compressed
   * e.g. named like:
   * 'workspace_2020_06_dan_peters_WeightClubfinal'
   * and zipped as:
   * 'workspace_2020_06_dan_peters_WeightClubfinal.zip'),
   *
   * 4. Console output MUST BE cut and pasted at end of main() method as comment.
   *
   *
   *
   * PART I (30 TOTAL POINTS): Design & Create TwoAlternatingThreads class
   *
   *
   * Design a class that will start TWO alternating threads (10 POINTS)
   * demonstrating control as they alternate output to the console (10 POINTS).
   * Two threads take turns alternating the output of all the letters of the
   * alphabet (10 POINTS) (All English alphabet letters, LOWERCASE and UPPERCASE,
   * in one output line, to console like: aAbAcCdD...xXyYzZ.
   *
   *
   * 30 TOTAL POINTS FOR PART I IS BROKEN DOWN AS FOLLOWS:
   * 10 POINTS: Output ENTIRE alphabet upper case and lower case to console
   * 10 POINTS: Create and Start TWO Threads
   * 10 POINTS: Control TWO Threads so they ALTERNATE output PERFECTLY to console (stdout)
   *
   *
   *
   * Part II (70 TOTAL POINTS): Design & Create a WeightClub class to demonstrate a weight club
   *
   *
   * 70 TOTAL POINTS FOR PART II IS BROKEN DOWN AS FOLLOWS:
   *
   * 10 POINTS): Derive Person class from AbstractPerson class;
   * 10 POINTS): Derive WeightLossClub from AbstractClub class;
   *
   * 10 POINTS): Create Persons from the supplied following CSV data (formatted as
   * "id,age,name,weightLbs,weightLossLbs"):
   *
   * "1,25,Jim,311,11"
   * "2,21,Sam,315,15"
   * "3,17,Dan,314,14"
   * "4,19,Bob,312,12"
   * "5,16,Ann,310,10"
   * "6,23,Eve,313,13"
   *
   * 40 POINTS): Add each person to club AND complete the demo method as directed
   * below and where points are as follows:
   * 40 TOTAL POINTS for demo IS BROKEN DOWN AS FOLLOWS:
   * 5 POINTS: Show ALL Member info (Person state) sorted by name
   * 5 POINTS: Show ALL Member info (Person state) sorted by WeightLoss
   *
   * 10 POINTS: GRAPH CURRENT Weight Loss (person weightLossLbs)
   * 10 POINTS: GRAPH PROJECTED 1 month Weight Loss (where each member is projected to lose an ADDITIONAL 10 pounds)
   * 10 POINTS: GRAPH PROJECTED 12 month Weight Loss (where each member is projected to lose 10 times more weight than
   * original current weight loss)
   *
   * static void demo() {
   *
   *
   * // Instantiate Person objects from the following CSV data
   * // formatted as follows:
   * //
   * // "id,age,name,weightLbs,weightLossLbs"
   *
   * System.out.println("Instantiate Person objects from supplied CSV data");
   * STUDENT ENTER CODE HERE
   *
   *
   * // add all Persons to weight loss club
   *
   * System.out.println("add all Persons to weight loss club");
   * STUDENT ENTER CODE HERE
   *
   *
   * // sort all members by name
   *
   * System.out.println("sort all members by name");
   * STUDENT ENTER CODE HERE
   * System.out.println();
   *
   *
   * // sort all members by CURRENT WeightLoss
   *
   * System.out.println("sort all members by CURRENT WeightLoss");
   * STUDENT ENTER CODE HERE
   * System.out.println();
   *
   *
   * // Graph CURRENT weight loss numbers
   * // (show the MAGNITUDE of each number using character "*" text Output to Console,
   * // e.g. 2.0 **
   * // 3.0 ***
   * // 4.0 ****
   * // Show on Console Sorted in INCREASING order followed immediately by Show on Console Sorted in DECREASING order
   *
   * System.out.println("Show MAGNITUDE GRAPH of CURRENT WeightLoss:");
   * STUDENT ENTER CODE HERE
   * System.out.println();
   *
   *
   * // Graph PROJECTED weight loss numbers
   * // (show the MAGNITUDE of each number using character "*" text Output to Console,
   * // e.g. 2.0 **
   * // 3.0 ***
   * // 4.0 ****
   * // AFTER Members have been on Club Diet for 1 month
   * // (where each member is PROJECTED to lose 10 ADDITIONAL pounds compared to ORIGINAL weight loss)
   * // Show on Console Sorted in INCREASING order
   * // followed immediately by Show on Console Sorted in DECREASING order
   *
   * System.out.println("Show MAGNITUDE GRAPH of PROJECTED WeightLoss AFTER 1 Month of DIET ALONE:");
   * STUDENT ENTER CODE HERE
   * System.out.println();
   *
   *
   *
   * // Graph PROJECTED weight loss numbers
   * // (show the MAGNITUDE of each number using character text Output to Console)
   * // AFTER Members have been on Club Diet and Exercise for 1 year
   * // (where each member is PROJECTED to lose 10 times more weight than ORIGINAL weight loss)
   * // Show on Console Sorted in INCREASING order
   * // followed immediately by Show on Console Sorted in DECREASING order
   *
   * System.out.println("Show MAGNITUDE GRAPH of PROJECTED WeightLoss AFTER 1 Year of DIET AND EXERCISE:"); }
   * STUDENT ENTER CODE HERE
   * System.out.println();
   *
   * } // end of method demo()
   *
   */

}

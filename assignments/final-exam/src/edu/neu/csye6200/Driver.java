package edu.neu.csye6200;

import static edu.neu.csye6200.Commons.CSV_DATAS;
import static edu.neu.csye6200.Commons.STAR;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import edu.neu.csye6200.base.AbstractClub;
import edu.neu.csye6200.base.AbstractPerson;
import edu.neu.csye6200.base.Person;
import edu.neu.csye6200.base.WeightLossClub;

/**
 * @author arronshentu
 */
public class Driver {

  private static final AbstractClub club = new WeightLossClub();

  /**
   * aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ
   * Instantiate Person objects from supplied CSV data
   * add all Persons to weight loss club
   * sort all members by name
   * Person{id=5, age=16, name='Ann', weightLbs=310, weightLossLbs=10}
   * Person{id=4, age=19, name='Bob', weightLbs=312, weightLossLbs=12}
   * Person{id=3, age=17, name='Dan', weightLbs=314, weightLossLbs=14}
   * Person{id=6, age=23, name='Eve', weightLbs=313, weightLossLbs=13}
   * Person{id=1, age=25, name='Jim', weightLbs=311, weightLossLbs=11}
   * Person{id=2, age=21, name='Sam', weightLbs=315, weightLossLbs=15}
   *
   * sort all members by CURRENT WeightLoss
   * Person{id=5, age=16, name='Ann', weightLbs=310, weightLossLbs=10}
   * Person{id=1, age=25, name='Jim', weightLbs=311, weightLossLbs=11}
   * Person{id=4, age=19, name='Bob', weightLbs=312, weightLossLbs=12}
   * Person{id=6, age=23, name='Eve', weightLbs=313, weightLossLbs=13}
   * Person{id=3, age=17, name='Dan', weightLbs=314, weightLossLbs=14}
   * Person{id=2, age=21, name='Sam', weightLbs=315, weightLossLbs=15}
   *
   * Show MAGNITUDE GRAPH of CURRENT WeightLoss:
   * 10 **********
   * 11 ***********
   * 12 ************
   * 13 *************
   * 14 **************
   * 15 ***************
   * 15 ***************
   * 14 **************
   * 13 *************
   * 12 ************
   * 11 ***********
   * 10 **********
   *
   * Show MAGNITUDE GRAPH of PROJECTED WeightLoss AFTER 1 Month of DIET ALONE:
   * 20 ********************
   * 21 *********************
   * 22 **********************
   * 23 ***********************
   * 24 ************************
   * 25 *************************
   * 25 *************************
   * 24 ************************
   * 23 ***********************
   * 22 **********************
   * 21 *********************
   * 20 ********************
   *
   * Show MAGNITUDE GRAPH of PROJECTED WeightLoss AFTER 1 Year of DIET AND EXERCISE:
   * 110 **************************************************************************************************************
   * 121
   * *************************************************************************************************************************
   * 132
   * ************************************************************************************************************************************
   * 143
   * ***********************************************************************************************************************************************
   * 154
   * **********************************************************************************************************************************************************
   * 165
   * *********************************************************************************************************************************************************************
   * 165
   * *********************************************************************************************************************************************************************
   * 154
   * **********************************************************************************************************************************************************
   * 143
   * ***********************************************************************************************************************************************
   * 132
   * ************************************************************************************************************************************
   * 121
   * *************************************************************************************************************************
   * 110 **************************************************************************************************************
   * 
   * @param args
   *          command args
   */
  public static void main(String[] args) {
    PartOne.demo();
    Driver.demo();
  }

  public static void demo() {
    System.out.println("Instantiate Person objects from supplied CSV data");
    List<Person> persons = Arrays.stream(CSV_DATAS).map((Person::new)).collect(Collectors.toList());

    System.out.println("add all Persons to weight loss club");
    persons.forEach(club::add);

    System.out.println("sort all members by name");
    club.sortAndShow((Comparator.comparing(AbstractPerson::getName)), System.out::println);
    System.out.println();

    System.out.println("sort all members by CURRENT WeightLoss");
    club.sortAndShow((Comparator.comparing(AbstractPerson::getWeightLossLbs)), System.out::println);
    System.out.println();

    System.out.println("Show MAGNITUDE GRAPH of CURRENT WeightLoss:");
    club.getWeightLossStats().stream().sorted().forEach(Driver::printWithGraph);
    club.getWeightLossStats().stream().sorted(Comparator.reverseOrder()).forEach(Driver::printWithGraph);
    System.out.println();

    System.out.println("Show MAGNITUDE GRAPH of PROJECTED WeightLoss AFTER 1 Month of DIET ALONE:");
    club.sortAndShow(Comparator.comparing(AbstractPerson::getWeightLossLbs), (person -> {
      int loss = person.getWeightLossLbs();
      loss = loss + 10;
      printWithGraph(loss);
    }));
    club.sortAndShow(Comparator.comparing(AbstractPerson::getWeightLossLbs).reversed(), (person -> {
      int loss = person.getWeightLossLbs();
      loss = loss + 10;
      printWithGraph(loss);
    }));
    System.out.println();

    System.out.println("Show MAGNITUDE GRAPH of PROJECTED WeightLoss AFTER 1 Year of DIET AND EXERCISE:");
    club.sortAndShow(Comparator.comparing(AbstractPerson::getWeightLossLbs), (person -> {
      int loss = person.getWeightLossLbs();
      loss = loss * 11;
      printWithGraph(loss);
    }));
    club.sortAndShow(Comparator.comparing(AbstractPerson::getWeightLossLbs).reversed(), (person -> {
      int loss = person.getWeightLossLbs();
      loss = loss * 11;
      printWithGraph(loss);
    }));
    System.out.println();

  }

  private static void printWithGraph(int loss) {
    StringBuilder stars = new StringBuilder();
    stars.append(loss).append(" ");
    for (int i = 0; i < loss; i++) {
      stars.append(STAR);
    }
    System.out.println(stars);
  }

}

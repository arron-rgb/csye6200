package edu.neu.csye6200.base;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author arronshentu
 */
public class WeightLossClub extends AbstractClub {

  private final static List<AbstractPerson> PERSONS = new ArrayList<>();

  @Override
  public void add(AbstractPerson p) {
    PERSONS.add(p);
  }

  @Override
  public void sortAndShow(Comparator<AbstractPerson> compare, Consumer<AbstractPerson> action) {
    PERSONS.sort(compare);
    PERSONS.forEach(action);
  }

  @Override
  public List<Integer> getWeightLossStats() {
    return PERSONS.stream().map(AbstractPerson::getWeightLossLbs).collect(Collectors.toList());
  }

}

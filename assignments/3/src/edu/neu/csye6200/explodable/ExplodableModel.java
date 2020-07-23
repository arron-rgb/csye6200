package edu.neu.csye6200.explodable;

import static edu.neu.csye6200.util.Factory.buildExplodableAPIs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arronshentu
 */
public class ExplodableModel extends AbstractExplodableModel {

  private static List<ExplodableAPI> apis = new ArrayList<>();

  public static void main(String[] args) {
    // AbstractExplodableModel:
    // My chemical formula is C6H2CH3(NO2)2 and my hashcode is 1329552164
    // My chemical formula is C6H2CH3(NO2)3 and my hashcode is 1854731462
    // My chemical formula is C6H2CH3(NO2)3 and my hashcode is 317574433
    // My class is class explodable.UnknownBomb and my hashcode is 885284298
    // My chemical formula is C6H2CH3(NO2)2 and my hashcode is 1389133897
    // My chemical formula is C6H2CH3(NO2)3 and my hashcode is 1534030866
    demo();
  }

  public static void demo() {
    System.out.println("AbstractExplodableModel:");
    AbstractExplodableModel explodableModel = new ExplodableModel();
    List<ExplodableAPI> data = buildExplodableAPIs();
    for (ExplodableAPI explodableAPI : data) {
      explodableModel.add(explodableAPI);
    }
    explodableModel.explode();
  }

  @Override
  public void add(ExplodableAPI e) {
    if (e != null) {
      apis.add(e);
    }
  }

  @Override
  public void explode() {
    apis.forEach(ExplodableAPI::explode);
  }

}

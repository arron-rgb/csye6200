package edu.neu.csye6200;

import edu.neu.csye6200.explodable.ExplodableModel;
import edu.neu.csye6200.model.ExplosionModel;
import edu.neu.csye6200.modela.ExplosionModelA;

/**
 * @author arronshentu
 */
public class Driver {
  // These numbers mean instances' hashcode, so it changes in each time
  //
  // AbstractExplodableModel:
  // My chemical formula is C6H2CH3(NO2)2 and my hashcode is 1329552164
  // ------
  // ExplosionModel:
  // My chemical formula is C(CH2ONO2)4 and my hashcode is 1389133897
  // My chemical formula is C7H5N5O8 and my hashcode is 1534030866
  // My chemical formula is C(CH2ONO2)4 and my hashcode is 664223387
  // My chemical formula is C(CH2ONO2)4 and my hashcode is 824909230
  // My chemical formula is C7H5N5O8 and my hashcode is 122883338
  // My chemical formula is C(CH2ONO2)4 and my hashcode is 666641942
  // My chemical formula is C7H5N5O8 and my hashcode is 960604060
  // My chemical formula is C3H6N6O6 and my hashcode is 1349393271
  // My chemical formula is C(CH2ONO2)4 and my hashcode is 1338668845
  // My chemical formula is C3H6N6O6 and my hashcode is 159413332
  // ------
  // ExplosionModelA:
  // My chemical formula is NH4NO3 and my hashcode is 20132171
  // My chemical formula is C3H5N3O9 and my hashcode is 186370029
  // My chemical formula is NH4NO3 and my hashcode is 2094548358
  // My chemical formula is NH4NO3 and my hashcode is 51228289
  // My chemical formula is C4H8N8O8 and my hashcode is 455896770
  // My chemical formula is C4H8N8O8 and my hashcode is 1323165413

  public static void main(String[] args) {
    ExplodableModel.demo();
    System.out.println("------");
    ExplosionModel.demo();
    System.out.println("------");
    ExplosionModelA.demo();
  }
}

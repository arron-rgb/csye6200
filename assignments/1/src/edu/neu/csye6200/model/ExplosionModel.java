package edu.neu.csye6200.model;

import java.util.ArrayList;
import java.util.List;

import edu.neu.csye6200.util.GenerateUtil;

/**
 * @author arronshentu
 */
public class ExplosionModel extends AbstractExplosionModel {

  private static ArrayList<Explosion> explosions = new ArrayList<>();

  public static void main(String[] args) {
    // ExplosionModel:
    // My chemical formula is C7H5N5O8 and my hashcode is 1329552164
    // My chemical formula is C7H5N5O8 and my hashcode is 1854731462
    // My chemical formula is C(CH2ONO2)4 and my hashcode is 317574433
    // My chemical formula is C(CH2ONO2)4 and my hashcode is 885284298
    // My chemical formula is C(CH2ONO2)4 and my hashcode is 1389133897
    // My chemical formula is C3H6N6O6 and my hashcode is 1534030866
    // My chemical formula is C3H6N6O6 and my hashcode is 664223387
    // My chemical formula is C7H5N5O8 and my hashcode is 824909230
    // My chemical formula is C3H6N6O6 and my hashcode is 122883338
    demo();
  }

  public static void demo() {
    System.out.println("ExplosionModel:");
    ExplosionModel model = new ExplosionModel();
    List<Explosion> explosions = GenerateUtil.generateExplosions();
    for (Explosion explosion : explosions) {
      model.add(explosion);
    }
    model.explode();
  }

  @Override
  public void add(Explosion e) {
    if (e != null) {
      explosions.add(e);
    }
  }

  @Override
  public void explode() {
    explosions.forEach(Explosion::explode);
  }

}

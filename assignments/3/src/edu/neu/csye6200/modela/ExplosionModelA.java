package edu.neu.csye6200.modela;

import java.util.ArrayList;
import java.util.List;

import edu.neu.csye6200.util.Factory;

/**
 * @author arronshentu
 */
public class ExplosionModelA extends AbstractExplosionModelA {

  private final List<AbstractExplosionAPI> explosions = new ArrayList<>();

  public static void main(String[] args) {
    // ExplosionModelA:
    // My chemical formula is C3H5N3O9 and my hashcode is 1329552164
    // My chemical formula is C4H8N8O8 and my hashcode is 1854731462
    // My chemical formula is C3H5N3O9 and my hashcode is 317574433
    // My chemical formula is NH4NO3 and my hashcode is 885284298
    // My chemical formula is NH4NO3 and my hashcode is 1389133897
    // My chemical formula is NH4NO3 and my hashcode is 1534030866
    // My chemical formula is C4H8N8O8 and my hashcode is 664223387
    // My chemical formula is C4H8N8O8 and my hashcode is 824909230
    // My chemical formula is NH4NO3 and my hashcode is 122883338
    demo();
  }

  public static void demo() {
    System.out.println("ExplosionModelA:");
    AbstractExplosionModelA model = new ExplosionModelA();
    List<AbstractExplosionAPI> abstractExplosionAPIs = Factory.buildAbstractExplosionAPIs();
    for (AbstractExplosionAPI abstractExplosionAPI : abstractExplosionAPIs) {
      model.add(abstractExplosionAPI);
    }
    model.explode();
  }

  @Override
  public void add(AbstractExplosionAPI e) {
    explosions.add(e);
  }

  @Override
  public void explode() {
    explosions.forEach(AbstractExplosionAPI::explode);
  }

}

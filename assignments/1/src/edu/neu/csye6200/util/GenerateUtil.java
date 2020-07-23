package edu.neu.csye6200.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import edu.neu.csye6200.explodable.DNT;
import edu.neu.csye6200.explodable.ExplodableAPI;
import edu.neu.csye6200.explodable.TNT;
import edu.neu.csye6200.explodable.UnknownBomb;
import edu.neu.csye6200.model.Explosion;
import edu.neu.csye6200.model.PETN;
import edu.neu.csye6200.model.RDX;
import edu.neu.csye6200.model.Tetryl;
import edu.neu.csye6200.modela.*;

/**
 * @author arronshentu
 */
@SuppressWarnings("rawtypes")
public class GenerateUtil {
  public static final String EXPLODE_MESSAGE = "My chemical formula is %s and my hashcode is %s";
  private static final List<Class> EXPLODABLE_CLZ =
    new ArrayList<>(Arrays.asList(DNT.class, TNT.class, UnknownBomb.class));
  private static final List<Class> ABSTRACT_EXPLOSION_CLZ =
    new ArrayList<>(Arrays.asList(HMX.class, NG.class, AN.class));
  private static final List<Class> EXPLOSION_CLZ = new ArrayList<>(Arrays.asList(PETN.class, RDX.class, Tetryl.class));

  private static final Random RANDOM = new Random();

  private static ExplodableAPI generateExplodableAPI() {
    ExplodableAPI api = (ExplodableAPI)getRandomItem(EXPLODABLE_CLZ);
    if (api == null) {
      api = new UnknownBomb();
    }
    return api;
  }

  private static Object getRandomItem(List<Class> list) {
    int index = RANDOM.nextInt(list.size()) % list.size();
    try {
      return list.get(index).newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return null;
  }

  private static AbstractExplosionAPI generateExplosionAPI() {
    AbstractExplosionAPI api = new ExplosionAPI();
    AbstractExplosion model = (AbstractExplosion)getRandomItem(ABSTRACT_EXPLOSION_CLZ);
    if (model == null) {
      model = new HMX();
    }
    api.setModel(model);
    return api;
  }

  private static Explosion generateExplosion() {
    Explosion explosion = (Explosion)getRandomItem(EXPLOSION_CLZ);
    if (explosion == null) {
      explosion = new RDX();
    }
    return explosion;
  }

  public static List<ExplodableAPI> generateExplodableAPIs() {
    int bound = getBound();
    List<ExplodableAPI> apis = new ArrayList<>();
    for (int i = 0; i < bound; i++) {
      apis.add(generateExplodableAPI());
    }
    return apis;
  }

  private static int getBound() {
    return RANDOM.nextInt(10) + 1;
  }

  public static List<Explosion> generateExplosions() {
    int bound = getBound();
    List<Explosion> apis = new ArrayList<>();
    for (int i = 0; i < bound; i++) {
      apis.add(generateExplosion());
    }
    return apis;
  }

  public static List<AbstractExplosionAPI> generateAbstractExplosionAPIs() {
    int bound = getBound();
    List<AbstractExplosionAPI> apis = new ArrayList<>();
    for (int i = 0; i < bound; i++) {
      apis.add(generateExplosionAPI());
    }
    return apis;
  }

}

package edu.neu.csye6200.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import edu.neu.csye6200.explodable.DNTFactory;
import edu.neu.csye6200.explodable.ExplodableAPI;
import edu.neu.csye6200.explodable.TNTFactory;
import edu.neu.csye6200.explodable.UnknownBombFactory;
import edu.neu.csye6200.model.Explosion;
import edu.neu.csye6200.model.PETNFactory;
import edu.neu.csye6200.model.RDXFactory;
import edu.neu.csye6200.model.TetrylFactory;
import edu.neu.csye6200.modela.*;

/**
 * @author arronshentu
 */
public class Factory {
  public static final String EXPLODE_MESSAGE = "My chemical formula is %s and my hashcode is %s";
  private static final List<Class<? extends AbstractExplodableFactory>> EXPLODABLE_FACTORIES_CLZ =
    new ArrayList<>(Arrays.asList(DNTFactory.class, TNTFactory.class, UnknownBombFactory.class));

  private static final List<Class<? extends AbstractExplosionFactory>> EXPLOSION_FACTORIES_CLZ =
    new ArrayList<>(Arrays.asList(PETNFactory.class, RDXFactory.class, TetrylFactory.class));

  private static final List<Class<? extends AbstractExplosionFactoryA>> ABSTRACT_EXPLOSION_FACTORIES_CLZ =
    new ArrayList<>(Arrays.asList(HMXFactory.class, NGFactory.class, ANFactory.class));

  private static final Random RANDOM = new Random();

  public static ExplodableAPI buildExplodableAPI(Class<? extends ExplodableAPI> clz) {
    try {
      return clz.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static Explosion buildExplosion(Class<? extends Explosion> clz) {
    try {
      return clz.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static AbstractExplosion buildAbstractExplosion(Class<? extends AbstractExplosion> clz) {
    try {
      return clz.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return null;
  }

  @SuppressWarnings("rawtypes")
  private static Object getRandomFactory(List array) {
    Class clz = (Class)array.get(RANDOM.nextInt(array.size()) % array.size());
    try {
      return clz.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static ExplodableAPI buildExplodableAPI() {
    AbstractExplodableFactory factory;
    factory = (AbstractExplodableFactory)getRandomFactory(EXPLODABLE_FACTORIES_CLZ);
    if (factory == null) {
      factory = new DNTFactory();
    }
    return factory.getObject();
  }

  public static AbstractExplosionAPI buildAbstractExplosionAPI() {
    ExplosionAPI api = new ExplosionAPI();
    api.setModel(buildAbstractExplosion());
    return api;
  }

  public static AbstractExplosion buildAbstractExplosion() {
    AbstractExplosionFactoryA factory;
    factory = (AbstractExplosionFactoryA)getRandomFactory(ABSTRACT_EXPLOSION_FACTORIES_CLZ);
    if (factory == null) {
      factory = new ANFactory();
    }
    return factory.getObject();
  }

  public static Explosion buildExplosion() {
    AbstractExplosionFactory factory;
    factory = (AbstractExplosionFactory)getRandomFactory(EXPLOSION_FACTORIES_CLZ);
    if (factory == null) {
      factory = new PETNFactory();
    }
    return factory.getObject();
  }

  public static List<ExplodableAPI> buildExplodableAPIs() {
    int bound = getBound();
    List<ExplodableAPI> apis = new ArrayList<>();
    for (int i = 0; i < bound; i++) {
      apis.add(buildExplodableAPI());
    }
    return apis;
  }

  private static int getBound() {
    return RANDOM.nextInt(10) + 1;
  }

  public static List<Explosion> buildExplosions() {
    int bound = getBound();
    List<Explosion> apis = new ArrayList<>();
    for (int i = 0; i < bound; i++) {
      apis.add(buildExplosion());
    }
    return apis;
  }

  public static List<AbstractExplosionAPI> buildAbstractExplosionAPIs() {
    int bound = getBound();
    List<AbstractExplosionAPI> apis = new ArrayList<>();
    for (int i = 0; i < bound; i++) {
      apis.add(buildAbstractExplosionAPI());
    }
    return apis;
  }

}

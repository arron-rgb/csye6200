package edu.neu.csye6200.modela;

/**
 * @author arronshentu
 */
public abstract class AbstractExplosionAPI {

  private AbstractExplosion model;

  public AbstractExplosionAPI() {}

  public AbstractExplosionAPI(AbstractExplosion model) {
    this.model = model;
  }

  public AbstractExplosion getModel() {
    return model;
  }

  public void setModel(AbstractExplosion model) {
    this.model = model;
  }

  public void explode() {
    if (this.model != null) {
      model.explode();
    }
  }

}

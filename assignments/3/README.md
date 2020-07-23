Explosion Factories: Use GoF Factory Pattern

Re-factor your Explosion assignment so each model uses the Factory Pattern to abstract the class constructor for each explosion.

100 Total points.
1. 5 points: Create your own Explosion Concrete Parent Class:
 a. include one explode() method.
2. 10 points: Create your own ExplosionModel derived from AbstractExplosionModel
           a. Include a static demo() method (to be called from Driver) to demonstrate its usage
 with objects derived from Explosion.
3. 10 points: Create your own ExplosionModelA derived from AbstractExplosionModelA
           a. Include a static demo() method (to be called from Driver) to demonstrate its usage
 with objects derived from AbstractExplosion.
4. 10 points: Create your own ExplodableModel derived from AbstractExplodableModel
           a. Include a static demo() method (to be called from Driver) to demonstrate its usage
 with objects implementing from ExplodableAPI.
5. 45 points total (5 points each class): Derive 3 Child classes from your Parent class to use with your object model (ExplosionModel). For each derived class:
 a. override the Explode() method in the Explosion base class
           b.  obtain an object USING GoF Factory pattern so you have an object to explode
Repeat and Derive 3 or more classes from an AbstractExplosion abstract class and use with ExplosionModelA.
Repeat and Derive 3 or more classes from an ExplodableAPI interface and use with ExplodableModel.
.
6. 10 points: In the model demo method, use objects from your derived classes to demonstrate Dynamic Run-Time Polymorphism.

7. 10 points: Name and zip compress your Eclipse workspace according to our standard (workspace_202006_dan_peters_explosion.zip) Your Eclipse workspace should contain your working program, compiled without errors with all console output pasted into main() method as a comment.

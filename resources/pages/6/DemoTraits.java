package edu.neu.csye6200;

import java.io.Serializable;

/**
 * Demonstrate ascribing traits by Interface implementation.
 * 
 * @author dpeters
 *
 */
public class DemoTraits {
	private interface MyMeasurable {
		double getMetric();
		String getMetricDescription();
	}
	private interface MyGunShotMeasurable extends MyMeasurable {
		double getMetric();
		String getMetricDescription();
		int getCaliber();
	}
	private class MyExplosion {
		public void explode() {
			System.out.println("Explosion (** EXPLODE **)");
		}
	}
	private class MyGunShot extends MyExplosion implements MyGunShotMeasurable, Comparable<Double>, Serializable {
		/**
		 * Original version
		 */
		private static final long serialVersionUID = 424087895874691839L;
		private static final int GUNSHOT_CALIBER = 22;
		private static final double GUNSHOT_METRIC = 0.22;
		private static final String GUNSHOT_METRIC_DESCRIPTION = "Not much BANG for the buck.";
		
		@Override
		public int getCaliber() {
			return GUNSHOT_CALIBER;
		}
		@Override
		public double getMetric() {
			return GUNSHOT_METRIC;
		}

		@Override
		public String getMetricDescription() {
			return GUNSHOT_METRIC_DESCRIPTION;
		}
		/**
		 * Implement Comparable interface
		 * 
		 * @param o		object to compare my GunShot object to
		 * @return
		 */
		@Override
		public int compareTo(Double o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	/**
	 * Show traits of a String class
	 */
	public void stringTraits() {
		System.out.println("\n\t" + DemoTraits.class.getName() + ".stringTraits()...");
		/**
		 * String class implements Comparable Interface: String object is Comparable
		 */
		if (new String() instanceof Comparable) {
			System.out.println("String is Comparable!");
		}
		
		/**
		 * String class implements Comparable Interface: String name is Comparable
		 */
		String name = "Dan";
		if (name instanceof Comparable) {
			System.out.println(name + " is Comparable!");
		}


		System.out.println("\n\t" + DemoTraits.class.getName() + ".stringTraits()... done!");
	}

	/**
	 * Show traits of a GunShot class
	 */
	public void gunShotTraits() {
		System.out.println("\n\t" + DemoTraits.class.getName() + ".gunShotTraits()...");
		
		MyGunShot gunShot = new MyGunShot();
		
		System.out.println("1: \t OBVIOUSLY, MyGunShot Is-A MyGunShot!!!");
		/**
		 * MyGunShot class inherits from  Object: MyGunShot object Is-A Object
		 */
		if (gunShot instanceof Object) {
			System.out.println("2: \t MyGunShot IS-A Object!");
		}
		
		/**
		 * MyGunShot class inherits from  MyExplosion: MyGunShot object Is-A MyExplosion
		 */
		if (gunShot instanceof MyExplosion) {
			System.out.println("3: \t MyGunShot IS-A MyExplosion!");
		}
		
		/**
		 * MyGunShot class implements MyGunShotMeasurable Interface: MyGunShot object is MyGunShotMeasurable
		 */
		if (gunShot instanceof MyGunShotMeasurable) {
			System.out.println("4: \t MyGunShot is MyGunShotMeasurable!");
		}
		
		/**
		 * MyGunShot class implements MyMeasurable Interface: MyGunShot object is MyMeasurable
		 */
		if (gunShot instanceof MyMeasurable) {
			System.out.println("5: \t MyGunShot is MyMeasurable!");
		}
		
		/**
		 * MyGunShot class implements Comparable Interface: MyGunShot object is Comparable
		 */
		if (gunShot instanceof Comparable) {
			System.out.println("6: \t MyGunShot is Comparable!");
		} else {
			System.out.println("MyGunShot is NOT Comparable!");
		}
		
		/**
		 * MyGunShot class implements Serializable Interface: MyGunShot object is Serializable
		 * NOTE: Serializable is a Marker Interface and DOES NOT require the implementation of ANY methods.
		 * Classes implement Serializable ONLY to ascribe (mark) the Serializeable subtype to their class.
		 */
		if (gunShot instanceof Serializable) {
			System.out.println("7: \t MyGunShot is Serializable!");
		} else {
			System.out.println("MyGunShot is NOT Serializable!");
		}
		
		
		System.out.println("\n\t" + DemoTraits.class.getName() + ".gunShotTraits()... done!");
	}
	
	/**
	 * Demonstrate the use of this class
	 */
	public static void demo() {
		System.out.println("\n\t" + DemoTraits.class.getName() + ".demo()...");
		DemoTraits obj = new DemoTraits();
		
		obj.stringTraits();
		obj.gunShotTraits();
		
		System.out.println("\n\t" + DemoTraits.class.getName() + ".demo()...done!");
	}
}

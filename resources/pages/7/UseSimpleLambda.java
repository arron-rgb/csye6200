package edu.neu.dgp;

import java.util.Arrays;
import java.util.List;

public class UseSimpleLambda {
	/**
	 * Inner class which implements the Runnable Interface
	 * @author dpeters
	 *
	 */
	public class MyRunnable implements Runnable {

		@Override
		public void run() {
			System.out.println("Run MyRunnable inner class, run!");
		}
	}
	
	/**
	 * Demonstrate using an Anonymous inner class
	 * to implement the Runnable Interface
	 */
	void runnableInnerClass() {
		/**
		 * Use object from class implementing Runnable Interface
		 */
		Thread t = new Thread(new MyRunnable());
		t.start();
//	    Runnable rAnonymous = new Runnable() {
//		@Override
//		public void run() {
//			System.out.println("Run rAnonymous, run!");
//		}
//	      };
//		Thread t = new Thread(rAnonymous);
//		t.start();
	}

	/**
	 * Demonstrate using an Anonymous inner class
	 * to implement the Runnable Interface
	 */
	void runnableAnonymous() {
		/**
		 * Anonymous inner class implementing Runnable Interface
		 */
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
			System.out.println("Run rAnonymous, run!");
			}
		};
		Thread t = new Thread(r);
		t.start();
//	    Runnable rAnonymous = new Runnable() {
//		@Override
//		public void run() {
//			System.out.println("Run rAnonymous, run!");
//		}
//	      };
//		Thread t = new Thread(rAnonymous);
//		t.start();
	}

	void runnableAnonymous2() {
		/**
		 * Anonymous inner class implementing Runnable Interface
		 */
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Run anonymous2, run!");
			}
		});
		t.start();
	}

	void runnableLambda() {
		/**
		 * Lambda implementation of the Runnable Interface
		 */
		Runnable r = () -> System.out.println("run runnableLambda thread in background...");
		Thread t = new Thread(r); // use Runnable r
		t.start();
	}
	
	void runnableLambda2() {
		/**
		 * Inline anonymous Lambda implementation of the Runnable Interface
		 */
		Thread t = new Thread(() -> System.out.println("run runnableLambda2 thread in background..."));
		t.start();
	}
	/**
	 * Generic Functional Interface
	 * accepts all Reference Types
	 * (like generically written List<T> interface)
	 * 
	 * @author dpeters
	 *
	 * @param <T>
	 */
	@FunctionalInterface
	public interface MyShowFunctionalInterface<T> {
		/**
		 * abstract method which must be implemented
		 * by class, anonymous inner class or Lambda expression
		 * 
		 * @param t
		 */
		void show(T t);	
	}
	/**
	 * 
	 */
	public void useGenericFunctionalInterface() {
		System.out.println("\n\t" + UseSimpleLambda.class.getName() + ".useGenericFunctionalInterface()...");
		/**
		 * Use Generic Interface for Double
		 * AND provide a Lambda expression for the implementation
		 */
		MyShowFunctionalInterface<Double> dShow = (d) -> System.out.println("Show Double value d = " + d);
		dShow.show(3.14);				// use lambda (autobox double wrapping in Double
		dShow.show( new Double(3.14) );	// use lambda
		
		/**
		 * Use Generic Interface for Integer
		 * AND provide a Lambda expression for the implementation
		 */
		MyShowFunctionalInterface<Integer> iShow = (n) -> System.out.println("Show Integer value n = " + n);
		iShow.show(314);				// use lambda (autobox double wrapping in Double
		iShow.show( new Integer(314) );	// use lambda
		
		/**
		 * Use Generic Interface for String
		 * AND provide a Lambda expression for the implementation
		 */
		MyShowFunctionalInterface<String> sShow = (n) -> System.out.println("Show String value n = " + n);
		sShow.show("314");				// use lambda
		/**
		 * Use an anonymous inner class as implementation for Generic Functional interface
		 */
		new MyShowFunctionalInterface<Double>() {

			@Override
			public void show(Double d) {
				System.out.println("Show Double value d = " + d);
			}
		}.show(3.14);
		
		System.out.println("\n\t" + UseSimpleLambda.class.getName() + ".useGenericFunctionalInterface()... done!");
	}

	/**
	 * Use Java 8 Stream API to sort and process int values
	 */
	public void useSimpleStream() {
		/**
		 * List of int values (autoboxed into Integer objects)
		 */
		List<Integer> list = Arrays.asList(5,2,4,1,3);
		/**
		 * Use Declarative programming (no loop here)
		 */
		list.forEach(n -> System.out.print(n + " "));
		/**
		 * Sort ONLY the odd integers from the integers in the list
		 */
		System.out.println("\n reduce to sorted odd subset");
		list.stream()	// convert List into a Stream for Stream API processing
		.filter(n -> n % 2 == 1)	// FILTER: odd ONLY
		.sorted()					// SOT: ascending
		.map(n -> 100*n) 			// MAP: scale by 10 & create NEW Stream
		.forEach(n -> System.out.print(n + ", "));	// FOREACH: output, no loop here
		System.out.println();
	}
	/**
	 * Demonstrate the use of this class
	 */
	public static void demo() {
		System.out.println("\n\t" + UseSimpleLambda.class.getName() + ".demo()...");

		UseSimpleLambda obj = new UseSimpleLambda();
		
		obj.runnableAnonymous();
		obj.runnableAnonymous2();
		obj.runnableInnerClass();
		
		obj.useGenericFunctionalInterface();
		
		obj.useSimpleStream();
		
		System.out.println("\n\t" + UseSimpleLambda.class.getName() + ".demo()... done!");
	}

}

package edu.neu.dgp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Demonstrate the use of Lambda expressions in a Generic class
 * which can be used with ANY REFERENCE TYPE
 * @author dpeters
 *
 * @param <T>
 */
public class UseSimpleLambda2<T> {
	
	/**
	 * showList generic method in a Generic Class
	 * Used for numbered output of collections of 
	 * various type elements.
	 * 
	 * Works with ANY REFERENCE TYPE
	 * 
	 * WRITTEN GENERICALLY
	 * With a Placeholder,
	 * 	T
	 * INSTEAD of a SPECIFIC TYPE.
	 * When this Generic method is used, 
	 * it will be used WITH a SPECIFIC PARAMETERIZED TYPE
	 * 
	 * 	<String>
	 * 
	 * (just like List<String> and ArrayList<String>();
	 * 
	 * @param title		Output title string
	 * @param l			Collection for output
	 */
	public <T> void showList(String title, List<T> myList) {
		System.out.println(myList.size() + title);
		int i = 1;		// 1 based numbering of elements
		for (T n : myList) {
			System.out.print(i + ". " + n + " ");
			i++;
		}
		System.out.println();
	}
	
	public void useShowList() {
		System.out.println("\n\t" + UseSimpleLambda2.class.getName() + ".useShowList()...");
		
		/**
		 * Use our Generic code for String type
		 */
		List<String> names = new ArrayList<String>(Arrays.asList("dan","ann","sam"));
		UseSimpleLambda2<String> objForString = new UseSimpleLambda2<String>();
		objForString.showList(" elements in a List of Names", names);
		System.out.println();

		/**
		 * Use our Generic code for Integer type
		 */
		List<Integer> numbers = new ArrayList<>(Arrays.asList(3,1,2));
		UseSimpleLambda2<Integer> objForInteger = new UseSimpleLambda2<>();
		objForString.showList(" elements in a List of Numbers", numbers);
		System.out.println();

		System.out.println("\n\t" + UseSimpleLambda2.class.getName() + ".useShowList()... done!");
	}

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
		System.out.println("\n\t" + UseSimpleLambda2.class.getName() + ".useGenericFunctionalInterface()...");
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
		
		System.out.println("\n\t" + UseSimpleLambda2.class.getName() + ".useGenericFunctionalInterface()... done!");
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
		.filter(n -> n % 2 == 1)	// FILTER: Source (5,2,4,1,3) OUTPUT: odd ONLY
		.sorted()					// SORT: Source (5,1,3) OUTPUT: in ascending order
		.map(n -> 1000*n) 			// MAP: Source(1,3,5) OUTPUT: scaled by 1000 & create NEW Stream
		.forEach(n -> System.out.print(n + ", "));	// FOREACH: OUTPUT (1000,3000,5000) to stdout, no loop here
		System.out.println();
	}
	/**
	 * Use Stream API to Filter a Stream of elements.
	 * 
	 */
	public void filterStream() {
		System.out.println("\n\t" + UseSimpleLambda2.class.getName() + ".filterStream()...");
		/**
		 * Use a List of Integers for our Source
		 */
		List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(3,1,2,5,4));
		
		/**
		 * Use a Simple Stream Pipeline to process the List of Integers
		 */
		numbers.stream()				// convert Source List into Stream
		/**
		 *  Filter Original Source Elements, create New Stream
		 */
		.filter(n -> n %2 == 1 )					// filter all Odd integers		
//		.filter(n -> n > 2 )						// filter all integers greater than 2		
//		.filter(n -> n > 4 )						// filter all integers greater than 4		
		.forEach(e -> System.out.print(e + ", "));	// Terminate Stream (all elements to stdout
//		.forEach(System.out::println);		// Terminate Stream (all elements to stdout
		System.out.println();
		
		System.out.println("\n\t" + UseSimpleLambda2.class.getName() + ".filterStream()...done");
	}
	
	/**
	 * Use Stream API to Map (transform) a Stream of elements.
	 * 
	 */
	public void mapStream() {
		System.out.println("\n\t" + UseSimpleLambda2.class.getName() + ".mapStream()...");
		/**
		 * Use a List of Integers for our Source
		 */
		List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(3,1,2,5,4));
		
		/**
		 * Use a Simple Stream Pipeline to process the List of Integers
		 */
		numbers.stream()				// convert Source List into Stream
		/**
		 *  Map (transform) Original Source Elements, create New Stream
		 */
		.map(n -> n * 10)							// map (transform) elements, new elements is old * 10
//		.map(n -> n + 100)							// map (transform) elements, new elements is old + 100
		.forEach(e -> System.out.print(e + ", "));	// Terminate Stream (all elements to stdout
//		.forEach(System.out::println);		// Terminate Stream (all elements to stdout
		System.out.println();
		
		System.out.println("\n\t" + UseSimpleLambda2.class.getName() + ".mapStream()...done");
	}


	/**
	 * Use Array as a Source
	 */
	public void arrayStream() {
		System.out.println(DemoStreams.class.getSimpleName() + ".arrayStream()");
		int numbers[] = {1,2,3,4,5,6,7};
		IntStream numberStream = Arrays.stream(numbers);
		// forEach closes stream:is terminal operation
//		numberStream.forEach(System.out::println);
		System.out.println();
		// forEach closes stream:is terminal operation
		numberStream.forEach(n -> System.out.print(n+","));
		System.out.println();
	}
	/**
	 * Process File System as a Stream using Stream API
	 */
	public void fileStream() {
		System.out.println(DemoStreams.class.getSimpleName() + ".fileStream()");
		try {
			Files.list( new File( "." ).toPath() ).forEach( System.out::println );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Use Stream API to Count elements
	 */
	public void demoCount() {
		System.out.println(DemoStreams.class.getSimpleName() + ".demoCount()");
		{
			String[] names = { "Jen", "Zac", "Dan" };
			List<String> list = new ArrayList<>(Arrays.asList(names));
			long count = 0;
			String startingWith = "J";

			for (String name : list) {
				System.out.print(name +", ");
				if (name.startsWith(startingWith))
					++count;
			}

			System.out.println(" includes " + count + " name(s) starting with '" + startingWith +"'");
		}
		{
			String[] names = { "Jen", "Zac", "Dan" };
			List<String> list = new ArrayList<>(Arrays.asList(names));
			String startingWith = "J";
			
			long count =  list.stream()
					.filter(name -> name.startsWith(startingWith))
					.count();

			list.forEach(name -> System.out.print(name +", "));
			System.out.println(" includes " + count + " name(s) starting with '" + startingWith +"'");
		}
		{
			String[] names = { "Jen", "Zac", "Dan" };
			List<String> list = new ArrayList<>(Arrays.asList(names));
			String startingWith = "J";
			
			long count =  list.parallelStream()
					.filter(name -> name.startsWith(startingWith))
					.count();

			list.forEach(name -> System.out.print(name +", "));
			System.out.println(" includes " + count + " name(s) starting with '" + startingWith +"'");
		}
		{
			List<String> list = Arrays.asList("Jen", "Zac", "Dan");
			list.forEach(System.out::print);
			System.out.println(list.size() + " elements in above list.");
		}
	}

	/**
	 * https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
	 */
	public void demoSumSquares() {
		System.out.println(DemoStreams.class.getSimpleName() + ".demoSumSquares()");

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		Integer totalSum = numbers.stream()
		       .filter(n -> {
		                System.out.println("filtering " + n); 
		                return n % 2 == 0;
		              })
		       .mapToInt(n -> {
		                System.out.println("mapping " + n);
		                return n * n;
		              })
		       .limit(2)
		       .sum();
		System.out.println("DemoStreams.demoSumSquares() = " + totalSum);
	}

	/**
	 * https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
	 */
	public void demoReduceSquares() {
		System.out.println(DemoStreams.class.getSimpleName() + ".demoReduceSquares()");

		// https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		Integer totalSum = numbers.stream()
		       .filter(n -> {
		                System.out.println("filtering " + n); 
		                return n % 2 == 0;
		              })
		       .mapToInt(n -> {
		                System.out.println("mapping " + n);
		                return n * n;
		              })
		       .limit(2)
		       // (identity/default/init, accumulator algorithm)
		       .reduce(0, (a,b) -> a + b);
		System.out.println("DemoStreams.demoReduceSquares() = " + totalSum);
	}

	/**
	 * Use Stream API processing to create a NEW List 
	 *
	 * https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
	 */
	public void demoCollect() {
		System.out.println(DemoStreams.class.getSimpleName() + ".demoCollect()");
		
		/**
		 * Source for Stream API
		 */
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		/**
		 * Use Stream API processing to create a NEW List 
		 */
		List<Integer> collectedTwoEvenSquares = 
		    numbers.stream()
		       .filter(n -> {
		                System.out.println("filtering EVEN integers " + n); 
		                return n % 2 == 0;
		              })
		       .map(n -> {
		                System.out.println("mapping SQUARE integers " + n);
		                return n * n;
		              })
		       .limit(2)	// I only want TWO in the Stream
		       .collect(Collectors.toList()); // terminating operation, creates a NEW List from Stream
		System.out.println(DemoStreams.class.getName() + ".demoCollect() = " + collectedTwoEvenSquares);
	}
	
	/**
	 * Use Integer Generator as a Source for Stream API
	 */
	public void UseIntStream() {
		System.out.println("\n\t" + DemoStreams.class.getSimpleName() + ".UseIntStream()...");
		/**
		 * Integer Stream Generator (RNG) will generate range of Integer values
		 */
		System.out.println("\n Integer Stream Generator (RNG) will generate range (1,5)) of Integer values");
		IntStream ints = IntStream.range(1,  5);
		ints.forEach( (n) -> System.out.print(n + ", "));

		System.out.println("\n\n Integer Stream Generator (RNG) will generate range (10,15) of Integer values");
		LongStream longs = LongStream.rangeClosed(10,  15);
		longs.forEach( (n) -> System.out.print(n + ", "));
		
		System.out.println("\n\t" + DemoStreams.class.getSimpleName() + ".UseIntStream()...done!");		
	}
	/**
	 * Use Double Generator as a Source for Stream API
	 */
	public void useDoubleStream() {
		System.out.println("\n\t" + DemoStreams.class.getSimpleName() + ".UseDoubleStream()...");
		/**
		 * Random Number Generator (RNG) will generate doubles
		 */
		int count = 5;	// amount of numbers to generate
		Random rand = new Random();
		// Generate ONLY count numbers
		DoubleStream randomDoubles = rand.doubles(count); 
		/**
		 * All generated doubles to stdout
		 */
		System.out.println("\n All " + count + " generated doubles to stdout");
		randomDoubles.forEach( (n) -> System.out.print(n + ", "));

		/**
		 * All generated doubles to stdout
		 */
		count = 10;	// amount of numbers to limit
		System.out.println("\n\n Limit the INFINITE generation of doubles to only " + count + " generated doubles to stdout");
		DoubleStream infiniteRandomDoubles = rand.doubles(1.0, 3.0).limit(count);
		infiniteRandomDoubles.forEach( (n) -> System.out.print(n + ", "));
//		DoubleStream doubles = DoubleStream.range(1.0,  5.0);

		System.out.println("\n\t" + DemoStreams.class.getSimpleName() + ".UseDoubleStream()...done!");		
	}

	
	/**
	 * Demonstrate the use of this class
	 */
	public static void demo() {
		System.out.println("\n\t" + UseSimpleLambda2.class.getName() + ".demo()...");

		UseSimpleLambda2 obj = new UseSimpleLambda2();
		
		obj.runnableAnonymous();
		obj.runnableAnonymous2();
		obj.runnableInnerClass();
		
		obj.useGenericFunctionalInterface();
		
		obj.useSimpleStream();
		
//		obj.filterStream();
//		obj.mapStream();
		obj.useDoubleStream();
		obj.fileStream();
		
		obj.demoCollect();
		
		obj.useShowList();
		
		System.out.println("\n\t" + UseSimpleLambda2.class.getName() + ".demo()... done!");
	}

}

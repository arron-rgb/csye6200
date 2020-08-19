package edu.neu.csye6200;

/**
 * ParameterPassing class shows how Java passes arguments to methods
 * 1. Pass by Value
 * 2. Pass by Reference
 * 
 * @author dpeters
 *
 */
public class ParameterPassing {
	private int myNumber = 0;
	
	/**
	 * Increment my private integer number
	 * @return	my private integer value
	 */
	public int incMyNumber() {
		return ++myNumber;
	}
	/**
	 * get my private integer number
	 * @return	my private integer value
	 */
	public int getMyNumber() {
		return myNumber;
	}
	/**
	 * set my private integer number
	 */
	public void setMyNumber(int myNumber) {
		this.myNumber = myNumber;
	}
	
	@Override
	public String toString() {
		return "ParameterPassing [n=" + myNumber + "]";
	}

	/**
	 * Add 1 to supplied integer value
	 * 
	 * @param n		supplied integer value
	 * 
	 * @return		result of integer arithmetic
	 */
	public int addOneInt(int n) {
		return ++n;
	}
	
	/**
	 * Add 1 to supplied Integer value
	 * 
	 * @param n		supplied Integer value
	 * 
	 * @return		result of Integer arithmetic
	 */
	public Integer addOneInteger(Integer n) {
		return ++n;
	}

	/**
	 * Add 1 to this.integer value
	 * 
	 * @return		result of integer arithmetic
	 */
	public int addOne() {
		return ++this.myNumber; // pre increment
//		return this.myNumber++; // post increment
	}
	
	/**
	 * Add 1 to supplied object's integer value
	 * 
	 * @param n		supplied object
	 * 
	 * @return		modified object
	 */
	public ParameterPassing addOne(ParameterPassing obj) {
		obj.setMyNumber(obj.getMyNumber() + 1);
		return obj;
	}

	/**
	 * Add 1 to integer value wrapped in object
	 * 
	 * @return		result of integer arithmetic
	 */
	public int addOneObj(ParameterPassing obj) {
		return obj.incMyNumber();
	}
	
	/**
	 * Add 1 to integer value wrapped in object
	 * 
	 * @return		result of integer arithmetic
	 */
	public int addOneAndDestroyObj(ParameterPassing obj) {
		ParameterPassing ObjRef = obj;	// copy obj referece
		obj.incMyNumber();
		obj = null;		// overwrite object supplied reference
		
		return ObjRef.getMyNumber();
	}

	/**
	 * Demonstrate the use of this class
	 */
	public static void demo() {
		System.out.println("\n\t" + ParameterPassing.class.getName() + ".demo()...");
		
		ParameterPassing obj = new ParameterPassing();
		
		System.out.println("Demonstrate Java Passing Parameters by Value by passing argument to an incrementing method...");
		int a = 1;
		System.out.println("Pass int by Value ...");
		System.out.println("Before   int a = " + a);
//		a = obj.addOneInt(a);	// assign return value to my variable so I can update my int a variable
//		System.out.println("Returned int a = " + a);
		System.out.println("Returned int a = " + obj.addOneInt(a));
		System.out.println("After    int a = " + a);
		System.out.println();
		
		/**
		 * This is an example of Pass by Reference
		 * As I am passing a (copy of a) reference to the one IMMUTABLE
		 *  (Integer b) object allocated on the heap
		 * ALL REFERENCES POINT TO THE SAME IMMUTABLE Integer OBJECT
		 * and when the state of that IMMUTABLE object WANTS TO BE updated
		 * The Java runtime MUST CREATE A NEW OBJECT on the heap with the new state
		 * AND my references will point to the ORIGINAL IMMUTABLE object
		 * which was never updated because it is an IMMUTABLE object.
		 * A NEW reference to the The NEW immutable object allocated on the heap 
		 * was returned and that points to the NEW immutable object with the updated state. 
		 */
		System.out.println("Pass Integer Object by Reference (copy of reference to immutable object on heap) ...");
		Integer b = new Integer(1);
		System.out.println("Before   Integer b = " + b);
//		b = obj.addOneInt(b);	// assign return value (new reference to a new immutable Integer object) to my variable so I can update my reference to an Integer object
//		System.out.println("Returned Integer b = " + b);
		System.out.println("Returned Integer b = " + obj.addOneInteger(b));
		System.out.println("After    Integer b = " + b);
		System.out.println();
		
		System.out.println(obj);
		/**
		 * These are all examples of Pass by Reference
		 * As I am passing a (copy of a) reference to the one MUTABLE
		 *  (ParameterPassing obj) object allocated on the heap
		 * ALL REFERENCES POINT TO THE SAME MUTABLE OBJECT
		 * and when the state of that mutable object is updated
		 * all references will point to the same object
		 * with the updated state. 
		 */
		System.out.println("Use ParameterPassing Object state (post inc wrapped int) ...");
		obj.setMyNumber(1);		// update this object's state
		System.out.println("Before   " + obj);
		System.out.println("Returned ParameterPassing obj = " + obj.addOne());
		System.out.println("After    " + obj);
		System.out.println();
		
		System.out.println("Pass ParameterPassing Object by Reference ...");
		obj.setMyNumber(1);		
		System.out.println("Before   " + obj);	// update supplied object's state
		System.out.println("Returned ParameterPassing obj = " + obj.addOne(obj));
		System.out.println("After    " + obj);
		System.out.println();
		
		System.out.println("Pass ParameterPassing Object by Reference ...");
		obj.setMyNumber(1);		
		System.out.println("Before   " + obj);	// update supplied object's state
		System.out.println("Returned ParameterPassing obj = " + obj.addOneObj(obj));
		System.out.println("After    " + obj);
		System.out.println();
		
		System.out.println("Pass ParameterPassing Object by Reference ...");
		obj.setMyNumber(1);		
		System.out.println("Before   " + obj);	// update supplied object's state
		System.out.println("Returned ParameterPassing obj = " + obj.addOneAndDestroyObj(obj));
		System.out.println("After    " + obj);
		System.out.println();
		
		System.out.println("\n\t" + ParameterPassing.class.getName() + ".demo()... done!");
	}
}

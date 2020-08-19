package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DemoException {
	/**
	 * MyException derives from Exception (Throwable)
	 * @author dpeters
	 *
	 */
	private class MyException extends Exception {

		public MyException() {
			super();
		}

		public MyException(String exceptionMessage) {
			super(exceptionMessage);
		}
		
	}

	public void throwAnException() throws Exception {
		System.out.println("\n\t" + DemoException.class.getName() + ".throwException()...");
		
		throw new Exception("DemoException.throwAnException() *** This is Only a Test *** ");
//		System.out.println("\n\t" + DemoExceptions.class.getName() + ".throwAnException()... done!");		
	}

	public void throwMyException() throws MyException {
		System.out.println("\n\t" + DemoException.class.getName() + ".throwMyException()...");
		
		throw new MyException("DemoException.throwMyException() *** This is Only a Test *** ");
//		throw new MyException();
//		System.out.println("\n\t" + DemoExceptions.class.getName() + ".throwAnException()... done!");		
	}

	public void throwException() throws Exception {
		System.out.println("\n\t" + DemoException.class.getName() + ".throwMyException()...");
		
		try {
			this.throwAnException();
		} catch (Exception e) {
			System.out.println(DemoException.class.getName() + ".throwException() exception handler!");
			System.out.println("e.getMessage() '" + e.getMessage()+ "'");
			e.printStackTrace();
		}
		System.out.println("\n\t" + DemoException.class.getName() + ".throwException()... done!");		
	}
		
	public void catchMyException() {
		System.out.println("\n\t" + DemoException.class.getName() + ".catchMyException()...");
		
		try {
			this.throwMyException();
		} catch (Exception e) {
			System.out.println(DemoException.class.getName() + ".catchMyException() exception handler!");
			System.out.println("e.getMessage() '" + e.getMessage()+ "'");
			e.printStackTrace();
		} finally {			
			System.out.println("\n\t" + DemoException.class.getName() + ".catchMyException()... FINALLY done!");		
		}
		System.out.println("\n\t" + DemoException.class.getName() + ".catchMyException()... done!");		
		
	}
		
	public void specifyMyException() throws MyException {
		System.out.println("\n\t" + DemoException.class.getName() + ".catchMyException()...");
		
		this.throwMyException();
		System.out.println("\n\t" + DemoException.class.getName() + ".catchMyException()... done!");		
		
	}
		
	public void specifyException() {
		System.out.println("\n\t" + DemoException.class.getName() + ".catchException()...");
		
		
		System.out.println("\n\t" + DemoException.class.getName() + ".catchException()... done!");		
	}
		
	public static void demo() {
		System.out.println("\n\t" + DemoException.class.getName() + ".demo()...");
		
		DemoException obj = new DemoException();
		
//		obj.catchMyException();
		
		try {
			obj.specifyMyException();
		} catch (Exception e) {
			System.out.println(DemoException.class.getName() + ".demo() exception handler!");
			System.out.println("e.getMessage() '" + e.getMessage()+ "'");
			e.printStackTrace();
		} finally {			
			System.out.println("\n\t" + DemoException.class.getName() + ".demo()... FINALLY done!");		
		}
		
		System.out.println("\n\t" + DemoException.class.getName() + ".demo()...done!");
	}

}

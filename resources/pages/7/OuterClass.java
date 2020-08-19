package edu.neu.dgp;

public class OuterClass {
	/**
	 * Object Instance member which is a Private Inner class
	 * NOTE: An Object Instance Member DOES NOT EXIST 
	 * until an object is created
	 * 
	 * @author dpeters
	 *
	 */
	private class PrivateInnerClass {
		private String name = PrivateInnerClass.class.getName();

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
	 	}
		@Override
		public String toString() {
			return "PrivateInnerClass [name=" + name + "]";
		}
	}

	/**
	 * Object Instance member which is a Public Inner class
	 * NOTE: An Object Instance Member DOES NOT EXIST 
	 * until an object is created
	 * 
	 * @author dpeters
	 *
	 */
	public class PublicInnerClass {
		private String name = PublicInnerClass.class.getName();
		
		public String getName() {
			return name;
		}		
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "PublicInnerClass [name=" + name + "]";
		}
	}
	
	/**
	 * Use the private inner class from withing this
	 * OuterClass object instance method
	 * (so OuterClass object has been created)
	 */
	public void usePrivateInnerClass() {
		System.out.println("\n\t" + OuterClass.class.getName() + ".usePrivateInnerClass()...");
		/**
		 * Instantiate inner class from Object instance method
		 * CLEARLY, we have an OuterClass object, 
		 * because we are USING an OuterClass object instance method
		 */
		System.out.println(new PrivateInnerClass());
		/**
		 * Use inner class method from outer class method
		 */
		System.out.println("name='" + new PrivateInnerClass().getName() + "'");
		
		System.out.println("\n\t" + OuterClass.class.getName() + ".usePrivateInnerClass()... done!");
	}
	
	/**
	 * Use the public inner class from withing this
	 * OuterClass object instance method
	 * (so OuterClass object has been created)
	 */
	public void usePublicInnerClass() {
		System.out.println("\n\t" + OuterClass.class.getName() + ".usePublicInnerClass()...");
		/**
		 * Instantiate inner class from Object instance method
		 * CLEARLY, we have an OuterClass object, 
		 * because we are USING an OuterClass object instance method
		 */
		System.out.println(new PublicInnerClass());
		/**
		 * Use inner class method from outer class method
		 */
		System.out.println("name='" + new PublicInnerClass().getName() + "'");
		
		System.out.println("\n\t" + OuterClass.class.getName() + ".usePublicInnerClass()... done!");
	}
	
	/**
	 * Demonstrate the use of this class
	 */
	public static void demo() {
		System.out.println("\n\t" + OuterClass.class.getName() + ".demo()...");
		
		OuterClass obj = new OuterClass();	// instantiate object from OuterClass
		obj.usePrivateInnerClass(); 		// call object instance method
		obj.usePublicInnerClass(); 		// call object instance method
		
		/**
		 * Use a Private inner class
		 * from a static class method BUT YOU MUST USE AN OUTER CLASS OBJECT for new
		 */
		System.out.println(obj.new PrivateInnerClass());
		/**
		 * Use inner class method from outer class method
		 */
		System.out.println("name='" + obj.new PrivateInnerClass().getName() + "'");
		/**
		 * Use a Public inner class
		 * from a static class method BUT YOU MUST USE AN OUTER CLASS OBJECT for new
		 */
		System.out.println(obj.new PublicInnerClass());
		/**
		 * Use inner class method from outer class method
		 */
		System.out.println("name='" + obj.new PublicInnerClass().getName() + "'");
		
		System.out.println("\n\t" + OuterClass.class.getName() + ".demo()... done!");
	}
}

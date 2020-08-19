package edu.neu.dgp;

/**
 * Demonstrate the use of Inheritance and Polymorphism
 * 
 * @author dpeters
 *
 */
public class School {
	/**
	 * Inner class Person
	 * Inherits from class Object IMPLICITLY
	 * no need to specify "extends Object"
	 * AND class Object implements toString() method
	 * 
	 * @author dpeters
	 *
	 */
	private class Person {
		private int age;
		private String name;
		/**
		 * Object initializer list
		 */
		{
			this.age = 17;
			this.name = "Dan";
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * toString() method
		 * 
		 * As implemented by Object class 
		 * and is INHERITED by this Person class
		 * AND IS ALSO Overridden by derived Student class
		 * SO, 
		 * Person API uses INHERITED toString()
		 * to get Student toString() implementation.
		 */
	}

	/**
	 * Inner class Student
	 * 
	 * @author dpeters
	 *
	 */
	private class Student extends Person {
		private double grade;
		/**
		 * Object initializer list
		 */
		{
			this.grade = 4.0;
		}
		@Override
		public String toString() {
			return "Student " + getName() + " earned a grade of " + grade + " at age " + getAge();
		}
		
	}
	
	/**
	 * Demonstrate the use of this Class
	 */
	public static void demo() {
		System.out.println("\\n\\t" + School.class.getName() + ".demo()...");
		/**
		 * Create Outer class FIRST
		 * (otherwise the inner classes do not exist
		 *  because they are NOT STATIC and are Object instance classes
		 *  and ONLY exist when an OUTER object has been created.)
		 */
		School obj = new School();	// create School object
		/**
		 * Student reference variable s
		 * is assigned a Student object
		 * So it will reference a heap allocated Student object
		 */
		Student s = obj.new Student();	// create Student object
		/**
		 * Call Student's toString() to output state to Console (stdout)
		 */
		System.out.println("Student: call toString()");
		System.out.println(s);	// call toString() 
		
		Student s2 = null;
		/*
		 * Student IS-A Person
		 * BECAUSE class Student INHERITS FROM (extends) class Person 
		 * SO it is ok 
		 * to have a Person variable 
		 * reference a Student object 
		 * AS IF IT WAS A Person Object
		 */
		Person p = s; // Person p reference Student object referenced by s
		/**
		 * Call Person's toString() to output state to Console (stdout)
		 * INHERITED FROM Object class
		 * Class Person did NOT implement toString() in Person class.
		 */
		System.out.println("Person: call toString()");
		System.out.println(s);	// call toString() inherited from Object
		
		/**
		 * TEST: does p contain a Student object?
		 */
		if (p instanceof Student ) {
			System.out.println("Reference variable P DOES CONTAIN a Student object!");
			/*
			 * if true, downcast reference to Person
			 * (because Person is ACTUALLY referencing a Studen Object)
			 * to tell Java Compiler that it is o.k. to use object as Student
			 */
			s2 = (Student) p; 
		} else {
			System.out.println("Reference variable P DOES NOT CONTAIN a Student object!");
		}

		System.out.println("\n\t" + School.class.getName() + ".demo()... done!");
	}
/**
 * CONSOLE OUTPUT
edu.neu.dgp.Driver.main()...
\n\tedu.neu.dgp.School.demo()...
Student: call toString()
Student Dan earned a grade of 4.0 at age 17
Person: call toString()
Student Dan earned a grade of 4.0 at age 17
Reference variable P DOES CONTAIN a Student object!

	edu.neu.dgp.School.demo()... done!
edu.neu.dgp.Driver.main()... done!

 */
}

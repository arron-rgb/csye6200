package edu.neu.csye6200;

public class Conversions {
	/**
	 * Convert from String representation of an integer to an int
	 * @param s
	 * @return
	 */
	public int parseInt(String s) {
		int n = 0;
		try {
			n = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			System.out.println("INVALID STRING FORMAT:'" + s + "'");
			e.printStackTrace();
		}
		return n;
	}
	/**
	 * Convert String representation of an integer value to an int value.
	 * 
	 * @param s		String representation of an integer, e.g. "7"
	 * @return		int value, e.g. 7
	 */
	public static int stringToInt(String s) {
		Conversions obj = new Conversions();
		return obj.parseInt(s);
	}
	/**
	 * Convert an integer value into a String representation, "7"
	 * @param n		int value, e,g, 7
	 * @return		String representation of an integer, e.g. "7"
	 */
	public static String intToString(int n) {
		return new Integer(n).toString();
	}
	/**
	 * Convert from String representation of an double to a double
	 * @param s		String representation, e.g. "7.1"
	 * @return		double value, e.g. 7.1
	 */
	public double parseDouble(String s) {
		double n = 0;
		try {
			n = Double.parseDouble(s);
		} catch (NumberFormatException e) {
			System.out.println("INVALID DOUBLE FORMAT:'" + s + "'");
			e.printStackTrace();
		}
		return n;
	}
	/**
	 * Convert String representation of an double precision floating point value to an double value.
	 * 
	 * @param s		String representation of an double, e.g. "7.1"
	 * @return		double value, e.g. 7.1
	 */
	public static double stringToDouble(String s) {
		Conversions obj = new Conversions();
		return obj.parseDouble(s);
	}
	/**
	 * Convert a double value into a String representation, "7.1"
	 * @param n		double value, e,g, 7.1
	 * @return		String representation of an double, e.g. "7.1"
	 */
	public static String doubleToString(double n) {
		return new Double(n).toString();
	}
	
	public static void demo() {
		System.out.println(Conversions.class.getName() + ".demo()...");
		String s1 = "3";
		String s2 = "7.7";
		System.out.println(s1 + " = " + Conversions.stringToInt(s1));
		System.out.println(s2 + " = " + Conversions.stringToDouble(s2));
		System.out.println(Conversions.class.getName() + ".demo()...");
	}

}

package edu.neu.csye6200;

import java.util.Comparator;

/**
 * Comparator to compare Item objects by Item Price attribute.
 * 
 * @author dpeters
 *
 */
public class CompareItemByPrice implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		return Double.compare(o1.getPrice(), o2.getPrice());
	}

}

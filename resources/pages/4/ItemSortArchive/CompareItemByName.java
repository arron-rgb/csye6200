package edu.neu.csye6200;

import java.util.Comparator;

/**
 * Comparator to compare Item objects by Item Name attribute.
 * 
 * @author dpeters
 *
 */
public class CompareItemByName implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		return o1.getName().compareToIgnoreCase(o2.getName());
	}

}

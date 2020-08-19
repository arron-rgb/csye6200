package edu.neu.csye6200;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {
	/**
	 * write to text file.
	 * 
	 * @param fileName		textfile to write.
	 * @param wData			data to write to file.
	 */
	public void writeTextFile(String fileName, List<String> wData) {
		System.out.println("\n\t" + FileUtility.class.getName() + ".writeFile() '" + fileName + "starting...");
		try (BufferedWriter out = new BufferedWriter(new FileWriter(fileName))) {
			for (String line : wData) {
				out.write(line);
				out.newLine();
			}
			out.flush();
		} catch (IOException e) {
			System.err.println("ERROR: writing '" + fileName + "'");
			e.printStackTrace();
		}
		System.out.println("\n" + FileUtility.class.getName() + ".writeFile() '" + "done!");
	}
	
	/**
	 * read from text file.
	 * @param fileName		text file to read
	 * @return				List containing lines of text (String data) read from text file.
	 */
	public List<String> readTextFile(String fileName) {
		System.out.println("\n\t" + FileUtility.class.getName() + ".readFile() '" + fileName + " starting...");
		List<String> rData = new ArrayList<>();
		try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
			String data  = null;
			while (null != (data = in.readLine())) {
				rData.add(data);
			}
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: reading file '" + fileName + "''");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("ERROR: reading file '" + fileName + "''");
			e.printStackTrace();
		}
		
//		for (String line : rData) System.out.println(line);
		System.out.println("\n" + FileUtility.class.getName() + ".readFile() '" + rData.size() + " lines read from file '" + fileName + "' done!");
		
		return rData;
	}
}

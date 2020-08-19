package edu.neu.csye6200;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Design a basic Swing GUI
 * 
 * (0,0)
 * +---------- 400 -----------+--+
 * |                             | } 10
 * +  +--------+  +-----------+  +
 * |  | Button |  | TextField |  | } 30
 * +30+--120---+20+----200----+30+ 
 * |                             | } 10
 * |  +-----------------------+  + 
 * |  |                       |  | \
 * |  |                       |  |  \
 * |  |       TextArea        |  |   } 160
 * |  |                       |  |  /
 * |  |                       |  | / 
 * |  +-----------------------+  + 
 * |                             | } 10
 * +30+------- 340 -----------+30+ 
 * 
 * @author dpeters
 *
 */
public class MySwingGUI3 implements Runnable {
	public final static int MAJOR = 2;
	public final static int MINOR = 2;
	public final static String REVISION = MAJOR + "." + MINOR;

	@Override
	public String toString() {
		return "MySwingGUI3 [ rev " + REVISION + " ]";
	}
	/**
	 * Execute on a new Thread
	 */
	@Override
	public void run() {
		this.createAndShowGUI();
	}
	/**
	 * initialize the Swing GUI
	 */
	private void createAndShowGUI() {
		/**
		 * Create the Swing JFrame Top-Level Container
		 *  (GUI Window)
		 * 
		 * JFrame dimensions:  frame.setBounds(x, y, width, height)
		 * 		x location horizontal coordinate
		 * 		y location vertical coordinate
		 * 		width
		 * 		height
		 * 		
		 */
		JFrame frame = new JFrame("Basic Swing GUI");
		frame.setBounds(100, 30, 400, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**
		 * Create a text field for user input
		 */
		JTextField jTextField1 = new JTextField("Enter Your Name Here...");
		jTextField1.setBounds(170, 10, 200, 30);
		
		/**
		 * Create a text area for output to user
		 */
		JTextArea jTextArea1 = new JTextArea("Your output appears in here...");
		jTextArea1.setBounds(30, 50, 340, 160);
		/**
		 * Create Swing Button control JButton("Label");
		 * dimensions:  button1.setBounds(x, y, width, height)
		 * 		x location horizontal coordinate
		 * 		y location vertical coordinate
		 * 		width
		 * 		height
		 */
		JButton button1 = new JButton("CLICK HERE!");
		button1.setBounds(30, 10, 120, 30);
		/**
		 * Attach code to execute on the 
		 * Event Dispatch Thread (EDT) 
		 * when user clicks button 
		 */
		/**
		 * All work done on EDT
		 * Simple but if long, 
		 * can make the GUI unresponsive
		 */
//		button1.addActionListener((e) -> jTextArea1.setText(jTextField1.getText().toUpperCase()));
		
		/**
		 * SLOW code where ALL work done on EDT
		 * AND this makes the GUI very unresponsie
		 * (GUI freezes for 3 seconds)
		 */
//		button1.addActionListener((e) -> { 
//			jTextArea1.setText(jTextField1.getText().toUpperCase());
//			try {
//				Thread.sleep(3000);	// sleep 3 seconds
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		} );

		/**
		 * Execute SLOW code on another background thread
		 * leaving the EDT free to respond to use actions
		 * and allowing our GUI to remain responsive
		 */
		button1.addActionListener((e) -> {
			/**
			 * get user input data from GUI on EDT
			 */
			String updateData = jTextField1.getText().toUpperCase();
			
//			jTextArea1.setText(jTextField1.getText().toUpperCase());
			/**
			 * Lambda implementation of Runnable
			 * so the rest of this SLOW code
			 * can be executed on it's own 
			 * background (another new) thread
			 */
			new Thread(() -> {
				/**
				 * Execute this slow code on background thread 
				 * (no GUI work done here)
				 */
				/*
				 * get data while on background thread
				 * e.g.
				 * - Reading a database
				 * - Receiving from a network connection
				 * - Calculating some lengthy algorithm,
				 */
				String backgroundData = " Another Thread executed this SLOW code.";
				/**
				 * Simulate Slow work on background thread
				 */
				try {
					Thread.sleep(3000); // sleep 3 seconds
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				/**
				 * Finally, we need to update the GUI 
				 * (on the EDT)
				 * Lambda Runnable to Update GUI 
				 * when queued to execute on EDT
				 */
				Runnable rLambdaGUIUpdate = () -> {
					jTextArea1.setText("[UpdateData] " + updateData + " : \n '" + backgroundData + "' ... \n\n\t" + this);
				};
				/**
				 * Queue Runnable (rLambdaGUIUpdate)
				 * on EDT for execution
				 */
				EventQueue.invokeLater(rLambdaGUIUpdate);

			}).start(); // start exection on new thread
			
		} );
		
//		button1.addActionListener((e) -> System.out.println("button1 was CLICKED"));
		
		/**
		 * Add GUI components to the JFrame Top Level Container
		 */
		frame.add(button1);
		frame.add(jTextField1);
		frame.add(jTextArea1);
//		frame.pack(); 	// automatically enlarge to fit contents
		
		frame.setLayout(null);	// no Layout Manager
//		frame.setLayout(new FlowLayout());	// Flow Layout Manager
		frame.setVisible(true);
	}

	/**
	 * Demonstrate the use of this class
	 */
	public static void demo() {
		/**
		 * 1. Create the object:
		 * 
		 * Note:
		 * 	MySwingGUI3 is a class which implements the Runnable Interface
		 * 	making all it's objects Runnable 
		 * 	i.e. it's run() method is executed on new Thread
		 * 
		 * 2. Execute Runnable on a New Thread
		 * 
		 * 	NOTE:
		 * 		a. original main thread is thread #1
		 * 		b. new Thread t1 starts thread #2
		 * 
		 * Thread.start() calls the run (method)
		 * and run() calls createAndShowGUI 
		 * to do everything to create, initialize 
		 * and make visible the GUI
		 */
		Thread t1 = new Thread(new MySwingGUI3());
		t1.start();	// start execution on new thread
//		Thread t2 = new Thread(new MySwingGUI2());
//		t2.start();
		try {
			t1.join();
//			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

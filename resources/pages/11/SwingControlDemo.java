package edu.neu.csye6200;


import static java.util.stream.Collectors.toList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import edu.neu.csye6200.util.FileUtility;
import edu.neu.csye6200.util.TextAreaUpdaterTask;

public class SwingControlDemo {

	private final Logger m_logger = Logger.getLogger(this.getClass().getCanonicalName());
	private JFrame m_mainFrame;
	private JLabel m_headerLabel;
	private JLabel m_statusLabel;
	private JPanel m_controlPanel;
	private JProgressBar m_progressBar;
	private JProgressBar m_fileProgressBar;
	private Task m_task;
	private TimeTask m_timeTask;
	private JButton m_browseButton;
	private JButton m_startButton;
	private JButton m_stopButton;
	private JButton m_recvButton;
	private JButton m_sendButton;
	private JTextField m_hostField;
	private JTextField m_portField;
	private JTextField m_fileNameField;
	private JTextArea m_outputTextArea;
	private JTextArea m_fileViewTextArea;
	private JTextArea m_sendViewTextArea;
	private JTextArea m_recvViewTextArea;
	private SocketServerTask m_socketServerTask;
	private String currentPattern = null;

	JTextField m_portTField = new JTextField("6066");
	String m_recvData = null;

	public SwingControlDemo() {
		prepareGUI();
	}

	// public static void main(String[] args){
	// SwingControlDemo swingControlDemo = new SwingControlDemo();
	// swingControlDemo.showComboboxDemo();
	// }

	private void prepareGUI() {
		m_mainFrame = new JFrame("Java Swing Examples");
		m_mainFrame.setSize(1000, 400);
//		m_mainFrame.setSize(400, 400);
		m_mainFrame.setLayout(new GridLayout(3, 1));
		m_mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		m_headerLabel = new JLabel("", JLabel.CENTER);
		m_statusLabel = new JLabel("", JLabel.CENTER);

		m_statusLabel.setSize(350, 100);

		m_controlPanel = new JPanel();
		m_controlPanel.setLayout(new FlowLayout());	// initial layout can be changed

		m_mainFrame.add(m_headerLabel);
		m_mainFrame.add(m_controlPanel);
		m_mainFrame.add(m_statusLabel);
		m_mainFrame.setVisible(true);
	}

	public void showComboboxDemo1() {
		m_headerLabel.setText("Control in action: JComboBox 1");

//		final DefaultComboBoxModel<Integer> fruitsName = new DefaultComboBoxModel<>();
//
//		fruitsName.addElement(1);
//		fruitsName.addElement(2);
//		fruitsName.addElement(3);
//		fruitsName.addElement(4);
//
//		final JComboBox<Integer> fruitCombo = new JComboBox<>(fruitsName);
		final DefaultComboBoxModel<String> fruitsName = new DefaultComboBoxModel<>();

		fruitsName.addElement("Apple");
		fruitsName.addElement("Grapes");
		fruitsName.addElement("Mango");
		fruitsName.addElement("Pear");
		fruitsName.addElement("BlueBerry");
		fruitsName.addElement("Banana");
		fruitsName.addElement("Cherry");

		final JComboBox<String> fruitCombo = new JComboBox<>(fruitsName);
		fruitCombo.setSelectedIndex(0);

		JScrollPane fruitListScrollPane = new JScrollPane(fruitCombo);

		JButton showButton = new JButton("Show");

		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = "";
				if (fruitCombo.getSelectedIndex() != -1) {
					data = "Fruits Selected: " + fruitCombo.getItemAt(fruitCombo.getSelectedIndex());
				}
				m_statusLabel.setText(data);
			}
		});
		m_controlPanel.add(fruitListScrollPane);
		m_controlPanel.add(showButton);
		m_mainFrame.setVisible(true);
	}
	
	private void reformat(String curPattern) {
		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(curPattern);
		try{
			String dateString = formatter.format(today);
			m_statusLabel.setForeground(Color.BLACK);
			m_statusLabel.setText(dateString);
			System.out.println(dateString);
		} catch (IllegalArgumentException iae) {
			m_statusLabel.setForeground(Color.red);
			m_statusLabel.setText("ERROR: "+iae.getMessage());
			System.err.println("ERROR: IllegalArgumentException: "+ iae.getMessage());
			iae.printStackTrace();
		}
	}
	public void showComboboxDemo2() {
		m_headerLabel.setText("Control in action: JComboBox 2");

//		final DefaultComboBoxModel<String> fruitsName = new DefaultComboBoxModel<>();

		String[] patternExamples = {
				"dd MMMMM yyyy",
				"dd.MM.yy",
				"MM/dd/yy",
				"yyyy.MM.dd G 'at' hh:mm:ss z",
				"EEE, MMM d, ''yy",
				"h:mm a",
				"H:mm:ss:SSS",
				"K:mm a,z",
				"yyyy.MMMMM.dd GGG hh:mm aaa"
			};
		final JComboBox<String> patternList = new JComboBox<>(patternExamples);
		patternList.setEditable(true);
		patternList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>) e.getSource();
				String newSelection = (String) cb.getSelectedItem();
				currentPattern = newSelection;
				reformat(currentPattern);
				m_logger.log(Level.ALL, "patternList CB Selected'{0}'", newSelection);
			}
		});
		currentPattern = patternExamples[0];
		patternList.setSelectedIndex(0);

		JScrollPane patternListScrollPane = new JScrollPane(patternList);

		JButton showButton = new JButton("Show");

		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = "";
				if (patternList.getSelectedIndex() != -1) {
					data = "Pattern Selected: " + patternList.getItemAt(patternList.getSelectedIndex());
				}
				m_statusLabel.setText(data);
			}
		});
		m_controlPanel.add(patternListScrollPane);
		m_controlPanel.add(showButton);
		m_mainFrame.setVisible(true);
	}

	public void showRadioButtonDemo() {
		m_headerLabel.setText("Control in action: RadioButton");

		final JRadioButton radApple = new JRadioButton("Apple", true);
		final JRadioButton radMango = new JRadioButton("Mango");
		final JRadioButton radPear = new JRadioButton("Pear");

		radApple.setMnemonic(KeyEvent.VK_A);
		radMango.setMnemonic(KeyEvent.VK_M);
		radPear.setMnemonic(KeyEvent.VK_P);

		radApple.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				m_statusLabel.setText("Apple RadioButton: " + (e.getStateChange() == 1 ? "checked" : "unchecked"));
			}
		});

		radMango.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				m_statusLabel.setText("Mango RadioButton: " + (e.getStateChange() == 1 ? "checked" : "unchecked"));
			}
		});

		radPear.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				m_statusLabel.setText("Pear RadioButton: " + (e.getStateChange() == 1 ? "checked" : "unchecked"));
			}
		});

		// Group the radio buttons.
		ButtonGroup group = new ButtonGroup();
		group.add(radApple);
		group.add(radMango);
		group.add(radPear);

		m_controlPanel.add(radApple);
		m_controlPanel.add(radMango);
		m_controlPanel.add(radPear);

		m_mainFrame.setVisible(true);
	}

	public void showFileChooserDemo() {
		m_headerLabel.setText("Control in action: JFileChooser");

		final JFileChooser fileDialog = new JFileChooser();
		JButton showFileDialogButton = new JButton("Open File");
		showFileDialogButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int returnVal = fileDialog.showOpenDialog(m_mainFrame);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					java.io.File file = fileDialog.getSelectedFile();
					m_statusLabel.setText("File Selected :" + file.getName());
				} else {
					m_statusLabel.setText("Open command cancelled by user.");
				}
			}
		});
		m_controlPanel.add(showFileDialogButton);
		m_mainFrame.setVisible(true);
	}

	public void showSliderDemo() {
		m_headerLabel.setText("Control in action: JSlider");
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 10);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				m_statusLabel.setText("Value : " + ((JSlider) e.getSource()).getValue());
			}
		});
		m_controlPanel.add(slider);
		m_mainFrame.setVisible(true);
	}

	public void showSpinnerDemo() {
		m_headerLabel.setText("Control in action: JSpinner");
		SpinnerModel spinnerModel = new SpinnerNumberModel(10, // initial value
				0, // min
				100, // max
				1);// step
		JSpinner spinner = new JSpinner(spinnerModel);
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				m_statusLabel.setText("Value : " + ((JSpinner) e.getSource()).getValue());
			}
		});
		m_controlPanel.add(spinner);
		m_mainFrame.setVisible(true);
	}

	public void showTextFieldDemo() {
		m_headerLabel.setText("Control in action: JTextField");

		JLabel namelabel = new JLabel("User ID: ", JLabel.RIGHT);
		JLabel passwordLabel = new JLabel("Password: ", JLabel.CENTER);
		final JTextField userText = new JTextField(6);
		final JPasswordField passwordText = new JPasswordField(6);

		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = "Username " + userText.getText();
				data += ", Password: " + new String(passwordText.getPassword());
				m_statusLabel.setText(data);
			}
		});

		m_controlPanel.add(namelabel);
		m_controlPanel.add(userText);
		m_controlPanel.add(passwordLabel);
		m_controlPanel.add(passwordText);
		m_controlPanel.add(loginButton);
		m_mainFrame.setVisible(true);
	}

	public void showListDemo() {

		m_headerLabel.setText("Control in action: JList");

		final DefaultListModel<String> fruitsName = new DefaultListModel<>();

		fruitsName.addElement("Apple");
		fruitsName.addElement("Grapes");
		fruitsName.addElement("Mango");
		fruitsName.addElement("Pear");

		final JList<String> fruitList = new JList<>(fruitsName);
		fruitList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		fruitList.setSelectedIndex(0);
		fruitList.setVisibleRowCount(3);

		JScrollPane fruitListScrollPane = new JScrollPane(fruitList);

		final DefaultListModel<String> vegName = new DefaultListModel<>();

		vegName.addElement("Lady Finger");
		vegName.addElement("Onion");
		vegName.addElement("Potato");
		vegName.addElement("Tomato");

		final JList<String> vegList = new JList<>(vegName);
		vegList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		vegList.setSelectedIndex(0);
		vegList.setVisibleRowCount(3);

		JScrollPane vegListScrollPane = new JScrollPane(vegList);

		JButton showButton = new JButton("Show");

		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = "";
				if (fruitList.getSelectedIndex() != -1) {
					data = "Fruits Selected: " + fruitList.getSelectedValue();
					m_statusLabel.setText(data);
				}
				if (vegList.getSelectedIndex() != -1) {
					data += " Vegetables selected: ";
					for (Object vegetable : vegList.getSelectedValuesList()) { // getSelectedValues() deprecated
						data += vegetable + " ";
					}
				}
				m_statusLabel.setText(data);
			}
		});

		m_controlPanel.add(fruitListScrollPane);
		m_controlPanel.add(vegListScrollPane);
		m_controlPanel.add(showButton);

		m_mainFrame.setVisible(true);
	}

	public void showColorChooserDemo() {
		m_headerLabel.setText("Control in action: JColorChooser");

		JButton chooseButton = new JButton("Choose Background");
		chooseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color backgroundColor = JColorChooser.showDialog(m_mainFrame, "Choose background color", Color.white);
				if (backgroundColor != null) {
					m_controlPanel.setBackground(backgroundColor);
					m_mainFrame.getContentPane().setBackground(backgroundColor);
				}
			}
		});

		m_controlPanel.add(chooseButton);
		m_mainFrame.setVisible(true);
	}

	public void showProgressBarDemo() {
		m_headerLabel.setText("Control in action: JProgressBar");

		m_progressBar = new JProgressBar(0, 100);
		m_progressBar.setValue(0);
		m_progressBar.setStringPainted(true);
		m_startButton = new JButton("Start");

		m_outputTextArea = new JTextArea("", 5, 20);

		JScrollPane scrollPane = new JScrollPane(m_outputTextArea);
		m_startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				m_task = new Task();
				m_task.start();
			}
		});

		m_controlPanel.add(m_startButton);
		m_controlPanel.add(m_progressBar);
		m_controlPanel.add(scrollPane);
		m_mainFrame.setVisible(true);
	}

	private class Task extends Thread {
		public Task() {
		}

		public void run() {
			for (int i = 0; i <= 100; i += 10) {
				final int progress = i;
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						m_progressBar.setValue(progress);
						m_outputTextArea.setText(
								m_outputTextArea.getText() + String.format("Completed %d%% of task.\n", progress));
					}
				});
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
			}
		}
	}

	private String timeText() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy hh:mm:ss aaa");
	    Calendar cal = new GregorianCalendar(2015, Calendar.NOVEMBER, 4);
        Calendar now = Calendar.getInstance();
        int h = now.get(Calendar.HOUR);		// 12-hour format
//        int h = now.get(Calendar.HOUR_OF_DAY);  // 24-hour format
        int m = now.get(Calendar.MINUTE);
        int s = now.get(Calendar.SECOND);
//        if (m == m_spinnerValue && 00 == s) {
//    		System.out.println("ALARM: " + sdf.format(now.getTime()));
//        }
//        return new String("" + h + ":" + m + ":" + s);
        LocalDateTime t = LocalDateTime.now();
        return new String(
        		t.getDayOfWeek().name()
        		+ " " + t.getMonth().name()
        		+ " " + t.getDayOfMonth()
        		+ ", " + t.getYear()
        		+ " " + t.getHour()
        		+ ":" + t.getMinute()
        		+ ":" + t.getSecond()
        		);
		
	}

	private class TimeTask extends Thread {
	    private volatile boolean running = true;
		public TimeTask() {
		}

		public void terminate() {
	        running = false;
	    }
		
		public void run() {
			for (int i = 0; i <= 10000; i += 10) {
				if (false == running) {
					break;	// exit loop and terminate thread
				}
				SwingUtilities.invokeLater(new Runnable() {
//					SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy hh:mm:ss aaa");

					public void run() {
						m_statusLabel.setText(timeText());					}
//						Date today = new Date();
//					m_statusLabel.setText(sdf.format(new Date().getTime()));					}
				});
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					running = false;
				}
			} // end for
		}
	} // end class TimeTask

	public void showAnalogClock() {
		
	}
	public void showClock() {
		JButton timeButton = new JButton("Time");
		
		timeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				m_timeTask = new TimeTask();
				m_timeTask.start();
		        m_logger.log(Level.ALL, "Background process successfully started.");
			}
		});
		JButton stopButton = new JButton("Stop");
		
		stopButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (null != m_timeTask) {
					m_timeTask.terminate();
			        m_logger.log(Level.ALL, "Background process successfully started.");
				}
			}		
		});

		m_controlPanel.add(timeButton);
		m_controlPanel.add(stopButton);
		m_mainFrame.setVisible(true);
	}


	private class SocketServerTask extends Thread {
		private volatile boolean running = true;
		private ServerSocket serverSocket;

		public SocketServerTask(int port) {
			try {
				serverSocket = new ServerSocket(port);
				serverSocket.setSoTimeout(10000);
			} catch (Exception e) {
				// handle IOException and SocketException
				e.printStackTrace();
			}
		}

		public void terminate() {
			running = false;
		}

		public void run() {
			while (true) {
				// terminate thread
				if (false == running) {
					break;
				}
				try {
					System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
					Socket server = serverSocket.accept();
					System.out.println("Just connected to " + server.getRemoteSocketAddress());
					DataInputStream in = new DataInputStream(server.getInputStream());
					m_recvData = in.readUTF();
					System.out.println(m_recvData);
//					System.out.println(in.readUTF());
					DataOutputStream out = new DataOutputStream(server.getOutputStream());
					out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
					server.close();
				} catch (SocketTimeoutException s) {
					System.out.println("Socket timed out!");
					break;
				} catch (IOException e) {
					e.printStackTrace();
					break;
				}

				// output to GUI
				SwingUtilities.invokeLater(new Runnable() {

					public void run() {
						m_statusLabel.setText(m_recvData);
					}
				});
			} // end while(true) loop
		}
	} // end class SocketServerTask
	
	public void socketClientDemo(){
		
	}
	public void socketServerDemo() {
		
		JButton startButton = new JButton("Server");
		
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int port = Integer.parseInt(m_portTField.getText());
				m_socketServerTask = new SocketServerTask(port);
				m_socketServerTask.start();
		        m_logger.log(Level.ALL, "Background process successfully started.");
			}
		});
		JButton stopButton = new JButton("Stop");
		
		stopButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (null != m_timeTask) {
					m_socketServerTask.terminate();
			        m_logger.log(Level.ALL, "Background process successfully started.");
				}
			}		
		});

		m_controlPanel.add(startButton);
		m_controlPanel.add(m_portTField);
		m_controlPanel.add(stopButton);
		m_mainFrame.setVisible(true);
	}
	
	public void tableDemo() {
		System.out.println("Table Demo");
	    Vector<String> rowOne = new Vector<String>();
	    rowOne.addElement("Row1-Column1");
	    rowOne.addElement("Row1-Column2");
	    rowOne.addElement("Row1-Column3");
	    
	    Vector<String> rowTwo = new Vector<String>();
	    rowTwo.addElement("Row2-Column1");
	    rowTwo.addElement("Row2-Column2");
	    rowTwo.addElement("Row2-Column3");
	    
	    Vector<Vector> rowData = new Vector<Vector>();
	    rowData.addElement(rowOne);
	    rowData.addElement(rowTwo);
	    
	    Vector<String> columnNames = new Vector<String>();
	    columnNames.addElement("Column One");
	    columnNames.addElement("Column Two");
	    columnNames.addElement("Column Three");
	    columnNames.addElement("Column Four");
	    JTable table = new JTable(rowData, columnNames);

		String [] colTitles = {"A","B", "C", "D"};
        DefaultTableModel myTM = new DefaultTableModel();
        myTM.setColumnCount(colTitles.length);
        table.setModel(myTM);
        table.setAutoCreateRowSorter(true);  // sortable table
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        int i = 0;
        for (String s : colTitles) {
        	table.getColumnModel().getColumn(i++).setHeaderValue(s);
        }
        for (i=0; i < 8; ++i) {
        	int link = 0 + 10*i;
        	double eid = 1.0 + 10*i;
        	int rip = 2 + 10*i;
        	int sti = 3 + 10*i;
            myTM.addRow(new Object[]{link, eid, rip, sti});
        }
        myTM.addRow(new Object[]{"link0", "eid0", "rip0", "st0"});
        myTM.addRow(new Object[]{"link1", "eid1", "rip1", "st1"});
        myTM.addRow(new Object[]{"link2", "eid2", "rip2", "st2"});
        myTM.addRow(new Object[]{"link3", "eid3", "rip3", "st3"});
	    
	    JScrollPane scrollPane = new JScrollPane(table);
//	    m_controlPanel.add(scrollPane, BorderLayout.CENTER);
	    m_mainFrame.add(scrollPane);
	    m_mainFrame.setSize(300, 150);
	    m_mainFrame.setVisible(true);		
	}
	
	public void scrollTableDemo() {
		System.out.println("Scroll Table Demo");

		// Create a table with 10 rows and 5 columns
		JTable table = new JTable(10, 5);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		String [] colTitles = {"A","B", "C", "E"};
        DefaultTableModel myTM = new DefaultTableModel();
        myTM.setColumnCount(colTitles.length);
        table.setModel(myTM);
        table.setAutoCreateRowSorter(true);  // sortable table
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        int i = 0;
//        for (String s : colTitles) {
//        	table.getColumnModel().getColumn(i++).setHeaderValue(s);
//        }
        myTM.setColumnIdentifiers(colTitles);
        for (i=0; i < 8; ++i) {
        	int link = 0 + 10*i;
        	double eid = 1.0 + 10*i;
        	int rip = 2 + 10*i;
        	int sti = 3 + 10*i;
            myTM.addRow(new Object[]{link, eid, rip, sti});
        }
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scrollPane.setWheelScrollingEnabled(true);
	    scrollPane.setVisible(true);
	    m_controlPanel.add(scrollPane, BorderLayout.CENTER);
	    m_mainFrame.setSize(300, 150);
	    m_mainFrame.setVisible(true);				
	}
	
	public void popupTable() {
//		String[] colName = new String[] { "Product Name", "Price" };
//		Object[][] products = new Object[][] { { "Galleta", "$80" }, { "Malta", "$40" }, { "Nestea", "$120" },
//				{ "Tolta", "$140" } };
//		JTable table = new JTable(products, colName);

		JTable table = new JTable();

		String [] colTitles = {"A","B", "C", "E"};
        DefaultTableModel myTM = new DefaultTableModel();
        myTM.setColumnCount(colTitles.length);
        table.setModel(myTM);
        table.setAutoCreateRowSorter(true);  // sortable table
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        int ix = 0;
//        for (String s : colTitles) {
//        	table.getColumnModel().getColumn(i++).setHeaderValue(s);
//        }
        myTM.setColumnIdentifiers(colTitles);
        for (ix=0; ix < 8; ++ix) {
        	int i1 = 0 + 10*ix;
        	double d1 = 1.0 + 10*ix;
        	int i2 = 2 + 10*ix;
        	int i3 = 3 + 10*ix;

        	myTM.addRow(new Object[]{i1, d1, i2, i3});
        }
		
		// create scroll pane for wrapping the table and add
		// it to the frame
        JFrame frame = new JFrame("Pop-up Table Example");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// exit entire program on close
        frame.add(new JScrollPane(table));
//		frame.pack();	// use either frame.pack() OR frame.setSize()
		frame.setSize(300, 100);		// use either frame.setSize() OR frame.pack()
		frame.setVisible(true);		
	}
	
	
	public void simpleTable(String[] colnames, Object[][] data) {
		JTable table = new JTable(data, colnames);

		JFrame frame = new JFrame("Simple Table Example");

		// create scroll pane for wrapping the table and add
		// it to the frame
		frame.add(new JScrollPane(table));
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Given a list of Person objects, create a Table Model
	 * 
	 * @param list	List of Person objects
	 */
	public void personTable(List<Person> list) {
		String [] colTitles = {"ID", "Pres #", "First Name","Last Name", "Age"};
        DefaultTableModel myTM = new DefaultTableModel();
        myTM.setColumnCount(colTitles.length);
        myTM.setColumnIdentifiers(colTitles);
        int ix = 0;
//        for (String s : colTitles) {
//        	table.getColumnModel().getColumn(i++).setHeaderValue(s);
//        }
        for (Person p : list) {
        	String fname = p.getFirstName();
        	String lname = p.getLastName();
        	int age = p.getAge();
        		myTM.addRow(new Object[]{++ix, p.getId(), fname, lname, age});
//        	myTM.addRow(new Object[]{++ix, fname, lname, age});
        }
        simpleTable(myTM);
        
        List<Integer> integers = new ArrayList<Integer>();
        /*
         *  autoboxing:
         *   literal int placed inside Integer object
         *   to add to sequential container
         *   (sequential containers cannot work with primitive types)
         */
        integers.add(2);	// autobox literal int 2
        integers.add(3);	// autobox literal int 3
        integers.add(1);	// autobox literal int 1
        integers.add(new Integer(4));	// add Integer holding int 4
	}
	
	public void simpleTable(DefaultTableModel myTM) {
		JTable table = new JTable();
		table.setModel(myTM);
		table.setAutoCreateRowSorter(true); // sortable table
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		JFrame frame = new JFrame("Person Table Example");

		// create scroll pane for wrapping the table and add
		// it to the frame
		frame.add(new JScrollPane(table));
		frame.pack();
		frame.setVisible(true);
	}
	
	public void showTableInFrame() {
		
	}

	public void simpleTable() {
		String[] colName = new String[] { "Product Name", "Price" };
		Object[][] products = new Object[][] { { "iPhone7", "$599" }, { "Galaxy7", "$499" }, { "TracPhone", "$120" },
				{ "WindowsPhone", "$240" } };
				
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				simpleTable(colName, products);

			}
		});
	}

	public void personTableDemo() {
		Person p1 = new Person(1, "George", "Washington", 43);
		Person p2 = new Person(4, "James", "Madison", 49);
		Person p3 = new Person(2, "John", "Adams", 48);
		Person p4 = new Person(45, "Danald", "Trump", 71);
		// Person p5 = new Person(46, "Daniel", "Peters", 17);
		List<Person> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(new Person(46, "Daniel", "Peters", 17));
		personTable(list);
	}
	
	private boolean isAFile(File file) {
		boolean amAFile = file.isFile();
		if (true == file.isFile()) {
			System.out.println("file.getParent() '" + file.getParent() + "'");
			System.out.println("file.getName() '" + file.getName() + "'");
			System.out.println("file.getPath() '" + file.getPath() + "'");
		} else {
			if (true == file.isDirectory()) {
				String message = "ERROR: '" + file.getName() + "' is a Directory!";
				System.err.println(message);
				JOptionPane.showMessageDialog(null, message);
			}
		}
		return amAFile;
	}
	
	private boolean isADirectory(File file) {
		boolean amAFile = file.isDirectory();
		if (true == file.isDirectory()) {
			System.out.println("file.getParent() '" + file.getParent() + "'");
			System.out.println("file.getName() '" + file.getName() + "'");
			System.out.println("file.getPath() '" + file.getPath() + "'");
		} else {
			if (true == file.isFile()) {
				String message = "ERROR: '" + file.getName() + "' is a File!";
				System.err.println(message);
				JOptionPane.showMessageDialog(null, message);
			}
		}
		return amAFile;
	}
	
	public String browseFileName() {
		return browseFile().getName();
	}
	
	public String browseFilePath() {
		return browseFile().getPath();
	}

	private String browseFilePath(JTextComponent guiComponent) {
		/*
		 * Retrieve file name.
		 */
		String filePathName = null;
		filePathName = this.browseFilePath();
		
		guiComponent.setText(filePathName);
//		/*
//		 * Retrieve data (read file) in background thread
//		 */
//		Runnable readFileRunnable = () -> {
//			StringBuffer buf = useCommand(m_fileNameField.getText());
//			TextAreaUpdaterTask<JComponent> guiUpdater = new TextAreaUpdaterTask<JComponent>(m_fileViewTextArea);
//			guiUpdater.setMessage(buf.toString());
//			EventQueue.invokeLater(guiUpdater); // update GUI on EDT
//		};
//
//		Thread readFileThread = new Thread(readFileRunnable);
//		readFileThread.start(); // start background thread
		
		return filePathName;
	}

	public File browseFile() {
		File file = null;
		final JFileChooser fileChooser = new JFileChooser();
		int ret = fileChooser.showOpenDialog(null);
		if (ret == JFileChooser.APPROVE_OPTION) {
			// m_fileProgressBar.setValue(0);
			// m_fileProgressBar.setVisible(true);
			// m_fileViewTextArea.setText("");
			file = fileChooser.getSelectedFile();
//			if (true == file.isFile()) {
//				System.out.println("file.getParent() '" + file.getParent() + "'");
//				System.out.println("file.getName() '" + file.getName() + "'");
//				System.out.println("file.getPath() '" + file.getPath() + "'");
//				System.out.println("Choosing '" + file.getName() + "'");
//				fileName = file.getPath();
//			} else {
//				if (true == file.isDirectory()) {
//					String message = "ERROR: '" + file.getName() + "' is a Directory!";
//					System.err.println(message);
//					JOptionPane.showMessageDialog(null, message);
//				}
//				fileName = null;
//			}
			// List<String> list = null;
			// if (null != (list = fileReader(file))) {
			// for (String l : list) {
			// m_fileProgressBar.setValue(m_fileProgressBar.getValue() + 10);
			// String data = m_fileViewTextArea.getText();
			// m_fileViewTextArea.setText(data + "\n" + l);
			// }
			// m_fileProgressBar.setValue(100);
			// }
		}
		// m_fileProgressBar.setVisible(false);
		return file;
	}
    	
        private String chooseFile() {
            final JFileChooser fileChooser = new JFileChooser();
            int ret = fileChooser.showOpenDialog(null);
            String fileName = null;
            if (ret == JFileChooser.APPROVE_OPTION) {
        		m_fileProgressBar.setValue(0);
                m_fileProgressBar.setVisible(true);
                m_fileViewTextArea.setText("");
                File file = fileChooser.getSelectedFile();
                fileName = file.getName();
                System.out.println("Opening '" + fileName + "'");
                List<String> list = null;
                if (null != (list = fileReader(file))) {
                    for (String l : list) {
                    	m_fileProgressBar.setValue(m_fileProgressBar.getValue() + 10);
                        String data = m_fileViewTextArea.getText();
                        m_fileViewTextArea.setText(data + "\n" + l);
                    }
        			m_fileProgressBar.setValue(100);
                }
            }
            m_fileProgressBar.setVisible(false);
            return fileName;
        }

    private List<String> fileReader(File file) {
        List<String> buf = new ArrayList<>();
        System.out.println("fileReader: Reading '" + file.getName() + "'");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = null;
            int progress = 0;
            while (null != (line = br.readLine())) {
            	progress += 10;
                buf.add(line);
				m_fileProgressBar.setValue(progress);
				m_statusLabel.setText(
						m_statusLabel.getText() + String.format("Completed %d%% of task.\n", progress));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SwingControlDemo.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("ERROR: '" + ex.getMessage() +"'");
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(SwingControlDemo.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("ERROR: '" + ex.getMessage() +"'");
            ex.printStackTrace();
        }
        return buf;
    }

    private void fileChooserDemo() {
		m_headerLabel.setText("Control in action: fileChooserDemo");

//		m_fileProgressBar = new JProgressBar(0, 100);  // range=0-100%
//		m_fileProgressBar.setValue(0);
//		m_fileProgressBar.setStringPainted(true);
//		m_fileProgressBar.setVisible(false);
		m_browseButton = new JButton("Browse");
		m_fileNameField = new JTextField("SelectedFileName");
		m_fileViewTextArea = new JTextArea("", 10, 60);
//		m_fileViewTextArea = new JTextArea("", 5, 20);

		JScrollPane fileScrollPane = new JScrollPane(m_fileViewTextArea);
		m_browseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				m_fileViewTextArea.setText("");
				m_fileNameField.setText(browseFilePath(m_fileNameField));
				Runnable readFileRunnable = () -> { 					
					FileUtility fileUtil = new FileUtility();
					StringBuffer buf = new StringBuffer();
					for ( String line : fileUtil.readFile(m_fileNameField.getText())) {
						buf.append(line).append("\n");
//						 String data = m_fileViewTextArea.getText();
//						 m_fileViewTextArea.setText(data + "\n" + line);
//	                 	m_fileProgressBar.setValue(m_fileProgressBar.getValue() + 10);
					}
//					m_fileProgressBar.setValue(100);
//					StringBuffer buf = useCommand(m_fileNameField.getText());
					TextAreaUpdaterTask<JComponent> guiUpdater = new TextAreaUpdaterTask<JComponent>(m_fileViewTextArea);
					guiUpdater.setMessage(buf.toString());
					EventQueue.invokeLater(guiUpdater);	// update GUI on EDT
				};
				/*
				 * read file on background thread
				 */
				Thread t = new Thread(readFileRunnable);
				t.start();		// start background thread 

//				FileUtility fileUtil = new FileUtility();
//				for ( String line : fileUtil.readFile(m_fileNameField.getText())) {
//					 String data = m_fileViewTextArea.getText();
//					 m_fileViewTextArea.setText(data + "\n" + line);
//                 	m_fileProgressBar.setValue(m_fileProgressBar.getValue() + 10);
//				}
//				m_fileProgressBar.setValue(100);
//				m_fileNameField.setText(chooseFile());
//				m_task = new Task();
//				m_task.start();
			}
		});
        
		m_controlPanel.add(m_fileNameField);
        m_controlPanel.add(m_browseButton);
//        m_controlPanel.add(m_fileProgressBar);
//        m_controlPanel.add(m_fileProgressBar);
		m_controlPanel.add(fileScrollPane);
        m_mainFrame.setVisible(true);
    }

    private void fileRunDemo() {
		m_headerLabel.setText("Control in action: fileRunDemo");

		m_fileProgressBar = new JProgressBar(0, 100);
		m_fileProgressBar.setValue(0);
		m_fileProgressBar.setStringPainted(true);
		m_fileProgressBar.setVisible(false);
		m_browseButton = new JButton("Browse");
		JButton fileRunButton = new JButton("Run");
		m_fileNameField = new JTextField("SelectedFileName");
		m_fileViewTextArea = new JTextArea("", 5, 20);

		JScrollPane fileScrollPane = new JScrollPane(m_fileViewTextArea);
		m_browseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				m_fileNameField.setText(browseFilePath(m_fileNameField));
//				m_fileNameField.setText(chooseFile());
//				m_task = new Task();
//				m_task.start();
			}
		});
        
		/*
		 * /Users/danielgmp/Documents/Java/workspace-o2-dgp-midterm/Project1/demo1v/a.out
		 */
		fileRunButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Runnable useCommandRunnable = () -> { 					
					StringBuffer buf = useCommand(m_fileNameField.getText());
					TextAreaUpdaterTask<JComponent> guiUpdater = new TextAreaUpdaterTask<JComponent>(m_fileViewTextArea);
					guiUpdater.setMessage(buf.toString());
					EventQueue.invokeLater(guiUpdater);	// update GUI on EDT
				};
				/*
				 * run command on background thread
				 */
				Thread t = new Thread(useCommandRunnable);
				t.start();		// start background thread 
//				StringBuffer buf = useCommand(m_fileNameField.getText());
//				TextAreaUpdaterTask<JComponent> guiUpdater = new TextAreaUpdaterTask<JComponent>(m_fileViewTextArea);
//				guiUpdater.setMessage(buf.toString());
//				EventQueue.invokeLater(guiUpdater);
			}
		});
        
		m_controlPanel.add(m_fileNameField);
        m_controlPanel.add(m_browseButton);
        m_controlPanel.add(fileRunButton);
        m_controlPanel.add(m_fileProgressBar);
        m_controlPanel.add(m_fileProgressBar);
		m_controlPanel.add(fileScrollPane);
        m_mainFrame.setVisible(true);
    }
    
	public StringBuffer useCommand(String cmd) {
		System.out.println(SwingControlDemo.class.getSimpleName() + ".useCommand('" + cmd + "')");
		StringBuffer rDataSB = new StringBuffer();
	    String line;
  
	    OutputStream stdin = null;
	    InputStream stderr = null;
	    InputStream stdout = null;

	      try {
			// launch EXE and grab stdin/stdout and stderr
			  Process process = Runtime.getRuntime ().exec (cmd);
			  stdin = process.getOutputStream ();
			  stderr = process.getErrorStream ();
			  stdout = process.getInputStream ();
			  
//			  // "write" the parms into stdin
//			  line = "param1" + "\n";   
//			  stdin.write(line.getBytes() );
//			  stdin.flush();
//
//			  line = "param2" + "\n";
//			  stdin.write(line.getBytes() );
//			  stdin.flush();
//
//			  line = "param3" + "\n";
//			  stdin.write(line.getBytes() );
//			  stdin.flush();

			  stdin.close();
			  
			  // clean up if any output in stdout
			  BufferedReader brCleanUp = 
			    new BufferedReader (new InputStreamReader (stdout));
			  while ((line = brCleanUp.readLine ()) != null) {
			    System.out.println ("[Stdout] " + line);
			    rDataSB.append("[Stdout] " + line + "\n");
			  }
			  brCleanUp.close();
			  
			  // clean up if any output in stderr
			  brCleanUp = 
			    new BufferedReader (new InputStreamReader (stderr));
			  while ((line = brCleanUp.readLine ()) != null) {
			    System.out.println ("[Stderr] " + line);
			    rDataSB.append("[Stderr] " + line + "\n");
			  }
			  brCleanUp.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(
					this.getClass().getSimpleName() +": "
					+ "ERROR: '"
					+ e.getMessage() + "'");
			e.printStackTrace();
		}
		return rDataSB;
	}

	/**
	 * udpDemo method
	 * 
	 * Demonstrate UDP Client Server Communication
	 * 1. UDP Client sends to UDP Server
	 * 2. THEN UDP Server returns received data, sending back to Client
	 * 3. UDP Receiver executes on NEW THREAD (multi-threaded Swing GUI code)
	 * 		a. Receiver blocks on NEW THREAD until data is received;
	 * 		b. Receiver starts Runnable to execute ON EDT (Swing is not multi-threaded safe)
	 * 		c. Runnable (TextAreaUpdaterTask) is responsible for updating GUI component;
	 * 		d. GUI is UPDATED (receive data written to GUI text area) when
	 * 			Runnable executes on Event Dispatch Thread (EDT)
	 * 4. ALL UDP Communication is taking place on THIS SAME MACHING (localhost)
	 * 
	 */
	public void udpDemo() {
		m_headerLabel.setText("Control in action: UDP Demo");

		m_hostField = new JTextField("localhost");
		m_portField = new JTextField(new Integer(UDPRecv.DEFAULT_PORT).toString());
		m_sendButton = new JButton("SEND");
		m_recvButton = new JButton("RECEIVE");
		m_sendViewTextArea = new JTextArea("", 5, 40);
		m_recvViewTextArea = new JTextArea("", 5, 40);

		JScrollPane sendScrollPane = new JScrollPane(m_sendViewTextArea);
		JScrollPane recvScrollPane = new JScrollPane(m_recvViewTextArea);
		m_sendViewTextArea.setText(
				"Click RECEUVE button FIRST (to enable receiver), THEN Type text in here and click SEND to transmit text.");
		m_recvViewTextArea
				.setText("Click RECEIVE button FIRST to enable receiver and receive text (in UPPERCASE) here.");

		/**
		 * RECEIVE BUTTON on UDP demo GUI
		 * 
		 * User must click RECEIVE button on GUI FIRST to start Server FIRST
		 * to make (enable) Receiver ready for Client send data
		 * 
		 * UDP Receive Server
		 * TCP/IP is Client Server
		 * Server must start FIRST
		 * Client will INITIATE data communication (send)
		 * 
		 * add action listeners for Buttons
		 * add action listener for Receive button using traditional anonymous inner class
		 * 
		 * ALL this UDP Server code executes on TWO threads:
		 * 		Event Dispatch Thread (EDT)
		 * 		NEW Background Thread for UDP Receiver
		 * 
		 * The order of execution is as follows:
		 * 	1. 	RECEIVE button listener invoked on the Event Dispatch Thread (EDT) upon User button click
		 * 	   	and starts a NEW background Thread dedicated ONLY for Receiver.
		 * 	2. 	Receiver execution started and then BLOCKING awaiting Client data transmission on background Thread.
		 * 	3. 	Receiver execution resumes AFTER BLOCKING upon receipt of Client send data on background Thread
		 * 	   	and queues Runnable (TextAreaUpdaterTask) on EDT to continue execution to update GUI.
		 * 	4. 	GUI Text area (m_recvViewTextArea) is updated with received data on the Event Dispatch Thread (EDT).
		 */
		m_recvButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/** 
				 * Text Area gives user information to CLICK RECEIVE button first
				 * THEN will contain data sent and received from the Client
				 */
				m_recvViewTextArea.setText("RECEIVER ENABLED ON PORT: " + Integer.parseInt(m_portField.getText()));
				/**
				 * Create a UDPRecv object to enable UDP Server to start Receiver
				 * 
				 * NOTES: 
				 *  1. THIS handler executes on the EDT when the RECEIVE button is clicked on GUI by user;
				 *  2. Create a UDP Receiver Runnable object (runnableUDPReceiver)
				 *     by calling a constructor with:
				 *  	a. EDT GUI update Runnable (TextAreaUpdaterTask)
				 *  	b. UDP port
				 *  3. Text Area (m_recvViewTextArea) will be used to display Received data on GUI
				 *     and is supplied to UDP Server (UDPRecv object) 
				 *  4. TextAreaUpdaterTask is a Runnable object
				 *     used to update a GUI JComponent (m_recvViewTextArea)
				 *     when it executes on the Event Dispatch Thread (EDT) after 
				 *     UDP Receiver receives data sent by UDP Client.
				 *     
				 * TCP/IP addressing Triple:
				 * 1. Host=localhost (name for THIS host,
				 * 2. Protocol=UDP,
				 * 3. UDP Port=4445
				 * 
				 */
				UDPRecv runnableUDPReceiver = new UDPRecv(new TextAreaUpdaterTask<JComponent>(m_recvViewTextArea),
						Integer.parseInt(m_portField.getText()));
//				m_recvViewTextArea.setText("RECEIVER ENABLED ON PORT: " + UDPRecv.DEFAULT_PORT);
//				UDPRecv obj = new UDPRecv(new TextAreaUpdaterTask<JComponent>(m_recvViewTextArea));
				// UDPRecv obj = new UDPRecv();
				// obj.recv(4445);
				/**
				 * Execute UDP Server Receiver runnable
				 * on a NEW (background) Thread and NOT on this EDT
				 * This was UDP Receiver can WAIT (blocking) until UDP Client Sends data
				 * (WITHOUT BLOCKING EDT).
				 */
				Thread t = new Thread(runnableUDPReceiver);
				t.start();
			}
		});
		/**
		 * SEND BUTTON on UDP demo GUI
		 * 
		 * User must click SEND button on GUI AFTER clicking RECEIVE button 
		 * to start Client (after Receiver is enabled) for Client to initiate send data
		 * 
		 * UDP Client initiates transmission with Send data
		 * 
		 * ALL this UDP Client code executes on the Event Dispatch Thread (EDT)
		 * add ActionListener for Send button using Lambda
		 */
		m_sendButton.addActionListener(e -> {
			String host = m_hostField.getText();
//			int port = new Integer(m_portField.getText());
			int port = Integer.parseInt(m_portField.getText());	// return int
//			int port = Integer.valueOf(m_portField.getText());	// returns Integer
			UDPSend obj = new UDPSend();
			/**
			 * UDP Client sends data to UDP Server Receiver
			 * NOTE: ALL UDP COMMUNICATON TAKES PLACE ON THIS MACHINE ONLY
			 * 
			 * TCP-IP Triple:
			 * Host=localhost, Protocol=UDP, UDP Port=4445
			 */
			
			obj.send("localhost", port, m_sendViewTextArea.getText().toUpperCase());
		});
//		// Define the panel to hold the buttons
//		JPanel panel = new JPanel();
//		panel.setLayout(new FlowLayout());
//		panel.add(m_sendButton);
//		panel.add(m_recvButton);
//		panel.add(sendScrollPane);
//		panel.add(recvScrollPane);

		// change to a more suitable layout
		m_controlPanel.setLayout(new GridLayout(3,2));	// GridLayout(rows, columns) 
		m_controlPanel.add(m_hostField);
		m_controlPanel.add(m_portField);
		m_controlPanel.add(m_sendButton);
		m_controlPanel.add(m_recvButton);
		m_controlPanel.add(sendScrollPane);
		m_controlPanel.add(recvScrollPane);
		//		m_controlPanel.add(panel);
		m_mainFrame.setVisible(true);
	}
    
	public void tcpDemo() {
		m_headerLabel.setText("Control in action: TCP Demo");

		m_recvButton = new JButton("RECEIVE");
		m_sendButton = new JButton("SEND");
		m_recvViewTextArea = new JTextArea("", 5, 20);

		JScrollPane recvScrollPane = new JScrollPane(m_recvViewTextArea);

		// add action listeners for buttons
		m_recvButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					Thread t = new GreetingServer(6066);
					t.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		m_sendButton.addActionListener(e -> {
			GreetingClient obj = new GreetingClient();
			obj.writeData(m_recvViewTextArea.getText());
//			obj.writeData(" my own data");
			obj.clientConnect("localhost", 6066);
		});

		m_controlPanel.add(m_recvButton);
		m_controlPanel.add(m_sendButton);
		m_controlPanel.add(recvScrollPane);
		m_mainFrame.setVisible(true);
	}
	
	public void agePersonList() {
		List<Person> persons = new ArrayList<>(); // container of Person objects
		
		persons.add(new Person(1, "Dan", "Peters", 17));
		persons.add(new Person(3, "Sam", "Peterson", 44));
		persons.add(new Person(2, "Jan", "Petersen", 23));
		persons.add(new Person(4, "Bill", "Johnson", 44));
		this.agePersonList(persons);
	}

	public void agePersonList(List<Person> list) {
		System.out.println("\n\t" + Person.class.getName() + ".agePerson()...");
		
		/**
		 * Original person list
		 */
		System.out.println("\n\t" +  "Show all persons: " + "\n");
		list.forEach(System.out::println);
		System.out.println();
		/**
		 * Age each person (1 additional year) if under 40 years old 
		 */
		System.out.println("\n\t" +  "Age all persons 1 year if under age 40: " + "\n");
		List<Person> agedPersons =
				
		list.stream()
		.map(p -> new Person(p.getId(), p.getFirstName(), p.getLastName(), 1+p.getAge()))
		.filter(p -> 40 >= p.getAge()) 	// persons younger than 40
		.sorted(Comparator.comparing(Person::getLastName))  // sort by last name

//		.forEach(System.out::println);	// output to stdout, a person per line
		
		.collect( toList() );
		agedPersons.forEach(System.out::println);	// output to stdout, a person per line
		
		this.personTable(agedPersons);
		
		System.out.println();
		
		System.out.println("\n\t" + Person.class.getName() + ".agePerson()... done!");		
	}
    public static void demo() {
    	/**
    	 * Execute UDP demo
    	 * using two NEW Threads and Console OUTPUT
    	 * WITHOUT A GUI
    	 */
//		UDPRecv.demo();

		SwingControlDemo obj = new SwingControlDemo();
		obj.udpDemo();	// demo EITHER UDP OR TCP but not both		
//		obj.tcpDemo();
		
//		obj.showComboboxDemo1();
//		obj.showListDemo();
//		obj.showRadioButtonDemo();
//		obj.showComboboxDemo2();
		
//		obj.tableDemo();
//		obj.scrollTableDemo();

//		obj.simpleTable();
//		obj.popupTable();
		
//		obj.personTableDemo();	// table model demo
//		obj.agePersonList();	// tablel of aged persons
		
//		obj.showClock();		// invokeLater thread and DateTime demo
//		obj.fileChooserDemo();
//		obj.fileRunDemo();	// execute a command
		
	}
}

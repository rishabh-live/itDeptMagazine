package itDeptMagazine;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Point;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Canvas;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.net.MalformedURLException;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import java.awt.GridLayout;

public class MainFrame {

	private JFrame frame;
	private final JPanel panel_4_4 = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("SMIT IT Dept Magazine");
		
		frame.setBounds(100, 100, 1045, 722);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Rectangle r =frame.getBounds();
		
		int windowHeight = r.height;
		
		final JPanel navigation_bar = new JPanel();
		navigation_bar.setBackground(new Color(51, 153, 255));
		navigation_bar.setBounds(0, -11, 224, windowHeight);
		frame.getContentPane().add(navigation_bar);
		navigation_bar.setLayout(null);
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(224, -61, 821, 746);
		frame.getContentPane().add(tabbedPane);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setRequestFocusEnabled(false);
		btnNewButton.setRolloverEnabled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Gargi", Font.BOLD, 20));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnNewButton.setBackground(new Color(0, 153, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(0);
				
			}
		});
		btnNewButton.setBounds(0, 198, 224, 44);
		navigation_bar.add(btnNewButton);
		
		JButton btnRead = new JButton("Read");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnRead.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRead.setRequestFocusEnabled(false);
		btnRead.setRolloverEnabled(false);
		btnRead.setForeground(Color.WHITE);
		btnRead.setFont(new Font("Gargi", Font.BOLD, 20));
		btnRead.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnRead.setBorderPainted(false);
		btnRead.setBorder(null);
		btnRead.setBackground(new Color(0, 153, 255));
		btnRead.setBounds(0, 239, 224, 44);
		navigation_bar.add(btnRead);
		
		JButton btnRead_1 = new JButton("About");
		btnRead_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		btnRead_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRead_1.setRolloverEnabled(false);
		btnRead_1.setRequestFocusEnabled(false);
		btnRead_1.setForeground(Color.WHITE);
		btnRead_1.setFont(new Font("Gargi", Font.BOLD, 20));
		btnRead_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnRead_1.setBorderPainted(false);
		btnRead_1.setBorder(null);
		btnRead_1.setBackground(new Color(0, 153, 255));
		btnRead_1.setBounds(0, 323, 224, 44);
		navigation_bar.add(btnRead_1);
		
		JButton btnNewButton_1 = new JButton("Write");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setRolloverEnabled(false);
		btnNewButton_1.setRequestFocusEnabled(false);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Gargi", Font.BOLD, 20));
		btnNewButton_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(0, 153, 255));
		btnNewButton_1.setBounds(0, 282, 224, 44);
		navigation_bar.add(btnNewButton_1);
		
		
		
		
		JPanel panel = new JPanel();
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		
		JButton btnNewButton_2_1 = new JButton("Request OTP");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RequestOtp otp = new RequestOtp();
				try {
					
					otp.send(textField.getText());
				
					tabbedPane.setSelectedIndex(4);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_2_1.setRolloverEnabled(false);
		btnNewButton_2_1.setRequestFocusEnabled(false);
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setFont(new Font("Gargi", Font.BOLD, 20));
		btnNewButton_2_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnNewButton_2_1.setBorderPainted(false);
		btnNewButton_2_1.setBorder(null);
		btnNewButton_2_1.setBackground(new Color(0, 153, 255));
		btnNewButton_2_1.setBounds(267, 413, 224, 44);
		panel.add(btnNewButton_2_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(0, 268, 816, 55);
		panel.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblCollegeEmailId = new JLabel("College Email ID");
		lblCollegeEmailId.setVerticalAlignment(SwingConstants.CENTER);
		lblCollegeEmailId.setFont(new Font("Gargi", Font.BOLD, 25));
		panel_5.add(lblCollegeEmailId);
		
		textField = new JTextField("my_email");
		textField.setFont(new Font("Gargi", Font.BOLD, 25));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setForeground(Color.RED);
		panel_5.add(textField);
		textField.setColumns(10);
		textField.setBorder(new EmptyBorder(0, 0, 0, 0));
		//textField.setVerticalAlignment(SwingConstants.BOTTOM);
		
		JLabel lblCollegeEmailId_1 = new JLabel("@smit.smu.edu.in");
		lblCollegeEmailId_1.setVerticalAlignment(SwingConstants.CENTER);
		lblCollegeEmailId_1.setFont(new Font("Gargi", Font.BOLD, 25));
		panel_5.add(lblCollegeEmailId_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setIcon(new ImageIcon("/hdd/industrial trainong/vsem/src code/itDeptMagazine/itDeptMagazine/images/smit-logo.png"));
		lblNewLabel_5.setBounds(0, 25, 816, 158);
		panel.add(lblNewLabel_5);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		panel_1.setAutoscrolls(true);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(12, 116, 784, 122);
		panel_4.setBackground(Color.WHITE);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnReadMore = new JButton("Read More");
		btnReadMore.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReadMore.setRolloverEnabled(false);
		btnReadMore.setRequestFocusEnabled(false);
		btnReadMore.setForeground(Color.WHITE);
		btnReadMore.setFont(new Font("Gargi", Font.BOLD, 20));
		btnReadMore.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnReadMore.setBorderPainted(false);
		btnReadMore.setBorder(null);
		btnReadMore.setBackground(Color.RED);
		btnReadMore.setBounds(548, 66, 224, 44);
		panel_4.add(btnReadMore);
		
		JLabel lblNewLabel = new JLabel("Very Awsome Title");
		lblNewLabel.setForeground(new Color(51, 153, 255));
		lblNewLabel.setFont(new Font("FreeSans", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 784, 44);
		panel_4.add(lblNewLabel);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBackground(Color.WHITE);
		panel_4_1.setBounds(12, 270, 784, 122);
		panel_1.add(panel_4_1);
		
		JButton btnReadMore_1 = new JButton("Read More");
		btnReadMore_1.setRolloverEnabled(false);
		btnReadMore_1.setRequestFocusEnabled(false);
		btnReadMore_1.setForeground(Color.WHITE);
		btnReadMore_1.setFont(new Font("Gargi", Font.BOLD, 20));
		btnReadMore_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnReadMore_1.setBorderPainted(false);
		btnReadMore_1.setBorder(null);
		btnReadMore_1.setBackground(Color.RED);
		btnReadMore_1.setBounds(548, 66, 224, 44);
		panel_4_1.add(btnReadMore_1);
		
		JLabel lblNewLabel_1 = new JLabel("Very Awsome Title");
		lblNewLabel_1.setForeground(new Color(51, 153, 255));
		lblNewLabel_1.setFont(new Font("FreeSans", Font.BOLD, 25));
		lblNewLabel_1.setBounds(0, 0, 784, 44);
		panel_4_1.add(lblNewLabel_1);
		
		JPanel panel_4_2 = new JPanel();
		panel_4_2.setLayout(null);
		panel_4_2.setBackground(Color.WHITE);
		panel_4_2.setBounds(12, 449, 784, 122);
		panel_1.add(panel_4_2);
		
		JButton btnReadMore_2 = new JButton("Read More");
		btnReadMore_2.setRolloverEnabled(false);
		btnReadMore_2.setRequestFocusEnabled(false);
		btnReadMore_2.setForeground(Color.WHITE);
		btnReadMore_2.setFont(new Font("Gargi", Font.BOLD, 20));
		btnReadMore_2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnReadMore_2.setBorderPainted(false);
		btnReadMore_2.setBorder(null);
		btnReadMore_2.setBackground(Color.RED);
		btnReadMore_2.setBounds(548, 66, 224, 44);
		panel_4_2.add(btnReadMore_2);
		
		JLabel lblNewLabel_2 = new JLabel("Very Awsome Title");
		lblNewLabel_2.setForeground(new Color(51, 153, 255));
		lblNewLabel_2.setFont(new Font("FreeSans", Font.BOLD, 25));
		lblNewLabel_2.setBounds(0, 0, 784, 44);
		panel_4_2.add(lblNewLabel_2);
		
		JPanel panel_4_3 = new JPanel();
		panel_4_3.setLayout(null);
		panel_4_3.setBackground(Color.WHITE);
		panel_4_3.setBounds(12, 597, 784, 122);
		panel_1.add(panel_4_3);
		
		JButton btnReadMore_3 = new JButton("Read More");
		btnReadMore_3.setRolloverEnabled(false);
		btnReadMore_3.setRequestFocusEnabled(false);
		btnReadMore_3.setForeground(Color.WHITE);
		btnReadMore_3.setFont(new Font("Gargi", Font.BOLD, 20));
		btnReadMore_3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnReadMore_3.setBorderPainted(false);
		btnReadMore_3.setBorder(null);
		btnReadMore_3.setBackground(Color.RED);
		btnReadMore_3.setBounds(548, 66, 224, 44);
		panel_4_3.add(btnReadMore_3);
		
		JLabel lblNewLabel_3 = new JLabel("Very Awsome Title");
		lblNewLabel_3.setForeground(new Color(51, 153, 255));
		lblNewLabel_3.setFont(new Font("FreeSans", Font.BOLD, 25));
		lblNewLabel_3.setBounds(0, 0, 784, 44);
		panel_4_3.add(lblNewLabel_3);
		panel_4_4.setBounds(0, 0, 0, 0);
		panel_1.add(panel_4_4);
		panel_4_4.setLayout(null);
		panel_4_4.setBackground(Color.WHITE);
		
		JButton btnReadMore_4 = new JButton("Read More");
		btnReadMore_4.setRolloverEnabled(false);
		btnReadMore_4.setRequestFocusEnabled(false);
		btnReadMore_4.setForeground(Color.WHITE);
		btnReadMore_4.setFont(new Font("Gargi", Font.BOLD, 20));
		btnReadMore_4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnReadMore_4.setBorderPainted(false);
		btnReadMore_4.setBorder(null);
		btnReadMore_4.setBackground(Color.RED);
		btnReadMore_4.setBounds(548, 66, 224, 44);
		panel_4_4.add(btnReadMore_4);
		
		JLabel lblNewLabel_4 = new JLabel("Very Awsome Title");
		lblNewLabel_4.setForeground(new Color(51, 153, 255));
		lblNewLabel_4.setFont(new Font("FreeSans", Font.BOLD, 25));
		lblNewLabel_4.setBounds(0, 0, 784, 44);
		panel_4_4.add(lblNewLabel_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblWrite = new JLabel("Write");
		lblWrite.setBounds(322, 322, 70, 15);
		panel_2.add(lblWrite);
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(new Color(30, 144, 255));
		panel_3.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblAbout = new JLabel("");
		lblAbout.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbout.setIcon(new ImageIcon("/hdd/industrial trainong/vsem/src code/itDeptMagazine/itDeptMagazine/images/smit-logo.png"));
		lblAbout.setBounds(0, 26, 816, 126);
		panel_3.add(lblAbout);
		
		JLabel lblAbout_1 = new JLabel("ABOUT");
		lblAbout_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAbout_1.setFont(new Font("Gargi", Font.PLAIN, 40));
		lblAbout_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbout_1.setBounds(0, 164, 816, 82);
		panel_3.add(lblAbout_1);
		
		JLabel lblMadeBy = new JLabel("Made By : ");
		lblMadeBy.setBounds(267, 317, 108, 27);
		panel_3.add(lblMadeBy);
		
		JLabel lblRishabh = new JLabel("RIshabh");
		lblRishabh.setBounds(462, 317, 108, 27);
		panel_3.add(lblRishabh);
		
		JLabel lblDated = new JLabel("Dated  : ");
		lblDated.setBounds(267, 375, 108, 27);
		panel_3.add(lblDated);
		
		JLabel lblAug = new JLabel("15 Aug 2021");
		lblAug.setBounds(462, 375, 108, 27);
		panel_3.add(lblAug);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel_6.setBackground(Color.WHITE);
		tabbedPane.addTab("New tab", null, panel_6, null);
		
		JButton btnNewButton_2_1_1 = new JButton("Confirm OTP");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2_1_1.setRolloverEnabled(false);
		btnNewButton_2_1_1.setRequestFocusEnabled(false);
		btnNewButton_2_1_1.setForeground(Color.WHITE);
		btnNewButton_2_1_1.setFont(new Font("Gargi", Font.BOLD, 20));
		btnNewButton_2_1_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnNewButton_2_1_1.setBorderPainted(false);
		btnNewButton_2_1_1.setBorder(null);
		btnNewButton_2_1_1.setBackground(new Color(0, 153, 255));
		btnNewButton_2_1_1.setBounds(267, 413, 224, 44);
		panel_6.add(btnNewButton_2_1_1);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBackground(Color.WHITE);
		panel_5_1.setBounds(0, 269, 816, 55);
		panel_6.add(panel_5_1);
		panel_5_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblCollegeEmailId_2 = new JLabel("Enter OTP        ");
		lblCollegeEmailId_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCollegeEmailId_2.setVerticalAlignment(SwingConstants.CENTER);
		lblCollegeEmailId_2.setFont(new Font("Gargi", Font.BOLD, 25));
		panel_5_1.add(lblCollegeEmailId_2);
		
		textField_1 = new JTextField("#######");
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setForeground(Color.RED);
		textField_1.setFont(new Font("Gargi", Font.BOLD, 25));
		textField_1.setColumns(10);
		textField_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_5_1.add(textField_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon("/hdd/industrial trainong/vsem/src code/itDeptMagazine/itDeptMagazine/images/smit-logo.png"));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setBounds(0, 25, 816, 158);
		panel_6.add(lblNewLabel_5_1);
		
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				Rectangle r =frame.getBounds();
				int windowHeight = r.height;
				int windowWidth = r.width;
				
				navigation_bar.setBounds(0, -11, 224, windowHeight);
				tabbedPane.setBounds(224, -61, windowWidth, windowHeight+30);
				
				
				
				
			}
		});
	}

	public boolean getFrameAlwaysOnTop() {
		return frame.isAlwaysOnTop();
	}
	public void setFrameAlwaysOnTop(boolean alwaysOnTop) {
		frame.setAlwaysOnTop(alwaysOnTop);
	}
}

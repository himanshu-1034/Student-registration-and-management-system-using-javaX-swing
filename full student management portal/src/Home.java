import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class Home {

	public JFrame homeframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.homeframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		homeframe = new JFrame();
		homeframe.getContentPane().setForeground(Color.WHITE);
		homeframe.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(10, 10, 780, 771);
		homeframe.getContentPane().add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 10, 728, 22);
		
		panel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Home");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				homeframe.setVisible(false);
				Home obj = new Home();
				obj.homeframe.setVisible(true);
				
				
			}
		});
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
		Image img = new ImageIcon(this.getClass().getResource("/home.png")).getImage();
		mntmNewMenuItem.setIcon(new ImageIcon(img));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("LogOut");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				homeframe.setVisible(false);
				Login login = new Login();
				login.frmStudentManagementSystem.setVisible(true);
				
			}
		});
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		Image img1 = new ImageIcon(this.getClass().getResource("/logout.png")).getImage();
		mntmNewMenuItem_1.setIcon(new ImageIcon(img1));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JLabel lblNewLabel = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img2));
		lblNewLabel.setBounds(234, 42, 325, 185);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				homeframe.setVisible(false);
				addStudent addstudent = new addStudent();
				addstudent.setVisible(true);
				
			}
		});
		Image img3 = new ImageIcon(this.getClass().getResource("/AddStudent.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img3));
		btnNewButton.setBounds(66, 250, 190, 190);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homeframe.setVisible(false);
				Studentsettings obj = new Studentsettings();
				obj.setVisible(true);
			}
		});
		Image img4 = new ImageIcon(this.getClass().getResource("/configuration.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img4));
		btnNewButton_1.setBounds(300, 250, 190, 190);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				homeframe.setVisible(false);
				showStudent obj = new showStudent();
				obj.setVisible(true);
				
			}
		});
		Image img5 = new ImageIcon(this.getClass().getResource("/showStudent.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(img5));
		btnNewButton_2.setBounds(533, 250, 182, 190);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Add Student");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(96, 450, 124, 31);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Operation");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(359, 450, 93, 31);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Show students");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(558, 450, 138, 31);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				homeframe.setVisible(false);
				Addadmin obj = new Addadmin();
				obj.setVisible(true);
				
			}
		});
		Image img6 = new ImageIcon(this.getClass().getResource("/addAdmin.png")).getImage();
		btnNewButton_3.setIcon(new ImageIcon(img6));
		btnNewButton_3.setBounds(66, 491, 190, 190);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				homeframe.setVisible(false);
				Adminsettings obj = new Adminsettings();
				obj.setVisible(true);
				
			}
		});
		Image img7 = new ImageIcon(this.getClass().getResource("/configuration1.png")).getImage();
		btnNewButton_3_1.setIcon(new ImageIcon(img7));
		btnNewButton_3_1.setBounds(300, 491, 190, 190);
		panel.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_2 = new JButton("");
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				homeframe.setVisible(false);
				Showadmin obj = new Showadmin();
				obj.setVisible(true);
				
			}
		});
		Image img8 = new ImageIcon(this.getClass().getResource("/showAdmin.png")).getImage();
		btnNewButton_3_2.setIcon(new ImageIcon(img8));
		btnNewButton_3_2.setBounds(533, 491, 190, 190);
		panel.add(btnNewButton_3_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Add Admin");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(96, 698, 117, 31);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("operation");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(354, 698, 98, 31);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Show Admin");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(558, 698, 138, 31);
		panel.add(lblNewLabel_1_3);
		homeframe.setTitle("Home page");
		homeframe.setForeground(Color.WHITE);
		homeframe.setResizable(false);
		homeframe.setBounds(100, 100, 804, 819);
		homeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

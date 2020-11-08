import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

public class addStudent extends JFrame {

	public JPanel addstudentcontentPane;
	private JTextField name;
	private JTextField fathersname;
	private JTextField city;
	private JTextField phonenumber;
	private JTextField classtextfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addStudent frame = new addStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	

	/**
	 * Create the frame.
	 */
	public addStudent() {
		
		con = connect_to_oracle.connecttooracle();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/AddStudent.png")));
		setTitle("Add Student");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 811);
		addstudentcontentPane = new JPanel();
		addstudentcontentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(addstudentcontentPane);
		addstudentcontentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 521, 763);
		addstudentcontentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(42, 129, 138, 33);
		panel.add(lblNewLabel);
		
		JLabel lblFathersName = new JLabel("Father's Name:");
		lblFathersName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFathersName.setBounds(42, 226, 138, 33);
		panel.add(lblFathersName);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCity.setBounds(42, 324, 138, 33);
		panel.add(lblCity);
		
		JLabel lblBloodType = new JLabel("Blood Type:");
		lblBloodType.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBloodType.setBounds(42, 421, 138, 33);
		panel.add(lblBloodType);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhoneNumber.setBounds(42, 529, 138, 33);
		panel.add(lblPhoneNumber);
		
		JLabel lblClass = new JLabel("Class:");
		lblClass.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClass.setBounds(42, 643, 138, 33);
		panel.add(lblClass);
		
		name = new JTextField();
		name.setBounds(305, 138, 138, 24);
		panel.add(name);
		name.setColumns(10);
		
		fathersname = new JTextField();
		fathersname.setColumns(10);
		fathersname.setBounds(305, 235, 138, 24);
		panel.add(fathersname);
		
		city = new JTextField();
		city.setColumns(10);
		city.setBounds(305, 333, 138, 24);
		panel.add(city);
		
		phonenumber = new JTextField();
		phonenumber.setColumns(10);
		phonenumber.setBounds(305, 538, 138, 24);
		panel.add(phonenumber);
		
		classtextfield = new JTextField();
		classtextfield.setColumns(10);
		classtextfield.setBounds(305, 652, 138, 24);
		panel.add(classtextfield);
		classtextfield.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            String value = classtextfield.getText();
	            int l = value.length();
	            if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')|| (ke.getKeyCode()==8)) {
	            	classtextfield.setEditable(true);
	               
	            } else {
	            	classtextfield.setEditable(false);
	               }
	         }
	      });
		
		JComboBox bloodtype = new JComboBox();
		bloodtype.setModel(new DefaultComboBoxModel(new String[] {"choose from below", "A+", "A-", "AB+", "AB-", "B+", "B-", "O+", "O-"}));
		bloodtype.setBounds(305, 429, 138, 25);
		panel.add(bloodtype);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					stmt = con.createStatement();
					String stdname = name.getText();
					
					int i = bloodtype.getSelectedIndex();
					String stdblood;
					if(i==0)
						stdblood="N.A.";
					else {
					stdblood = (String) bloodtype.getSelectedItem();
					}
					String stdfather = fathersname.getText();
					String stdcity = city.getText();
					String stdphone = phonenumber.getText();
					int stdclass = Integer.parseInt(classtextfield.getText());
					
					String sql = "insert into student values (student_id.nextval,'"+stdname+"','"+stdfather+"','"+stdblood+"','"+stdphone+"','"+stdcity+"',"+stdclass+")";
					
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Data inserted into Our database.");
					
					
					name.setText("");
					fathersname.setText("");
					city.setText("");
					classtextfield.setText("");
					phonenumber.setText("");
					bloodtype.setSelectedIndex(0);
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/submit.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img2));
		btnNewButton.setBounds(42, 702, 138, 38);
		panel.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home obj = new Home();
				obj.homeframe.setVisible(true);
			}
		});
		Image img3 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack.setIcon(new ImageIcon(img3));
		btnBack.setBounds(305, 702, 138, 38);
		panel.add(btnBack);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 521, 22);
		panel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Home");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
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
				setVisible(false);
				Login login = new Login();
				login.frmStudentManagementSystem.setVisible(true);
				
			}
		});
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		Image img1 = new ImageIcon(this.getClass().getResource("/logout.png")).getImage();
		mntmNewMenuItem_1.setIcon(new ImageIcon(img1));
		mnNewMenu.add(mntmNewMenuItem_1);
	}
}

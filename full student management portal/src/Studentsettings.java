import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Studentsettings extends JFrame {

	private JPanel contentPane;
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
					Studentsettings frame = new Studentsettings();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	Connection con=null;
	Statement stmt = null;
	ResultSet rs;
	private JTextField bloodtype;
	private JTextField id;
	

	public Studentsettings() {
		
		con = connect_to_oracle.connecttooracle();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/configuration.png")));
		setTitle("Settings");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 811);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 588, 763);
		contentPane.add(panel);
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
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					stmt = con.createStatement();
			String stdname = name.getText();
					
					
					String stdblood = bloodtype.getText();
					String stdfather = fathersname.getText();
					String stdcity = city.getText();
					String stdphone = phonenumber.getText();
					int stdclass = Integer.parseInt(classtextfield.getText());
					int stdid = Integer.parseInt(id.getText());
					String sql = "update student set stdname='"+stdname+"',stdfathername='"+stdfather+"',stdblood='"+stdblood+"',stdphone='"+stdphone+"',stdcity='"+stdcity+"',class="+stdclass+" where id="+stdid;
					
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(contentPane, "Updation succeeded...");
					
					name.setText("");
					fathersname.setText("");
					city.setText("");
					classtextfield.setText("");
					phonenumber.setText("");
					bloodtype.setText("");
					id.setText("");
					
					
					
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
		Image img4 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack.setIcon(new ImageIcon(img4));
		btnBack.setBounds(305, 702, 138, 38);
		panel.add(btnBack);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 586, 22);
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
		Image img5 = new ImageIcon(this.getClass().getResource("/home.png")).getImage();
		mntmNewMenuItem.setIcon(new ImageIcon(img5));
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
		Image img6 = new ImageIcon(this.getClass().getResource("/logout.png")).getImage();
		mntmNewMenuItem_1.setIcon(new ImageIcon(img6));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					stmt = con.createStatement();
					int stdid = Integer.parseInt(id.getText());
					String sql = "select * from student where id ="+stdid;
					rs = stmt.executeQuery(sql);
					if(rs.next()) {
						
						name.setText(rs.getString("stdname"));
						fathersname.setText(rs.getString("stdfathername"));
						city.setText(rs.getString("stdcity"));
						bloodtype.setText(rs.getString("stdblood"));
						phonenumber.setText(rs.getString("stdphone"));
						classtextfield.setText(String.format("%s", rs.getInt("class")));
						
						
					}else {
						JOptionPane.showMessageDialog(contentPane, "Record Not Found");
					}
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/loupe.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img));
		btnNewButton_1.setBounds(453, 49, 117, 36);
		panel.add(btnNewButton_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					stmt = con.createStatement();
					int stdid = Integer.parseInt(id.getText());
					String sql= "delete from student where id="+stdid;
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(contentPane, "Record deleted");
					setVisible(false);
					showStudent obj =new showStudent();
					obj.setVisible(true);
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		Image img3 = new ImageIcon(this.getClass().getResource("/cancel1.png")).getImage();
		btnDelete.setIcon(new ImageIcon(img3));
		btnDelete.setBounds(190, 702, 104, 38);
		panel.add(btnDelete);
		
		bloodtype = new JTextField();
		bloodtype.setColumns(10);
		bloodtype.setBounds(305, 430, 138, 24);
		panel.add(bloodtype);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(305, 56, 138, 24);
		id.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            String value = id.getText();
	            int l = value.length();
	            if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')|| (ke.getKeyCode()==8)) {
	            	id.setEditable(true);
	               
	            } else {
	            	id.setEditable(false);
	               }
	         }
	      });
		panel.add(id);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStudentId.setBounds(42, 47, 138, 33);
		panel.add(lblStudentId);
	}
}

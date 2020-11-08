import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	public JFrame frmStudentManagementSystem;
	private JPasswordField password;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmStudentManagementSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	
	public Login() {
		con = connect_to_oracle.connecttooracle();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudentManagementSystem = new JFrame();
		frmStudentManagementSystem.setTitle("Student management system");
		frmStudentManagementSystem.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 18));
		frmStudentManagementSystem.setBackground(Color.LIGHT_GRAY);
		frmStudentManagementSystem.setResizable(false);
		frmStudentManagementSystem.setBounds(100, 100, 524, 414);
		frmStudentManagementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudentManagementSystem.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.GRAY);
		panel.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Login portal Wizard", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Login Portal Wizard", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 500, 366);
		frmStudentManagementSystem.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("E-Mail :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(82, 138, 69, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(82, 207, 98, 31);
		panel.add(lblNewLabel_1);
		
		password = new JPasswordField();
		password.setBounds(300, 213, 137, 19);
		panel.add(password);
		
		email = new JTextField();
		email.setBounds(300, 141, 137, 19);
		panel.add(email);
		email.setColumns(10);
		
		JButton btnNewButton = new JButton("   LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				try {
					stmt = con.createStatement();

					String useremail = email.getText();
					String userpassword = password.getText();
					
					String sql = "select * from admin where mail= '"+useremail+"' and password='"+userpassword+"'";
					rs = stmt.executeQuery(sql);
					
					if(rs.next()) {
						frmStudentManagementSystem.setVisible(false);
						Home homeobj =new Home();
						homeobj.homeframe.setVisible(true);
						
					}else {
						JOptionPane.showMessageDialog(null, "Password or Email is invalid");
					}
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/login1.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img1));
		btnNewButton.setBounds(82, 287, 138, 31);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("   CANCEL");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/cancel1.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img2));
		btnNewButton_1.setBounds(271, 285, 128, 33);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(Color.GRAY);
		Image img = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(173, 10, 252, 95);
		panel.add(lblNewLabel_2);
	}
}

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class Addadmin extends JFrame {

	private JPanel contentPane;
	private JTextField adminname;
	private JTextField adminmail;
	private JPasswordField adminpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addadmin frame = new Addadmin();
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
	
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	
	public Addadmin() {
		
		con = connect_to_oracle.connecttooracle();
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/addAdmin.png")));
		setTitle("Add Admin");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

JMenuBar menuBar = new JMenuBar();
menuBar.setBounds(0, 0, 515, 22);
contentPane.add(menuBar);

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
JPanel panel = new JPanel();
panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "ADD ADMIN", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
panel.setBounds(0, 23, 515, 537);
contentPane.add(panel);
panel.setLayout(null);
JLabel lblNewLabel = new JLabel("Name :");
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
lblNewLabel.setBounds(46, 89, 134, 37);
panel.add(lblNewLabel);
JLabel lblEmail = new JLabel("E-Mail :");
lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
lblEmail.setBounds(46, 209, 134, 37);
panel.add(lblEmail);
JLabel lblPassword = new JLabel("Password :");
lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
lblPassword.setBounds(46, 337, 134, 37);
panel.add(lblPassword);
adminname = new JTextField();
adminname.setBounds(280, 89, 175, 30);
panel.add(adminname);
adminname.setColumns(10);
adminmail = new JTextField();
adminmail.setColumns(10);
adminmail.setBounds(280, 220, 175, 30);
panel.add(adminmail);
adminpass = new JPasswordField();
adminpass.setBounds(280, 348, 175, 30);
panel.add(adminpass);
JButton btnNewButton = new JButton("Submit");
btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		try {
			stmt = con.createStatement();
			String name = adminname.getText();
			String mail = adminmail.getText();
			String password = adminpass.getText();
			
			String sql = "insert into admin values (admin_id.nextval,'"+mail+"','"+password+"','"+name+"')";
			
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(contentPane, "Admin inserted successfully");
			
			adminname.setText("");
			adminmail.setText("");
			adminpass.setText("");
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
});
Image img2 = new ImageIcon(this.getClass().getResource("/submit.png")).getImage();
btnNewButton.setIcon(new ImageIcon(img2));
btnNewButton.setBounds(46, 456, 134, 42);
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
btnBack.setBounds(280, 456, 134, 42);
panel.add(btnBack);
		
		
		
	}
}

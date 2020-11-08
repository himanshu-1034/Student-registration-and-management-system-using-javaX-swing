import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.sql.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.border.TitledBorder;

public class Adminsettings extends JFrame {

	private JPanel contentPane;
	private JTextField adminname;
	private JTextField adminmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminsettings frame = new Adminsettings();
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
	Statement stmt=null;
	ResultSet rs=null;
	private JTextField adminid;
	private JTextField adminpass;
	public Adminsettings() {
		con = connect_to_oracle.connecttooracle();
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/configuration1.png")));
		setTitle("Admin Settings");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 473, 22);
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
panel.setBounds(0, 23, 473, 537);
contentPane.add(panel);
panel.setLayout(null);
JLabel lblNewLabel = new JLabel("Name :");
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
lblNewLabel.setBounds(46, 164, 134, 37);
panel.add(lblNewLabel);
JLabel lblEmail = new JLabel("E-Mail :");
lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
lblEmail.setBounds(46, 246, 134, 37);
panel.add(lblEmail);
JLabel lblPassword = new JLabel("Password :");
lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
lblPassword.setBounds(46, 337, 134, 37);
panel.add(lblPassword);
adminname = new JTextField();
adminname.setBounds(247, 170, 175, 30);
panel.add(adminname);
adminname.setColumns(10);
adminmail = new JTextField();
adminmail.setColumns(10);
adminmail.setBounds(247, 252, 175, 30);
panel.add(adminmail);
JButton btnNewButton = new JButton("Update");
btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		try {
			stmt = con.createStatement();
			String name = adminname.getText();
			String mail = adminmail.getText();
			String password = adminpass.getText();
			int id = Integer.parseInt(adminid.getText());
			String sql = "update admin set mail='"+mail+"',password='"+password+"',name='"+name+"' where id="+id;
			
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(contentPane, "Admin data updated successfully");
			
			adminname.setText("");
			adminmail.setText("");
			adminpass.setText("");
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
});
Image img3 = new ImageIcon(this.getClass().getResource("/submit.png")).getImage();
btnNewButton.setIcon(new ImageIcon(img3));
btnNewButton.setBounds(46, 418, 120, 42);
panel.add(btnNewButton);
JButton btnBack = new JButton("Back");
btnBack.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		setVisible(false);
		Home obj = new Home();
		obj.homeframe.setVisible(true);
		
	}
});
Image img5 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
btnBack.setIcon(new ImageIcon(img5));
btnBack.setBounds(302, 418, 120, 42);
panel.add(btnBack);
JLabel lblId = new JLabel("ID:");
lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
lblId.setBounds(46, 28, 134, 37);
panel.add(lblId);
adminid = new JTextField();
adminid.setColumns(10);
adminid.setBounds(247, 34, 175, 30);
adminid.addKeyListener(new KeyAdapter() {
    public void keyPressed(KeyEvent ke) {
       String value = adminid.getText();
       int l = value.length();
       if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')|| (ke.getKeyCode()==8)) {
    	   adminid.setEditable(true);
          
       } else {
    	   adminid.setEditable(false);
          }
    }
 });

panel.add(adminid);
adminpass = new JTextField();
adminpass.setColumns(10);
adminpass.setBounds(247, 348, 175, 30);
panel.add(adminpass);
JButton btnSearch = new JButton("Search");
btnSearch.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		try {
			stmt = con.createStatement();
			int id = Integer.parseInt(adminid.getText());
			String sql = "select * from admin where id="+id;
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				adminname.setText(rs.getString(4));
				adminmail.setText(rs.getString(2));
				adminpass.setText(rs.getString(3));
			}else {
				JOptionPane.showMessageDialog(contentPane, "Your search doesn't exist in our database");
				adminname.setText("");
				adminmail.setText("");
				adminpass.setText("");
				
			}
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
});
Image img2 = new ImageIcon(this.getClass().getResource("/loupe.png")).getImage();
btnSearch.setIcon(new ImageIcon(img2));
btnSearch.setBounds(152, 97, 134, 42);
panel.add(btnSearch);
JButton btnDelete = new JButton("Delete");
btnDelete.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		try {
			stmt =con.createStatement();
			int id = Integer.parseInt(adminid.getText());
			String sql = "delete from admin where id="+id;
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(contentPane, "Admin deleted successfully");
			adminname.setText("");
			adminmail.setText("");
			adminpass.setText("");
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
});
Image img4 = new ImageIcon(this.getClass().getResource("/cancel1.png")).getImage();
btnDelete.setIcon(new ImageIcon(img4));
btnDelete.setBounds(172, 418, 120, 42);
panel.add(btnDelete);

		
		
		
		
	}

}

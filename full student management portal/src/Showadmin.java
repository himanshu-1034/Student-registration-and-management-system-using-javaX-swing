import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class Showadmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Showadmin frame = new Showadmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	Connection con = null;
	Statement stmt = null;
	private JTable table_1;
	//ResultSet rs;
	
	
	/**
	 * Create the frame.
	 */
	public Showadmin() {
		con = connect_to_oracle.connecttooracle();
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/showAdmin.png")));
		setTitle("All Admins");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "ADMINS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home obj = new Home();
				obj.homeframe.setVisible(true);
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.setBounds(217, 441, 121, 42);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 46, 500, 350);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table_1);
		
	
		Showrecord();
		
	}
	
	public void Showrecord() {
		
		try {
			stmt=con.createStatement();
			String sql1 = "select * from admin";
			ResultSet res = stmt.executeQuery(sql1);
			
			ResultSetMetaData rsmd = res.getMetaData();
			int c = rsmd.getColumnCount();
			DefaultTableModel tm = new DefaultTableModel();
			//tm.setRowCount(0);
			for(int i=1;i<=c;i++) {
				tm.addColumn(rsmd.getColumnName(i));
			}
			Object[] v = new Object[c];
			while(res.next()) {
				
				
				for(int i = 0; i < c; i++) {
                    v[i] = res.getObject(i+1);
                 //   System.out.print("1-");
             }
				
				tm.addRow(v);
				//System.out.print("2-");
				
				
			}
			table_1.setModel(tm);
			//System.out.print("3-");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print(e);
			e.printStackTrace();
		}
		
	}




}







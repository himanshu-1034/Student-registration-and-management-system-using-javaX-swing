import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Image;

import javax.swing.table.DefaultTableModel;


import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class showStudent extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showStudent frame = new showStudent();
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
	public showStudent() {
		con = connect_to_oracle.connecttooracle();
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/showStudent.png")));
		setTitle("All Students");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "STUDENTS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		btnNewButton.setBounds(346, 459, 121, 42);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 46, 700, 350);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table_1);
		
	
		Showrecord();
		
	}
	
	public void Showrecord() {
		
		try {
			stmt=con.createStatement();
			String sql1 = "select * from student";
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





































//table_1.setModel(new DefaultTableModel(
//new Object[][] {
//	{null, null, null, null, null, null, null},
//	{null, null, null, null, null, null, null},
//	{null, null, null, null, null, null, null},
//	{null, null, null, null, null, null, null},
//	{null, null, null, null, null, null, null},
//	{null, null, null, null, null, null, null},
//	{null, null, null, null, null, null, null},
//	{null, null, null, null, null, null, null},
//	{null, null, null, null, null, null, null},
//	{null, null, null, null, null, null, null},
//},
//new String[] {
//	"New column", "New column", "New column", "New column", "New column", "New column", "New column"
//}
//));

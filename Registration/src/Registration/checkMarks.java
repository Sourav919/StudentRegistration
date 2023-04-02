package Registration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

public class checkMarks {

	private JFrame frame;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkMarks window = new checkMarks();
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
	public checkMarks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 626, 418);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lb1 = new JLabel("Name:");
		lb1.setForeground(new Color(204, 255, 255));
		lb1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb1.setBounds(320, 115, 154, 34);
		frame.getContentPane().add(lb1);
		
		JLabel lb2 = new JLabel("Marks:");
		lb2.setForeground(new Color(204, 255, 255));
		lb2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb2.setBounds(320, 187, 161, 34);
		frame.getContentPane().add(lb2);
		
		JLabel sno = new JLabel("Roll No.:");
		sno.setForeground(new Color(204, 255, 255));
		sno.setFont(new Font("Times New Roman", Font.BOLD, 18));
		sno.setBounds(61, 115, 99, 34);
		frame.getContentPane().add(sno);
		
		t1 = new JTextField();
		t1.setBackground(new Color(255, 255, 255));
		t1.setBounds(151, 114, 89, 34);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		JButton btnNewButton = new JButton("ENTER");
		btnNewButton.setForeground(new Color(204, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String s=t1.getText();
				int roll=Integer.parseInt(s);
				
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iot","root","Sourav14#");
					String q="select name,marks from student where roll=?";
					PreparedStatement ps=con.prepareStatement(q);
					ps.setInt(1, roll);
					ResultSet rs=ps.executeQuery();
					rs.next();
					lb1.setText("Name: "+rs.getString(1));
					lb2.setText("Marks: "+rs.getString(2));
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(151, 188, 89, 39);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Retrive Marks");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(199, 27, 187, 34);
		frame.getContentPane().add(lblNewLabel);
	}
}
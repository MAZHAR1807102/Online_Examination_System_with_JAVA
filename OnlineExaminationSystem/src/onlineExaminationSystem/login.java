package onlineExaminationSystem;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.sql.*;
import java.awt.event.ActionListener;







@SuppressWarnings("unused")
public class login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TxtUsername;
	private JPasswordField pwdPassword;
	private static JLabel ltext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 139), 3));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 51, 51)));
		panel.setBackground(new Color(255, 204, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel user = new JPanel();
		user.setBorder(null);
		user.setBounds(185, 296, 326, 38);
		user.setBackground(new Color(255, 255, 204));
		panel.add(user);
		user.setLayout(null);
		
		TxtUsername = new JTextField();
		TxtUsername.setBackground(new Color(255, 255, 204));
		TxtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(TxtUsername.getText().equals("Username")) {
					TxtUsername.setText("");
				}
				else {
					TxtUsername.selectAll();
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if(TxtUsername.getText().equals(""))
					TxtUsername.setText("Username");
			}
		});
		TxtUsername.setBorder(null);
		TxtUsername.setFont(new Font("Rokkitt Medium", Font.PLAIN, 24));
		TxtUsername.setToolTipText("");
		TxtUsername.setText("Username");
		TxtUsername.setBounds(0, 0, 169, 39);
		user.add(TxtUsername);
		TxtUsername.setColumns(10);
		
		JPanel pass = new JPanel();
		pass.setBorder(null);
		pass.setBounds(185, 349, 326, 38);
		pass.setBackground(new Color(255, 255, 204));
		pass.setLayout(null);
		panel.add(pass);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBackground(new Color(255, 255, 204));
		pwdPassword.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				if(pwdPassword.getText().equals("Password")) {
				pwdPassword.setEchoChar('*');
				pwdPassword.setText("");
				}
				else {
					pwdPassword.selectAll();
				}
			}
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent e) {
				if(pwdPassword.getText().equals("")) {
					pwdPassword.setText("Password");
				}
			}
		});
		pwdPassword.setFont(new Font("Rokkitt Medium", Font.PLAIN, 24));
		pwdPassword.setBorder(null);
		pwdPassword.setEchoChar((char)0);
		pwdPassword.setText("Password");
		pwdPassword.setBounds(10, 0, 190, 40);
		pass.add(pwdPassword);
		setLocationRelativeTo(null);
		
		
		ltext = new JLabel("");
		ltext.setBounds(198, 300, 196, 20);
		ltext.setForeground(Color.WHITE);
		ltext.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(ltext);
		
		JButton btnlogin = new JButton("LOGIN");
		btnlogin.setBorder(null);
		btnlogin.setBounds(185, 431, 286, 50);
	
		
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("deprecation")
				String pass = pwdPassword.getText();
				String User = TxtUsername.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
					Statement stmt = con.createStatement();
					String sql = "Select * from student where Name ='"+User+"' and Password ='"+pass.toString()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"Login Successfully");
					Dashboard dsh = new Dashboard(pass);
					dsh.setVisible(true);
					login.this.dispose();
					}
					else
						JOptionPane.showMessageDialog(null, "Incorrect Username or Password!");
					con.close();
			}catch(Exception e1) {System.out.print(e1);}
			}
		});
		btnlogin.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnlogin.setBackground(new Color(255, 255, 204));
		btnlogin.setForeground(new Color(47, 79, 79));
		panel.add(btnlogin);
		
		JLabel lblReg = new JLabel("SIGN UP");
		lblReg.setBackground(new Color(51, 255, 102));
		lblReg.setBounds(366, 511, 104, 43);
		panel.add(lblReg);
		lblReg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblReg.setForeground(Color.green);
				Registration reg = new Registration();
				reg.setVisible(true);
				login.this.dispose();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblReg.setForeground(new Color(47, 79, 79));
			}
		});
		
		JLabel exit = new JLabel("BACK");
		exit.setIcon(new ImageIcon("G:\\JavaProject2\\Back.png"));
		exit.setBounds(197, 513, 117, 39);
		panel.add(exit);
		exit.setAlignmentX(Component.RIGHT_ALIGNMENT);
		exit.setBorder(null);
		exit.setBackground(new Color(47, 79, 79));
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirmation",JOptionPane.YES_NO_OPTION ) == 0)
					login.this.dispose();
				ChooseLogin cl = new ChooseLogin();
				cl.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			exit.setForeground(Color.red);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				exit.setForeground(Color.black);
			}
		});
		exit.setFont(new Font("Rokkitt", Font.BOLD, 24));
		exit.setForeground(new Color(51, 255, 0));
		
		lblReg.setFont(new Font("Rokkitt", Font.BOLD, 24));
		lblReg.setForeground(new Color(102, 255, 51));
		JLabel logstu = new JLabel("SIGN IN AS STUDENT");
		logstu.setBounds(185, 103, 321, 61);
		logstu.setForeground(new Color(255, 255, 204));
		logstu.setFont(new Font("Space Ranger Halftone", Font.PLAIN, 30));
		panel.add(logstu);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon("G:\\JavaProject2\\login2.png"));
		lblNewLabel.setBounds(21, 20, 600, 600);
		panel.add(lblNewLabel);
		
		
	}
}

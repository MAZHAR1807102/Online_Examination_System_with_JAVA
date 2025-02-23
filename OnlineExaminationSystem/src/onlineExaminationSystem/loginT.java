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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.sql.*;
import java.awt.event.ActionListener;







public class loginT extends JFrame {

	

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
					loginT frame = new loginT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public  loginT(){
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(new Color(255, 51, 51), 3));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel user = new JPanel();
		user.setBorder(null);
		user.setBackground(new Color(255, 204, 255));
		user.setBounds(185, 299, 324, 36);
		panel.add(user);
		user.setLayout(null);
		
		TxtUsername = new JTextField();
		TxtUsername.setBackground(new Color(255, 204, 255));
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
		TxtUsername.setBounds(10, 0, 166, 36);
		user.add(TxtUsername);
		TxtUsername.setColumns(10);
		
		JPanel pass = new JPanel();
		pass.setBackground(new Color(255, 204, 255));
		pass.setLayout(null);
		pass.setBounds(185, 351, 324, 36);
		panel.add(pass);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBackground(new Color(255, 204, 255));
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
		pwdPassword.setBounds(10, 0, 185, 36);
		pass.add(pwdPassword);
		setLocationRelativeTo(null);
		
		
		ltext = new JLabel("");
		ltext.setForeground(Color.WHITE);
		ltext.setFont(new Font("Arial", Font.PLAIN, 12));
		ltext.setBounds(198, 300, 196, 20);
		panel.add(ltext);
		
		JButton btnlogin = new JButton("LOGIN");
		btnlogin.setBorder(null);
	
		
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
					Statement stmt = con.createStatement();
					@SuppressWarnings("deprecation")
					String sql = "Select * from teacher where Name ='"+TxtUsername.getText()+"' and Password ='"+pwdPassword.getText().toString()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"Login Successfully");
					adminPanel dsh = new adminPanel();
					dsh.setVisible(true);
					loginT.this.dispose();
					}
					else
						JOptionPane.showMessageDialog(null, "Incorrect Username or Password!");
					con.close();
			}catch(Exception e1) {System.out.print(e1);}
			}
		});
		btnlogin.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnlogin.setBackground(new Color(255, 204, 255));
		btnlogin.setForeground(new Color(47, 79, 79));
		btnlogin.setBounds(185, 436, 287, 43);
		panel.add(btnlogin);
		
		JLabel lblReg = new JLabel("SIGN UP");
		lblReg.setBorder(null);
		lblReg.setBounds(350, 508, 122, 43);
		panel.add(lblReg);
		lblReg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblReg.setForeground(Color.green);
				RegistrationT reg = new RegistrationT();
				reg.setVisible(true);
				loginT.this.dispose();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblReg.setForeground(new Color(47, 79, 79));
			}
		});
		
		JLabel exit = new JLabel("BACK");
		exit.setIcon(new ImageIcon("G:\\JavaProject2\\Back.png"));
		exit.setBounds(200, 509, 96, 43);
		panel.add(exit);
		exit.setAlignmentX(Component.RIGHT_ALIGNMENT);
		exit.setBorder(null);
		exit.setBackground(new Color(47, 79, 79));
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirmation",JOptionPane.YES_NO_OPTION ) == 0)
					loginT.this.dispose();
				ChooseLogin cl = new ChooseLogin();
				cl.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			exit.setForeground(Color.red);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				exit.setForeground(Color.white);
			}
		});
		exit.setFont(new Font("Rockwell", Font.BOLD, 20));
		exit.setForeground(new Color(0, 255, 0));
		
		lblReg.setFont(new Font("Rockwell", Font.BOLD, 22));
		lblReg.setForeground(new Color(102, 255, 102));
		JLabel lblsign = new JLabel("SIGN IN AS TEACHER");
		lblsign.setForeground(new Color(255, 255, 255));
		lblsign.setFont(new Font("Space Ranger Title", Font.PLAIN, 30));
		lblsign.setBounds(118, 122, 423, 56);
		panel.add(lblsign);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon("G:\\JavaProject2\\login2.png"));
		lblNewLabel.setBounds(21, 20, 600, 600);
		panel.add(lblNewLabel);
		
		JLabel lblbg = new JLabel("New label");
		lblbg.setBounds(0, 0, 904, 694);
	}
}

package onlineExaminationSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class Registration extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtRoll;
	private JTextField txtDept;
	private JTextField txtbatch;
	private JTextField txthall;
	private JPasswordField PassField;
	
/*	Connection con;
	PreparedStatement stmt;
	
	
	public void Connect() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
			
		}catch(ClassNotFoundException e) {
			Logger.getLogger(Registration.class.getName()).log(Level.SEVERE,null, e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	*/

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	/**
	 * Create the frame.
	 */
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Rockwell", Font.BOLD, 34));
		lblUsername.setBounds(75, 219, 194, 37);
		contentPane.add(lblUsername);
		
		JLabel lblRoll = new JLabel("Roll");
		lblRoll.setForeground(new Color(255, 255, 255));
		lblRoll.setFont(new Font("Rokkitt Medium", Font.BOLD, 34));
		lblRoll.setBounds(75, 276, 110, 37);
		contentPane.add(lblRoll);
		
		JLabel lbldept = new JLabel("Deptartment");
		lbldept.setForeground(new Color(255, 255, 255));
		lbldept.setFont(new Font("Rokkitt Medium", Font.BOLD, 34));
		lbldept.setBounds(75, 337, 194, 37);
		contentPane.add(lbldept);
		
		JLabel batch = new JLabel("Batch");
		batch.setForeground(new Color(255, 255, 255));
		batch.setFont(new Font("Rokkitt Medium", Font.BOLD, 34));
		batch.setBounds(75, 394, 110, 37);
		contentPane.add(batch);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Rokkitt Medium", Font.BOLD, 34));
		lblPassword.setBounds(75, 461, 147, 37);
		contentPane.add(lblPassword);
		
		
		JLabel lblNewLabel_1_3 = new JLabel("Hall");
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setFont(new Font("Rokkitt Medium", Font.BOLD, 34));
		lblNewLabel_1_3.setBounds(75, 527, 110, 37);
		contentPane.add(lblNewLabel_1_3);
		
		txtName = new JTextField();
		txtName.setBorder(UIManager.getBorder("DesktopIcon.border"));
		txtName.setBounds(301, 219, 226, 37);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtRoll = new JTextField();
		txtRoll.setBorder(UIManager.getBorder("DesktopIcon.border"));
		txtRoll.setColumns(10);
		txtRoll.setBounds(301, 276, 226, 37);
		contentPane.add(txtRoll);
		
		txtDept = new JTextField();
		txtDept.setBorder(UIManager.getBorder("DesktopIcon.border"));
		txtDept.setColumns(10);
		txtDept.setBounds(301, 337, 226, 37);
		contentPane.add(txtDept);
		
		txtbatch = new JTextField();
		txtbatch.setBorder(UIManager.getBorder("DesktopIcon.border"));
		txtbatch.setColumns(10);
		txtbatch.setBounds(301, 394, 226, 37);
		contentPane.add(txtbatch);

		PassField = new JPasswordField();
		PassField.setBorder(UIManager.getBorder("DesktopIcon.border"));
		PassField.setBounds(301, 461, 226, 37);
		contentPane.add(PassField);
		
		txthall = new JTextField();
		txthall.setBorder(UIManager.getBorder("DesktopIcon.border"));
		txthall.setColumns(10);
		txthall.setBounds(301, 527, 226, 37);
		contentPane.add(txthall);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBorder(null);
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stname = txtName.getText();
				String stroll = txtRoll.getText();
				String stDept = txtDept.getText();
				String stbatch = txtbatch.getText();
				@SuppressWarnings("deprecation")
				String stPass = PassField.getText();
				String stHall = txthall.getText();
				int mark = 0;
				
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
					String query = "INSERT INTO student values('"+stroll+"', '"+stname+"', '"+stPass+"', '"+stDept+"', '"+stbatch+"', '"+stHall+"','"+mark+"')";
					Statement sta = con.createStatement();
					int x = sta.executeUpdate(query);
					if(x == 0)
					{
						JOptionPane.showMessageDialog(btnAdd, "This is already exists");
					}
					else
					{
						JOptionPane.showMessageDialog(btnAdd, "Your account is successfully created");
						login log = new login();
						log.setVisible(true);
						Registration.this.dispose();
					}
				}catch(Exception Ex) {
					Ex.printStackTrace();
				}
						
				
			}
		});
		btnAdd.setBackground(new Color(255, 182, 193));
		btnAdd.setFont(new Font("Rockwell", Font.BOLD, 24));
		btnAdd.setBounds(311, 614, 131, 47);
		contentPane.add(btnAdd);

		JLabel exit = new JLabel("CANCEL");
		exit.setBounds(142, 614, 102, 47);
		contentPane.add(exit);
		exit.setForeground(new Color(255, 255, 255));
		exit.setFont(new Font("Rockwell", Font.BOLD, 20));
		
		JPanel panel_1 = new JPanel();
		panel_1.setFont(new Font("Rockwell", Font.BOLD, 20));
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBackground(new Color(255, 192, 203));
		panel_1.setBounds(124, 614, 120, 47);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTxtReg = new JLabel("REGISTRATION");
		lblTxtReg.setForeground(new Color(255, 255, 255));
		lblTxtReg.setBounds(95, 84, 370, 128);
		contentPane.add(lblTxtReg);
		lblTxtReg.setFont(new Font("Space Ranger Bold", Font.BOLD, 50));
		
		
		
		
		
		
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirmation",JOptionPane.YES_NO_OPTION ) == 0)
				{
					login log = new login();
					log.setVisible(true);
					Registration.this.dispose();
				}
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
		
		

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 192, 203));
		lblNewLabel.setBorder(UIManager.getBorder("CheckBox.border"));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\my website\\bg.jpg"));
		lblNewLabel.setBounds(0, 0, 600, 750);
		contentPane.add(lblNewLabel);
	
		
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
}

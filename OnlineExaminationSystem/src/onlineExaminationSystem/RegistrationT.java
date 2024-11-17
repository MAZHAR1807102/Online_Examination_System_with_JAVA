package onlineExaminationSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Connect.ConnectionProvider;

public class RegistrationT extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtDept;
	private JTextField txtphone;
	private JPasswordField PassField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationT frame = new RegistrationT();
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
	public RegistrationT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Rokkitt Medium", Font.BOLD, 34));
		lblUsername.setBounds(72, 232, 208, 37);
		contentPane.add(lblUsername);
		
		JLabel lbldept = new JLabel("Deptartment");
		lbldept.setForeground(new Color(255, 255, 255));
		lbldept.setFont(new Font("Rokkitt Medium", Font.BOLD, 34));
		lbldept.setBounds(72, 302, 208, 37);
		contentPane.add(lbldept);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Rokkitt Medium", Font.BOLD, 34));
		lblPassword.setBounds(72, 379, 208, 37);
		contentPane.add(lblPassword);
		
		
		JLabel lblNewLabel_1_3 = new JLabel("Contact");
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setFont(new Font("Rokkitt Medium", Font.BOLD, 34));
		lblNewLabel_1_3.setBounds(72, 455, 208, 37);
		contentPane.add(lblNewLabel_1_3);
		
		txtName = new JTextField();
		txtName.setBounds(290, 232, 198, 37);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtDept = new JTextField();
		txtDept.setColumns(10);
		txtDept.setBounds(290, 302, 198, 37);
		contentPane.add(txtDept);

		PassField = new JPasswordField();
		PassField.setBounds(290, 379, 198, 37);
		contentPane.add(PassField);
		
		txtphone = new JTextField();
		txtphone.setColumns(10);
		txtphone.setBounds(290, 455, 198, 37);
		contentPane.add(txtphone);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBorder(null);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stname = txtName.getText();
				
				String stDept = txtDept.getText();
			
				@SuppressWarnings("deprecation")
				String stPass = PassField.getText();
				String stphone = txtphone.getText();
				
				try {
					Connection con = ConnectionProvider.getcon();
					String query = "INSERT INTO teacher values('"+stname+"', '"+stDept+"', '"+stPass+"','"+stphone+"')";
					Statement sta = con.createStatement();
					int x = sta.executeUpdate(query);
					if(x == 0)
					{
						JOptionPane.showMessageDialog(btnAdd, "This is already exists");
					}
					else
					{
						JOptionPane.showMessageDialog(btnAdd, "Your account is successfully created");
						loginT log = new loginT();
						log.setVisible(true);
						RegistrationT.this.dispose();
					}
				}catch(Exception Ex) {
					Ex.printStackTrace();
				}
						
				
			}
		});
		btnAdd.setBackground(new Color(255, 204, 255));
		btnAdd.setFont(new Font("Rokkitt Black", Font.BOLD, 22));
		btnAdd.setBounds(315, 526, 131, 49);
		contentPane.add(btnAdd);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 192, 203));
		panel_1.setBounds(125, 526, 131, 49);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel exit = new JLabel("CANCEL");
		exit.setBounds(30, 0, 101, 49);
		panel_1.add(exit);
		exit.setForeground(new Color(0, 0, 0));
		exit.setFont(new Font("Rockwell", Font.BOLD, 22));
		
		
		
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirmation",JOptionPane.YES_NO_OPTION ) == 0)
				{
					loginT log = new loginT();
					log.setVisible(true);
					RegistrationT.this.dispose();
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
		exit.setFont(new Font("Arial Black", Font.BOLD, 12));
		exit.setForeground(new Color(255, 255, 255));
		
		JLabel lblTxtReg = new JLabel("REGISTRATION");
		lblTxtReg.setForeground(new Color(255, 255, 255));
		lblTxtReg.setBounds(92, 62, 370, 128);
		contentPane.add(lblTxtReg);
		lblTxtReg.setFont(new Font("Space Ranger Bold", Font.BOLD, 50));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\my website\\bg.jpg"));
		lblNewLabel.setBounds(0, 0, 550, 650);
		contentPane.add(lblNewLabel);
		
		setUndecorated(true);
		setLocationRelativeTo(null);
	}

}

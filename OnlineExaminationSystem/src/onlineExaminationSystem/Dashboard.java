package onlineExaminationSystem;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import Connect.ConnectionProvider;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Dashboard extends JFrame {

private JPanel contentPane;
	public String Pass;
	private JLabel yourNM;
	private JLabel YourRoll;
	private JLabel batch;
	private JLabel hall;
	private JLabel department;
public Dashboard(String pass)
	{
		Dashboard1();
		Pass = pass;
		//JOptionPane.showMessageDialog(null, pass);
		
		try {
			Connection con = ConnectionProvider.getcon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select *from student where Password ='"+Pass+"'");
			while(rs.next())
			{
				yourNM.setText(rs.getString(2));
				YourRoll.setText(rs.getString(1));
				batch.setText(rs.getString(5));
				hall.setText(rs.getString(6));
				department.setText(rs.getString(4));
				
				//JOptionPane.showMessageDialog(null, rs.getString(2));
			}
			
		}catch(Exception ex)
			{
				
			}
		
		
	}
public Dashboard()
{
	Dashboard1();
}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public void Dashboard1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 650);

		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new LineBorder(new Color(25, 25, 112), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panMcq = new JPanel();
		panMcq.setBounds(0, 391, 301, 82);
		contentPane.add(panMcq);
		panMcq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panMcq.setBackground(new Color(0, 128, 128));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panMcq.setBackground(new Color(47, 79, 79));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Test tst = new Test(Pass);
				tst.setVisible(true);
				Dashboard.this.dispose();
			}
		});
		panMcq.setBorder(null);
		panMcq.setBackground(new Color(47, 79, 79));
		panMcq.setForeground(new Color(0, 128, 128));
		panMcq.setLayout(null);
		
		JLabel lblMcqExam = new JLabel("MCQ EXAM");
		lblMcqExam.setForeground(Color.WHITE);
		lblMcqExam.setFont(new Font("Space Ranger Title", Font.PLAIN, 36));
		lblMcqExam.setBounds(21, 0, 248, 82);
		panMcq.add(lblMcqExam);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\my website\\btn.png"));
		lblNewLabel_5.setBounds(-73, 0, 374, 82);
		panMcq.add(lblNewLabel_5);
		
		JPanel panWExam = new JPanel();
		panWExam.setBounds(0, 474, 301, 82);
		contentPane.add(panWExam);
		panWExam.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panWExam.setBackground(new Color(0, 128, 128));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panWExam.setBackground(new Color(47, 79, 79));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				WrittenTest wr = new WrittenTest(Pass);
				wr.setVisible(true);
				
			}
		});
		panWExam.setBorder(null);
		panWExam.setBackground(new Color(47, 79, 79));
		panWExam.setForeground(new Color(0, 128, 128));
		panWExam.setLayout(null);
		
		JLabel lblWrittenExam = new JLabel("WRITTEN EXAM");
		lblWrittenExam.setForeground(Color.WHITE);
		lblWrittenExam.setFont(new Font("Space Ranger Title", Font.PLAIN, 28));
		lblWrittenExam.setBounds(10, 0, 278, 82);
		panWExam.add(lblWrittenExam);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\my website\\btn.png"));
		lblNewLabel_6.setBounds(-81, 0, 421, 82);
		panWExam.add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("LOGOUT");
		btnNewButton_1.setBorder(null);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Are you Sure?","select",JOptionPane.YES_NO_OPTION);
				login lt = new login();
				setVisible(false);
				lt.setVisible(true);
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("G:\\JavaProject2\\Logout.png"));
		btnNewButton_1.setFont(new Font("Space Ranger Title", Font.BOLD, 30));
		btnNewButton_1.setBounds(0, 554, 301, 96);
		contentPane.add(btnNewButton_1);
		yourNM = new JLabel("Your Name");
		yourNM.setForeground(new Color(255, 235, 205));
		yourNM.setFont(new Font("Rockwell", Font.BOLD, 40));
		yourNM.setBounds(66, 292, 222, 56);
		contentPane.add(yourNM);
		
		YourRoll = new JLabel("Your Roll");
		YourRoll.setFont(new Font("Rockwell", Font.BOLD, 24));
		YourRoll.setBounds(769, 158, 205, 38);
		contentPane.add(YourRoll);
		
		batch = new JLabel(" Your Batch");
		batch.setFont(new Font("Rockwell", Font.BOLD, 24));
		batch.setBounds(755, 237, 205, 38);
		contentPane.add(batch);
		
		department = new JLabel("DEPARTMENT : ");
		department.setFont(new Font("Rockwell", Font.BOLD, 24));
		department.setBounds(755, 316, 205, 38);
		contentPane.add(department);
		
		hall = new JLabel(" Your hall");
		hall.setFont(new Font("Rockwell", Font.BOLD, 24));
		hall.setBounds(755, 404, 205, 38);
		contentPane.add(hall);
		
		JLabel lblNewLabel_4_1 = new JLabel("BATCH : ");
		lblNewLabel_4_1.setFont(new Font("Rockwell", Font.BOLD, 24));
		lblNewLabel_4_1.setBounds(523, 237, 151, 38);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("DEPARTMENT : ");
		lblNewLabel_4_2.setFont(new Font("Rockwell", Font.BOLD, 24));
		lblNewLabel_4_2.setBounds(523, 316, 205, 38);
		contentPane.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("HALL : ");
		lblNewLabel_4_3.setFont(new Font("Rockwell", Font.BOLD, 24));
		lblNewLabel_4_3.setBounds(523, 404, 90, 38);
		contentPane.add(lblNewLabel_4_3);
		JLabel lblNewLabel_9 = new JLabel("Khulna University Of Engineering & Technology");
		lblNewLabel_9.setBounds(523, 474, 451, 82);
		lblNewLabel_9.setFont(new Font("Rockwell", Font.BOLD, 18));
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_4 = new JLabel("ROLL : ");
		lblNewLabel_4.setFont(new Font("Rockwell", Font.BOLD, 24));
		lblNewLabel_4.setBounds(523, 158, 90, 38);
		contentPane.add(lblNewLabel_4);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("G:\\JavaProject2\\login.png"));
		lblNewLabel_2.setBounds(33, 302, 23, 38);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\my website\\256px-Student_icon.svg.png"));
		lblNewLabel.setBounds(10, 10, 265, 272);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\azure-one-colour-plain-single-solid-color-1440x2960-c-223c57-f-24.png"));
		lblNewLabel_1.setBounds(0, 0, 301, 710);
		contentPane.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
			
		});
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\my website\\cross.png"));
		lblNewLabel_3.setBounds(1145, 0, 55, 45);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBorder(UIManager.getBorder("FileChooser.listViewBorder"));
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\luke-chesser-PHtp0cDBJSM-unsplash.jpg"));
		lblNewLabel_8.setBounds(465, 77, 547, 527);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\blue-teal-brush-stroke-textured-background.jpg"));
		lblNewLabel_7.setBounds(302, 0, 922, 700);
		contentPane.add(lblNewLabel_7);
	
		
	
		
		setLocationRelativeTo(null);
		setUndecorated(true);
	}
}

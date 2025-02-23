package onlineExaminationSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ChooseLogin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseLogin frame = new ChooseLogin();
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
	public ChooseLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStu = new JButton("STUDENT");
		btnStu.setIcon(new ImageIcon("G:\\JavaProject2\\index student.png"));
		btnStu.setBorder(null);
		btnStu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login log = new login();
				log.setVisible(true);
				ChooseLogin.this.dispose();
				
			}
		});
		btnStu.setForeground(new Color(0, 0, 0));
		btnStu.setBackground(new Color(176, 224, 230));
		btnStu.setFont(new Font("Rockwell", Font.BOLD, 22));
		btnStu.setBounds(175, 193, 233, 69);
		contentPane.add(btnStu);
		
		JButton btnTeacher = new JButton("TEACHER");
		btnTeacher.setIcon(new ImageIcon("G:\\JavaProject2\\index admin.png"));
		btnTeacher.setBorder(null);
		btnTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginT log = new loginT();
				log.setVisible(true);
				ChooseLogin.this.dispose();				
			}
		});
		btnTeacher.setForeground(new Color(220, 20, 60));
		btnTeacher.setFont(new Font("Rockwell", Font.BOLD, 22));
		btnTeacher.setBackground(new Color(176, 224, 230));
		btnTeacher.setBounds(175, 311, 233, 69);
		contentPane.add(btnTeacher);
		
		JLabel lblmsg = new JLabel("Please select an Option");
		lblmsg.setForeground(Color.BLACK);
		lblmsg.setFont(new Font("Space Ranger", Font.BOLD, 36));
		lblmsg.setBounds(35, 57, 523, 110);
		contentPane.add(lblmsg);
		
		JPanel cancel = new JPanel();
		cancel.setBorder(null);
		cancel.setBackground(new Color(255, 0, 0));
		cancel.setForeground(new Color(255, 0, 51));
		cancel.setBounds(175, 425, 233, 37);
		contentPane.add(cancel);
		cancel.setLayout(null);
		
		JLabel exit = new JLabel("CANCEL");
		exit.setForeground(new Color(255, 255, 255));
		exit.setBorder(null);
		exit.setBackground(new Color(255, 0, 51));
		exit.setFont(new Font("Rockwell", Font.BOLD, 22));
		exit.setBounds(73, 0, 150, 37);
		
		cancel.add(exit);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\\u2014Pngtree\u2014waves background_3618987.png"));
		lblNewLabel.setBounds(0, 0, 590, 550);
		contentPane.add(lblNewLabel);
		
		
		
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirmation",JOptionPane.YES_NO_OPTION ) == 0)
					ChooseLogin.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			exit.setForeground(Color.green);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				exit.setForeground(Color.white);
			}
		});
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
}

package onlineExaminationSystem;

import Connect.ConnectionProvider;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetWrittenQues extends JFrame {
Connection con;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel Qno;
public SetWrittenQues()
{
	SetWrittenQues1();
	try {
		con = ConnectionProvider.getcon();
		Statement st = con.createStatement();
	    ResultSet rs = st.executeQuery("select count(ID) from written1");
		if(rs.next())
		{
			int ID = rs.getInt(1);
			ID = ID++;
			@SuppressWarnings("unused")
			String Str = String.valueOf(ID);
			Qno.setText(Str);
		}
		else
			Qno.setText("1");
		
	}catch(Exception e)
	{
		JFrame jf = new JFrame();
		jf.setAlwaysOnTop(true);
		JOptionPane.showMessageDialog(jf, e);
	}
}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetWrittenQues frame = new SetWrittenQues();
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
	public void SetWrittenQues1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Question Set");
		lblNewLabel.setFont(new Font("Space Ranger Title", Font.BOLD, 40));
		lblNewLabel.setBounds(233, 40, 423, 36);
		contentPane.add(lblNewLabel);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Question : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(130, 188, 117, 36);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Rokkitt", Font.PLAIN, 20));
		textField.setBounds(123, 250, 665, 123);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setIcon(new ImageIcon("G:\\JavaProject2\\save.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					con = ConnectionProvider.getcon();
					PreparedStatement st = con.prepareStatement("Insert into written1 values(?,?)");
					st.setString(1, Qno.getText());
					st.setString(2, textField.getText());
					if(st.executeUpdate()==1)
					{
						JOptionPane.showMessageDialog(null, "Successsfully Added");
						SetWrittenQues.this.dispose();
						adminPanel ap = new adminPanel();
						ap.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, " Unsuccessfull");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(130, 443, 117, 36);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setIcon(new ImageIcon("G:\\JavaProject2\\Back.png"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null,"Are You Sure?", "select", JOptionPane.YES_NO_OPTION);
				setVisible(false);
				adminPanel ap = new adminPanel();
				ap.setVisible(true);
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.setBorder(null);
		btnCancel.setBackground(Color.RED);
		btnCancel.setBounds(671, 443, 117, 36);
		contentPane.add(btnCancel);
		
		Qno = new JLabel("00");
		Qno.setFont(new Font("Tahoma", Font.BOLD, 20));
		Qno.setBounds(244, 188, 41, 36);
		contentPane.add(Qno);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\my website\\images.jpg"));
		lblNewLabel_1.setBounds(-80, -44, 1037, 788);
		contentPane.add(lblNewLabel_1);
		
		
		setLocationRelativeTo(null);
		setUndecorated(true);
	}

}

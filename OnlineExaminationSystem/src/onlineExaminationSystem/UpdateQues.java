package onlineExaminationSystem;

import java.awt.BorderLayout;
import Connect.ConnectionProvider;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

@SuppressWarnings("unused")
public class UpdateQues extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblQhead;
	private JLabel lbltxtQN;
	private JLabel lblQues;
	private JPanel Panbg;
	private JLabel lblOp1;
	private JLabel lblOp2;
	private JLabel lblOp3;
	private JLabel lblOp4;
	private JLabel lblAns;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txtans;
	private JTextField txtques;
	private JButton btnClear;
	private JTextField Qno;
	private JButton btnAdd;
	
	private JButton btnSearch;
	private JLabel lblNewLabel;
public UpdateQues()
{
	UpdateQues1();
}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateQues frame = new UpdateQues();
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
	public void UpdateQues1() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 900, 700);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
		    lblQhead = new JLabel("Update Question");
		    lblQhead.setIcon(new ImageIcon("G:\\JavaProject2\\Update Question.png"));
			lblQhead.setFont(new Font("Space Ranger Bold", Font.BOLD, 36));
			lblQhead.setForeground(new Color(255, 255, 255));
			lblQhead.setBounds(270, 42, 411, 59);
			contentPane.add(lblQhead);
			
			lbltxtQN = new JLabel("Qeustion No:");
			lbltxtQN.setForeground(new Color(255, 255, 255));
			lbltxtQN.setFont(new Font("Arial", Font.BOLD, 14));
			lbltxtQN.setBounds(27, 87, 98, 25);
			contentPane.add(lbltxtQN);
			
			lblQues = new JLabel("Question: ");
			lblQues.setForeground(new Color(255, 255, 255));
			lblQues.setFont(new Font("Arial Black", Font.BOLD, 16));
			lblQues.setBounds(27, 122, 110, 33);
			contentPane.add(lblQues);
			
			Panbg = new JPanel();
			Panbg.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			Panbg.setBackground(new Color(255, 255, 255));
			Panbg.setBounds(80, 194, 747, 385);
			contentPane.add(Panbg);
			Panbg.setLayout(null);
			
			lblOp1 = new JLabel("Option1");
			lblOp1.setFont(new Font("Rokkitt", Font.PLAIN, 20));
			lblOp1.setBounds(47, 41, 84, 42);
			Panbg.add(lblOp1);
			
			lblOp2 = new JLabel("Option2");
			lblOp2.setFont(new Font("Rokkitt", Font.PLAIN, 20));
			lblOp2.setBounds(47, 101, 84, 42);
			Panbg.add(lblOp2);
			
			lblOp3 = new JLabel("Option3");
			lblOp3.setFont(new Font("Rokkitt", Font.PLAIN, 20));
			lblOp3.setBounds(47, 168, 84, 42);
			Panbg.add(lblOp3);
			
		    lblOp4 = new JLabel("Option4");
			lblOp4.setFont(new Font("Rokkitt", Font.PLAIN, 20));
			lblOp4.setBounds(47, 233, 84, 42);
			Panbg.add(lblOp4);
			
			lblAns = new JLabel("Answer");
			lblAns.setFont(new Font("Rokkitt", Font.PLAIN, 20));
			lblAns.setBounds(47, 317, 84, 13);
			Panbg.add(lblAns);
			
			txt1 = new JTextField();
			txt1.setFont(new Font("Rockwell", Font.PLAIN, 20));
			txt1.setBounds(153, 41, 517, 42);
			Panbg.add(txt1);
			txt1.setColumns(10);
			
			txt2 = new JTextField();
			txt2.setFont(new Font("Rockwell", Font.PLAIN, 20));
			txt2.setColumns(10);
			txt2.setBounds(153, 101, 517, 42);
			Panbg.add(txt2);
			
			txt3 = new JTextField();
			txt3.setFont(new Font("Rockwell", Font.PLAIN, 20));
			txt3.setColumns(10);
			txt3.setBounds(153, 168, 517, 42);
			Panbg.add(txt3);
			
			txt4 = new JTextField();
			txt4.setFont(new Font("Rockwell", Font.PLAIN, 20));
			txt4.setColumns(10);
			txt4.setBounds(153, 235, 517, 42);
			Panbg.add(txt4);
			
			txtans = new JTextField();
			txtans.setFont(new Font("Rockwell", Font.PLAIN, 20));
			txtans.setColumns(10);
			txtans.setBounds(153, 304, 517, 42);
			Panbg.add(txtans);
			
			txtques = new JTextField();
			txtques.setFont(new Font("Arial", Font.PLAIN, 12));
			txtques.setBounds(124, 122, 461, 46);
			contentPane.add(txtques);
			txtques.setColumns(10);
			
			btnAdd = new JButton("UPDATE");
			btnAdd.setIcon(new ImageIcon("G:\\JavaProject2\\Update Question.png"));
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnAdd.addActionListener(new ActionListener() {
						@SuppressWarnings("rawtypes")
						public void actionPerformed(ActionEvent e) {
							
							
							String QN =Qno.getText();
							String stques = txtques.getText();
							String stOp1 = txt1.getText();
							String stOp2 = txt2.getText();
							String stOp3 = txt3.getText();
							String stOp4 = txt4.getText();
							String stans = txtans.getText();
							
							try {
								Connection con = ConnectionProvider.getcon();
								PreparedStatement ps ;
								ps = con.prepareStatement("Update test set question = ?, option1 = ?, option2 = ?, option3 = ?, option4 = ?,answer = ? where ID = '"+QN+"'");
								ps.setString(1, stques);
								ps.setString(2, stOp1);
								ps.setString(3, stOp2);
								ps.setString(4, stOp3);
								ps.setString(5, stOp4);
								ps.setString(6, stans);
								
								int k = ps.executeUpdate();
								if(k== 0)
								{
									JOptionPane.showMessageDialog(btnAdd, "This is already exists");
								}
								else
								{
									JOptionPane.showMessageDialog(btnAdd, "Qeustion Set is successfully Updated");
									
									UpdateQues.this.dispose();
									UpdateQues qs = new UpdateQues();
									qs.setVisible(true);
								}
								
							
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					
				}
			});
			btnAdd.setBackground(new Color(255, 0, 0));
			btnAdd.setForeground(new Color(255, 255, 255));
			btnAdd.setFont(new Font("Arial", Font.BOLD, 20));
			btnAdd.setBorder(null);
			btnAdd.setBounds(80, 606, 165, 46);
			contentPane.add(btnAdd);
			
			JButton btnCancel = new JButton("Cancel");
			btnCancel.setIcon(new ImageIcon("G:\\JavaProject2\\Back.png"));
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirmation",JOptionPane.YES_NO_OPTION ) == 0)
						adminPanel.open = 0;
						adminPanel ap = new adminPanel();
						ap.setVisible(true);
						setVisible(false);
				}
			});
			btnCancel.setForeground(Color.WHITE);
			btnCancel.setFont(new Font("Arial", Font.BOLD, 20));
			btnCancel.setBorder(null);
			btnCancel.setBackground(Color.RED);
			btnCancel.setBounds(670, 606, 121, 46);
			contentPane.add(btnCancel);
			
		    btnClear = new JButton("CLEAR");
		    btnClear.setIcon(new ImageIcon("G:\\JavaProject2\\clear.png"));
		    btnClear.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		txtques.setText("");
					txt1.setText("");
					txt2.setText("");
					txt3.setText("");
					txt4.setText("");
					txtans.setText("");
					
		    	}
		    });
			btnClear.setForeground(Color.WHITE);
			btnClear.setFont(new Font("Arial", Font.BOLD, 20));
			btnClear.setBorder(null);
			btnClear.setBackground(Color.RED);
			btnClear.setBounds(270, 606, 121, 46);
			contentPane.add(btnClear);
			
		    Qno = new JTextField("00");
			Qno.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
			Qno.setBounds(135, 87, 54, 25);
			contentPane.add(Qno);
			
			btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					@SuppressWarnings("unused")
					String ID = Qno.getText();
					try {
						Connection con = ConnectionProvider.getcon();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("select * from test where ID ='"+ID+"'");
						if(rs.next())
						{
							txtques.setText(rs.getString(2));
							txt1.setText(rs.getString(3));
							txt2.setText(rs.getString(4));
							txt3.setText(rs.getString(5));
							txt4.setText(rs.getString(6));
							txtans.setText(rs.getString(7));
						
						}
						else
						{
							JFrame jf = new JFrame();
							jf.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(jf, "Question Id doesn't Exit");
							
						}
						
					}catch(Exception e1) {
						
					}
					
					
					
					
					
					
				}
			});
			btnSearch.setIcon(new ImageIcon("G:\\java project\\Online Examination System\\image\\search.png"));
			btnSearch.setForeground(Color.WHITE);
			btnSearch.setFont(new Font("Arial", Font.BOLD, 20));
			btnSearch.setBorder(null);
			btnSearch.setBackground(Color.RED);
			btnSearch.setBounds(641, 122, 110, 46);
			contentPane.add(btnSearch);
			
			lblNewLabel = new JLabel("");
			lblNewLabel.setFont(new Font("Rockwell", Font.PLAIN, 20));
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\my website\\images.jpg"));
			lblNewLabel.setBounds(-134, 0, 1057, 845);
			contentPane.add(lblNewLabel);
			setUndecorated(true);
			setLocationRelativeTo(null);
	}

}

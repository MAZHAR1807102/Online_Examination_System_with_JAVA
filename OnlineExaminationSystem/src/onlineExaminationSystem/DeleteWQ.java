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
public class DeleteWQ extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblQhead;
	private JLabel lbltxtQN;
	private JLabel lblQues;
	private JTextField txtques;
	private JButton btnClear;
	private JTextField Qno;
	private JButton btnAdd;
	
	private JButton btnSearch;
public DeleteWQ()
{
	DeleteQues1();
}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteWQ frame = new DeleteWQ();
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
	public void DeleteQues1() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 900, 700);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
		    lblQhead = new JLabel("DELETE QUESTION");
		    lblQhead.setIcon(new ImageIcon("G:\\JavaProject2\\delete Question.png"));
			lblQhead.setFont(new Font("Space Ranger Bold", Font.BOLD, 36));
			lblQhead.setForeground(new Color(47, 79, 79));
			lblQhead.setBounds(242, 65, 411, 59);
			contentPane.add(lblQhead);
			
			lbltxtQN = new JLabel("Qeustion No:");
			lbltxtQN.setFont(new Font("Arial", Font.BOLD, 14));
			lbltxtQN.setBounds(133, 175, 98, 25);
			contentPane.add(lbltxtQN);
			
			lblQues = new JLabel("Question: ");
			lblQues.setFont(new Font("Arial Black", Font.BOLD, 16));
			lblQues.setBounds(133, 210, 110, 33);
			contentPane.add(lblQues);
			
			txtques = new JTextField();
			txtques.setFont(new Font("Arial", Font.BOLD, 20));
			txtques.setBounds(126, 253, 610, 228);
			contentPane.add(txtques);
			txtques.setColumns(10);
			
			btnAdd = new JButton("DELETE");
			btnAdd.setIcon(new ImageIcon("G:\\JavaProject2\\delete.png"));
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnAdd.addActionListener(new ActionListener() {
						@SuppressWarnings("rawtypes")
						public void actionPerformed(ActionEvent e) {
							
							
							String QN =Qno.getText();
							String stques = txtques.getText();
							
							try {
								Connection con = ConnectionProvider.getcon();
								PreparedStatement ps ;
								ps = con.prepareStatement("delete from Written1 where ID = ?");
								ps.setString(1, QN);
								
								int k = ps.executeUpdate();
								if(k== 0)
								{
									JOptionPane.showMessageDialog(btnAdd, "Unseccessfull");
								}
								else
								{
									JOptionPane.showMessageDialog(btnAdd, "Qeustion Set is successfully DELETED");
									
									DeleteWQ.this.dispose();
									DeleteWQ qs = new DeleteWQ();
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
			btnAdd.setBounds(144, 529, 143, 46);
			contentPane.add(btnAdd);
			
			JButton btnCancel = new JButton("Cancel");
			btnCancel.setIcon(new ImageIcon("G:\\JavaProject2\\Back.png"));
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirmation",JOptionPane.YES_NO_OPTION ) == 0)
						DeleteWQ.this.dispose();adminPanel.open = 0;
						setVisible(false);
				}
			});
			btnCancel.setForeground(Color.WHITE);
			btnCancel.setFont(new Font("Arial", Font.BOLD, 20));
			btnCancel.setBorder(null);
			btnCancel.setBackground(Color.RED);
			btnCancel.setBounds(571, 529, 131, 46);
			contentPane.add(btnCancel);
			
		    btnClear = new JButton("CLEAR");
		    btnClear.setIcon(new ImageIcon("G:\\JavaProject2\\clear.png"));
		    btnClear.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		txtques.setText("");
					
		    	}
		    });
			btnClear.setForeground(Color.WHITE);
			btnClear.setFont(new Font("Arial", Font.BOLD, 20));
			btnClear.setBorder(null);
			btnClear.setBackground(Color.RED);
			btnClear.setBounds(371, 529, 131, 46);
			contentPane.add(btnClear);
			
		    Qno = new JTextField("00");
			Qno.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
			Qno.setBounds(233, 176, 54, 25);
			contentPane.add(Qno);
			
			btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					@SuppressWarnings("unused")
					String ID = Qno.getText();
					try {
						Connection con = ConnectionProvider.getcon();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("select * from Written1 where ID ='"+ID+"'");
						if(rs.next())
						{
							txtques.setText(rs.getString(2));
						
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
			btnSearch.setIcon(new ImageIcon("G:\\JavaProject2\\search.png"));
			btnSearch.setForeground(Color.WHITE);
			btnSearch.setFont(new Font("Arial", Font.BOLD, 20));
			btnSearch.setBorder(null);
			btnSearch.setBackground(Color.RED);
			btnSearch.setBounds(571, 176, 110, 46);
			contentPane.add(btnSearch);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\my website\\images.jpg"));
			lblNewLabel.setBounds(0, 0, 900, 711);
			contentPane.add(lblNewLabel);
			setUndecorated(true);
			setLocationRelativeTo(null);
	}
}

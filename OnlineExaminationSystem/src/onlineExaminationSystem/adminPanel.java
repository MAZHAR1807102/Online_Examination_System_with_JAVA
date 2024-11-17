package onlineExaminationSystem;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class adminPanel extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static int open = 0;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminPanel frame = new adminPanel();
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
	public adminPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddQ = new JButton("Add Ques");
		btnAddQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("rawtypes")
				QuestionSet qs = new QuestionSet();
				qs.setVisible(true);
				setVisible(false);
			}
		});
		btnAddQ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//@SuppressWarnings("rawtypes")
				//QuestionSet qs = new QuestionSet();
				//qs.setVisible(true);
			}
		});
		btnAddQ.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnAddQ.setIcon(new ImageIcon("G:\\JavaProject2\\add new question.png"));
		btnAddQ.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddQ.setBounds(20, 291, 176, 64);
		contentPane.add(btnAddQ);
		
		JButton btnUpdateQ = new JButton("Update Ques");
		btnUpdateQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateQues uq = new UpdateQues();
				uq.setVisible(true);
				adminPanel.this.dispose();
			}
		});
		btnUpdateQ.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpdateQ.setIcon(new ImageIcon("G:\\JavaProject2\\Update Question.png"));
		btnUpdateQ.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdateQ.setBounds(257, 291, 189, 64);
		contentPane.add(btnUpdateQ);
		
		JButton btnExit = new JButton("");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame jf = new JFrame();
				jf.setAlwaysOnTop(true);
				if(JOptionPane.showConfirmDialog(jf, "Are you sure?", "Confirmation",JOptionPane.YES_NO_OPTION ) == 0)
					System.exit(0);
			}
		});
		btnExit.setBorder(null);
		btnExit.setIcon(new ImageIcon("G:\\JavaProject2\\Close.png"));
		btnExit.setBounds(911, 0, 89, 64);
		contentPane.add(btnExit);
		
		JButton btnDlt = new JButton("Delete Ques");
		btnDlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteQues dq = new DeleteQues();
				dq.setVisible(true);
				setVisible(false);
			}
		});
		btnDlt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnDlt.setIcon(new ImageIcon("G:\\JavaProject2\\delete Question.png"));
		btnDlt.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDlt.setBounds(515, 291, 189, 64);
		contentPane.add(btnDlt);
		
		JButton btnAllrs = new JButton("LOGOUT");
		btnAllrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Are you Sure?","select",JOptionPane.YES_NO_OPTION);
				loginT lt = new loginT();
				setVisible(false);
				lt.setVisible(true);
			}
		});
		btnAllrs.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnAllrs.setIcon(new ImageIcon("G:\\JavaProject2\\Logout.png"));
		btnAllrs.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAllrs.setBounds(788, 291, 189, 64);
		contentPane.add(btnAllrs);
		

		JLabel lblNewLabel_2 = new JLabel("TEACHER PANEL");
		lblNewLabel_2.setFont(new Font("Rockwell", Font.BOLD, 40));
		lblNewLabel_2.setIcon(new ImageIcon("G:\\JavaProject2\\index admin.png"));
		lblNewLabel_2.setBounds(20, 80, 451, 64);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("MCQ PART");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Space Ranger Title", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(20, 193, 286, 68);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("WRITTEN PART");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Space Ranger Title", Font.PLAIN, 40));
		lblNewLabel_1_1.setBounds(20, 421, 396, 68);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnAddQ_1 = new JButton("Add Ques");
		btnAddQ_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetWrittenQues sq = new SetWrittenQues();
				sq.setVisible(true);
				setVisible(false);
			}
		});
		btnAddQ_1.setIcon(new ImageIcon("G:\\JavaProject2\\add new question.png"));
		btnAddQ_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddQ_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnAddQ_1.setBounds(20, 529, 176, 64);
		contentPane.add(btnAddQ_1);
		
		JButton btnUpdateQ_1 = new JButton("Update Ques");
		btnUpdateQ_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateWQ wq = new UpdateWQ();
				wq.setVisible(true);
			}
		});
		btnUpdateQ_1.setIcon(new ImageIcon("G:\\JavaProject2\\Update Question.png"));
		btnUpdateQ_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdateQ_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpdateQ_1.setBounds(257, 529, 189, 64);
		contentPane.add(btnUpdateQ_1);
		
		JButton btnDlt_1 = new JButton("Delete Ques");
		btnDlt_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteWQ DQ = new DeleteWQ();
						DQ.setVisible(true);
			}
		});
		btnDlt_1.setIcon(new ImageIcon("G:\\JavaProject2\\delete Question.png"));
		btnDlt_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDlt_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnDlt_1.setBounds(515, 529, 189, 64);
		contentPane.add(btnDlt_1);
		
		JButton btnDlt_1_1 = new JButton("SCRIPTS");
		btnDlt_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writtensript wr = new writtensript();
				wr.setVisible(true);
				setVisible(false);
			}
		});
		btnDlt_1_1.setIcon(new ImageIcon("G:\\JavaProject2\\all questions.png"));
		btnDlt_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDlt_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnDlt_1_1.setBounds(788, 529, 189, 64);
		contentPane.add(btnDlt_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\luke-chesser-pJadQetzTkI-unsplash.jpg"));
		lblNewLabel.setBounds(-42, -37, 1088, 763);
		contentPane.add(lblNewLabel);
		
		
		
		
		setUndecorated(true);
		setLocationRelativeTo(null);
	

	}
}

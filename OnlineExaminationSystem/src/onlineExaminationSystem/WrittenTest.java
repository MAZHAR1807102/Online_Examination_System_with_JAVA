package onlineExaminationSystem;

import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Connect.ConnectionProvider;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class WrittenTest extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField script;
	public String Pass;
	public String qId;
	public String Question;
	public int mint = 0;
	public int secd = 0;
	public int marks = 0;
	public String ans;
	private JLabel Qno;
	private JLabel lblQues;
	private JLabel Hall;
	private JLabel Dept;
	private JLabel Batch;
	private JLabel YourRoll;
	private JLabel YourNM;
	private JLabel min;
	private JLabel sec;
	
	
	
	static int second = 00;
    static int minute = 5;
    static String ddSecond, ddMinute;
    static DecimalFormat dFormat = new DecimalFormat("00");
    static boolean state = true; 

public void timer(){
    state = true;
        Thread t = new Thread(){
          public void run(){
              for(;;){
                  if(state == true){
                      try{
                          sleep(1000);
                          second--;
                          ddSecond = dFormat.format(second);
                          ddMinute = dFormat.format(minute);
                          min.setText(""+ddMinute);
                          sec.setText(""+ddSecond);
                          if(second == -1){
                              second = 59;
                              minute--;
                              ddSecond = dFormat.format(second);
                              ddMinute = dFormat.format(minute);
                              min.setText(""+ddMinute);
                              sec.setText(""+ddSecond);
                          }
                          if(minute == 0 && second == 0){
                              state = false;
                             JOptionPane.showMessageDialog(null,"Stop Writting!! Times Up!");
                             
                              setVisible(false);
                          }
                      }
                      catch(Exception e){
                        e.printStackTrace();
                      }
                  }
                  else{
                      break;
                  }
              }
          }  
        };
        t.start();
    }

    public void question()
	{
    	//JOptionPane.showMessageDialog(null,qId);
		int Qid1 = Integer.parseInt(qId);
		Qid1 = Qid1+1;
		qId = String.valueOf(Qid1);
		//JOptionPane.showMessageDialog(null,qId);
		try {
			Connection con = ConnectionProvider.getcon();
			Statement st = con.createStatement();
			ResultSet rs1 = st.executeQuery("select *from written1 where ID ='"+qId+"'");
			while(rs1.next())
			{
				Qno.setText(rs1.getString(1));
				lblQues.setText(rs1.getString(2));
				

			}
			
		}catch(Exception ex)
		{
			
		}
	}
	public WrittenTest(String pass)
	{
		
		Pass = pass;
		//JOptionPane.showMessageDialog(null, Pass);
		WrittenTest1();
		pass = Pass;
		qId = "0";
		
		/*SimpleDateFormat dform = new SimpleDateFormat("dd-mm-yyyy");
		Date date = new Date();
		lblDate.setText(dform.format(date));*/
		
		//Display first question
		try {
			Connection con = ConnectionProvider.getcon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select *from student where Password ='"+pass+"'");
			while(rs.next())
			{
				YourNM.setText(rs.getString(2));
				YourRoll.setText(rs.getString(1));
				Batch.setText(rs.getString(5));
				Hall.setText(rs.getString(6));
				Dept.setText(rs.getString(4));
				
			//	JOptionPane.showMessageDialog(null, rs.getString(2));
				
			}
			ResultSet rs1 = st.executeQuery("select *from written1 where ID ='"+qId+"'");
			while(rs1.next())
			{
				Qno.setText(rs1.getString(1));
				lblQues.setText(rs1.getString(2));
				ans = script.getText();

			}
			
		}catch(Exception ex)
		{
			
		}
		timer();
		setLocationRelativeTo(this);
		
	}
	public WrittenTest()
	{
		WrittenTest1();
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WrittenTest frame = new WrittenTest();
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
	public void WrittenTest1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Written Test");
		lblNewLabel.setFont(new Font("Space Ranger Title", Font.BOLD, 40));
		lblNewLabel.setBounds(246, 47, 463, 68);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Question No:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(21, 139, 135, 25);
		contentPane.add(lblNewLabel_1);
		
		Qno = new JLabel("00");
		Qno.setFont(new Font("Tahoma", Font.BOLD, 20));
		Qno.setBounds(159, 129, 45, 44);
		contentPane.add(Qno);
		
		JLabel lblNewLabel_3 = new JLabel("Question:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(21, 174, 97, 32);
		contentPane.add(lblNewLabel_3);
		
		lblQues = new JLabel("Demo");
		lblQues.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQues.setBounds(122, 174, 545, 32);
		contentPane.add(lblQues);
		
		script = new JTextField();
		script.setBounds(270, 263, 585, 284);
		contentPane.add(script);
		script.setColumns(10);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			   String id = Qno.getText();
				String Roll = YourRoll.getText();

				String ques = lblQues.getText();

				String ans = script.getText();
				
				try{  
					Connection con = ConnectionProvider.getcon();
					PreparedStatement st = con.prepareStatement("Insert into script1(ID,Roll,Question,Answer) values(?,?,?,?)");
					st.setString(1, id);
					st.setString(2, Roll);
					st.setString(3, ques);
					st.setString(4, ans);
					if(st.executeUpdate()==1)
					{
						JOptionPane.showMessageDialog(null, "Successsfully Added");
						question();
						//setVisible(false);
					
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
		btnNext.setIcon(new ImageIcon("G:\\JavaProject2\\Next.png"));
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNext.setBorder(null);
		btnNext.setBackground(new Color(255, 0, 0));
		btnNext.setForeground(new Color(255, 255, 255));
		btnNext.setBounds(105, 557, 117, 44);
		contentPane.add(btnNext);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setIcon(new ImageIcon("G:\\JavaProject2\\clear.png"));
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancel.setBorder(null);
		btnCancel.setBackground(Color.RED);
		btnCancel.setBounds(280, 557, 117, 44);
		contentPane.add(btnCancel);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setIcon(new ImageIcon("G:\\JavaProject2\\save.png"));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSubmit.setBorder(null);
		btnSubmit.setBackground(Color.RED);
		btnSubmit.setBounds(698, 557, 117, 44);
		contentPane.add(btnSubmit);
		
		JLabel lblNewLabel_2 = new JLabel("Write Your Answer Here");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(414, 230, 229, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Total Question:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(660, 114, 156, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Time:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(660, 149, 73, 25);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("05");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(826, 114, 36, 25);
		contentPane.add(lblNewLabel_1_1_1_1);
		

		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		panel.setBounds(21, 261, 229, 286);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Name:");
		lblNewLabel_4.setFont(new Font("Rokkitt", Font.BOLD, 16));
		lblNewLabel_4.setBounds(10, 44, 88, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Roll:");
		lblNewLabel_4_1.setFont(new Font("Rokkitt", Font.BOLD, 16));
		lblNewLabel_4_1.setBounds(10, 90, 88, 13);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Batch:");
		lblNewLabel_4_2.setFont(new Font("Rokkitt", Font.BOLD, 16));
		lblNewLabel_4_2.setBounds(10, 136, 88, 13);
		panel.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("Department:");
		lblNewLabel_4_3.setFont(new Font("Rokkitt", Font.BOLD, 16));
		lblNewLabel_4_3.setBounds(10, 183, 88, 13);
		panel.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("Hall:");
		lblNewLabel_4_4.setFont(new Font("Rokkitt", Font.BOLD, 16));
		lblNewLabel_4_4.setBounds(10, 230, 88, 13);
		panel.add(lblNewLabel_4_4);
		
		YourNM = new JLabel("Your Name");
		YourNM.setFont(new Font("Space Ranger Title", Font.PLAIN, 16));
		YourNM.setForeground(new Color(0, 0, 0));
		YourNM.setBounds(89, 39, 130, 23);
		panel.add(YourNM);
		
		YourRoll = new JLabel("0000");
		YourRoll.setFont(new Font("Space Ranger Title", Font.PLAIN, 20));
		YourRoll.setForeground(new Color(0, 0, 0));
		YourRoll.setBounds(89, 85, 130, 23);
		panel.add(YourRoll);
		
		Batch = new JLabel("2018");
		Batch.setFont(new Font("Space Ranger Title", Font.PLAIN, 20));
		Batch.setForeground(new Color(0, 0, 0));
		Batch.setBounds(89, 126, 130, 23);
		panel.add(Batch);
		
		Dept = new JLabel("");
		Dept.setFont(new Font("Space Ranger Title", Font.PLAIN, 20));
		Dept.setForeground(new Color(0, 0, 0));
		Dept.setBounds(99, 173, 130, 23);
		panel.add(Dept);
		
		Hall = new JLabel("Hall");
		Hall.setFont(new Font("Space Ranger Title", Font.PLAIN, 20));
		Hall.setForeground(new Color(0, 0, 0));
		Hall.setBounds(89, 220, 130, 23);
		panel.add(Hall);
		min = new JLabel("00");
		min.setFont(new Font("Tahoma", Font.PLAIN, 16));
		min.setBounds(730, 153, 27, 20);
		contentPane.add(min);
		
		sec = new JLabel("00");
		sec.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sec.setBounds(754, 153, 18, 20);
		contentPane.add(sec);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\my website\\images.jpg"));
		lblNewLabel_5.setBounds(-16, -60, 947, 768);
		contentPane.add(lblNewLabel_5);
		
		setUndecorate(true);
		setLocationRelativeTo(null);
		
	}
	private void setUndecorate(boolean b) {
		// TODO Auto-generated method stub
		
	}
}

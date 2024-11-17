package onlineExaminationSystem;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JProgressBar;
import java.awt.Font;
import java.awt.Image;

public class SplashScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JLabel lblNewLabel;
	private static JProgressBar progressBar;
	private JLabel lblNewLabel_2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		int x;
			SplashScreen frame = new SplashScreen();
					frame.setVisible(true);
					try {
				for(x = 0; x<= 100; x++){
					SplashScreen.progressBar.setValue(x);
					Thread.sleep(20);
					SplashScreen.lblNewLabel.setText(Integer.toString(x)+"%");
					if(x == 100) {
						ChooseLogin log = new ChooseLogin();
						log.setVisible(true);
					frame.dispose();
					}
				}
					}catch (InterruptedException e) {
						e.printStackTrace();
			}
	}
	/**
	 * Create the frame.
	 */
	public SplashScreen() {
	    setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
	    lblNewLabel = new JLabel("progress");
	    lblNewLabel.setBackground(Color.WHITE);
	    lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 26));
	    lblNewLabel.setForeground(new Color(255, 255, 204));
		lblNewLabel.setBounds(285, 300, 107, 23);
		contentPane.add(lblNewLabel);
		
	    progressBar = new JProgressBar();
		progressBar.setBackground(new Color(240, 240, 240));
		progressBar.setForeground(new Color(0, 0, 0));
		progressBar.setBounds(72, 333, 464, 5);
		contentPane.add(progressBar);
		/*lblpic.setBackground(new Color(255, 255, 255));
		ImageIcon  ico = new ImageIcon(this.getClass().getResource("/cover.jpg"));
		Image img = ico.getImage();
		Image scaled = img.getScaledInstance(lblpic.getWidth(),lblpic.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(scaled);
		lblpic.setIcon(icon);*/
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\my website\\Artboard 1.png"));
		lblNewLabel_2.setBounds(0, 0, 600, 400);
		contentPane.add(lblNewLabel_2);
	
	
		
		
		
	

	}
}

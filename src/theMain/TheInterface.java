package theMain;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TheInterface extends UserData implements ActionListener
{
	private JPanel panel;
	private JFrame frame;
	private JButton loggInBt;
	private JTextField userName; 
	private JTextField userPassword; 
	public TheInterface() 
	{
		panel = new JPanel();
		frame = new JFrame();
		userName = new JTextField();
		userPassword = new JTextField();
		loggInBt = new JButton("Login");
		panel.setBorder(BorderFactory.createEmptyBorder(50,80,10,80));
		frame.setLocationRelativeTo(null);
		panel.setLayout(new GridLayout(0,1));
		panel.add(userName);
		panel.add(userPassword);
		panel.add(loggInBt);
		loggInBt.addActionListener(this);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("BeSafe");
		URL iconUrl = getClass().getResource("/BSIcon.png");
		ImageIcon icon = new ImageIcon(iconUrl);
		frame.setIconImage(icon.getImage());
		frame.pack();
		frame.setVisible(true);
	}
	
 public static void main(String[] args) 
 {
	new TheInterface();
 }
 @Override
 public void actionPerformed(ActionEvent e)
 {
	 saveUserData(userPassword.getText(), userName.getText());
 }



}

package theMain;
import java.awt.BorderLayout;
import java.awt.Container;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class RegisterWindow {
	private JPanel panel;
	private JFrame frame;
	private JTextField userName;
	private JTextField userPassword;
	private JTextField userConfPassword;
	private JButton registerUserBt;
	private JButton cancelBt;
	private JLabel userNameJLabel;
	private JLabel userPasswordJLabel;
	private JLabel userPasswordConfJLabel;
	
	public RegisterWindow() {
		panel = new JPanel(new SpringLayout());
		frame = new JFrame();
		userName = new JTextField("", 15);
		userPassword = new JTextField("", 15);
		userConfPassword = new JTextField("", 15);	
		userNameJLabel = new JLabel("Name:");
		userPasswordJLabel = new JLabel("Password:");
		userPasswordConfJLabel = new JLabel("Password:");
		registerUserBt = new JButton("Register");
		cancelBt = new JButton("Cancel");
		Container contentPane = frame.getContentPane();
		frame.setLocationRelativeTo(null);
		SpringLayout layout = new SpringLayout();
		frame.setLayout(layout);
		contentPane.add(userNameJLabel);
		contentPane.add(userName);
		layout.putConstraint(SpringLayout.WEST, userNameJLabel, 10, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, userNameJLabel, 10, SpringLayout.NORTH, contentPane);
			
		layout.putConstraint(SpringLayout.WEST, userName, 5, SpringLayout.EAST, userPasswordJLabel);
		layout.putConstraint(SpringLayout.NORTH, userName, 10, SpringLayout.NORTH, contentPane);
		
		contentPane.add(userPasswordJLabel);
		contentPane.add(userPassword);
		layout.putConstraint(SpringLayout.WEST, userPasswordJLabel, 10, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, userPasswordJLabel, 10, SpringLayout.SOUTH, userNameJLabel);
			
		layout.putConstraint(SpringLayout.WEST, userPassword, 5, SpringLayout.EAST, userPasswordJLabel);
		layout.putConstraint(SpringLayout.NORTH, userPassword, 10, SpringLayout.SOUTH, userNameJLabel);
		
		contentPane.add(userPasswordConfJLabel);
		contentPane.add(userConfPassword);
		layout.putConstraint(SpringLayout.WEST, userPasswordConfJLabel, 10, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, userPasswordConfJLabel, 10, SpringLayout.SOUTH, userPasswordJLabel);
		
		layout.putConstraint(SpringLayout.WEST, userConfPassword, 5, SpringLayout.EAST, userPasswordJLabel);
		layout.putConstraint(SpringLayout.NORTH, userConfPassword, 10, SpringLayout.SOUTH, userPasswordJLabel);
		
		contentPane.add(registerUserBt);
		contentPane.add(cancelBt);
		layout.putConstraint(SpringLayout.WEST, registerUserBt, 10, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, registerUserBt, 10, SpringLayout.SOUTH, userPasswordConfJLabel);
		
		layout.putConstraint(SpringLayout.WEST, cancelBt, 5, SpringLayout.EAST, registerUserBt);
		layout.putConstraint(SpringLayout.NORTH, cancelBt, 10, SpringLayout.SOUTH, userPasswordConfJLabel);		
		frame.add(panel, BorderLayout.CENTER);
		frame.setSize(300 , 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("BeSafe");
		URL iconUrl = getClass().getResource("/BSIcon.png");
		ImageIcon icon = new ImageIcon(iconUrl);
		frame.setIconImage(icon.getImage());
		frame.setVisible(true);
	}

	private JTextField getUserName() {
		return userName;
	}

	private void setUserName(JTextField userName) {
		this.userName = userName;
	}

	private JTextField getUserPassword() {
		return userPassword;
	}

	private void setUserPassword(JTextField userPassword) {
		this.userPassword = userPassword;
	}

	private JTextField getUserConfPassword() {
		return userConfPassword;
	}

	private void setUserConfPassword(JTextField userConfPassword) {
		this.userConfPassword = userConfPassword;
	}	

}


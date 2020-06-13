package theMain;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;

public class RegisterWindow extends UserData {
	private JPanel panel;
	private JFrame frame;
	private JTextField userName;
	private JPasswordField userPassword;
	private JPasswordField userConfPassword;
	public JButton registerUserBt;
	public JButton cancelBt;
	private JLabel userNameJLabel;
	private JLabel userPasswordJLabel;
	private JLabel userPasswordConfJLabel;

	public RegisterWindow() {
		panel = new JPanel(new SpringLayout());
		frame = new JFrame();
		userName = new JTextField("", 15);
		userPassword = new JPasswordField("", 15);
		userConfPassword = new JPasswordField("", 15);
		userPassword.setEchoChar('*');
		userConfPassword.setEchoChar('*');
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
		frame.setSize(300, 350);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setTitle("BeSafe");
		URL iconUrl = getClass().getResource("/BSIcon.png");
		ImageIcon icon = new ImageIcon(iconUrl);
		frame.setIconImage(icon.getImage());
		frame.setVisible(true);
		cancelBt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		registerUserBt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				char[] userPasswordChar = getUserPassword().getPassword();
				char[] userConfPasswordChar = getUserConfPassword().getPassword();
				String userNameString = getUserName().getText();
				if (userNameString.isEmpty()) {
					System.out.println("Please enter a Username.");
				} else if (userPasswordChar.length == 0 || userConfPassword.getPassword().length == 0) {
					System.out.println("Please enter a Password");
				} else if ((Arrays.equals(userPasswordChar, userConfPasswordChar) == false)) {
					System.out.println("The Passwords doesn't match!");
				} else if (Arrays.equals(userPasswordChar, userConfPasswordChar)) {
					saveUserData(userPasswordChar, getUserName().getText());
					frame.dispose();
				} else {
					System.out.println("Something went wrong!");
				}
			}
		});

	}

	private JTextField getUserName() {
		return userName;
	}

	private JPasswordField getUserPassword() {
		return userPassword;
	}

	private JPasswordField getUserConfPassword() {
		return userConfPassword;
	}
}

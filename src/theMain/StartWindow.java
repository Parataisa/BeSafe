package theMain;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.*;

public class StartWindow {
	public JPanel panel;
	public JFrame frame;
	public JButton loggInBt;
	public JButton registerUserBt;
	public JTextField userName;
	public JPasswordField userPassword;
	
	public StartWindow(UserDataClass userDataClass) {	
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		userName = new JTextField();
		userPassword = new JPasswordField();
		userPassword.setEchoChar('*');
		loggInBt = new JButton("Login");
		registerUserBt = new JButton("Register");
		panel.setBorder(BorderFactory.createEmptyBorder(15, 5, 15, 5));
		frame.setLocationRelativeTo(null);
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		panel.add(userName).setSize(250, 50);
		panel.add(userPassword);
		panel.add(loggInBt);
		layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(userName, 10, 200, 300)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(userPassword, 10, 200, 300).addComponent(registerUserBt, 10, 40, 100)
						.addComponent(loggInBt, 10, 40, 100)));
		layout.setVerticalGroup(layout
				.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(userName).addComponent(userPassword))
				.addComponent(registerUserBt).addComponent(loggInBt));
		frame.add(panel, BorderLayout.CENTER);
		frame.setSize(300, 350);
		loggInBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				char[] userPasswordChar = userPassword.getPassword();
				userDataClass.setUserNameString(userName.getText());
				UserData tempData = new UserData();
				try {
					userDataClass
							.setLogin(tempData.CheckUserData(userDataClass.getUserNameString(), userPasswordChar));
					if (userDataClass.isLogin() == true) {
						TheMainProgram.logginCheck(userDataClass);						
						frame.dispose();
					}
					else {
						System.out.println("Wrong Password or User doesn't exist");
					}
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		userPassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent pw) {
				char[] pwInput = userPassword.getPassword();
				userDataClass.setUserPasswordCharAr(pwInput);

			}
		});
		registerUserBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new RegisterWindow();
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("BeSafe");
		URL iconUrl = getClass().getResource("/BSIcon.png");
		ImageIcon icon = new ImageIcon(iconUrl);
		frame.setIconImage(icon.getImage());
		frame.setVisible(true);
	}
}

package theMain;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TheInterface extends UserDataClass implements ActionListener {
	public JPanel panel;
	public JFrame frame;
	public JButton loggInBt;
	public JButton registerUserBt;
	public JTextField userName;
	public JTextField userPassword;
	
	public TheInterface() {
			panel = new JPanel();
			frame = new JFrame();
			userName = new JTextField();
			userPassword = new JTextField();
			loggInBt = new JButton("Login");
			registerUserBt = new JButton("Register");
			panel.setBorder(BorderFactory.createEmptyBorder(50,80,10,80));
			frame.setLocationRelativeTo(null);						
			GroupLayout layout = new GroupLayout(panel);
			panel.setLayout(layout);
			layout.setAutoCreateGaps(true);
			layout.setAutoCreateContainerGaps(true);
			panel.add(userName).setSize(250, 50);
			panel.add(userPassword);
			panel.add(loggInBt);
			layout.setHorizontalGroup(layout.createSequentialGroup()
					.addComponent(userName, 10, 200, 300).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(userPassword, 10, 200, 300)
							.addComponent(registerUserBt, 10, 40, 100)
							.addComponent(loggInBt,10,40,100)));
			layout.setVerticalGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(userName)
							.addComponent(userPassword))
								.addComponent(registerUserBt)
								.addComponent(loggInBt));
			frame.add(panel, BorderLayout.CENTER);
			frame.setSize(1280, 720);
			loggInBt.addActionListener(this);
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
	 @Override
	 public void actionPerformed(ActionEvent e)
	 {			 
		 	UserDataClass tempUserDataClass = new UserDataClass();
		 	tempUserDataClass.setUserNameString(userName.getText());
		 	tempUserDataClass.setUserPasswordString(userPassword.getText());
		 	UserData tempData = new UserData();
			try {
				tempData.CheckUserData(tempUserDataClass.getUserNameString(), tempUserDataClass.getUserPasswordString());
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	 }
	 
	 
}
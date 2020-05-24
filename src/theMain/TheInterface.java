package theMain;
import java.awt.BorderLayout;
import java.awt.GridLayout;
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
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TheInterface {
	public JPanel panel;
	public JFrame frame;
	public JButton loggInBt;
	public JButton registerUserBt;
	private JTextField userName;
	private JPasswordField userPassword;
	
	public TheInterface(UserDataClass userDataClass) {
		
			if (userDataClass.isLogin()) {
				panel = new JPanel();
				frame = new JFrame();
				frame.setLocationRelativeTo(null);
				frame.setSize(1280, 720);
				
				/**MenuBar on top of the logged in Frame*/
				JMenuBar jMenuBar = new JMenuBar();
				JMenu m1 = new JMenu("File");
				JMenu m2 = new JMenu("Help");
				jMenuBar.add(m1);
				jMenuBar.add(m2);
				JMenuItem mi1 = new JMenuItem("Log out");
				JMenuItem mi2 = new JMenuItem("Quit");
				JMenuItem mi3 = new JMenuItem("About BeSafe");
				JMenuItem mi4 = new JMenuItem("Help");
				m1.add(mi1);
				m1.add(mi2);
				m2.add(mi3);
				m2.add(mi4);
				frame.getContentPane().add(BorderLayout.NORTH, jMenuBar);
				/** */
				
				/**Tool bar at the bottom, of the Frame */
		        JLabel acccountNameLabel = new JLabel("Accountname: ");
		        JLabel acccountPasswordLabel = new JLabel("Accountpassword: ");
		        JLabel accountSiteLabel = new JLabel("For which Site: ");
		        
		        JTextField accountNametf = new JTextField(20);
		        JTextField accountPasswordPwf = new JTextField(20);
		        JTextField accountSitetf = new JTextField(20);

		        /** */
		        
		        /** Button Layout in the middle with the account names */
		        GridLayout centerButtonGridLayout = new GridLayout(10, 10);
		        JButton add = new JButton("add");
		        JPanel buttonPanel = new JPanel();
		        PasswordManagementSystem addAccWithAddButton = new PasswordManagementSystem();    
		        	addAccWithAddButton.restoreAccountData(userDataClass, centerButtonGridLayout, buttonPanel, frame);
		        add.addActionListener(new ActionListener() {				
					@Override
					public void actionPerformed(ActionEvent e1) {
							userDataClass.setSiteNameString(accountSitetf.getText());
							userDataClass.setSiteUserNameString(accountNametf.getText());
							userDataClass.setUserSitePasswordString(accountPasswordPwf.getText());
							addAccWithAddButton.storeAccountLocally(userDataClass);
							addAccWithAddButton.addAccountToTheList(userDataClass,
									centerButtonGridLayout, buttonPanel, frame);
							accountNametf.setText("");
							accountPasswordPwf.setText("");
							accountSitetf.setText("");	
					}
		        });
		        
		        /** */
		        
		        JButton cancel = new JButton("Cancel");
		        cancel.addActionListener(new ActionListener() {	     
					@Override
					public void actionPerformed(ActionEvent e) {
							accountNametf.setText("");
							accountPasswordPwf.setText("");
							accountSitetf.setText("");								
					}
				}); 
		        panel.add(accountSiteLabel);
		        panel.add(accountSitetf);
		        panel.add(acccountNameLabel);
		        panel.add(accountNametf);
		        panel.add(acccountPasswordLabel);
		        panel.add(accountPasswordPwf);
		        panel.add(add);
		        panel.add(cancel);
		        frame.getContentPane().add(BorderLayout.SOUTH, panel);
		        
		        
		        
		        
		        
		        
		          
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("BeSafe");
				URL iconUrl = getClass().getResource("/BSIcon.png");
				ImageIcon icon = new ImageIcon(iconUrl);
				frame.setIconImage(icon.getImage());
				frame.setVisible(true);
			}
			else if (userDataClass.isLogin() == false) {	
				panel = new JPanel();
				frame = new JFrame();
				userName = new JTextField();
				userPassword = new JPasswordField();
				userPassword.setEchoChar('*');
				loggInBt = new JButton("Login");
				registerUserBt = new JButton("Register");
				panel.setBorder(BorderFactory.createEmptyBorder(15,5,15,5));
				frame.setLocationRelativeTo(null);						
				GroupLayout layout = new GroupLayout(panel);
				panel.setLayout(layout);
				layout.setAutoCreateGaps(true);
				layout.setAutoCreateContainerGaps(true);
				panel.add(userName).setSize(250, 50);
				panel.add(userPassword);
				panel.add(loggInBt);
				layout.setHorizontalGroup(layout.createSequentialGroup()
						.addComponent(userName, 10, 200, 300)
						
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(userPassword, 10, 200, 300)
								.addComponent(registerUserBt, 10, 40, 100)
								.addComponent(loggInBt,10,40,100)
								));
				layout.setVerticalGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(userName)
								.addComponent(userPassword))
								.addComponent(registerUserBt)
								.addComponent(loggInBt));
				frame.add(panel, BorderLayout.CENTER);
				frame.setSize(300, 350);
				loggInBt.addActionListener(new ActionListener() {			
					@Override
					public void actionPerformed(ActionEvent e) 
						 {			 
								char[] userPasswordChar = userPassword.getPassword();
							 	userDataClass.setUserNameString(userName.getText());
							 	UserData tempData = new UserData();
								try {
									userDataClass.setLogin(tempData.CheckUserData(
											userDataClass.getUserNameString(), 
											userPasswordChar));
									 frame.dispose();
									 TheMainProgram.logginCheck(userDataClass);
								} catch (URISyntaxException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
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
			else {
				System.out.println("Something went wrong!");
			}
			
	}


	 
}
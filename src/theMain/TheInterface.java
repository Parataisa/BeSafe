package theMain;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TheInterface extends UserDataClass {
	public JPanel panel;
	public JFrame frame;
	public JButton loggInBt;
	public JButton registerUserBt;
	public JTextField userName;
	public JTextField userPassword;

	public TheInterface(boolean login) {
		
			if (login) {
				panel = new JPanel();
				frame = new JFrame();
				frame.setLocationRelativeTo(null);
				frame.setSize(1280, 720);
				
				/**MenuBar on top of the logedin Frame*/
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
		        JTextField accountNametf = new JTextField(20);
		        JTextField accountPasswordtf = new JTextField(20);
		        JButton add = new JButton("Add");
		        JButton cancel = new JButton("Cancel");
		        panel.add(acccountNameLabel);
		        panel.add(accountNametf);
		        panel.add(acccountPasswordLabel);
		        panel.add(accountPasswordtf);
		        panel.add(add);
		        panel.add(cancel);
		        frame.getContentPane().add(BorderLayout.SOUTH, panel);
		        /** */
		        
		        
		        
		        /** */
		        UserDataClass userSavedAccountUserDataClass = new UserDataClass();
		        String[] accountSiteStringArray = {"This is a Test","2"}; // Add Parameter to "te" for the Component for the List.
		        userSavedAccountUserDataClass.setTestArrayStrings(accountSiteStringArray);
		        String labels[] = userSavedAccountUserDataClass.getTestArrayStrings();        		
		        Container contentPane = frame.getContentPane();	        
		        JList<String> jlist = new JList<>(labels);
		        JScrollPane scrollPane1 = new JScrollPane(jlist);
		        contentPane.add(scrollPane1, BorderLayout.WEST);
		        
		        ListSelectionListener listSelectionListener = new ListSelectionListener() {
		            public void valueChanged(ListSelectionEvent listSelectionEvent) {
		              System.out.print("First index: " + listSelectionEvent.getFirstIndex());
		              System.out.print(", Last index: " + listSelectionEvent.getLastIndex());
		              boolean adjust = listSelectionEvent.getValueIsAdjusting();
		              System.out.println(", Adjusting? " + adjust);
		              if (!adjust) {
		                JList<?> list = (JList<?>) listSelectionEvent.getSource();
		                int selections[] = list.getSelectedIndices();
		                String selectionValues = list.getSelectedValue().toString();
		                for (int i = 0, n = selections.length; i < n; i++) {
		                  if (i == 0) {
		                    System.out.print("  Selections: ");
		                  }
		                  System.out.print(selections[i] + "/" + selectionValues + " ");
		                }
		                System.out.println();
		              }
		            }
		          };
		          jlist.addListSelectionListener(listSelectionListener);

		          MouseListener mouseListener = new MouseAdapter() {
		            public void mouseClicked(MouseEvent mouseEvent) {
		              JList<?> theList = (JList<?>) mouseEvent.getSource();
		              if (mouseEvent.getClickCount() == 2) {
		                int index = theList.locationToIndex(mouseEvent.getPoint());
		                if (index >= 0) {
		                  Object o = theList.getModel().getElementAt(index);
		                  System.out.println("Double-clicked on: " + o.toString());
		                }
		              }
		            }
		          };
		          jlist.addMouseListener(mouseListener);
		        /** */
		          
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("BeSafe");
				URL iconUrl = getClass().getResource("/BSIcon.png");
				ImageIcon icon = new ImageIcon(iconUrl);
				frame.setIconImage(icon.getImage());
				frame.setVisible(true);
			}
			else if (login == false) {	
				panel = new JPanel();
				frame = new JFrame();
				userName = new JTextField();
				userPassword = new JTextField();
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
							 	UserDataClass tempUserDataClass = new UserDataClass();
							 	tempUserDataClass.setUserNameString(userName.getText());
							 	tempUserDataClass.setUserPasswordString(userPassword.getText());
							 	UserData tempData = new UserData();
								try {
									 tempUserDataClass.setLogin(tempData.CheckUserData(tempUserDataClass.getUserNameString(), tempUserDataClass.getUserPasswordString()));
									 frame.dispose();
									 TheMainProgram.logginCheck(tempUserDataClass.isLogin());
								} catch (URISyntaxException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
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
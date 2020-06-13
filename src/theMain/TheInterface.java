package theMain;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class TheInterface {

	public TheInterface(UserDataClass userDataClass) {
			JPanel panel = new JPanel();
			JFrame frame = new JFrame();
			frame.setLocationRelativeTo(null);
			frame.setSize(1280, 720);

			/** MenuBar on top of the logged in Frame */
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

			/** Tool bar at the bottom, of the Frame */
			JLabel accountSiteLabel = new JLabel("For which Site: ");
			JLabel acccountNameLabel = new JLabel("Accountname: ");
			JLabel acccountPasswordLabel = new JLabel("Accountpassword: ");

			JTextField accountSitetf = new JTextField(20);
			JTextField accountNametf = new JTextField(20);
			JTextField accountPasswordPwf = new JTextField(20);

			JCheckBox editBox = new JCheckBox("Edit", false);

			/** Button Layout in the middle with the account names */
			GridLayout centerButtonGridLayout = new GridLayout(10, 10);
			JButton add = new JButton("add");
			JPanel buttonPanel = new JPanel();
			SiteDataManagementSystem addAccWithAddButton = new SiteDataManagementSystem();
			addAccWithAddButton.restoreAccountData(userDataClass, centerButtonGridLayout, buttonPanel, frame, editBox);
			add.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e1) {
					if (emptyCheck(accountSitetf, accountNametf, accountPasswordPwf)) {
						userDataClass.setSiteNameString(accountSitetf.getText());
						userDataClass.setSiteUserNameString(accountNametf.getText());
						userDataClass.setUserSitePasswordString(accountPasswordPwf.getText());
						addAccWithAddButton.storeAccountLocally(userDataClass);
						addAccWithAddButton.addAccountToTheList(userDataClass, centerButtonGridLayout, buttonPanel,
								frame, editBox);
						accountNametf.setText("");
						accountPasswordPwf.setText("");
						accountSitetf.setText("");
					} else {
						System.out.println("One of the Data were null!");
					}
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
			panel.add(editBox);
			frame.getContentPane().add(BorderLayout.SOUTH, panel);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("BeSafe");
			URL iconUrl = getClass().getResource("/BSIcon.png");
			ImageIcon icon = new ImageIcon(iconUrl);
			frame.setIconImage(icon.getImage());
			frame.setVisible(true);
	}

	private boolean emptyCheck(JTextField site, JTextField acc, JTextField pw) {
		if (site.getText().isEmpty()) {
			System.out.println("No sitename");
			return false;
		} else if (acc.getText().isEmpty()) {
			System.out.println("No Accountname");
			return false;
		} else if (pw.getText().isEmpty()) {
			System.out.println("No password");
			return false;
		} else {
			return true;
		}
	}

}

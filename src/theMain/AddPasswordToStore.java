package theMain;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddPasswordToStore {

	
	public void addAccountToTheList(UserDataClass userDataClass, JTextField accountNametf,
			JTextField accountPasswordtf, JTextField accountSitetf, GridLayout centerButtonGridLayout,
			JPanel buttonPanel, JFrame frame) {
		buttonPanel.setLayout(centerButtonGridLayout);
		JButton accountButton = new JButton();
		userDataClass.setUserNameString(accountNametf.getText());
		userDataClass.setUserPasswordString(accountPasswordtf.getText());
		userDataClass.setUserSiteNameString(accountSitetf.getText());					
		accountButton.setText(userDataClass.getUserNameString());
		accountButton.setSize(250, 100);
		buttonPanel.add(accountButton);
		buttonPanel.revalidate();
		buttonPanel.repaint();
		frame.getContentPane().add(BorderLayout.WEST, buttonPanel);
		frame.revalidate();
		frame.repaint();
	}
	}


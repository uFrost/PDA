package chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import login.LoginConfirmation;
import login.NewAccountCreation;
import base.Main;

public class MessageSpaceDialog extends JFrame {

	private static final long serialVersionUID = 1L;
	public ArrayList<JRadioButton> buttons = new ArrayList<JRadioButton>();
	public ArrayList<String> curMS = new ArrayList<String>();
	JButton Submit = new JButton("Add");
	Boolean first = true;
	public ArrayList<String> exChats = new ArrayList<String>();

	public MessageSpaceDialog() {
		super("New Conversation");
		setLocationRelativeTo(null);
		setResizable(true);
		setLayout(new BoxLayout(getContentPane(), 1));
		add(Submit);
		Submit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				namer();
			}
		});
		pack();
		setVisible(false);

	}

	public void buttonListener(JRadioButton button) {
		if (button.isSelected()) {
			curMS.add(button.getText());
			//System.out.println("Added: " + curMS);
		} else {
			curMS.remove(button.getText());
			//System.out.println("Removed: " + button.getText());
		}

	}

	public void init() {

		
		// Adds names of all accounts as Radio Buttons in an arrayList
		curMS.clear();
		ArrayList<String> names = NewAccountCreation.getAccounts();
		names.remove(LoginConfirmation.getUserName());
		System.out.println(names);

		for (int x = 0; x < names.size(); x++) {
			
			buttons.add(new JRadioButton());
			buttons.get(x).setText(names.get(x));
			buttons.get(x).setSelected(false);
			

			// listener for radio buttons
			if(first){
				buttons.get(x).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {

					buttonListener((JRadioButton) arg0.getSource());
					}

				});
				
			}
			
			this.add(buttons.get(x));
			pack();
		}
		first=false;
	}

	
	public void namer(){
		
		if(!curMS.contains(LoginConfirmation.getUserName()))
		curMS.add(LoginConfirmation.getUserName());
		
		Collections.sort(curMS);
		String temp = "";
		for (int x = 0; x < curMS.size(); x++) {
			if ((x + 1) < curMS.size())
				temp += curMS.get(x) + ", ";
			else {
				temp += curMS.get(x);
			}
		}
		
		
		
		if(!exChats.contains(temp)){
			Main.window.addConvo(temp);
			setVisible(false);
			exChats.add(temp);
		}
		else{
			//init();
			
		}
		
		
	}
	
	
	
}

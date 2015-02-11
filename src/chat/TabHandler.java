package chat;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import base.Main;

public class TabHandler extends JPanel {
	
	JButton add = new JButton("+");
	JButton close = new JButton("-");
	
	public TabHandler(){
		setLayout(new BorderLayout());
		add(add,BorderLayout.NORTH);
		add(close,BorderLayout.SOUTH);
		add.addActionListener(new ActionListener(){

        public void actionPerformed(ActionEvent e){
        Main.window.messageSpaceDialog.init();
       Main.window.messageSpaceDialog.setVisible(true);
        }});
		
		close.addActionListener(new ActionListener(){

	        public void actionPerformed(ActionEvent e){
	       Main.window.closeCurrentTab();
	        }});
	}
	
}

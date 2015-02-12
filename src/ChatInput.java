package UI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextArea;

public class ChatInput extends JTextArea{

	void ChatInput(){
	this.addKeyListener(new KeyListener(){
		public void keyPressed(KeyEvent arg0) {
			//push the data
		}
		public void keyReleased(KeyEvent arg0) {}public void keyTyped(KeyEvent arg0) {}});
	}
	
}

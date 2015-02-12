
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ChatPanel extends JPanel{

	void UpdateChat(String newThing){
		JTextArea text = new JTextArea();
		text.setBackground(new Color(40, 40, 40));
		text.setForeground(new Color(200, 200, 200));
		
		/*if(newThing.startsWith(FireBaseUtils.myName()){
			text.setAlignmentX(RIGHT_ALIGNMENT);
		}
		else{
			text.setAlignmentX(LEFT_ALIGNMENT);
		}
		
		this.add(text);*/
	}
	
	
	
}
